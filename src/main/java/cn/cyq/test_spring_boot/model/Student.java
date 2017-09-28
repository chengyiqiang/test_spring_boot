package cn.cyq.test_spring_boot.model;

import org.springframework.stereotype.Component;

@Component
public class Student {
	
	//
	
	public Student (){
		
	}
	
	private String name;
	private String sex;
	private String age;
	private String banji;
	private String grade;
	private Score score = new Score();
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getBanji() {
		return banji;
	}
	public void setBanji(String banji) {
		this.banji = banji;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Score getScore() {
		return score;
	}



}















