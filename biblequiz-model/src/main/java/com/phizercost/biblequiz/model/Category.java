package com.phizercost.biblequiz.model;

import java.util.ArrayList;

public class Category {

	private int id;
	private String categoryName;
	private ArrayList<Question> questions;

	public Category() {
		
	}
	public Category(int id, String categoryName, ArrayList<Question> questions) {
		this.id = id;
		this.categoryName = categoryName;
		this.setQuestions(questions);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public ArrayList<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}
	
	

}