package backend;

import util.Constants;

public class Calculator {
	
	private static long result;			// the totaled number
	private static long entry;			// the input before it becomes a part of result
	private static long sign;			// negative / positive
	private	static int base;			// 2 - bin; 8 - oct; 10 - dec; 16 - hex
	private static int displayState;	// state for whether result or entry is displayed
	private static int op;				// operation code
	private static boolean intent;		// user's intention to update entry
	private static long hold;			// entry number for display during base change;
										// used to act just like the Windows Calculator
	
	/**
	 * Operation Codes					Display State Codes
	 *
	 * 0  - clear						0 - result is currently displayed
	 * 1  - clear entry					1 - entry is currently displayed
	 * 2  - invert
	 * 3  - divide
	 * 4  - multiply
	 * 5  - subtract
	 * 6  - add
	 * 7  - mod
	 * 8  - backspace
	 * 9  - idle
	 *
	 * -1 - error, div by 0
	 *
	 */
	
	public static void init() {
		result = 0;
		entry = 0;
		sign = 1;
		base = 10;
		displayState = 0;
		op = 9;
		hold = entry;
		intent = false;
	}
	
	public static void total() {
		switch (op) {
			case -1:
				error();
				break;
			case 0:
				clear();
				break;
			case 1:
				clearEntry();
				break;
			case 2:
				invert();
				break;
			case 3:
				div();
				break;
			case 4:
				mul();
				break;
			case 5:
				sub();
				break;
			case 6:
				add();
				break;
			case 7:
				mod();
				break;
			case 8:
				backspace();
				break;
			case 9:
				firstEntry();
			default:
				break;
		}
	}
	
	public static void backspace() {
		if (entryIsDisplayed()) {
			setEntry(backspace(entry));
		} else if (resultIsDisplayed()) {
			setResult(backspace(result));
		}
	}

	public static long backspace(long val) {
		return val / (long) base;
	}

	public static void mod() {
		result = result % entry;
		postTotal();
	}
		
	public static void add() {
		result = result + entry;
		postTotal();
	}
	
	public static void sub() {
		result = result - entry;
		postTotal();
	}
		
	public static void mul() {
		result = result * entry;
		postTotal();
	}
		
	public static void div() {
		if (entry == 0) {
			op = -1;		// error code
		} else {
			result = result / entry;
			postTotal();
		}
	}

	public static void invert() {
		sign = (sign == 1 ? -1 : 1);
		// state 1 = invert entry; state 0 = invert result
		if (entryIsDisplayed()) {
			if (entry == 0 && hold != 0) {
				entry = (-1) * hold;
			} else {
				entry = (-1) * entry;
			}
			hold = entry;
		} else {
			result = (-1) * result;
		}
	}
	
	public static void postTotal() {
		sign = 1;
		intent = false;	// assumes that user does not intend to update entry
		displayResult();
	}
	
	// post click of digit/operation button
	public static void postButtonClick() {
		intent = true;
		displayEntry();
	}
	
	public static void clear() {
		result = 0;
		entry = 0;
		sign = 1;
		resultIsDisplayed();
		hold = entry;
		op = 9;
	}
	
	public static void clearEntry() {
		result = entry;
		entry = 0;
		sign = 1;
		entryIsDisplayed();
		hold = entry;
	}
	
	// clears entry without clearing the held value, hold
	public static void clearEntryQuietly() {
		entry = 0;
		sign = 1;
		entryIsDisplayed();
	}

	public static void firstEntry() {
		result = entry;
	}
	
	/**
	 * Operation Codes					Display State Codes
	 * 
	 * 0 - clear						0 - result is currently displayed
	 * 1 - clear entry					1 - entry is currently displayed
	 * 2 - invert
	 * 3 - divide
	 * 4 - multiply
	 * 5 - subtract
	 * 6 - add
	 * 7 - mod
	 * 8 - backspace
	 * 9 - idle
	 * 
	 */
	public static void updateOp(int newOp) {
		sign = 1;
		intent = false;
		if (op == 9) {
			result = entry;
		}
		op = newOp;
	}

	public static void updateResult(int newResult) {
		if (sign < 0 && newResult > 0) {
			result = sign * newResult;
		} else {
			result = newResult;
		}
		postTotal();
	}
	
	public static void updateEntry(long newEntry) {
		if (op != 9 && !intent) {
			intent = true;
			clearEntryQuietly();
		}
		if (sign < 0 && entry > 0) {
			entry = (sign * (entry * base)) + (sign * newEntry);
		} else {
			entry = ((entry * base) + sign * newEntry);
		}
		hold = entry;
		postButtonClick();
	}
	
	public static void displayResult() {
		displayState = Constants.DISPLAY_STATE_RESULT;
	}
	
	public static void displayEntry() {
		displayState = Constants.DISPLAY_STATE_ENTRY;
	}
	
	public static boolean resultIsDisplayed() {
		if (displayState == Constants.DISPLAY_STATE_RESULT) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean entryIsDisplayed() {
		if (displayState == Constants.DISPLAY_STATE_ENTRY) {
			return true;
		} else {
			return false;
		}
	}

	public static long getResult() {
		return result;
	}
	
	public static long getEntry() {
		return entry;
	}
	
	public static void setEntry(long newEntry) {
		entry = newEntry;
		hold = entry;
	}
	
	public static void setResult(long newResult) {
		result = newResult;
	}

	public static String getEntryAsString() {
		if (base == Constants.HEX_BASE)
			return BaseConverter.getHex(hold);
		else if (base == Constants.OCT_BASE)
			return BaseConverter.getOct(hold);
		else if (base == Constants.BIN_BASE)
			return BaseConverter.getBin(hold);
		return String.valueOf(hold);
	}
	
	public static String getResultAsString() {
		if (base == Constants.HEX_BASE)
			return BaseConverter.getHex(result);
		else if (base == Constants.OCT_BASE)
			return BaseConverter.getOct(result);
		else if (base == Constants.BIN_BASE)
			return BaseConverter.getBin(result);
		return String.valueOf(result);
	}

	public static String error() {
		if (op == -1) {
			clear();
			return Constants.ERROR_DIV_BY_ZERO;
		}
		return Constants.ERROR_MESSAGE;
	}

	public static void clearError() {
		op = 9;
	}

	public static String getEntryInBinary() {
		return BaseConverter.getBin(hold);
	}
	
	public static String getResultInBinary() {
		return BaseConverter.getBin(result);
	}

	public static int getOp() {
		return op;
	}

	public static int getBase() {
		return base;
	}

	public static void setBase(int newBase) {
		base = newBase;
	}
	
	public static void setHold() {
		hold = entry;
	}
	
	public static long getHold() {
		return hold;
	}

}
