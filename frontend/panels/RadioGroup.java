package frontend.panels;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import frontend.components.Buttons;
import util.Constants;

public class RadioGroup extends JPanel {

	private ButtonGroup radioGroup;
	private GridBagConstraints constraints;
	private LineBorder radioGroupBorder;
	private Font font;
	private int y;

	public RadioGroup() {
		this.setupRadioButtonPanel(Constants.RADIO_BUTTONS_IN_GROUP);
	}
		
	private void setupRadioButtonPanel(int radioButtonQuantity) {
		setLayout(new GridBagLayout());
		setBackground(new Color(
				Constants.RADIO_PANEL_BG_COLOR_R,
				Constants.RADIO_PANEL_BG_COLOR_G,
				Constants.RADIO_PANEL_BG_COLOR_B
		));
		radioGroupBorder = new LineBorder(Color.LIGHT_GRAY, 1, true);
		font = new Font("", Font.PLAIN, 11);
		radioGroup = new ButtonGroup();
		if (Buttons.getRadioButtonGroupCount() == 0) {
			setPreferredSize(new Dimension(
					Constants.RADIO_BUTTON_PANEL_WIDTH,
					Constants.RADIO_BUTTON_PANEL_HEIGHT + 2));
			setBorder(BorderFactory.createCompoundBorder(
					new EmptyBorder(0,
									Constants.PANEL_PADDING,
									3,
									0), radioGroupBorder));
			Buttons.setRadioButtonGroupCount(1);
			addButtonsToGroupAndPanel(Buttons.baseRadioButtons);
		} else {
			setPreferredSize(new Dimension(
					Constants.RADIO_BUTTON_PANEL_WIDTH,
					Constants.RADIO_BUTTON_PANEL_HEIGHT + 4));
			setBorder(BorderFactory.createCompoundBorder(
					new EmptyBorder(3,
									Constants.PANEL_PADDING, 
									Constants.PANEL_PADDING/2 - 2,
									0), radioGroupBorder));
			addButtonsToGroupAndPanel(Buttons.bitRadioButtons);
		}
	}
	
	public void addButtonsToGroupAndPanel(JRadioButton[] radioButtons) {
		constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.weightx = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.anchor = GridBagConstraints.LINE_START;
		constraints.insets = new Insets(-2,5,-1,0);
		y = 0;
		for (JRadioButton radioButton : radioButtons) {
			radioButton.setFont(font);
			constraints.gridy = y++;
			radioGroup.add(radioButton);
			add(radioButton, constraints);
		}
	}

	public JPanel getRadioPanel() {
		return this;
	}

	public ButtonGroup getRadioGroup() {
		return radioGroup;
	}
	
}
