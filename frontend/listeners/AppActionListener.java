package frontend.listeners;

import backend.Input;
import frontend.components.Buttons;
import frontend.controllers.Display;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppActionListener implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        // RadioActions
        if (e.getSource() == Buttons.baseRadioButtons[0]) {
            Buttons.radioButtonHex();
        } else if (e.getSource() == Buttons.baseRadioButtons[1]) {
            Buttons.radioButtonDec();
        } else if (e.getSource() == Buttons.baseRadioButtons[2]) {
            Buttons.radioButtonOct();
        } else if (e.getSource() == Buttons.baseRadioButtons[3]) {
            Buttons.radioButtonBin();
        }

        // pushButtons

        // 0
        else if (e.getSource() == Buttons.pushButtons[43]) {
            Input.button0Action();
        }
        // 1
        else if (e.getSource() == Buttons.pushButtons[35]) {
            Input.button1Action();
        }
        // 2
        else if (e.getSource() == Buttons.pushButtons[36]) {
            Input.button2Action();
        }
        // 3
        else if (e.getSource() == Buttons.pushButtons[37]) {
            Input.button3Action();
        }
        // 4
        else if (e.getSource() == Buttons.pushButtons[27]) {
            Input.button4Action();
        }
        // 5
        else if (e.getSource() == Buttons.pushButtons[28]) {
            Input.button5Action();
        }
        // 6
        else if (e.getSource() == Buttons.pushButtons[29]) {
            Input.button6Action();
        }
        // 7
        else if (e.getSource() == Buttons.pushButtons[19]) {
            Input.button7Action();
        }
        // 8
        else if (e.getSource() == Buttons.pushButtons[20]) {
            Input.button8Action();
        }
        // 9
        else if (e.getSource() == Buttons.pushButtons[21]) {
            Input.button9Action();
        }
        // A
        else if (e.getSource() == Buttons.pushButtons[2]) {
            Input.buttonAAction();
        }
        // B
        else if (e.getSource() == Buttons.pushButtons[10]) {
            Input.buttonBAction();
        }
        // C
        else if (e.getSource() == Buttons.pushButtons[18]) {
            Input.buttonCAction();
        }
        // D
        else if (e.getSource() == Buttons.pushButtons[26]) {
            Input.buttonDAction();
        }
        // E
        else if (e.getSource() == Buttons.pushButtons[34]) {
            Input.buttonEAction();
        }
        // F
        else if (e.getSource() == Buttons.pushButtons[42]) {
            Input.buttonFAction();
        }
        // mod
        else if (e.getSource() == Buttons.pushButtons[1]) {
            Input.buttonModAction();
        }
        // add
        else if (e.getSource() == Buttons.pushButtons[45]) {
            Input.buttonAddAction();
        }
        // sub
        else if (e.getSource() == Buttons.pushButtons[38]) {
            Input.buttonSubAction();
        }
        // mul
        else if (e.getSource() == Buttons.pushButtons[30]) {
            Input.buttonMulAction();
        }
        // div
        else if (e.getSource() == Buttons.pushButtons[22]) {
            Input.buttonDivAction();
        }
        // +/-
        else if (e.getSource() == Buttons.pushButtons[14]) {
            Input.buttonSignAction();
        }
        // Enter
        else if (e.getSource() == Buttons.pushButtons[39]) {
            Input.buttonEnterAction();
        }
        // Back
        else if (e.getSource() == Buttons.pushButtons[11]) {
            Input.buttonBackAction();
        }
        // Clear
        else if (e.getSource() == Buttons.pushButtons[13]) {
            Input.buttonClearAction();
        }
        // Clear Entry
        else if (e.getSource() == Buttons.pushButtons[12]) {
            Input.buttonClearEntryAction();
        }
        Display.update();
    }

}
