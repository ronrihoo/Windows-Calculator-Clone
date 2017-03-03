package frontend.listeners;

import backend.Calculator;
import backend.Input;
import frontend.controllers.Display;
import util.Constants;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AppKeyListener implements KeyListener {

    @Override
    public void keyTyped(KeyEvent k) {

    }

    @Override
    public void keyPressed(KeyEvent k) {
        // 0
        if (k.getKeyCode() == KeyEvent.VK_0 ||
                k.getKeyCode() == KeyEvent.VK_NUMPAD0) {
            Input.button0Action();
        }
        // 1
        else if ((k.getKeyCode() == KeyEvent.VK_1 ||
                k.getKeyCode() == KeyEvent.VK_NUMPAD1)) {
            Input.button1Action();
        }
        // 2
        else if ((k.getKeyCode() == KeyEvent.VK_2 ||
                k.getKeyCode() == KeyEvent.VK_NUMPAD2) &&
                (Calculator.getBase() != Constants.BIN_BASE)) {
            Input.button2Action();
        }
        // 3
        else if ((k.getKeyCode() == KeyEvent.VK_3 ||
                k.getKeyCode() == KeyEvent.VK_NUMPAD3) &&
                (Calculator.getBase() != Constants.BIN_BASE)) {
            Input.button3Action();
        }
        // 4
        else if ((k.getKeyCode() == KeyEvent.VK_4 ||
                k.getKeyCode() == KeyEvent.VK_NUMPAD4) &&
                (Calculator.getBase() != Constants.BIN_BASE)) {
            Input.button4Action();
        }
        // 5
        else if ((k.getKeyCode() == KeyEvent.VK_5 ||
                k.getKeyCode() == KeyEvent.VK_NUMPAD5) &&
                (Calculator.getBase() != Constants.BIN_BASE)) {
            Input.button5Action();
        }
        // 6
        else if ((k.getKeyCode() == KeyEvent.VK_6 ||
                k.getKeyCode() == KeyEvent.VK_NUMPAD6) &&
                (Calculator.getBase() != Constants.BIN_BASE)) {
            Input.button6Action();
        }
        // 7
        else if ((k.getKeyCode() == KeyEvent.VK_7 ||
                k.getKeyCode() == KeyEvent.VK_NUMPAD7) &&
                (Calculator.getBase() != Constants.BIN_BASE)) {
            Input.button7Action();
        }
        // 8
        else if ((k.getKeyCode() == KeyEvent.VK_8 ||
                k.getKeyCode() == KeyEvent.VK_NUMPAD8) &&
                (Calculator.getBase() != Constants.BIN_BASE &&
                    Calculator.getBase() != Constants.OCT_BASE)) {
            Input.button8Action();
        }
        // 9
        else if ((k.getKeyCode() == KeyEvent.VK_9 ||
                k.getKeyCode() == KeyEvent.VK_NUMPAD9) &&
                (Calculator.getBase() != Constants.BIN_BASE &&
                        Calculator.getBase() != Constants.OCT_BASE)) {
            Input.button9Action();
        }
        // A
        else if (k.getKeyCode() == KeyEvent.VK_A &&
                Calculator.getBase() == Constants.HEX_BASE) {
            Input.buttonAAction();
        }
        // B
        else if (k.getKeyCode() == KeyEvent.VK_B &&
                Calculator.getBase() == Constants.HEX_BASE) {
            Input.buttonBAction();
        }
        // C
        else if (k.getKeyCode() == KeyEvent.VK_C &&
                Calculator.getBase() == Constants.HEX_BASE) {
            Input.buttonCAction();
        }
        // D
        else if (k.getKeyCode() == KeyEvent.VK_D &&
                Calculator.getBase() == Constants.HEX_BASE) {
            Input.buttonDAction();
        }
        // E
        else if (k.getKeyCode() == KeyEvent.VK_E &&
                Calculator.getBase() == Constants.HEX_BASE) {
            Input.buttonEAction();
        }
        // F
        else if (k.getKeyCode() == KeyEvent.VK_F &&
                Calculator.getBase() == Constants.HEX_BASE) {
            Input.buttonFAction();
        }
        // add
        else if (k.getKeyCode() == KeyEvent.VK_ADD) {
            Input.buttonAddAction();
        }
        // sub
        else if (k.getKeyCode() == KeyEvent.VK_SUBTRACT) {
            Input.buttonSubAction();
        }
        // mul
        else if (k.getKeyCode() == KeyEvent.VK_MULTIPLY) {
            Input.buttonMulAction();
        }
        // div
        else if (k.getKeyCode() == KeyEvent.VK_DIVIDE) {
            Input.buttonDivAction();
        }
        // Enter
        else if (k.getKeyCode() == KeyEvent.VK_ENTER) {
            Input.buttonEnterAction();
        }
        // Back
        else if (k.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            Input.buttonBackAction();
        }
        // Clear
        else if (k.getKeyCode() == KeyEvent.VK_ESCAPE) {
            Input.buttonClearAction();
        }
        Display.update();
    }

    public void keyReleased(KeyEvent k) {

    }

}
