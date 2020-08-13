package com.controller;

import java.util.ArrayList;

import com.dao.HrDao;
import com.dto.HrDto;
import com.util.Request;
import com.util.Response;

public class HrSelectEmployees implements HrExecute{
	@Override
	public void execute(Request request, Response response) {
		inputView(request, response);
		logic(request, response);
		outputView(request, response);
	}

	@Override
	public void inputView(Request request, Response response) {
		
	}	
	
	
	@Override
	public void logic(Request request, Response response) {
		HrDao dao=new HrDao();
		response.setArrHrDto(dao.selectEmployees());

	}

	@Override
	public void outputView(Request request, Response response) {
		if(response!=null) {
			ArrayList<HrDto> dtos=response.getArrHrDto();
			System.out.println("선택 가능한 Manager 다음과 같습니다.");
			System.out.println("\t[ID]   [FirstName]\t[LastName]");
			for(HrDto dto:dtos) {
				System.out.println(dto.employeesSelectString());
			}
			System.out.println("선택할 Manager ID입력>>");
		}else {
			System.out.println("선택 가능한 Manager가 없습니다.");
		}
		
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
}
