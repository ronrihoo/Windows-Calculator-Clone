package backend;

import java.math.BigInteger;

import util.Constants;

public class BaseConverter {
	
	// Binary from Decimal
	public static String getBin(long dec) {
		return Long.toBinaryString(dec);
	}
	
	// Binary from Base 8, 10, 16
	public static String getBin(String num, int base) {
		if (base == 16) {
			return Long.toBinaryString(getDecFromHex(num));
		} else if (base == 10) {
			return Long.toBinaryString(Long.parseLong(num));
		} else if (base == 8) {
			return Long.toBinaryString(getDecFromOct(num));
		} else {
			return num;
		}
	}
	
	// Octal from Decimal
	public static String getOct(long dec) {
		return Long.toOctalString(dec);
	}
	
	// Octal from Base 2, 10, 16
	public static String getOct(String num, int base) {
		if (base == 16) {
			return Long.toOctalString(getDecFromHex(num));
		} else if (base == 10) {
			return Long.toOctalString(Long.parseLong(num));
		} else if (base == 2) {
			return Long.toOctalString(getDecFromBin(num));
		} else {
			return num;
		}
	}

	// Hexadecimal from Decimal
	public static String getHex(long dec) {
		return Long.toHexString(dec).toUpperCase();
	}
	
	// Hexadecimal from Base 2, 8, 10
	public static String getHex(String num, int base) {
		if (base == 10) {
			return Long.toHexString(Long.parseLong(num)).toUpperCase();
		} else if (base == 8) {
			return Long.toHexString(getDecFromOct(num)).toUpperCase();
		} else if (base == 2) {
			return Long.toHexString(getDecFromBin(num)).toUpperCase();
		} else {
			return num.toUpperCase();
		}
	}
	
	public static long getDecFromBase(String num, int base) {
		System.out.println(num + "\t" + base);
		if (base == Constants.HEX_BASE) {
			return getDecFromHex(num);
		} else if (base == Constants.DEC_BASE) {
			return Long.parseLong(num);
		} else if (base == Constants.OCT_BASE) {
			return getDecFromOct(num);
		} else if (base == Constants.BIN_BASE) {
			return getDecFromBin(num);
		} 
		return 0;	// unknown value -- in case something goes wrong in RAM
	}
	
	// Decimal from Binary
	public static long getDecFromBin(String binStr) {
		String[] bin = binStr.split("");
		BigInteger dec = new BigInteger("0");
		for (int i = 0, p = bin.length - 1; i < bin.length; i++, p--) {
			if (p == 63 && bin[i].equals("1")) {
				dec = new BigInteger(Constants.LONG_NEG_MAX);
			} else if (p < 63) {
				dec = dec.add(BigInteger.valueOf((long) (Long.parseLong(bin[i]) * Math.pow(2, p))));
			}
		}
		return dec.longValueExact();
	}
	
	// Decimal from Octal
	public static long getDecFromOct(String octStr) {
		String[] oct = octStr.split("");
		long dec = 0;
		for (int i = 0, p = oct.length - 1; i < oct.length; i++, p--) {
			dec += (long) (Long.parseLong(oct[i]) * Math.pow(8, p));
		}
		return dec;
	}
		
	// Decimal from Hexadecimal
	public static long getDecFromHex(String hexStr) {
		String[] hex = hexStr.split("");
		long dec = 0;
		for (int i = 0, p = hex.length - 1; i < hex.length; i++, p--) {
			dec += (long) (Constants.HEX.get(hex[i]) * Math.pow(16, p));
		}
		return dec;
	}

}
