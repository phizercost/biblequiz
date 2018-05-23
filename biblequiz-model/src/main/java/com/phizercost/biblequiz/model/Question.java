package com.phizercost.biblequiz.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Question {
	
	private int questionId;
	private String question;
	private String answer;
	private int questionType;
	private int maxPoint;
	private int countdown;
	private int status;
	private ArrayList<String> questionDetails;
	
	public Question(int questionId, String question, String answer, int maxPoint, int questionType, int countdown, int status) {
		this.questionId = questionId;
		this.question = question;
		this.answer = answer;
		this.maxPoint = maxPoint;
		this.questionType = questionType;
		this.countdown = countdown;
		this.status = status;
	}
	
	public Question(int questionId, String question, String answer, int maxPoint, int questionType, int countdown, int status, ArrayList<String> questionDetails) {
		this.questionId = questionId;
		this.question = question;
		this.answer = answer;
		this.maxPoint = maxPoint;
		this.questionType = questionType;
		this.questionDetails = questionDetails;
		this.countdown = countdown;
		this.status= status;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getQuestionType() {
		return questionType;
	}

	public void setQuestionType(int questionType) {
		this.questionType = questionType;
	}

	public ArrayList<String> getQuestionDetails() {
		return questionDetails;
	}

	public void setQuestionDetails(ArrayList<String> questionDetails) {
		this.questionDetails = questionDetails;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public int getMaxPoint() {
		return maxPoint;
	}

	public void setMaxPoint(int maxPoint) {
		this.maxPoint = maxPoint;
	}

	public int getCountdown() {
		return countdown;
	}

	public void setCountdown(int countdown) {
		this.countdown = countdown;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
	
	
}
