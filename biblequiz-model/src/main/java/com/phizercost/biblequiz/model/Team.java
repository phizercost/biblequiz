package com.phizercost.biblequiz.model;

public class Team {
	
	private String teamName;
	private int teamScore;

	public Team() {
		
	}
	public Team(String teamName, int teamScore) {
		this.teamName = teamName;
		this.teamScore = teamScore;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public int getTeamScore() {
		return teamScore;
	}
	public void setTeamScore(int teamScore) {
		this.teamScore = this.teamScore + teamScore;
	}	

}
