package cn.cyq.test_spring_boot.requestmodel;

import org.springframework.stereotype.Component;

@Component
public class TransferData {
	private String userID;
	private String documentID;
	public TransferData (){
		
	}
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getDocumentID() {
		return documentID;
	}
	public void setDocumentID(String documentID) {
		this.documentID = documentID;
	}
}
