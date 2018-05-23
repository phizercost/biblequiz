package com.phizercost.biblequiz.utils;



import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JTextField;
import javax.swing.JTextPane;

import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;

import javax.swing.text.StyledDocument;

public class ComponentInitializer {

	JButton button;
	JLabel label;
	JTextField textField;
	JFrame frame;
	JTextPane textPane;

	public ComponentInitializer(String component, int horizontalLoc, int verticalLoc, int horizontalSize,
			int verticalSize) {
		if (component.equalsIgnoreCase("button")) {
			// Button initialization
			button = new JButton();
			button.setLocation(horizontalLoc, verticalLoc);
			button.setSize(horizontalSize, verticalSize);
		}else if(component.equalsIgnoreCase("label")) {
			// Label initialization
			label = new JLabel();
			label.setLocation(horizontalLoc, verticalLoc);
			label.setSize(horizontalSize, verticalSize);
		}else if(component.equalsIgnoreCase("textField")) {
			// TestField initialization
			textField = new JTextField();
			textField.setLocation(horizontalLoc, verticalLoc);
			textField.setSize(horizontalSize, verticalSize);
		}else if(component.equalsIgnoreCase("frame")) {
			// Frame initialization
			frame = new JFrame();
			frame.setSize(horizontalSize, verticalSize);
		}
		else if(component.equalsIgnoreCase("textPane")) {
			// TextArea initialization
			textPane = new JTextPane();
			textPane.setEnabled(false);
			StyledDocument doc = textPane.getStyledDocument();
			Style style = textPane.addStyle("Black", null);
			StyleConstants.setForeground(style, Color.black);
			style = textPane.addStyle("Black Underline", style);
			StyleConstants.setUnderline(style, true);
			SimpleAttributeSet center = new SimpleAttributeSet();
			StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
			doc.setParagraphAttributes(0, doc.getLength(), center, false);
			textPane.setLocation(horizontalLoc, verticalLoc);
			textPane.setSize(horizontalSize, verticalSize);
			
		}
	}

	public JButton getButton() {
		return button;
	}

	public JLabel getLabel() {
		return label;
	}

	public JTextField getTextField() {
		return textField;
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public JTextPane getTextPane() {
		return textPane;
	}

}
