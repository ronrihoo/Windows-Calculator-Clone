package test;

import static test.Assert.assertEquals;

import backend.Input;
import frontend.components.Buttons;
import frontend.controllers.*;
import frontend.components.TextFields;
import backend.Calculator;
import util.Config;
import util.Constants;

import javax.swing.*;

/* This may seem like a lot of effort for something like this,
 * but as features are changed around, they may affect other
 * parts of the features/code. So constant testing helps to
 * ensure nothing else goes wrong, as intended parts of certain
 * features are changed. This will also help when expanding
 * the project.
 */
public class Test {

    private static int base = 10;
    private static int posNum1 = 3;
    private static int posNum2 = 2;
    private static int negNum1 = -3;
    private static int negNum2 = -2;
    private static int sumTwoPos = posNum1 + posNum2;
    private static int sumTwoNeg = negNum1 + negNum2;
    private static int sumOnePosOneNeg = posNum1 + negNum2;
    private static int diffTwoPos = posNum1 - posNum2;
    private static int diffTwoNeg = negNum1 - negNum2;
    private static int diffOneNegOnePos = negNum1 - posNum2;
    private static int prodTwoPos = posNum1 * posNum2;
    private static int prodTwoNeg = negNum1 * negNum2;
    private static int prodOneNegOnePos = negNum1 * posNum2;
    private static int quotTwoPos = posNum1 / posNum2;
    private static int quotTwoNeg = negNum1 / negNum2;
    private static int quotOnePosOneNeg = posNum1 / negNum2;
    private static int quotOneNegOnePos = negNum1 / posNum2;
    private static int quotZeroByNum = 0 / posNum1;
    private static String quotNumByZero = Constants.ERROR_DIV_BY_ZERO;
    private static String hex222 = "DE";
    private static String dec222 = "222";
    private static String oct222 = "336";
    private static String bin222 = "11011110";
    private static String hexDF = "DF";
    private static String hexD = "D";
    private static String dec22 = "22";
    private static String oct332 = "332";
    private static String oct33 = "33";
    private static String bin1101 = "1101";
    private static String bin110 = "110";
    private static String add = " + ";
    private static String sub = " - ";
    private static String mul = " * ";
    private static String div = " / ";


    public static void runAll() {
        System.out.println("Arithmetic tests...");
        arithmetic(10);
        System.out.println();
        System.out.println("Base conversion tests...");
        convertHexDecOctBin();
        binaryBits();
        System.out.println();
        System.out.println("C, CE, and Backspace tests...");
        Input.buttonClearAction();
        clear();
        clearEntry();
        backspace();
        System.out.println();
        System.out.println("Menu action tests...");
        copy();
    }
    
    private static void arithmetic(int newBase) {
        base = newBase;
        addTwoPosNums();
        Input.buttonClearAction();
        addTwoNegNums();
        Input.buttonClearAction();
        addOnePosOneNeg();
        Input.buttonClearAction();
        subTwoPosNums();
        Input.buttonClearAction();
        subTwoNegNums();
        Input.buttonClearAction();
        subOneNegOnePos();
        Input.buttonClearAction();
        mulTwoPosNums();
        Input.buttonClearAction();
        mulTwoNegNums();
        Input.buttonClearAction();
        mulOneNegOnePos();
        Input.buttonClearAction();
        divTwoPosNums();
        Input.buttonClearAction();
        divTwoNegNums();
        Input.buttonClearAction();
        divOnePosOneNeg();
        Input.buttonClearAction();
        divOneNegOnePos();
        Input.buttonClearAction();
        divZeroByNum();
        Input.buttonClearAction();
        divNumByZero();
        Input.buttonClearAction();
        // ensure base 10 on return
        setBase(10);
    }
    
    private static void addTwoPosNums() {
        setBase(base);
        Input.button3Action();
        Input.buttonAddAction();
        Input.button2Action();
        Input.buttonEnterAction();
        Display.update();
        assertEquals(TextFields.resultField.getText(),
                String.valueOf(sumTwoPos),
                posNum1,
                posNum2,
                add
        );
    }

    private static void addTwoNegNums() {
        setBase(base);
        Input.button3Action();
        Input.buttonSignAction();
        Input.buttonAddAction();
        Input.button2Action();
        Input.buttonSignAction();
        Input.buttonEnterAction();
        Display.update();
        assertEquals(TextFields.resultField.getText(),
                String.valueOf(sumTwoNeg),
                negNum1,
                negNum2,
                add
        );
    }

    private static void addOnePosOneNeg() {
        setBase(base);
        Input.button3Action();
        Input.buttonAddAction();
        Input.button2Action();
        Input.buttonSignAction();
        Input.buttonEnterAction();
        Display.update();
        assertEquals(TextFields.resultField.getText(),
                String.valueOf(sumOnePosOneNeg),
                posNum1,
                negNum2,
                add
        );
    }

    private static void subTwoPosNums() {
        setBase(base);
        Input.button3Action();
        Input.buttonSubAction();
        Input.button2Action();
        Input.buttonEnterAction();
        Display.update();
        assertEquals(TextFields.resultField.getText(),
                String.valueOf(diffTwoPos),
                posNum1,
                posNum2,
                sub
        );
    }

    private static void subTwoNegNums() {
        setBase(base);
        Input.button3Action();
        Input.buttonSignAction();
        Input.buttonSubAction();
        Input.button2Action();
        Input.buttonSignAction();
        Input.buttonEnterAction();
        Display.update();
        assertEquals(TextFields.resultField.getText(),
                String.valueOf(diffTwoNeg),
                negNum1,
                negNum2,
                sub
        );
    }

    private static void subOneNegOnePos() {
        setBase(base);
        Input.button3Action();
        Input.buttonSignAction();
        Input.buttonSubAction();
        Input.button2Action();
        Input.buttonEnterAction();
        Display.update();
        assertEquals(TextFields.resultField.getText(),
                String.valueOf(diffOneNegOnePos),
                negNum1,
                posNum2,
                sub
        );
    }

    private static void mulTwoPosNums() {
        setBase(base);
        Input.button3Action();
        Input.buttonMulAction();
        Input.button2Action();
        Input.buttonEnterAction();
        Display.update();
        assertEquals(TextFields.resultField.getText(),
                String.valueOf(prodTwoPos),
                posNum1,
                posNum2,
                mul
        );
    }

    private static void mulTwoNegNums() {
        setBase(base);
        Input.button3Action();
        Input.buttonSignAction();
        Input.buttonMulAction();
        Input.button2Action();
        Input.buttonSignAction();
        Input.buttonEnterAction();
        Display.update();
        assertEquals(TextFields.resultField.getText(),
                String.valueOf(prodTwoNeg),
                negNum1,
                negNum2,
                mul
        );
    }

    private static void mulOneNegOnePos() {
        setBase(base);
        Input.button3Action();
        Input.buttonSignAction();
        Input.buttonMulAction();
        Input.button2Action();
        Input.buttonEnterAction();
        Display.update();
        assertEquals(TextFields.resultField.getText(),
                String.valueOf(prodOneNegOnePos),
                negNum1,
                posNum2,
                mul
        );
    }

    private static void divTwoPosNums() {
        setBase(base);
        Input.button3Action();
        Input.buttonDivAction();
        Input.button2Action();
        Input.buttonEnterAction();
        Display.update();
        assertEquals(TextFields.resultField.getText(),
                String.valueOf(quotTwoPos),
                posNum1,
                posNum2,
                div
        );
    }

    private static void divTwoNegNums() {
        setBase(base);
        Input.button3Action();
        Input.buttonSignAction();
        Input.buttonDivAction();
        Input.button2Action();
        Input.buttonSignAction();
        Input.buttonEnterAction();
        Display.update();
        assertEquals(TextFields.resultField.getText(),
                String.valueOf(quotTwoNeg),
                negNum1,
                negNum2,
                div
        );
    }

    private static void divOneNegOnePos() {
        setBase(base);
        Input.button3Action();
        Input.buttonSignAction();
        Input.buttonDivAction();
        Input.button2Action();
        Input.buttonEnterAction();
        Display.update();
        assertEquals(TextFields.resultField.getText(),
                String.valueOf(quotOneNegOnePos),
                negNum1,
                posNum2,
                div
        );
    }

    private static void divOnePosOneNeg() {
        setBase(base);
        Input.button3Action();
        Input.buttonDivAction();
        Input.button2Action();
        Input.buttonSignAction();
        Input.buttonEnterAction();
        Display.update();
        assertEquals(TextFields.resultField.getText(),
                String.valueOf(quotOnePosOneNeg),
                posNum1,
                negNum2,
                div
        );
    }

    private static void divZeroByNum() {
        setBase(base);
        Input.button0Action();
        Input.buttonDivAction();
        Input.button2Action();
        Input.buttonEnterAction();
        Display.update();
        assertEquals(TextFields.resultField.getText(),
                String.valueOf(quotZeroByNum),
                0,
                posNum2,
                div
        );
    }

    private static void divNumByZero() {
        setBase(base);
        Input.button3Action();
        Input.buttonDivAction();
        Input.button0Action();
        Input.buttonEnterAction();
        Display.update();
        assertEquals(TextFields.resultField.getText(),
                quotNumByZero,
                posNum1,
                0,
                div
        );
    }

    private static void convertHexDecOctBin() {
        setBase(base);
        // insert 222 as entry
        Input.button2Action();
        Input.button2Action();
        Input.button2Action();
        // check Hex
        setBase(16);
        assertEquals(TextFields.resultField.getText(), hex222, "decimal to hex", dec222);
        // check Decimal
        setBase(10);
        assertEquals(TextFields.resultField.getText(), dec222, "decimal", dec222);
        // check Octal
        setBase(8);
        assertEquals(TextFields.resultField.getText(), oct222, "decimal to octal", dec222);
        // check Binary
        setBase(2);
        assertEquals(TextFields.resultField.getText(), bin222, "decimal to binary", dec222);
        // back to Decimal mode
        setBase(10);
    }

    private static void clear() {
        Input.button3Action();
        Input.buttonAddAction();                  // add is op 6
        Input.button2Action();
        Input.buttonClearAction();
        Display.update();
        assertEquals(TextFields.resultField.getText(),
                Calculator.getResult(),
                Calculator.getEntry(),
                Calculator.getHold(),
                Calculator.getOp(),
                "0",
                0,
                0,
                0,
                9,
                "TextField.getText()",
                "Calculator.getResult()",
                "Calculator.getEntry()",
                "Calculator.getHold()",
                "Calculator.getOp()",
                "Clear button behaves like on Windows' Calculator"
        );
    }

    private static void clearEntry() {
        Input.button3Action();
        Input.buttonAddAction();
        Input.button2Action();
        Input.buttonClearEntryAction();
        Display.update();
        assertEquals(TextFields.resultField.getText(),
                Calculator.getResult(),
                Calculator.getEntry(),
                Calculator.getHold(),
                Calculator.getOp(),
                "0",
                3,
                0,
                0,
                6,
                "TextField.getText()",
                "Calculator.getResult()",
                "Calculator.getEntry()",
                "Calculator.getHold()",
                "Calculator.getOp()",
                "CE button behaves like on Windows' Calculator"
        );
    }

    private static void backspace() {
        // hex
        setBase(16);
        Input.buttonClearEntryAction();
        Input.buttonDAction();
        Input.buttonFAction();
        Input.buttonBackAction();
        Display.update();
        assertEquals(TextFields.resultField.getText(), hexD, "hex backspace", hexDF);
        // decimal
        setBase(10);
        Input.buttonClearEntryAction();
        Input.button2Action();
        Input.button2Action();
        Input.button2Action();
        Input.buttonBackAction();
        Display.update();
        assertEquals(TextFields.resultField.getText(), dec22, "decimal backspace", dec222);
        // octal
        setBase(8);
        Input.buttonClearEntryAction();
        Input.button3Action();
        Input.button3Action();
        Input.button2Action();
        Input.buttonBackAction();
        Display.update();
        assertEquals(TextFields.resultField.getText(), oct33, "octal backspace", oct332);
        // binary
        setBase(2);
        Input.buttonClearEntryAction();
        Input.button1Action();
        Input.button1Action();
        Input.button0Action();
        Input.button1Action();
        Input.buttonBackAction();
        Display.update();
        assertEquals(TextFields.resultField.getText(), bin110, "binary backspace", bin1101);
        // return back to decimal mode
        setBase(10);
    }

    private static void binaryBits() {
        String bits = "";
        for (JTextField bitField : TextFields.bitFields) {
            bits += bitField.getText();
        }
        // switch to binary mode
        setBase(2);
        assertEquals(TextFields.resultField.getText(),
                String.valueOf(Long.parseLong(bits)),
                "bit JTextFields display the same thing as binary result");
        // return to decimal mode
        setBase(10);
    }

    private static void copy() {
        Input.button3Action();
        Input.button2Action();
        Input.button4Action();
        Display.update();
        Config.mBarContext.getAppMenuListeners().copy();
        assertEquals(Config.mBarContext.getAppMenuListeners().paste().toString(),
                "324",
                "copy feature transfers JTextField content onto clipboard"
        );
        // clear clipboard
        Config.mBarContext.getAppMenuListeners().copy("");
        returnToDefaultState();
    }

    private static void setBase(int base) {
        if (base == Constants.HEX_BASE) {
            Input.radioButtonHex();
            Buttons.baseRadioButtons[0].setSelected(true);
            Display.update();
        } else if (base == Constants.DEC_BASE) {
            Input.radioButtonDec();
            Buttons.baseRadioButtons[1].setSelected(true);
            Display.update();
        } else if (base == Constants.OCT_BASE) {
            Input.radioButtonOct();
            Buttons.baseRadioButtons[2].setSelected(true);
            Display.update();
        } else if (base == Constants.BIN_BASE) {
            Input.radioButtonBin();
            Buttons.baseRadioButtons[3].setSelected(true);
            Display.update();
        }
    }

    private static void returnToDefaultState() {
        setBase(10);
        Buttons.baseRadioButtons[1].setSelected(true);
        Calculator.clear();
        Display.update();
    }

}
