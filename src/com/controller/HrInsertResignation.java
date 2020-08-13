package com.controller;

import java.util.Scanner;

import com.dao.HrDao;
import com.dto.HrDto;
import com.util.DBConn;
import com.util.Request;
import com.util.Response;

public class HrInsertResignation implements HrExecute{
	@Override
	public void execute(Request request, Response response) {
		inputView(request, response);
		logic(request, response);
		outputView(request, response);
	}

	@Override
	public void inputView(Request request, Response response) {
		Scanner sc=new Scanner(System.in);
//		System.out.println("���� ������ �Է��ϼ���");
//		System.out.println("Job ID �Է�");
		String jobId="RESIGN";
		
//		System.out.println("Job Title �Է�");
		String jobTitle="Resignation";
//		String countryName=temp.substring(0,1).toUpperCase()+temp.substring(1).toLowerCase();
		//��ҹ��� ���� ũ�⸸ŭ �����ʿ�
//		System.out.println("MinSalary �Է�");
		int minSalary=0;
		
//		System.out.println("MaxSalary �Է�");
		int maxSalary=0;
		
		HrDto dto=new HrDto();
		
		dto.setJobId(jobId.toUpperCase());
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
		
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
}
