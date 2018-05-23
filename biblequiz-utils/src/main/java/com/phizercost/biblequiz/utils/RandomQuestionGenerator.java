package com.phizercost.biblequiz.utils;

import java.util.ArrayList;
import java.util.Random;

public class RandomQuestionGenerator {
	
	private int result;
	private ArrayList<Integer> playedQuestions;
	private int maximum;
	public RandomQuestionGenerator(int result, ArrayList<Integer> playedQuestions, int maximum) {
		this.result = result;
		this.playedQuestions = playedQuestions;
		this.maximum = maximum;
	}
	
	public int getRandomQuestionId() {
		
		for(int j = 0; j < playedQuestions.size(); j++) {
			int i = randomNumber();
			if (i != playedQuestions.get(j))
				return i;
		}
		
		
		return maximum;
		
	}
	
	private int randomNumber() {
		Random rand = new Random();

		int  n = rand.nextInt(maximum) + 1;
		
		return maximum;
	}
	

}