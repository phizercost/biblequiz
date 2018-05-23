package com.phizercost.biblequiz.ui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter;

import com.phizercost.biblequiz.model.Team;
import com.phizercost.biblequiz.utils.BibleQuizFont;
import com.phizercost.biblequiz.utils.BibleQuizUtils;
import com.phizercost.biblequiz.utils.ComponentInitializer;
import com.phizercost.biblequiz.utils.UppercaseDocumentFilter;



public class TeamPanel {
	JPanel panel;
	JLabel label;
	JTextField firstTeamTextBox;
	JTextField secondTeamTextBox;
	Team firstTeam;
	Team secondTeam;
	
	
	
	BibleQuizFont fonts;
	DocumentFilter filter;

	public JLabel getLabel() {
		return label;
	}
	public void setLabel(JLabel label) {
		this.label = label;
	}

	public TeamPanel() {
		filter = new UppercaseDocumentFilter();
		fonts = new BibleQuizFont();
		ComponentInitializer componentInitializer;
		
		//Panel initialization
		panel = new JPanel();
		panel.setName("teamPanel");
		panel.setLayout(null);
		
		//label initialization
		componentInitializer = new ComponentInitializer("label", 100, 15, 1200, 75);
		label = componentInitializer.getLabel();
		label.setText(BibleQuizUtils.MAIN_TITLE.getString());
		label.setFont(fonts.getMainlblFont());
		label.setHorizontalAlignment(0);
		panel.add(label);
		
		//Text boxes initialization
		componentInitializer = new ComponentInitializer("textField", 200, 200, 500, 150);
		firstTeamTextBox = componentInitializer.getTextField();
		firstTeamTextBox.setName("firstTeamTextBox");
		firstTeamTextBox.setFont(fonts.getTxtFieldFont());
		((AbstractDocument) firstTeamTextBox.getDocument()).setDocumentFilter(filter);
		panel.add(firstTeamTextBox);
		
		componentInitializer = new ComponentInitializer("textField", 800, 200, 500, 150);
		secondTeamTextBox = componentInitializer.getTextField();
		secondTeamTextBox.setName("secondTeamTextBox");
		secondTeamTextBox.setFont(fonts.getTxtFieldFont());
		((AbstractDocument) secondTeamTextBox.getDocument()).setDocumentFilter(filter);
		panel.add(secondTeamTextBox);
      
	}
	

	public JPanel getPanel(){
		return panel;
	}
	
	 
	
}
