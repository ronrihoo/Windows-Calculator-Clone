package frontend.components;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import util.Config;
import util.Constants;

public class TextFields {
	
	public static JTextField resultField;
	public static JTextField[] bitFields;
	private static Font resultFieldFont;
	public static Border bitFieldBorder;
	
	public static void init() {
		bitFieldBorder = new LineBorder(Color.LIGHT_GRAY, 0, false);
		buildResultField();
		buildBitFields();
	}
	
	public static void buildResultField() {
		resultField = new JTextField("0", 19);
		resultField.setHorizontalAlignment(SwingConstants.RIGHT);
		resultField.setBorder(new LineBorder(Color.LIGHT_GRAY, 0, false));
		resultField.setPreferredSize(new Dimension(
				Constants.DECIMAL_JTEXTFIELD_WIDTH, 
				Constants.DECIMAL_JTEXTFIELD_HEIGHT));
		resultField.setBackground(new Color(
				Constants.TEXTFIELD_BG_COLOR_R,
				Constants.TEXTFIELD_BG_COLOR_G,
				Constants.TEXTFIELD_BG_COLOR_B
		));
		configureResultFieldFont();
		resultField.setEditable(false);
		resultField.setFocusable(false);
	}

	public static void configureResultFieldFont() {
		resultFieldFont = new Font(Constants.TEXTFIELD_FONT, 
				Font.PLAIN, 
				Constants.TEXTFIELD_FONT_SIZE_1);
		resultField.setFont(resultFieldFont);
	}
	
	public static void configureResultFieldFont(int fontSize) {
		resultFieldFont = new Font(Constants.TEXTFIELD_FONT, Font.PLAIN, fontSize);
		//resultFieldFont = new Font(Constants.TEXTFIELD_FONT, Font.PLAIN, fontSize);
		resultField.setFont(resultFieldFont);
	}
	
	public static void buildBitFields() {
		bitFields = new JTextField[Constants.BINARY_JTEXTFIELD_QUANTITY];
	}
	
	public static void configureBitField(int i, Color backgroundColor) {
		bitFields[i] = new JTextField("0");
		bitFields[i].setEditable(false);
		bitFields[i].setFocusable(false);
		bitFields[i].setPreferredSize(new Dimension(
				Constants.BIT_FIELD_WIDTH, 
				Constants.BIT_FIELD_HEIGHT));
		bitFields[i].setBorder(bitFieldBorder);
		bitFields[i].setBackground(backgroundColor);
		bitFields[i].setFont(new Font("", Font.PLAIN, Constants.BIT_FIELD_FONT_SIZE));
	}
	
	public static void addTextField(String text, GridBagConstraints constraints, JPanel panel) {
		JTextField temp = new JTextField(text);
		temp.setEditable(false);
		temp.setFocusable(false);
		temp.setEnabled(true);
		if (!text.equals("")) {
			temp.setPreferredSize(new Dimension(
					Constants.BIT_FIELD_INDICATOR_WIDTH,
					Constants.BIT_FIELD_INDICATOR_HEIGHT
			));
		}
		temp.setBorder(TextFields.bitFieldBorder);
		temp.setBackground(UIManager.getColor(panel.getBackground()));
		temp.setForeground(Constants.BIT_FIELD_INDICATOR_FONT_COLOR);
		temp.setFont(new Font("", Font.PLAIN, Constants.BIT_FIELD_INDICATOR_FONT_SIZE));
		temp.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(temp, constraints);
	}

	public static void addTextField(String text, int width, GridBagConstraints constraints, JPanel panel) {
		JTextField temp = new JTextField(text);
		temp.setEditable(false);
		temp.setFocusable(false);
		temp.setEnabled(true);
		temp.setBorder(TextFields.bitFieldBorder);
		temp.setForeground(Constants.BIT_FIELD_INDICATOR_FONT_COLOR);
		temp.setBackground(UIManager.getColor(panel.getBackground()));
		temp.setPreferredSize(new Dimension(width, Constants.BIT_FIELD_HEIGHT));
		panel.add(temp, constraints);
	}

	public static JTextPane newBorderlessTextField(JTextPane textPane, String str, boolean setColor) {
		textPane = new JTextPane();
		textPane.setContentType("text/html");
		textPane.setEditable(false);
		textPane.setText(str);
		if (setColor) {
			textPane.setBackground(Constants.APP_BG_COLOR);
		}
		textPane.setBorder(new EmptyBorder(0,
				0,
				0,
				0));
		return textPane;
	}
	
	public static void setupActionListeners() {
		for (JTextField bitField : bitFields) {
			bitField.addMouseListener(Config.rPanelContext);
		}
	}
	
	public static void invertBitAt(int i) {
		bitFields[i].setText((bitFields[i].getText().equals("0") ? "1" : "0"));
	}
	
	public static void invertBitOf(JTextField bitField) {
		bitField.setText((bitField.getText().equals("0") ? "1" : "0"));
	}
	
	public static String generateBinaryAsString() {
		String binaryNumber = "";
		for (JTextField bitField : bitFields) {
			binaryNumber += bitField.getText();
		}
		return binaryNumber;
	}
	
}
