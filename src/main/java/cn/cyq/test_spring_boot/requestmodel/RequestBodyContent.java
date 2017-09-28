package cn.cyq.test_spring_boot.requestmodel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RequestBodyContent {
	
	
	private String CommandCode;	
	private String Marker;
	private String  TransferData;
	public RequestBodyContent (){
		
	}

	public String getCommandCode() {
		return CommandCode;
	}
	public void setCommandCode(String commandCode) {
		this.CommandCode = commandCode;
	}
	public String getMarker() {
		return Marker;
	}
	public void setMarker(String marker) {
		this.Marker = marker;
	}

	public String getTransferData() {
		return TransferData;
	}

	public void setTransferData(String transferData) {
		TransferData = transferData;
	}
	
}
