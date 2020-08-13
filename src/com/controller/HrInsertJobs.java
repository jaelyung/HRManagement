package com.controller;

import java.util.Scanner;

import com.dao.HrDao;
import com.dto.HrDto;
import com.util.DBConn;
import com.util.Request;
import com.util.Response;

public class HrInsertJobs implements HrExecute{
	@Override
	public void execute(Request request, Response response) {
		inputView(request, response);
		logic(request, response);
		outputView(request, response);
	}

	@Override
	public void inputView(Request request, Response response) {
		Scanner sc=new Scanner(System.in);
		System.out.println("���� ������ �Է��ϼ���");
		System.out.println("Job ID �Է�");
		HrExecute he=null;
		he=new JobIdInsertCheck();
		he.execute(request, response);
		
		System.out.println("Job Title �Է�");
		String jobTitle=DBConn.inputString();
//		String countryName=temp.substring(0,1).toUpperCase()+temp.substring(1).toLowerCase();
		//��ҹ��� ���� ũ�⸸ŭ �����ʿ�
		System.out.println("MinSalary �Է�");
		  int minSalary=DBConn.inputInt();
		  int maxSalary=0;
		  System.out.println("MaxSalary �Է�");
		  boolean salaryFlag=true;
		  do {
		   try {
		    maxSalary=DBConn.inputInt();
		    if(maxSalary>minSalary) {
		     salaryFlag=false;
		    }else {
		     System.out.println("MinSalary���� ū �ݾ��� �Է����ּ���.");
		    }
		   }catch(Exception e){
		    System.out.println(e.toString());
		   }
		  }while(salaryFlag);
		
		HrDto dto=new HrDto();
		
		dto.setJobId(JobIdInsertCheck.jobId);
		dto.setJobTitle(jobTitle);
		dto.setMinSalary(minSalary);
		dto.setMaxSalary(maxSalary);		
		
		request.setHrDto(dto);
	}	
	

	@Override
	public void logic(Request request, Response response) {
		HrDto dto=request.getHrDto();
		HrDao dao=new HrDao();
		int i=dao.insertJobs(dto);
		
		response.setResultValue(i);
	}

	@Override
	public void outputView(Request request, Response response) {
		System.out.println(response.getResultValue()+"���� �����͸� �߰��Ͽ����ϴ�.");
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
}
