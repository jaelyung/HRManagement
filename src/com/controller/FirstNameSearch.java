package com.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.dao.HrDao;
import com.dto.HrDto;
import com.util.Request;
import com.util.Response;

public class FirstNameSearch implements HrExecute {

	@Override
	public void execute() {
		HrDto request=new HrDto();
		ArrayList<HrDto> response=new ArrayList<HrDto>();
		
//		inputView(request,response);
//		logic(request,response);
//		outputView(request,response);

	}

	@Override
	public void execute(Request request,Response response) {
		inputView(request,response);
		logic(request,response);
		outputView(request,response);
	}

	@Override
	public void inputView(Request request,Response response) {
		System.out.println("직원 개인 정보를 출력합니다");
	}

	@Override
	public void logic(Request request,Response response) {
		HrDao dao=new HrDao();
		Scanner sc=new Scanner(System.in);
		System.out.println("firstName을 입력하세요");
		String first=sc.nextLine();
		String firstName=first.substring(0,1).toUpperCase()+first.substring(1).toLowerCase();
		
		
		response.setArrHrDto(dao.firstNameSearch(firstName));
		
	}

	@Override
	public void outputView(Request request,Response response) {
		if(response!=null) {
			ArrayList<HrDto> dtos=
					response.getArrHrDto();
			
			System.out.println("  [EmployeeId]   [FirstName]   [LastName] \t   [Email]"
					+ "\t   [PhoneNumber]"
					+ "\t[JobId]  ");
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
