package com.controller.salary;

import java.util.ArrayList;
import java.util.Scanner;

import com.controller.HrExecute;
import com.dao.HrDao;
import com.dto.HrDto;
import com.util.Request;
import com.util.Response;

public class SalLastNameSearch implements HrExecute {

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
	}

	@Override
	public void logic(Request request,Response response) {
		HrDao dao=new HrDao();
		Scanner sc=new Scanner(System.in);
		System.out.println("LastName을 입력하세요");
		String last=sc.nextLine();
		
		
		
		if(last.isEmpty()) {
			response.setArrHrDto(dao.selectSalEmp());
		}else {
			String lastName=last.substring(0,1).toUpperCase()+last.substring(1).toLowerCase();
			response.setArrHrDto(dao.lastNameSearch(lastName));
		}
	
	}

	@Override
	public void outputView(Request request,Response response) {
		if(response!=null) {
			ArrayList<HrDto> dtos = response.getArrHrDto();
			System.out.println("   [Employee Id] [FirstName] \t[LastName] \t[Salary]");
			for(HrDto dto:dtos) {
				System.out.println(dto.salEmpSelect());
			}
			if(dtos.isEmpty()) {
				System.out.println("해당하는 데이터가 존재하지 않습니다");
				
			}
			System.out.println("");
		}else {
			System.out.println("데이터가 없습니다");
		}

	}

}
