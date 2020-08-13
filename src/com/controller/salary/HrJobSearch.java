package com.controller.salary;

import java.util.ArrayList;
import java.util.Scanner;

import com.controller.HrExecute;
import com.controller.HrSelectJobs;
import com.dao.HrDao;
import com.dto.HrDto;
import com.util.Request;
import com.util.Response;

public class HrJobSearch implements HrExecute {

	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

	@Override
	public void execute(Request request, Response response) {
		inputView(request, response);
		logic(request, response);
		outputView(request, response);

	}

	@Override
	public void inputView(Request request, Response response) {
		System.out.println("직원 개인 정보를 출력합니다");

	}

	@Override
	public void logic(Request request, Response response) {
		HrDao dao=new HrDao();
		Scanner sc=new Scanner(System.in);
		System.out.println("검색할 직무 ID를 입력하세요");
		HrExecute he=null;
		he=new HrSelectJobs();
		he.execute(request, response);
		
		String userInput=sc.nextLine();
		String jobId=userInput.toUpperCase();
		
		response.setArrHrDto(dao.jobSearch(jobId));

	}

	@Override
	public void outputView(Request request, Response response) {
		if(response!=null) {
			ArrayList<HrDto> dtos=response.getArrHrDto();
			System.out.println("  [EmployeeId]   [FirstName]   [LastName] \t   [Email]"
					+ "\t   [PhoneNumber]\t[JobId]");
			if(dtos.isEmpty()) {
				System.out.println("해당하는 데이터가 존재하지 않습니다");
			}
			for(HrDto dto:dtos) {
				System.out.println(dto.employeesPersonalToString());
			}
			System.out.println("");
		}else {
			System.out.println("데이터가 없습니다");
		}

	}

}
