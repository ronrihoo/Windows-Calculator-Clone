package frontend.menu;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import frontend.AppFrame;
import frontend.listeners.AppMenuListeners;
import util.Config;
import util.Constants;

public class MenuBar extends JMenuBar {
	
	JMenu viewMenu;
	JMenu editMenu;
	JMenu helpMenu;
	JMenuItem menuItem;
	AppMenuListeners appMenuListeners;
	
	public MenuBar() {
		// share context
		Config.mBarContext = this;
		appMenuListeners = new AppMenuListeners();
		setBackground(new Color(
				Constants.MENU_BAR_BG_COLOR_R,
				Constants.MENU_BAR_BG_COLOR_G,
				Constants.MENU_BAR_BG_COLOR_B
		));
		setPreferredSize(new Dimension(
				Constants.APP_WIDTH,
				Constants.MENU_BAR_HEIGHT
		));
		setupViewMenu();
		setupEditMenu();
		setupHelpMenu();
		add(viewMenu);
		add(editMenu);
		add(helpMenu);
	}
	
	private void setupViewMenu() {
		viewMenu = new JMenu("View");
		viewMenu.setFont(new Font("", Font.PLAIN, Constants.MENU_BAR_FONT_SIZE));
		menuItem = new JMenuItem("Hide");
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				AppFrame.frame.setState(Frame.ICONIFIED);
			}
		});
		viewMenu.add(menuItem);
	}
	
	private void setupEditMenu() {
		editMenu = new JMenu("Edit");
		editMenu.setFont(new Font("", Font.PLAIN, Constants.MENU_BAR_FONT_SIZE));
		menuItem = new JMenuItem("Copy");
		menuItem.addActionListener(appMenuListeners.copyListener);
		editMenu.add(menuItem);
	}
	
	private void setupHelpMenu() {
		helpMenu = new JMenu("Help");
		helpMenu.setFont(new Font("", Font.PLAIN, Constants.MENU_BAR_FONT_SIZE));
		menuItem = new JMenuItem("Documentation");
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				new Help();
			}
		});
		helpMenu.add(menuItem);
		menuItem = new JMenuItem("About");
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				About about = new About();
				about.setVisible(true);
			}
		});
		helpMenu.add(menuItem);
	}

	public AppMenuListeners getAppMenuListeners() {
		return appMenuListeners;
	}

}
