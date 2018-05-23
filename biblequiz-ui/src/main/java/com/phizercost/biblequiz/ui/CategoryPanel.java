package com.phizercost.biblequiz.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import com.phizercost.biblequiz.model.Category;
import com.phizercost.biblequiz.model.Team;
import com.phizercost.biblequiz.utils.BibleQuizFont;
import com.phizercost.biblequiz.utils.BibleQuizUtils;
import com.phizercost.biblequiz.utils.ComponentInitializer;



public class CategoryPanel {

	Team firstTeam;
	Team secondTeam;
	ArrayList<Category> categoryQuestions;
	

	JPanel panel;
	JLabel mainLabel;

	JLabel firstTeamLabel;
	JLabel secondTeamLabel;
	JLabel firstTeamScoreLabel;
	JLabel secondTeamScoreLabel;
	JButton firstCategoryBtn;
	JButton secondCategoryBtn;
	JButton thirdCategoryBtn;

	// ButtonHandler click;
	BibleQuizFont fonts;

	ButtonHandler click;
	
	boolean secondTeamCategory = false;

	public CategoryPanel(Team firstTeam, Team secondTeam, ArrayList<Category> categoryQuestions, boolean secondTeamCategory) {
		this.firstTeam = firstTeam;
		this.secondTeam = secondTeam;
		this.categoryQuestions = categoryQuestions;
		this.secondTeamCategory = secondTeamCategory;
		initializeComponent();

	}
	

	private void initializeComponent() {
		
		Collections.shuffle(categoryQuestions);
		fonts = new BibleQuizFont();
		click = new ButtonHandler();
		ComponentInitializer componentInitializer;

		// Panel initialization
		panel = new JPanel();
		panel.setLayout(null);

		// label initialization
		componentInitializer = new ComponentInitializer("label", 150, 15, 1200, 75);
		mainLabel = componentInitializer.getLabel();
		mainLabel.setText(BibleQuizUtils.MAIN_TITLE.getString());
		mainLabel.setFont(fonts.getMainlblFont());
		mainLabel.setHorizontalAlignment(SwingConstants.CENTER);

		// Team Labels initialization
		componentInitializer = new ComponentInitializer("label", 50, 100, 500, 150);
		firstTeamLabel = componentInitializer.getLabel();
		firstTeamLabel.setFont(fonts.getLblFont());
		firstTeamLabel.setText(firstTeam.getTeamName());
		firstTeamLabel.setHorizontalAlignment(SwingConstants.CENTER);

		componentInitializer = new ComponentInitializer("label", 900, 100, 500, 150);
		secondTeamLabel = componentInitializer.getLabel();
		secondTeamLabel.setFont(fonts.getLblFont());
		secondTeamLabel.setText(secondTeam.getTeamName());
		secondTeamLabel.setHorizontalAlignment(SwingConstants.CENTER);

		// Team Scores Initialization
		componentInitializer = new ComponentInitializer("label", 225, 100, 300, 500);
		firstTeamScoreLabel = componentInitializer.getLabel();
		firstTeamScoreLabel.setFont(fonts.getScoreAndTeamLblFont());
		firstTeamScoreLabel.setText(Integer.toString(firstTeam.getTeamScore()));

		componentInitializer = new ComponentInitializer("label", 1125, 100, 300, 500);
		secondTeamScoreLabel = componentInitializer.getLabel();
		secondTeamScoreLabel.setFont(fonts.getScoreAndTeamLblFont());
		secondTeamScoreLabel.setText(Integer.toString(secondTeam.getTeamScore()));

		// First Category Button initialization
		componentInitializer = new ComponentInitializer("button", 500, 150, 400, 150);
		firstCategoryBtn = componentInitializer.getButton();
		firstCategoryBtn.setFont(fonts.getBtnFont());
		firstCategoryBtn.setText(categoryQuestions.get(0).getCategoryName());
		firstCategoryBtn.setOpaque(true);
		firstCategoryBtn.setEnabled(true);
		firstCategoryBtn.addActionListener(click);

		// Second Category Button initialization
		componentInitializer = new ComponentInitializer("button", 500, 350, 400, 150);
		secondCategoryBtn = componentInitializer.getButton();
		secondCategoryBtn.setFont(fonts.getBtnFont());
		secondCategoryBtn.setText(categoryQuestions.get(1).getCategoryName());
		secondCategoryBtn.setOpaque(true);
		secondCategoryBtn.setEnabled(true);
		secondCategoryBtn.addActionListener(click);

		// Third Category Button initialization
		componentInitializer = new ComponentInitializer("button", 500, 550, 400, 150);
		thirdCategoryBtn = componentInitializer.getButton();
		thirdCategoryBtn.setFont(fonts.getBtnFont());
		thirdCategoryBtn.setText(categoryQuestions.get(2).getCategoryName());
		thirdCategoryBtn.setOpaque(true);
		thirdCategoryBtn.setEnabled(true);
		thirdCategoryBtn.addActionListener(click);

		// Adding components on the panel

		panel.add(mainLabel);

		panel.add(firstTeamLabel);
		panel.add(secondTeamLabel);

		panel.add(firstTeamScoreLabel);
		panel.add(secondTeamScoreLabel);

		panel.add(firstCategoryBtn);
		panel.add(secondCategoryBtn);
		panel.add(thirdCategoryBtn);
		
	}


	private class ButtonHandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Component component = (Component) e.getSource();
			if (e.getSource() == firstCategoryBtn) {
				SpeedPanel speedPanel = new SpeedPanel(firstTeam, secondTeam, categoryQuestions, 0, "category",secondTeamCategory);
				speedPanel.getPanel();
				swapPanel(speedPanel.getPanel(), component);
			} else if (e.getSource() == secondCategoryBtn) {
				SpeedPanel speedPanel = new SpeedPanel(firstTeam, secondTeam, categoryQuestions, 1, "category",secondTeamCategory);
				speedPanel.getPanel();
				swapPanel(speedPanel.getPanel(), component);
			}else if (e.getSource() == thirdCategoryBtn) {
				SpeedPanel speedPanel = new SpeedPanel(firstTeam, secondTeam, categoryQuestions, 2, "category",secondTeamCategory);
				speedPanel.getPanel();
				swapPanel(speedPanel.getPanel(), component);
			}

		}
		
		private void swapPanel(JPanel panel, Component component) {

			JFrame frame = (JFrame) SwingUtilities.getRoot(component);
			frame.getContentPane().removeAll();
			frame.setContentPane(panel);
			frame.setResizable(false);
			frame.setVisible(true);

		}

	}
	public JPanel getPanel() {
		return panel;
	}
}
