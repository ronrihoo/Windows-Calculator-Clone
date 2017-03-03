package frontend.panels;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import frontend.components.Buttons;
import frontend.SwingDesignRules;
import util.Constants;

import java.awt.*;

public class ButtonPanel extends JPanel {
	
	LineBorder buttonBorder;
	GridBagConstraints constraints;
	
	public ButtonPanel() {
		setBorder(new EmptyBorder(0, 
				  0,
				  0, 
				  0));
		setBackground(new Color(
				Constants.CONTROL_PANEL_BG_COLOR_R,
				Constants.CONTROL_PANEL_BG_COLOR_G,
				Constants.CONTROL_PANEL_BG_COLOR_B
		));
		setupButtonPanel();
	}
	
	private void setupButtonPanel() {
		JPanel panel = new JPanel();
		panel.setBackground(Constants.APP_BG_COLOR);
		panel.setLayout(new GridBagLayout());
		panel.setBorder(new EmptyBorder(0, 
								  0,
								  0, 
								  0));
		int row = 0;
		int col = 0;
		int colAdjustment = 0;
		int count = 0;
		constraints = new GridBagConstraints();
		buttonBorder = new LineBorder(
				Color.LIGHT_GRAY, 
				1, 
				true);
		Buttons.pushButtons[39].setBorder(buttonBorder);
		Buttons.pushButtons[43].setBorder(buttonBorder);
		for (JButton button : Buttons.pushButtons) {
			constraints.gridx = col;
			constraints.gridy = row;
			constraints.fill = GridBagConstraints.NONE;
			constraints.gridwidth = GridBagConstraints.RELATIVE;
			constraints.insets = SwingDesignRules
					.distanceBetweenPushButtons(count);
			button.setBorder(buttonBorder);
			if (col == 7 && row == 4){
				constraints.gridwidth = 1;
				constraints.gridheight = 2;
				constraints.fill = GridBagConstraints.VERTICAL;
				button.setPreferredSize(new Dimension(
						Constants.BUTTON_WIDTH, 
						Constants.LONG_BUTTON_HEIGHT));
			} else if (col == 3 && row == 5) {
				constraints.fill = GridBagConstraints.HORIZONTAL;
				constraints.gridwidth = 2;
				constraints.gridheight = 1;
				colAdjustment++;
				button.setPreferredSize(new Dimension(
						Constants.WIDE_BUTTON_WIDTH, 
						Constants.BUTTON_HEIGHT));
			} else {
				constraints.gridx = col + colAdjustment;
				constraints.gridwidth = 1;
				constraints.gridheight = 1;
				button.setPreferredSize(new Dimension(
						Constants.BUTTON_WIDTH, 
						Constants.BUTTON_HEIGHT));
			}
			panel.add(button, constraints);
			if (col == 7) {
				col = 0;
				row++;
			} else {
				col++;
			}
			count++;	// for deciding insets
		}
		add(panel);
	}

}
