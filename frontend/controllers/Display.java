package frontend.controllers;

import backend.Calculator;
import frontend.components.TextFields;
import util.Constants;

public class Display {
	
	public static void update() {
		updateText();
		updateBits();
	}
	
	public static void updateText() {
		if (Calculator.getOp() == -1){
			TextFields.resultField.setText(Calculator.error());
			Calculator.clearError();
		} else if (Calculator.entryIsDisplayed()) {
			if (Calculator.getEntryAsString().split("").length > 59) {
				TextFields.configureResultFieldFont(8);
			} else 
			if (Calculator.getEntryAsString().split("").length > 44) {
				TextFields.configureResultFieldFont(10);
			} else 
			if (Calculator.getEntryAsString().split("").length > 39) {
				TextFields.configureResultFieldFont(12);
			} else 
			if (Calculator.getEntryAsString().split("").length > 35) {
				TextFields.configureResultFieldFont(14);
			} else if (Calculator.getEntryAsString().split("").length > 30) {
				TextFields.configureResultFieldFont(16);
			} else if (Calculator.getEntryAsString().split("").length > 27) {
				TextFields.configureResultFieldFont(18);
			} else {
				TextFields.configureResultFieldFont(Constants.TEXTFIELD_FONT_SIZE_1);
			}
			TextFields.resultField.setText(Calculator.getEntryAsString());
		} else if (Calculator.resultIsDisplayed()) {
			if (Calculator.getResultAsString().split("").length > 59) {
				TextFields.configureResultFieldFont(8);
			} else if (Calculator.getResultAsString().split("").length > 44) {
				TextFields.configureResultFieldFont(10);
			} else if (Calculator.getResultAsString().split("").length > 39) {
				TextFields.configureResultFieldFont(12);
			} else if (Calculator.getResultAsString().split("").length > 35) {
				TextFields.configureResultFieldFont(14);
			} else if (Calculator.getResultAsString().split("").length > 30) {
				TextFields.configureResultFieldFont(16);
			} else if (Calculator.getResultAsString().split("").length > 27) {
				TextFields.configureResultFieldFont(18);
			} else {
				TextFields.configureResultFieldFont(Constants.TEXTFIELD_FONT_SIZE_1);
			}
			TextFields.resultField.setText(Calculator.getResultAsString());
		}
	}
	
	public static void updateBits() {
		String[] digits = {""};
		if (Calculator.entryIsDisplayed()) {
			digits = Calculator.getEntryInBinary().split("");
		} else {
			digits = Calculator.getResultInBinary().split("");
		}
		if (digits.length != 64) {
			String[] temp = new String[64];
			int diff = 64 - digits.length;
			for (int i = 0; i < 64; i++) {
				if (i < diff) {
					temp[i] = "0";
				} else {
					temp[i] = digits[i - diff];
				}
			}
			digits = temp;
		}
		int index = digits.length - 1;
		for (int i = TextFields.bitFields.length - 1; i >= 0; i--) {
			if (index >= 0) {
				TextFields.bitFields[i].setText(digits[index]);
				index--;
			} else if (TextFields.bitFields[i].getText() != "0") {
				TextFields.bitFields[i].setText("0");
			}
		}
	}
	
}
