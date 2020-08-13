package com.controller;

import java.util.ArrayList;

import com.dao.HrDao;
import com.dto.HrDto;
import com.util.DBConn;
import com.util.Request;
import com.util.Response;

public class HrSelectSalaryMtoMCheck implements HrExecute{
	
	static String jobId;
	static int salary;
	public static int minSalary;
	public static int maxSalary;
	
	public void execute(Request request, Response response) {
		inputView(request, response);
		logic(request, response);
		outputView(request, response);
	}

	@Override
	public void inputView(Request request, Response response) {
		jobId=JobIdCheck.jobId;
	}
	
	@Override
	public void logic(Request request, Response response) {
		HrDao dao=new HrDao();
		response.setArrHrDto(dao.jobsSelect(jobId));

	}
	
	@Override
	public void outputView(Request request, Response response) {
		boolean flag = true;
		int inputMinSalary = 0;
		
		if (response != null) {
			ArrayList<HrDto> dtos = response.getArrHrDto();
			for (HrDto dto : dtos) {
//				minSalary = dto.getMinSalary();
				maxSalary = dto.getMaxSalary();
			}
			System.out.println();
			System.out.println("최소급여를 입력하세요.");
			while (flag) {
				inputMinSalary = DBConn.inputInt();
				if (inputMinSalary > maxSalary) {
					System.out.println("_________________________________");
					System.out.println("※최대 급여 보다 작은 금액만 입력가능※");
					System.out.println("< ~ " + "최대:" + maxSalary + ">");
					System.out.println("_________________________________");
					System.out.println("다시 입력해주세요");
				} else {
					
					flag = false;
				}
			}
			minSalary = inputMinSalary;
			
		} else {
			System.out.println("직무정보가 없습니다.");
		}

	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
}
