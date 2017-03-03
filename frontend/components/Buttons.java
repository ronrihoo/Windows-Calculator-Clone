package frontend.components;

import backend.Input;
import util.Config;
import util.Constants;

import javax.swing.*;
import java.awt.*;

public class Buttons {

    private static int radioButtonGroupCount;
    public static JRadioButton[] baseRadioButtons;
    public static JRadioButton[] bitRadioButtons;
    public static JButton[] pushButtons;

    public static void init() {
        setupBaseRadioButtons();
        setupBinRadioButtons();
        setupButtons();
        setInitialButtonStates();
        setPushButtonColor();
    }

    private static void setupBaseRadioButtons() {
        baseRadioButtons = new JRadioButton[Constants.RADIO_BUTTONS_IN_GROUP];
        for (int i = 0; i < Constants.RADIO_BUTTONS_IN_GROUP; i++) {
            baseRadioButtons[i] =
                    new JRadioButton(Constants.BASE_RADIO_BUTTON_TEXT[i]);
            baseRadioButtons[i].setBackground(new Color(
                    Constants.RADIO_BUTTON_BG_COLOR_R,
                    Constants.RADIO_BUTTON_BG_COLOR_G,
                    Constants.RADIO_BUTTON_BG_COLOR_B
            ));
            baseRadioButtons[i].setFocusable(false);
        }
    }

    private static void setupBinRadioButtons() {
        bitRadioButtons = new JRadioButton[Constants.RADIO_BUTTONS_IN_GROUP];
        for (int i = 0; i < Constants.RADIO_BUTTONS_IN_GROUP; i++) {
            bitRadioButtons[i] =
                    new JRadioButton(Constants.BIN_SIZE_RADIO_BUTTON_TEXT[i]);
            bitRadioButtons[i].setBackground(new Color(
                    Constants.RADIO_BUTTON_BG_COLOR_R,
                    Constants.RADIO_BUTTON_BG_COLOR_G,
                    Constants.RADIO_BUTTON_BG_COLOR_B
            ));
            bitRadioButtons[i].setFocusable(false);
        }
    }

    private static void setupButtons() {
        pushButtons = new JButton[Constants.BUTTON_QUANTITY];
        for (int i = 0; i < Constants.BUTTON_QUANTITY; i++) {
            pushButtons[i] =
                    new JButton(Constants.BUTTON_TEXT_LIST[i]);
            pushButtons[i].setBackground(new Color(
                    Constants.RADIO_BUTTON_BG_COLOR_R,
                    Constants.RADIO_BUTTON_BG_COLOR_G,
                    Constants.RADIO_BUTTON_BG_COLOR_B
            ));
            pushButtons[i].setFocusable(false);
        }
    }

    private static void setInitialButtonStates() {
        baseRadioButtons[1].setSelected(true);
        bitRadioButtons[0].setSelected(true);
        setEnabledBitRadioButtons(false);
        setEnabledUnusedPushButtons(false);
        setEnabledHexButtons(false);
        setEnabledDecButtons(true);
    }

    public static void setEnabledBitRadioButtons(boolean b) {
        bitRadioButtons[0].setEnabled(b);
        bitRadioButtons[1].setEnabled(b);
        bitRadioButtons[2].setEnabled(b);
        bitRadioButtons[3].setEnabled(b);
    }

    public static void setEnabledUnusedPushButtons(boolean b) {
        for (int i = 0; i < pushButtons.length; i++) {
            if (((i + 1) % 8 == 0 && i < 32) ||
                    i % 8 == 0 ||
                    ((i - 1) % 8 == 0 && i > 1) ||
                    (i > 2 && i < 7) ||
                    i == 44) {
                pushButtons[i].setEnabled(b);
            }
        }
    }

    // Input A-F
    public static void setEnabledHexButtons(boolean b) {
        pushButtons[2].setEnabled(b);		// A
        pushButtons[10].setEnabled(b);		// B
        pushButtons[18].setEnabled(b);		// C
        pushButtons[26].setEnabled(b);		// D
        pushButtons[34].setEnabled(b);		// E
        pushButtons[42].setEnabled(b);		// F
    }

    // Input 2-9
    public static void setEnabledDecButtons(boolean b) {
        pushButtons[36].setEnabled(b);		// 2
        pushButtons[37].setEnabled(b);		// 3
        pushButtons[27].setEnabled(b);		// 4
        pushButtons[28].setEnabled(b);		// 5
        pushButtons[29].setEnabled(b);		// 6
        pushButtons[19].setEnabled(b);		// 7
        pushButtons[20].setEnabled(b);		// 8
        pushButtons[21].setEnabled(b);		// 9
    }

    // Input 2-7, but not buttons 8 and 9
    public static void setEnabledOctButtons(boolean b) {
        pushButtons[36].setEnabled(b);		// 2
        pushButtons[37].setEnabled(b);		// 3
        pushButtons[27].setEnabled(b);		// 4
        pushButtons[28].setEnabled(b);		// 5
        pushButtons[29].setEnabled(b);		// 6
        pushButtons[19].setEnabled(b);		// 7
        pushButtons[20].setEnabled(!b);		// !8
        pushButtons[21].setEnabled(!b);		// !9
    }

    public static void setPushButtonColor() {
        for (JButton button : pushButtons) {
            if (button.isEnabled()) {
                button.setBackground(Constants.PUSH_BUTTON_BG_COLOR);
            } else {
                button.setBackground(Constants.PUSH_BUTTON_DISABLED_BG_COLOR);
            }
        }
    }

    public static void setupActionListeners() {
        for (JRadioButton button : baseRadioButtons) {
            button.addActionListener(Config.cPanelContext.getActionListener());
        }
        for (JRadioButton button : bitRadioButtons) {
            button.addActionListener(Config.cPanelContext.getActionListener());
        }
        for (JButton button : pushButtons) {
            button.addActionListener(Config.cPanelContext.getActionListener());
        }
    }

    // "Hex" RadioButton

    public static void radioButtonHex() {
        Input.radioButtonHex();
        setEnabledHexButtons(true);
        setEnabledDecButtons(true);
        setPushButtonColor();
    }

    // "Dec" RadioButton
    public static void radioButtonDec() {
        Input.radioButtonDec();
        setEnabledHexButtons(false);
        setEnabledDecButtons(true);
        setPushButtonColor();
    }

    // "Oct" RadioButton
    public static void radioButtonOct() {
        Input.radioButtonOct();
        setEnabledHexButtons(false);
        setEnabledOctButtons(true);
        setPushButtonColor();
    }

    // "Bin" RadioButton
    public static void radioButtonBin() {
        Input.radioButtonBin();
        setEnabledHexButtons(false);
        setEnabledDecButtons(false);
        setPushButtonColor();
    }

    // Getters and Setters
    public static int getRadioButtonGroupCount() {
        return radioButtonGroupCount;
    }
    public static void setRadioButtonGroupCount(int count) {
        radioButtonGroupCount = count;
    }
    public static JRadioButton[] getBaseRadioButtons() {
        return baseRadioButtons;
    }
    public static void setBaseRadioButtons(JRadioButton[] buttons) {
        baseRadioButtons = buttons;
    }
    public static JRadioButton[] getBitRadioButtons() {
        return bitRadioButtons;
    }
    public static void setBitRadioButtons(JRadioButton[] buttons) {
        bitRadioButtons = buttons;
    }

}
