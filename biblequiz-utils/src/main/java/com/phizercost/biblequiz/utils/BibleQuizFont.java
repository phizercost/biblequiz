package com.phizercost.biblequiz.utils;

import java.awt.Font;

public class BibleQuizFont {

	Font txtFieldFont;
	Font mainlblFont;
	Font btnFont;
	Font lblFont;
	Font scoreAndTeamLblFont;
	Font qstnLblFont;
	public BibleQuizFont() {
		txtFieldFont = new Font("SansSerif", Font.BOLD, 70);
		mainlblFont = new Font("SansSerif", Font.BOLD, 80);
		btnFont = new Font("SansSerif", Font.BOLD, 30);
		lblFont = new Font("SansSerif", Font.BOLD, 50);
		scoreAndTeamLblFont = new Font("SansSerif", Font.BOLD, 100);
		qstnLblFont = new Font("SansSerif", Font.BOLD, 60);
	}
	public Font getTxtFieldFont() {
		return txtFieldFont;
	}
	public Font getMainlblFont() {
		return mainlblFont;
	}
	public Font getBtnFont() {
		
		return btnFont;
	}
	
	public Font getQstnLblFont() {
		return qstnLblFont;
	}
	
	public Font getLblFont() {
		return lblFont;
	}
	public Font getScoreAndTeamLblFont() {
		return scoreAndTeamLblFont;
	}
	
	
	
	
}