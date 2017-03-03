package frontend.menu;

import javax.swing.*;

import frontend.components.TextFields;
import util.Constants;

import java.awt.*;

public class Help extends JDialog {
	
	JPanel helpPanel;
	JTextPane helpPane;

    public Help() {
        this.setTitle("Documentation");
        this.setSize(new Dimension(
                400,
                400)
        );
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);
        this.setDefaultLookAndFeelDecorated(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setupHelpPanel();
        this.add(helpPanel, BorderLayout.LINE_START);
        this.setVisible(true);
    }
    
    private void setupHelpPanel() {
    	helpPanel = new JPanel();
    	helpPanel.setBackground(Color.WHITE);
    	helpPanel.add(TextFields.newBorderlessTextField(helpPane, 
    			Constants.HELP, false));
    }


}
