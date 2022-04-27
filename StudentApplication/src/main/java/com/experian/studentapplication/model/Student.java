package com.experian.studentapplication.model;

import java.util.Date;

public class Student {

	private int studentNumber;
	private String firstName;
	private String lastName;
	private Date DOB;
	private String cellphoneNumber;
	private String email;
	private int score;
	private double averageScore;
	
	public Student() {
		super();
	}
	public Student(int studentNumber, String firstName, String lastName, Date dOB, String cellphoneNumber, String email,
			int score, double averageScore) {
		super();
		this.studentNumber = studentNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		DOB = dOB;
		this.cellphoneNumber = cellphoneNumber;
		this.email = email;
		this.score = score;
		this.averageScore = averageScore;
	}
	public int getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public String getCellphoneNumber() {
		return cellphoneNumber;
	}
	public void setCellphoneNumber(String cellphoneNumber) {
		this.cellphoneNumber = cellphoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public double getAverageScore() {
		return averageScore;
	}
	public void setAverageScore(double averageScore) {
		this.averageScore = averageScore;
	}
	@Override
	public String toString() {
		return "Student [studentNumber=" + studentNumber + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", DOB=" + DOB + ", cellphoneNumber=" + cellphoneNumber + ", email=" + email + ", score=" + score
				+ ", averageScore=" + averageScore + "]";
	}
	
}
