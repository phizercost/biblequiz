package com.phizercost.biblequiz.ui;


import java.awt.Component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.phizercost.biblequiz.model.Team;
import com.phizercost.biblequiz.utils.BibleQuizFont;
import com.phizercost.biblequiz.utils.BibleQuizUtils;
import com.phizercost.biblequiz.utils.ComponentInitializer;
 

public class MainFrame {


	static BibleQuizUtils utils;
	static TeamPanel teamPanel;
	static JButton teamPanelButton;
	static JFrame frame;

	public static void main(String[] args) {
		

		ComponentInitializer componentInitializer;
		ButtonHandler click = new ButtonHandler();
		BibleQuizFont fonts = new BibleQuizFont();

		// Button initialization
		componentInitializer = new ComponentInitializer("button", 650, 450, 200, 80);
		teamPanelButton = componentInitializer.getButton();
		teamPanelButton.setText(BibleQuizUtils.INITIALIZE_GAME.getString().toUpperCase());
		teamPanelButton.setFont(fonts.getBtnFont());
		teamPanelButton.addActionListener(click);

		teamPanel = new TeamPanel();
		teamPanel.getPanel().add(teamPanelButton);
		componentInitializer = new ComponentInitializer("frame", 0, 0, 1500, 800);
		frame = componentInitializer.getFrame();
		

		frame.setContentPane(teamPanel.getPanel());
		frame.setTitle(BibleQuizUtils.MAIN_TITLE.getString());
		frame.setResizable(false);
		frame.setVisible(true);

	}

	private static class ButtonHandler implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			HashMap<?, ?> panelMap = getMapComponents(teamPanel.getPanel());
			JTextField firstTeamTextBox = (JTextField) getComponentByName("firstTeamTextBox", panelMap), secondTeamTextBox = (JTextField) getComponentByName("secondTeamTextBox", panelMap);
			Team firstTeam = null;
			Team secondTeam = null;

			if (event.getSource() == teamPanelButton) {
				
				if (firstTeamTextBox.getText().isEmpty() || secondTeamTextBox.getText().isEmpty() || (firstTeamTextBox.getText().equalsIgnoreCase(secondTeamTextBox.getText()))) {
					JOptionPane.showMessageDialog(teamPanel.getPanel(), BibleQuizUtils.TEAM_NAMES_NOT_SET.getString());
				} else {
					firstTeam = new Team(firstTeamTextBox.getText(),0);
					secondTeam = new Team(secondTeamTextBox.getText(), 0);
					
					GameOptionsPanel gameOptionsPanel = new GameOptionsPanel(firstTeam, secondTeam, 1); 
					frame.getContentPane().removeAll();
					frame.setContentPane(gameOptionsPanel.getPanel());
					frame.setResizable(false);
					frame.setVisible(true);

				}
			}

		}

		private HashMap<String, Component> getMapComponents(JPanel panel) {
			HashMap<String, Component> componentMap = new HashMap<String, Component>();
			Component[] components = panel.getComponents();
			for (int i = 0; i < components.length; i++) {
				componentMap.put(components[i].getName(), components[i]);
			}
			return componentMap;
		}

		public Component getComponentByName(String name, HashMap<?, ?> componentMap) {
			if (componentMap.containsKey(name)) {
				return (Component) componentMap.get(name);
			} else
				return null;
		}
	}

}

