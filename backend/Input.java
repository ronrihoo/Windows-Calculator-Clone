package backend;

import util.Constants;

public class Input {

	// "Hex" RadioButton
	public static void radioButtonHex() {
		Calculator.setBase(Constants.HEX_BASE);
		Calculator.clearEntryQuietly();
	}

	// "Dec" RadioButton
	public static void radioButtonDec() {
		Calculator.setBase(Constants.DEC_BASE);
		Calculator.clearEntryQuietly();
	}

	// "Oct" RadioButton
	public static void radioButtonOct() {
		Calculator.setBase(Constants.OCT_BASE);
		Calculator.clearEntryQuietly();
	}

	// "Bin" RadioButton
	public static void radioButtonBin() {
		Calculator.setBase(Constants.BIN_BASE);
		Calculator.clearEntryQuietly();
	}

	// 0
	public static void button0Action() {
		Calculator.updateEntry(Integer
				.parseInt(Constants.BUTTON_TEXT_LIST[43]));
	}

	// 1
	public static void button1Action() {
		Calculator.updateEntry(Integer
				.parseInt(Constants.BUTTON_TEXT_LIST[35]));
	}

	// 2
	public static void button2Action() {
		Calculator.updateEntry(Integer
				.parseInt(Constants.BUTTON_TEXT_LIST[36]));
	}

	// 3
	public static void button3Action() {
		Calculator.updateEntry(Integer
				.parseInt(Constants.BUTTON_TEXT_LIST[37]));
	}

	// 4
	public static void button4Action() {
		Calculator.updateEntry(Integer
				.parseInt(Constants.BUTTON_TEXT_LIST[27]));
	}

	// 5
	public static void button5Action() {
		Calculator.updateEntry(Integer
				.parseInt(Constants.BUTTON_TEXT_LIST[28]));
	}

	// 6
	public static void button6Action() {
		Calculator.updateEntry(Integer
				.parseInt(Constants.BUTTON_TEXT_LIST[29]));
	}

	// 7
	public static void button7Action() {
		Calculator.updateEntry(Integer
				.parseInt(Constants.BUTTON_TEXT_LIST[19]));
	}

	// 8
	public static void button8Action() {
		Calculator.updateEntry(BaseConverter
				.getDecFromBin(String.valueOf(Integer
						.parseInt(Constants.BUTTON_TEXT_LIST[20]))));
	}

	// 9
	public static void button9Action() {
		Calculator.updateEntry(Integer
				.parseInt(Constants.BUTTON_TEXT_LIST[21]));
	}

	// A
	public static void buttonAAction() {
		Calculator.updateEntry(Constants.HEX_A_IN_DEC);
	}

	// B
	public static void buttonBAction() {
		Calculator.updateEntry(Constants.HEX_B_IN_DEC);
	}

	// C
	public static void buttonCAction() {
		Calculator.updateEntry(Constants.HEX_C_IN_DEC);
	}

	// D
	public static void buttonDAction() {
		Calculator.updateEntry(Constants.HEX_D_IN_DEC);
	}

	// E
	public static void buttonEAction() {
		Calculator.updateEntry(Constants.HEX_E_IN_DEC);
	}

	// F
	public static void buttonFAction() {
		Calculator.updateEntry(Constants.HEX_F_IN_DEC);
	}

	// mod
	public static void buttonModAction() {
		Calculator.updateOp(7);
	}

	// add
	public static void buttonAddAction() {
		Calculator.updateOp(6);
	}

	// sub
	public static void buttonSubAction() {
		Calculator.updateOp(5);
	}

	// mul
	public static void buttonMulAction() {
		Calculator.updateOp(4);
	}

	// div
	public static void buttonDivAction() {
		Calculator.updateOp(3);
	}

	// +/-
	public static void buttonSignAction() {
		Calculator.invert();
	}

	// Enter
	public static void buttonEnterAction() {
		Calculator.total();
	}

	// Back
	public static void buttonBackAction() {
		Calculator.backspace();
	}

	// Clear
	public static void buttonClearAction() {
		Calculator.clear();
	}

	// Clear Entry
	public static void buttonClearEntryAction() {
		Calculator.clearEntry();
	}

}
