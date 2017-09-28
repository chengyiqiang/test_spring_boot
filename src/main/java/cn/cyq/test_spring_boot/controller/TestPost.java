package cn.cyq.test_spring_boot.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cn.cyq.test_spring_boot.model.Student;
import cn.cyq.test_spring_boot.requestmodel.RequestBodyContent;
import cn.cyq.test_spring_boot.requestmodel.TransferData;

@RestController
@RequestMapping(value = "/getStudent",produces = "application/json;charset=UTF-8") 
public class TestPost {

	//http://192.168.51.151:8080/getStudent/002   类型请求，"2"为参数
	@RequestMapping(value = "/00{studentnum}",method = RequestMethod.POST)
	public Student getStudent(@PathVariable String studentnum){
		Student student = new Student();
//		业务逻辑
		student.setAge("18");                                                
		student.setBanji("2");
		student.setGrade("1");
		student.setName("小张" + studentnum);
		student.setSex("女");
		student.getScore().setChinese("18分");
		student.getScore().setEnglish("19分");
		student.getScore().setMath("20分");
		return student;
	}
	
	//http://192.168.51.151:8080/getStudent/01?studentnum=2   类型请求，"2"为参数
	@RequestMapping(value = "/01",method = RequestMethod.POST)
	public Student getStudent1(@RequestParam(value = "studentnum", required = true) String studentnum){
		Student student = new Student();
//		业务逻辑
		student.setAge("18");                                                
		student.setBanji("2");
		student.setGrade("1");
		student.setName("小张" + studentnum);
		student.setSex("女");
		student.getScore().setChinese("18分");
		student.getScore().setEnglish("19分");
		student.getScore().setMath("20分");
		return student;
	}
	
	
	//http://192.168.51.151:8080/getStudent/02类型请求,参数为json串
	@RequestMapping(value = "/02", method = RequestMethod.POST)
	public Student getStudent2(HttpServletRequest request,HttpServletResponse response) {
		
		RequestBodyContent requestBodyContent = new RequestBodyContent();
		TransferData transferData = new TransferData();
		try {
			//通过输入流来获取json串
			String jsString = new String(IOUtils.toString(request.getInputStream()).getBytes(),"UTF-8");
			System.out.println(jsString);
			//通过gson将json串转换为RequestBodyContent实体对象
			requestBodyContent = new Gson().fromJson(jsString,RequestBodyContent.class);
//			System.out.println(requestBodyContent.getTransferData());
			//将属性transferdata中的json串转为TransferData对象
			transferData = new Gson().fromJson(requestBodyContent.getTransferData(), TransferData.class);
//			System.out.println(transferData.getDocumentID());
						
		} catch (IOException e) {
			e.printStackTrace();
		}		
		Student student = new Student();
		// 业务逻辑
		student.setAge(requestBodyContent.getCommandCode());
		student.setBanji(requestBodyContent.getMarker());
//		student.setGrade(requestBodyContent.getTransferData().getDocumentID());
		student.setName("小张");
		student.setSex("女");
		student.getScore().setChinese(transferData.getDocumentID());
		student.getScore().setEnglish(transferData.getUserID());
		student.getScore().setMath("20分");
		return student;
	}
	
	
}
