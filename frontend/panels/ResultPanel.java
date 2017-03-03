package frontend.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import frontend.controllers.Display;
import frontend.components.TextFields;
import backend.BaseConverter;
import backend.Calculator;
import util.Config;
import util.Constants;

public class ResultPanel extends JPanel implements MouseListener {

	private JPanel resultPanelHelper;
	private JPanel decimalResultPanel;
	private JPanel binaryResultPanel;
	private LineBorder resultPanelBorder;
	private LineBorder binaryPanelBorder;
	private GridBagConstraints constraints;

	public ResultPanel() {
		this.shareContext();
		setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(
				Constants.RESULT_PANEL_WIDTH,
				Constants.RESULT_PANEL_HEIGHT - 6));
		this.resultPanelHelper = new JPanel (new GridBagLayout());
		this.buildDecimalResultPanel();
		this.buildBinaryResultPanel();
		this.constraints = new GridBagConstraints();
		this.constraints.gridy = 0;
		this.resultPanelHelper.add(decimalResultPanel, constraints);
		this.constraints.gridy = 1;
		this.resultPanelHelper.add(binaryResultPanel, constraints);
		this.add(resultPanelHelper);
	}
	
	private void shareContext() {
		Config.rPanelContext = this;
	}
	
	private void buildDecimalResultPanel() {
		decimalResultPanel = new JPanel();
		decimalResultPanel.setBackground(new Color(
				Constants.RESULT_PANEL_BG_COLOR_R,
				Constants.RESULT_PANEL_BG_COLOR_G,
				Constants.RESULT_PANEL_BG_COLOR_B
		));
		resultPanelBorder = new LineBorder(Color.LIGHT_GRAY, 1, true);
		decimalResultPanel.setBorder(BorderFactory
				.createCompoundBorder(new EmptyBorder(
						Constants.PANEL_PADDING/6,
						Constants.PANEL_PADDING, 
						0, 
						Constants.PANEL_PADDING), 
				resultPanelBorder));
		decimalResultPanel.setPreferredSize(new Dimension(
				Constants.DECIMAL_JTEXTFIELD_WIDTH, 
				Constants.DECIMAL_JTEXTFIELD_HEIGHT));
		decimalResultPanel.setLayout(new BorderLayout());
		decimalResultPanel.add(TextFields.resultField);
	}

	private void buildBinaryResultPanel() {
		binaryResultPanel = new JPanel();
		binaryResultPanel.setBackground(new Color(
				Constants.RESULT_PANEL_BG_COLOR_R,
				Constants.RESULT_PANEL_BG_COLOR_G,
				Constants.RESULT_PANEL_BG_COLOR_B
		));
		binaryResultPanel.setLayout(new GridBagLayout());
		binaryPanelBorder = new LineBorder(Color.LIGHT_GRAY, 1, true);
		binaryResultPanel.setBorder(BorderFactory
				.createCompoundBorder(new EmptyBorder(
						Constants.PANEL_PADDING/2,
						Constants.PANEL_PADDING,
						Constants.PANEL_PADDING/2,
						Constants.PANEL_PADDING), 
				binaryPanelBorder));
		binaryResultPanel.setPreferredSize(new Dimension(
				Constants.BINARY_JPANEL_WIDTH, 
				Constants.BINARY_JPANEL_HEIGHT));
		// begin configuring and adding bit JTextFields
		constraints = new GridBagConstraints();
		//constraints.weightx = 1;
		//constraints.insets = new Insets(0, 0, 0, 0);
		int counter = 0;
		for (int i = 0, j = 0; i < TextFields.bitFields.length; i++, j++) {
			if (j > 38) {
				constraints.gridx = j - 39;
				constraints.gridy = 2;
			} else {
				constraints.gridx = j;
				constraints.gridy = 0;
			}
			TextFields.configureBitField(i, 
					UIManager.getColor(binaryResultPanel));
			binaryResultPanel.add(TextFields.bitFields[i], constraints);
			if (i == 31) {
				constraints.gridy = 1;
				for (int m = 0; m < 39; m++) {
					constraints.gridx = m;
					constraints.anchor = GridBagConstraints.LINE_START;
					if (m == 0) {
						TextFields.addTextField("6", 
								constraints, 
								binaryResultPanel);
						constraints.gridx = ++m;
						TextFields.addTextField("3", 
								constraints, 
								binaryResultPanel);
					} else if (m == 20) {
						TextFields.addTextField("4", 
								constraints, 
								binaryResultPanel);
						constraints.gridx = ++m;
						TextFields.addTextField("7", 
								constraints, 
								binaryResultPanel);
					} else if (m == 37) {
						TextFields.addTextField("3", 
								constraints, 
								binaryResultPanel);
						constraints.gridx = ++m;
						TextFields.addTextField("2", 
								constraints, 
								binaryResultPanel);
					} else {
						TextFields.addTextField(" ", 
								constraints, 
								binaryResultPanel);
					}
				}
				constraints.gridx = 0;
				counter = -1;
			} else if (i == 63) {
				constraints.gridy = 3;
				for (int m = 0; m < 39; m++) {
					constraints.gridx = m;
					if (m == 0) {
						TextFields.addTextField("3", 
								constraints, 
								binaryResultPanel);
						constraints.gridx = ++m;
						TextFields.addTextField("1", 
								constraints, 
								binaryResultPanel);
					} else if (m == 20) {
						TextFields.addTextField("1", 
								constraints, 
								binaryResultPanel);
						constraints.gridx = ++m;
						TextFields.addTextField("5", 
								constraints, 
								binaryResultPanel);
					} else if (m == 38) {
						TextFields.addTextField("0", 
								constraints, 
								binaryResultPanel);
					} else {
						TextFields.addTextField(" ", 
								constraints, 
								binaryResultPanel);
					}
				}
				break;
			}
			if (counter > 2) {
				constraints.gridx = (j > 38 ? ++j - 39 : ++j);
				TextFields.addTextField(" ",
						Constants.BIT_FIELD_SEPARATOR_WIDTH,
						constraints, 
						binaryResultPanel);
				counter = -1;
			}
			counter++;
		}
		
	}

	public JPanel getResultPanel() {
		return this;
	}
	
	public JPanel getBinaryResultPanel() {
		return binaryResultPanel;
	}

	public void mouseClicked(MouseEvent e) {
		// Bit Fields
		for (int i = 0; i < TextFields.bitFields.length; i++) {
			if (e.getSource() == TextFields.bitFields[i]) {
				TextFields.invertBitAt(i);
				if (Calculator.entryIsDisplayed()) {
					Calculator.setEntry(BaseConverter.getDecFromBin(TextFields.generateBinaryAsString()));
				} else {
					Calculator.setResult(BaseConverter.getDecFromBin(TextFields.generateBinaryAsString()));
				}
			}
		}
		Display.updateText();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	
}
