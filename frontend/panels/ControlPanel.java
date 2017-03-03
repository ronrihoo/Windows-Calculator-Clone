package frontend.panels;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import frontend.listeners.AppActionListener;
import util.Config;
import util.Constants;

public class ControlPanel extends JPanel {

	private JPanel leftControlPanel;
	private JPanel rightControlPanel;
	private JPanel pushButtonPanel;
	private RadioGroup baseRadioGroup;
	private RadioGroup bitRadioGroup;
	private AppActionListener actionListener;

	public ControlPanel() {
		this.shareContext();
		this.actionListener = new AppActionListener();
		this.setPreferredSize(new Dimension(
				Constants.CONTROL_PANEL_WIDTH, 
				Constants.CONTROL_PANEL_HEIGHT));
		this.setLayout(new BorderLayout());
		this.buildLeftSideControls();
		this.buildRightSideControls();
		this.add(leftControlPanel, BorderLayout.WEST);
		this.add(rightControlPanel, BorderLayout.EAST);
	}
	
	public void shareContext() {
		Config.cPanelContext = this;
	}
	
	private void buildLeftSideControls() {
		leftControlPanel = new JPanel();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.weightx = 1;
		constraints.weighty = 1;
		constraints.insets = new Insets(-1,0,0,0);
		leftControlPanel.setLayout(new GridBagLayout());
		leftControlPanel.setBackground(new Color(
						Constants.CONTROL_PANEL_BG_COLOR_R,
						Constants.CONTROL_PANEL_BG_COLOR_G,
						Constants.CONTROL_PANEL_BG_COLOR_B
		));
		buildRadioButtonGroups();
		leftControlPanel.add(baseRadioGroup.getRadioPanel(), constraints);
		constraints.gridy = 1;
		leftControlPanel.add(bitRadioGroup.getRadioPanel(), constraints);
	}
	
	private void buildRightSideControls() {
		rightControlPanel = new JPanel(new BorderLayout());
		rightControlPanel.setBackground(new Color(
				Constants.CONTROL_PANEL_BG_COLOR_R,
				Constants.CONTROL_PANEL_BG_COLOR_G,
				Constants.CONTROL_PANEL_BG_COLOR_B
		));
		rightControlPanel.setBorder(new EmptyBorder(
				-5,
				0,
				0, 
				Constants.PANEL_PADDING/2));
		pushButtonPanel = new ButtonPanel();
		pushButtonPanel.setBackground(Constants.APP_BG_COLOR);
		rightControlPanel.add(pushButtonPanel);
	}
	
	private void buildRadioButtonGroups() {
		baseRadioGroup = new RadioGroup();
		bitRadioGroup = new RadioGroup();
	}

	public JPanel getControlPanel() {
		return this;
	}

	public AppActionListener getActionListener() {
		return actionListener;
	}

}
