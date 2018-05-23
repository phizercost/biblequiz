package com.phizercost.biblequiz.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
import com.phizercost.biblequiz.utils.UppercaseDocumentFilter;

public class HintsPanel {
	
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
	JButton hintBtn;
	JButton waitBtn;
	JButton answerBtn;
	JTextPane questionArea;
	ButtonHandler click;

	ArrayList<Question> questions = null;
	
	// ButtonHandler click;
	BibleQuizFont fonts;
	DocumentFilter filter;
	int counter = 0;
	int hintCounter = 0;

	int level = 3;
	
	public HintsPanel(Team firstTeam, Team secondTeam, ArrayList<Question> questions) {
		this.firstTeam = firstTeam;
		this.secondTeam = secondTeam;
		this.questions = questions;
		
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
		componentInitializer = new ComponentInitializer("label", 250, 600, 1000, 150);
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

		// First Team Score initialization
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
		hintBtn = componentInitializer.getButton();
		hintBtn.setFont(fonts.getBtnFont());
		hintBtn.setText(BibleQuizUtils.GET_QUESTION_TITLE.getString());
		hintBtn.setBackground(Color.BLACK);
		hintBtn.setForeground(Color.WHITE);
		hintBtn.setOpaque(true);
		hintBtn.setBorderPainted(false);
		hintBtn.addActionListener(click);

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
		panel.add(hintBtn);
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

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == hintBtn) {

				if (counter >= 5) {
					
					level++;
		
					JFrame frame = (JFrame) SwingUtilities.getRoot(panel);
					GameOptionsPanel gameOptionsPanel = new GameOptionsPanel(firstTeam, secondTeam, level); 
					frame.getContentPane().removeAll();
					frame.setContentPane(gameOptionsPanel.getPanel());
					frame.setResizable(false);
					frame.setVisible(true);
					
					
				} else {
					ComponentInitializer componentInitializer = new ComponentInitializer("textPane", 400, 300, 650,
							300);
					questionArea = componentInitializer.getTextPane();
					questionArea.setFont(fonts.getQstnLblFont());
					questionArea.setForeground(Color.BLACK);
					
					//Collections.shuffle(questions);
					question = questions.get(counter);
					
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
					hintBtn.setEnabled(false);
					firstTeamScoreBtn.setEnabled(false);
					secondTeamScoreBtn.setEnabled(false);
					
					questionArea.setText(question.getQuestionDetails().get(0));
					hintCounter = 1;
					JFrame frame = (JFrame) SwingUtilities.getRoot(hintBtn);
					frame.getContentPane().add(questionArea);
					frame.setContentPane(frame.getContentPane());
					frame.setVisible(true);
				}

			} else if (e.getSource() == answerBtn) {
				question.setStatus(1);
				answerBtn.setEnabled(false);
				waitBtn.setEnabled(false);
				hintBtn.setEnabled(true);
				counterLabel.setForeground(Color.BLUE);
				counterLabel.setText(question.getAnswer());
				wait = true;
				waitBtn.setText(BibleQuizUtils.GET_WAIT_TITLE.getString());
				if (seconds > 0) {
					firstTeamScoreBtn.setEnabled(true);
					secondTeamScoreBtn.setEnabled(true);
				}
				counter++;
			} else if (e.getSource() == waitBtn) {
				if (wait) {
					wait = false;
					halt = timer;
					timer.stop();
					waitBtn.setText(BibleQuizUtils.GET_HINT_TITLE.getString());
					answerBtn.setEnabled(true);
				} else {
					wait = true;
					timer = halt;
					timer.start();
					waitBtn.setText(BibleQuizUtils.GET_WAIT_TITLE.getString());
					answerBtn.setEnabled(false);
					String hint = "";
					question.setMaxPoint(question.getMaxPoint() - 10);
					
					
					hintCounter++;
					
					if(hintCounter > 4){
						hintCounter --;
						question.setMaxPoint(question.getMaxPoint() + 10);
					}
					//hint = questionArea.getText().toString();
					for (int k = 0; k < hintCounter; k++){
						if (k==0)
							hint = question.getQuestionDetails().get(k);
						else
							hint = hint +"\n"+question.getQuestionDetails().get(k);
					}
					questionArea.setText(hint);
					JFrame frame = (JFrame) SwingUtilities.getRoot(hintBtn);
					frame.getContentPane().add(questionArea);
					frame.setContentPane(frame.getContentPane());
					frame.setVisible(true);
					
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
