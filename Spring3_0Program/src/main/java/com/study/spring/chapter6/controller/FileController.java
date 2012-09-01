package com.study.spring.chapter6.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/chapter6/fileUpload.do")
public class FileController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String subMain() {
		return "chapter6/fileUpload";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submitReport(
			@RequestParam("studentNumber") String studentNumber,
			@RequestParam("report") MultipartFile report) {
		
		System.out.println("Content Type : " + report.getContentType());
		System.out.println("파일 이름 : " + report.getName());
		System.out.println("파일 원본 이름 : " + report.getOriginalFilename());
		System.out.println("파일 크기 : " + report.getSize());
		
		try {
			InputStream inputStream = report.getInputStream();
			FileWriter fileWriter = new FileWriter(report.getName());
			
			int readData = 0;
			StringBuilder strBuilder = new StringBuilder();
			
			while ( (readData = inputStream.read()) != -1 ) {
				
				strBuilder.append((char) readData);
				
			}
			
			fileWriter.append(strBuilder.subSequence(0, strBuilder.length()));
			fileWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "chapter6/submissionComplete";
	}
	
}
