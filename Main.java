
import frontend.components.Buttons;
import frontend.components.TextFields;
import backend.Calculator;
import frontend.AppFrame;
import test.Test;

public class Main {
	
	private static AppFrame appFrame;
	
	public static void main(String[] args) {
		init();
		Test.runAll();
	}
	
	public static void init() {
		Calculator.init();
		TextFields.init();
		Buttons.init();
		appFrame = new AppFrame();
		Buttons.setupActionListeners();
		TextFields.setupActionListeners();
	}

	
}