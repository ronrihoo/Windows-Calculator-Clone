package util;

import java.awt.*;
import java.util.HashMap;

public class Constants {

	public static final String APP_TITLE = "Calculator";
	public static final int APP_WIDTH = 423;
	public static final int APP_HEIGHT = 387;
	public static final boolean RESIZABLE = true;
	public static final boolean SHOW_GUI = true;
	public static final int BG_COLOR_R = 217;		// Why define separately?
	public static final int BG_COLOR_G = 228;		// Portability.
	public static final int BG_COLOR_B = 241;		// ...
	public static final Color APP_BG_COLOR = new Color(
			BG_COLOR_R,
			BG_COLOR_G,
			BG_COLOR_B
	);

	// menu Bar
	public static final int MENU_BAR_HEIGHT = 20;
	public static final int MENU_BAR_FONT_SIZE = 12;
	public static final int MENU_BAR_BG_COLOR_R = 214;
	public static final int MENU_BAR_BG_COLOR_G = 221;
	public static final int MENU_BAR_BG_COLOR_B = 239;
	
	// Result Panel
	public static final int RESULT_PANEL_WIDTH = 405;
	public static final int RESULT_PANEL_HEIGHT = 128;
	public static final int DECIMAL_JTEXTFIELD_WIDTH = 405;
	public static final int DECIMAL_JTEXTFIELD_HEIGHT = 51;
	public static final int BINARY_JPANEL_WIDTH = 405;
	public static final int BINARY_JPANEL_HEIGHT = 71;
	public static final int BINARY_JTEXTFIELD_QUANTITY = 64;
	public static final int BIT_FIELD_WIDTH = 8;
	public static final int BIT_FIELD_HEIGHT = 10;
	public static final int BIT_FIELD_FONT_SIZE = 12;
	public static final int BIT_FIELD_SEPARATOR_WIDTH = 15;
	public static final int BIT_FIELD_INDICATOR_WIDTH = 6;
	public static final int BIT_FIELD_INDICATOR_HEIGHT = 18;
	public static final int BIT_FIELD_INDICATOR_FONT_SIZE = 11;

	public static final int TEXTFIELD_FONT_SIZE_1 = 23;
	public static final String TEXTFIELD_FONT = "Segoe UI";

	public static final int RESULT_PANEL_BG_COLOR_R = 217;
	public static final int RESULT_PANEL_BG_COLOR_G = 228;
	public static final int RESULT_PANEL_BG_COLOR_B = 241;
	public static final int TEXTFIELD_BG_COLOR_R = 245;
	public static final int TEXTFIELD_BG_COLOR_G = 249;
	public static final int TEXTFIELD_BG_COLOR_B = 253;
	public static final Color BIT_FIELD_INDICATOR_FONT_COLOR = new Color(
			102,
			102,
			102
	);
	
	// Control Panel
	public static final int CONTROL_PANEL_WIDTH = 405;
	public static final int CONTROL_PANEL_HEIGHT = 190;
	public static final int RADIO_BUTTONS_IN_GROUP = 4;
	public static final int BUTTON_QUANTITY = 46;
	public static final int PANEL_PADDING = 10;
	public static final int RADIO_BUTTON_PANEL_WIDTH = 83;
	public static final int RADIO_BUTTON_PANEL_HEIGHT = 93;
	public static final int BUTTON_WIDTH = 34;
	public static final int BUTTON_HEIGHT = 27;
	public static final int WIDE_BUTTON_WIDTH = 73;
	public static final int LONG_BUTTON_HEIGHT = 56;
	public static final String PUSH_BUTTON_FONT = "Segoe UI";
	public static final int RADIO_PANEL_BG_COLOR_R = 217;
	public static final int RADIO_PANEL_BG_COLOR_G = 228;
	public static final int RADIO_PANEL_BG_COLOR_B = 241;
	public static final int CONTROL_PANEL_BG_COLOR_R = 217;
	public static final int CONTROL_PANEL_BG_COLOR_G = 228;
	public static final int CONTROL_PANEL_BG_COLOR_B = 241;

	public static final int RADIO_BUTTON_BG_COLOR_R = 217;
	public static final int RADIO_BUTTON_BG_COLOR_G = 228;
	public static final int RADIO_BUTTON_BG_COLOR_B = 241;
	public static final int PUSH_BUTTON_BG_COLOR_R = 233;
	public static final int PUSH_BUTTON_BG_COLOR_G = 240;
	public static final int PUSH_BUTTON_BG_COLOR_B = 248;
	public static final int PUSH_BUTTON_DISABLED_BG_COLOR_R = 217;
	public static final int PUSH_BUTTON_DISABLED_BG_COLOR_G = 228;
	public static final int PUSH_BUTTON_DISABLED_BG_COLOR_B = 241;
	public static final Color PUSH_BUTTON_BG_COLOR = new Color(
			PUSH_BUTTON_BG_COLOR_R,
			PUSH_BUTTON_BG_COLOR_G,
			PUSH_BUTTON_BG_COLOR_B
	);
	public static final Color PUSH_BUTTON_DISABLED_BG_COLOR = new Color(
			PUSH_BUTTON_DISABLED_BG_COLOR_R,
			PUSH_BUTTON_DISABLED_BG_COLOR_G,
			PUSH_BUTTON_DISABLED_BG_COLOR_B
	);

	public static final String[] BASE_RADIO_BUTTON_TEXT = {
			"Hex", "Dec", "Oct", "Bin"
	};
	public static final String[] BIN_SIZE_RADIO_BUTTON_TEXT = {
			"Qword", "Dword", "Word", "Byte"
	};	
	public static final String[] BUTTON_TEXT_LIST_FULL = {
			"",		"Mod",	"A",	"MC",	"MR",	"MS",	"M+",	"M-",
			"(",	")",	"B",	"←",	"CE",	"C",	"±",	"√",
			"RoL",	"RoR",	"C",	"7",	"8",	"9",	"/",	"%",
			"Or",	"Xor",	"D",	"4",	"5",	"6",	"*",	"1/x",
			"Lsh",	"Rsh",	"E",	"1",	"2",	"3",	"-",	"=",
			"Not",	"And",	"F",	"0",	".",	"+"
	};
	public static final String[] BUTTON_TEXT_LIST = {
		// 	0		1		2		3		4		5		6		7
			"",		"Mod",	"A",	"",		"",		"",		"",		"",
		//	8		9		10		11		12		13		14		15
			"",		"",		"B",	"←",	"CE",	"C",	"±",	"√",
		//	16		17		18		19		20		21		22		23
			"",		"",		"C",	"7",	"8",	"9",	"/",	"%",
		//	24		25		26		27		28		29		30		31
			"",		"",		"D",	"4",	"5",	"6",	"*",	"1/x",
		//	32		33		34		35		36		37		38		39
			"",		"",		"E",	"1",	"2",	"3",	"-",	"=",
		//	40		41		42		43		44		45
			"",		"",		"F",	"0",	".",	"+"
	};
	
	// Backend
	public static final int DISPLAY_STATE_RESULT = 0;
	public static final int DISPLAY_STATE_ENTRY = 1;

	public static final int BIN_BASE = 2;
	public static final int OCT_BASE = 8;
	public static final int DEC_BASE = 10;
	public static final int HEX_BASE = 16;

	public static final int HEX_A_IN_DEC = 10;
	public static final int HEX_B_IN_DEC = 11;
	public static final int HEX_C_IN_DEC = 12;
	public static final int HEX_D_IN_DEC = 13;
	public static final int HEX_E_IN_DEC = 14;
	public static final int HEX_F_IN_DEC = 15;

	public static final HashMap<String, Integer> HEX = new HashMap<String, Integer>(){{
		put("1", 1);
		put("2", 2);
		put("3", 3);
		put("4", 4);
		put("5", 5);
		put("6", 6);
		put("7", 7);
		put("8", 8);
		put("9", 9);
		put("A", 10);
		put("B", 11);
		put("C", 12);
		put("E", 14);
		put("F", 15);
		}};

	public static final String LONG_NEG_MAX = "-9223372036854775808";

	// Errors
	public static String ERROR_DIV_BY_ZERO = "Cannot divide by zero";
	public static String ERROR_MESSAGE = "An error has occurred";

	// About
	public static final String ABOUT = "<HTML>" +
			"<p>" +
			"<BR>" +
			"Brief: A Windows Calculator clone written in Java.<BR>" +
			"Version 1.0 <BR>" +
			"Author: Ron Rihoo<BR>" +
			"</p>" +
			"</HTML>";
	
	// Help
	public static final String HELP = "<HTML>" +
			"<p>" +
			"<H1>Instructions</H1>" +
			"<BR>" +
			"<BR>" +
			"This calculator behaves like the Windows Calculator application<BR>" +
			"for the most part. One feature that has been changed is the invoking<BR>" +
			"of the total function after each arithmetic operation button has been<BR>" +
			"pushed for a second time.<BR>" +
			"<BR>" +
			"This has been done in favor of the capability to change the<BR>" +
			"arithmetic operation after inputting the new number. So the total<BR>" +
			"button, '=', has to be pushed for every new total." +
			"</p>" +
			"</HTML>";

}
