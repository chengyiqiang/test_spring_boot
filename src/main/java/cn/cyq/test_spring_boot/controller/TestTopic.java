package cn.cyq.test_spring_boot.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;

@RestController
@RequestMapping("/topic")
public class TestTopic {

	@RequestMapping(value = { "/zz" })
	public String zzwyc() {
		JsonObject jsonObject = new JsonObject();
		try {
			jsonObject.addProperty("一号", "1");
			jsonObject.addProperty("儿号", "2");
			jsonObject.addProperty("三号", "3");
			jsonObject.addProperty("死号", "4");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return jsonObject.toString();
	}

	//以流的方式提供下载文件
	@RequestMapping(value={"/zzwyc"},method=RequestMethod.GET)  
	public void testDownload(HttpServletResponse resp) throws IOException{  
	  File file = new File("D:/test1.txt");
//	  resp.setHeader("content-type", "application/octet-stream");
//	  resp.setContentType("application/octet-stream");
	  resp.setHeader("content-type", "text/plain");
	  resp.setHeader("Content-Disposition", "attachment;filename=" + "test1.txt");
	  byte[] buff = new byte[1024];
	  BufferedInputStream bis = null;
	  OutputStream os = null;
	  try {
		  //获取响应输出流
		 os = resp.getOutputStream();
//		 将本地文件写入缓冲输入流
		 bis = new BufferedInputStream(new FileInputStream(file));
//		 读取本地文件到buff
		 int i = 0;
		 while((i=bis.read(buff))  != -1){
//			 将缓冲数据写入响应输出流
//			 os.write(buff);//下载文件缺失		
			
			 os.write(buff, 0, i);
		 }
		 os.flush();
	} catch (IOException e) {
		e.printStackTrace();
	}finally{
		bis.close();
		os.close();
	
	}
	}
	
	//第二中下载方式
	@RequestMapping(value={"/zzwyc2"},method=RequestMethod.GET)  
	public ResponseEntity<InputStreamResource> testDownload2 () throws IOException {  
		FileSystemResource fsr = new FileSystemResource("D:/test.txt");
		 HttpHeaders headers = new HttpHeaders();  
	        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");  
	        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", "test.txt"));  
	        headers.add("Pragma", "no-cache");  
	        headers.add("Expires", "0");  
	        
	        return ResponseEntity
	        		.ok()
	        		.headers(headers)
	        		.body(new InputStreamResource(fsr.getInputStream()));

	}	
	
}


	

