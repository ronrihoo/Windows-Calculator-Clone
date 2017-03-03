package frontend;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

import frontend.listeners.AppKeyListener;
import frontend.menu.MenuBar;
import frontend.panels.ControlPanel;
import frontend.panels.ResultPanel;
import util.Constants;

public class AppFrame {
	
	public static JFrame frame;
	private MenuBar menuBar;
	private JPanel mainPanel;			// for padding from the frame borders
	private ResultPanel resultPanel;	// for displaying results
	private ControlPanel controlPanel;	// for all buttons
	private GridBagConstraints constraints;
	
	public AppFrame() {
		this.buildGUI();
		this.showGUI();
	}

	public void buildGUI() {
		frame = new JFrame(Constants.APP_TITLE);
		frame.setSize(Constants.APP_WIDTH, Constants.APP_HEIGHT);
		frame.setLayout(new BorderLayout());
		frame.setResizable(Constants.RESIZABLE);
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setupMenuBar();
		setupMainPanel();
		frame.setJMenuBar(menuBar);
		frame.add(mainPanel, BorderLayout.CENTER);
		frame.setFocusable(true);
		frame.addKeyListener(new AppKeyListener());
		frame.setState(Frame.NORMAL);
		frame.toFront();
	}
	
	private void setupMenuBar() {
		menuBar = new MenuBar();
		menuBar.setFocusable(false);
	}
	
	private void setupMainPanel() {
		mainPanel = new JPanel();
		resultPanel = new ResultPanel();
		controlPanel = new ControlPanel();
		constraints = new GridBagConstraints();
		mainPanel.setBackground(new Color(
				Constants.BG_COLOR_R,
				Constants.BG_COLOR_G,
				Constants.BG_COLOR_B
		));
		mainPanel.setLayout(new GridBagLayout());
		constraints.gridy = 0;
		constraints.insets = new Insets(-2,0,0,0);
		mainPanel.add(resultPanel, constraints);
		constraints.gridy = 1;
		constraints.insets = new Insets(0,0,0,0);
		mainPanel.add(controlPanel, constraints);
	}
	
	public void showGUI() {
		frame.setVisible(Constants.SHOW_GUI);
	}

}
