package com.phizercost.biblequiz.ui;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.text.DocumentFilter;

import com.phizercost.biblequiz.model.Category;
import com.phizercost.biblequiz.model.Question;
import com.phizercost.biblequiz.model.Team;
import com.phizercost.biblequiz.utils.BibleQuizFont;
import com.phizercost.biblequiz.utils.BibleQuizUtils;
import com.phizercost.biblequiz.utils.ComponentInitializer;
import com.phizercost.biblequiz.utils.SendMessage;
import com.phizercost.biblequiz.utils.UppercaseDocumentFilter;



public class SpeedPanel {
	Team firstTeam;
	Team secondTeam;

	JPanel panel;
	JLabel mainLabel;
	JLabel counterLabel;
	Timer timer;

	JLabel firstTeamLabel;
	JLabel secondTeamLabel;
	JLabel firstTeamScoreLabel;
	JLabel secondTeamScoreLabel;
	JButton firstTeamScoreBtn;
	JButton secondTeamScoreBtn;
	JButton questionBtn;
	JButton waitBtn;
	JButton answerBtn;
	JTextPane questionArea;
	ButtonHandler click;

	// ButtonHandler click;
	BibleQuizFont fonts;
	DocumentFilter filter;

	Category category;
	ArrayList<Question> questions = null;
	int counter = 0;
	int pickedCategory=-1;
	String stepPlayed = "";
	boolean secondTeamCategory = false;
	int level = 1;

	public SpeedPanel(Team firstTeam, Team secondTeam, Category category) {
		this.firstTeam = firstTeam;
		this.secondTeam = secondTeam;
		this.category = category;
		
		initializePanel();

	}
	
	public SpeedPanel(Team firstTeam, Team secondTeam, ArrayList<Category> categoryList, int index, String stepPlayed, boolean secondTeamCategory) {
		this.firstTeam = firstTeam;
		this.secondTeam = secondTeam;
		this.category = categoryList.get(index);
		this.pickedCategory = index;
		this.stepPlayed = stepPlayed;
		this.secondTeamCategory = secondTeamCategory;
		
		initializePanel();

	}

	
	private void initializePanel() {
		filter = new UppercaseDocumentFilter();
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

		// Counter label initialization
		componentInitializer = new ComponentInitializer("label", 250, 650, 1000, 150);
		counterLabel = componentInitializer.getLabel();
		counterLabel.setFont(fonts.getMainlblFont());
		counterLabel.setHorizontalAlignment(0);
		counterLabel.setHorizontalAlignment(SwingConstants.CENTER);

		// Team Labels initialization
		componentInitializer = new ComponentInitializer("label", 50, 100, 500, 150);
		firstTeamLabel = componentInitializer.getLabel();
		firstTeamLabel.setFont(fonts.getLblFont());
		firstTeamLabel.setText(firstTeam.getTeamName());
		firstTeamLabel.setHorizontalAlignment(SwingConstants.CENTER);

		// First Team Score initialization
		componentInitializer = new ComponentInitializer("button", 180, 500, 200, 50);
		firstTeamScoreBtn = componentInitializer.getButton();
		firstTeamScoreBtn.setFont(fonts.getBtnFont());
		firstTeamScoreBtn.setText(BibleQuizUtils.GET_SCORE_TITLE.getString());
		firstTeamScoreBtn.setOpaque(true);
		firstTeamScoreBtn.setEnabled(false);
		firstTeamScoreBtn.addActionListener(click);

		// Second Team Score initialization
		componentInitializer = new ComponentInitializer("button", 1100, 500, 200, 50);
		secondTeamScoreBtn = componentInitializer.getButton();
		secondTeamScoreBtn.setFont(fonts.getBtnFont());
		secondTeamScoreBtn.setText(BibleQuizUtils.GET_SCORE_TITLE.getString());
		secondTeamScoreBtn.setOpaque(true);
		secondTeamScoreBtn.setEnabled(false);
		secondTeamScoreBtn.addActionListener(click);

		componentInitializer = new ComponentInitializer("label", 900, 100, 500, 150);
		secondTeamLabel = componentInitializer.getLabel();
		secondTeamLabel.setFont(fonts.getLblFont());
		secondTeamLabel.setText(secondTeam.getTeamName());
		secondTeamLabel.setHorizontalAlignment(SwingConstants.CENTER);

		// Button Question initialization
		componentInitializer = new ComponentInitializer("button", 600, 100, 300, 50);
		questionBtn = componentInitializer.getButton();
		questionBtn.setFont(fonts.getBtnFont());
		questionBtn.setText(BibleQuizUtils.GET_QUESTION_TITLE.getString());
		questionBtn.setBackground(Color.BLACK);
		questionBtn.setForeground(Color.WHITE);
		questionBtn.setOpaque(true);
		questionBtn.setBorderPainted(false);
		questionBtn.addActionListener(click);

		// Button Response initialization
		componentInitializer = new ComponentInitializer("button", 600, 160, 300, 50);
		waitBtn = componentInitializer.getButton();
		waitBtn.setFont(fonts.getBtnFont());
		waitBtn.setText(BibleQuizUtils.GET_WAIT_TITLE.getString());
		waitBtn.setBackground(Color.BLUE);
		waitBtn.setForeground(Color.WHITE);
		waitBtn.setOpaque(true);
		waitBtn.setBorderPainted(false);
		waitBtn.addActionListener(click);
		waitBtn.setEnabled(false);

		// Button Response initialization
		componentInitializer = new ComponentInitializer("button", 600, 220, 300, 50);
		answerBtn = componentInitializer.getButton();
		answerBtn.setFont(fonts.getBtnFont());
		answerBtn.setText(BibleQuizUtils.GET_ANSWER_TITLE.getString());
		answerBtn.setBackground(Color.cyan);
		answerBtn.setForeground(Color.black);
		answerBtn.setOpaque(true);
		answerBtn.setBorderPainted(false);
		answerBtn.addActionListener(click);
		answerBtn.setEnabled(false);

		// Team Scores Initialization
		componentInitializer = new ComponentInitializer("label", 200, 100, 200, 500);
		firstTeamScoreLabel = componentInitializer.getLabel();
		firstTeamScoreLabel.setFont(fonts.getScoreAndTeamLblFont());
		firstTeamScoreLabel.setText(Integer.toString(firstTeam.getTeamScore()));

		componentInitializer = new ComponentInitializer("label", 1125, 100, 300, 500);
		secondTeamScoreLabel = componentInitializer.getLabel();
		secondTeamScoreLabel.setFont(fonts.getScoreAndTeamLblFont());
		secondTeamScoreLabel.setText(Integer.toString(secondTeam.getTeamScore()));

		// Adding components on the panel

		panel.add(mainLabel);
		panel.add(firstTeamLabel);
		panel.add(firstTeamScoreBtn);
		panel.add(secondTeamLabel);
		panel.add(secondTeamScoreBtn);
		panel.add(questionBtn);
		panel.add(waitBtn);
		panel.add(answerBtn);
		panel.add(firstTeamScoreLabel);
		panel.add(secondTeamScoreLabel);
		panel.add(counterLabel);
	}

	private class ButtonHandler implements ActionListener {

		Timer timer, halt = null;
		Question question = null;
		Boolean wait = true;
		int seconds = -1;
		SendMessage sendMessage = new SendMessage();
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == questionBtn) {

				if (counter >= 2) {
					
					level++;
					if (stepPlayed.equalsIgnoreCase("category") && !secondTeamCategory)
					{
						level = 2;
						secondTeamCategory = true;
					}else if(stepPlayed.equalsIgnoreCase("category") && secondTeamCategory)
					{
						level = 3;
						//level = 4;
						secondTeamCategory = true;
					}
						
					
					JFrame frame = (JFrame) SwingUtilities.getRoot(panel);
					GameOptionsPanel gameOptionsPanel = new GameOptionsPanel(firstTeam, secondTeam, level, secondTeamCategory); 
					frame.getContentPane().removeAll();
					frame.setContentPane(gameOptionsPanel.getPanel());
					frame.setResizable(false);
					frame.setVisible(true);
					
					
				} else {
					ComponentInitializer componentInitializer = new ComponentInitializer("textPane", 400, 270, 650,
							400);
					questionArea = componentInitializer.getTextPane();
					questionArea.setFont(fonts.getQstnLblFont());
					

					questions = category.getQuestions();
					
					
					//Collections.shuffle(questions);
					question = questions.get(counter);
					
					/*try {
						sendMessage.broadcast("250783647207", question.getAnswer());
						//sendMessage.broadcast("250785641217", question.getAnswer());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}*/
					counter++;
					seconds = question.getCountdown();
					// seconds = questionone.getCountdown();

					counterLabel.setForeground(Color.BLACK);
					counterLabel.setText("" + seconds);

					timer = new Timer(1000, new ActionListener() {
						public void actionPerformed(ActionEvent o) {
							seconds--;
							long second = TimeUnit.SECONDS.toSeconds(seconds)
									- (TimeUnit.SECONDS.toMinutes(seconds) * 60);
							counterLabel.setText("" + second);
							if (seconds <= 0) {
								timer.stop();
								answerBtn.setEnabled(true);
								waitBtn.setEnabled(false);
								counterLabel.setText(BibleQuizUtils.TIME_OVER.getString());
								counterLabel.setForeground(Color.RED);
							}
						}
					});
					timer.start();
					waitBtn.setEnabled(true);
					answerBtn.setEnabled(false);
					questionBtn.setEnabled(false);
					firstTeamScoreBtn.setEnabled(false);
					secondTeamScoreBtn.setEnabled(false);

					questionArea.setText(question.getQuestion());
					JFrame frame = (JFrame) SwingUtilities.getRoot(questionBtn);
					frame.getContentPane().add(questionArea);
					frame.setContentPane(frame.getContentPane());
					frame.setVisible(true);
				}

			} else if (e.getSource() == answerBtn) {
				question.setStatus(1);
				answerBtn.setEnabled(false);
				waitBtn.setEnabled(false);
				questionBtn.setEnabled(true);
				counterLabel.setForeground(Color.BLUE);
				counterLabel.setText(question.getAnswer());
				wait = true;
				waitBtn.setText(BibleQuizUtils.GET_WAIT_TITLE.getString());
				if (seconds > 0) {
					firstTeamScoreBtn.setEnabled(true);
					secondTeamScoreBtn.setEnabled(true);
				}
			} else if (e.getSource() == waitBtn) {
				if (wait) {
					wait = false;
					halt = timer;
					timer.stop();
					waitBtn.setText(BibleQuizUtils.GET_CONTINUE_TITLE.getString());
					answerBtn.setEnabled(true);
				} else {
					wait = true;
					timer = halt;
					timer.start();
					waitBtn.setText(BibleQuizUtils.GET_WAIT_TITLE.getString());
					answerBtn.setEnabled(false);
				}
			} else if (e.getSource() == firstTeamScoreBtn) {
				firstTeamScoreBtn.setEnabled(false);
				secondTeamScoreBtn.setEnabled(false);
				firstTeam.setTeamScore(question.getMaxPoint());
				firstTeamScoreLabel.setText(Integer.toString(firstTeam.getTeamScore()));

			} else if (e.getSource() == secondTeamScoreBtn) {
				firstTeamScoreBtn.setEnabled(false);
				secondTeamScoreBtn.setEnabled(false);
				secondTeam.setTeamScore(question.getMaxPoint());
				secondTeamScoreLabel.setText(Integer.toString(secondTeam.getTeamScore()));

			}

			if (firstTeam.getTeamScore() < secondTeam.getTeamScore()) {
				firstTeamScoreLabel.setForeground(Color.RED);
				secondTeamScoreLabel.setForeground(Color.BLUE);
			} else if (firstTeam.getTeamScore() > secondTeam.getTeamScore()) {
				firstTeamScoreLabel.setForeground(Color.BLUE);
				secondTeamScoreLabel.setForeground(Color.RED);
			} else {
				firstTeamScoreLabel.setForeground(Color.BLACK);
				secondTeamScoreLabel.setForeground(Color.BLACK);
			}

		}

	}

	

	public JPanel getPanel() {
		return panel;
	}

}
