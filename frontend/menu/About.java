package frontend.menu;

import frontend.components.TextFields;
import util.Constants;

import javax.swing.*;
import java.awt.*;

public class About extends JDialog {

    JPanel about;
    JTextPane textPane;

    public About () {
        this.setTitle("About");
        this.setSize(new Dimension(
                350,
                150)
        );
        this.setResizable(false);
        this.setBackground(Constants.APP_BG_COLOR);
        this.setLayout(new BorderLayout());
        this.setDefaultLookAndFeelDecorated(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setupPanel();
        this.add(about, BorderLayout.CENTER);
        this.setVisible(true);
    }

    private void setupPanel() {
        about = new JPanel();
        about.setBackground(Constants.APP_BG_COLOR);
        about.add(TextFields.newBorderlessTextField(textPane, 
        		Constants.ABOUT, true));
    }


}
