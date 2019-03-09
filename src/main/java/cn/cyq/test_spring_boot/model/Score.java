package cn.cyq.test_spring_boot.model;

import org.springframework.stereotype.Component;

@Component
public class Score {

	private String math;
	private String english;
	private String chinese;

	public String getMath() {
		return math;
	}
	public void setMath(String math) {
		this.math = math;
	}
	public String getEnglish() {
		return english;
	}
	public void setEnglish(String english) {
		this.english = english;
	}
	public String getChinese() {
		return chinese;
	}
	public void setChinese(String chinese) {
		this.chinese = chinese;
	}
}
