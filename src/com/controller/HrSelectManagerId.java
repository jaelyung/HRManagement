package com.controller;

import java.util.ArrayList;

import com.dao.HrDao;
import com.dto.HrDto;
import com.util.Request;
import com.util.Response;

public class HrSelectManagerId implements HrExecute{
	public static int managerId;
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
		response.setArrHrDto(dao.selectManagerId());

	}
	
	@Override
	public void outputView(Request request, Response response) {
		if(response!=null) {
			ArrayList<HrDto> dtos=response.getArrHrDto();
			System.out.println("선택 가능한 Manager는 다음과 같습니다.");
			System.out.println("\t[ID]\t [FirstName] \t[LastName]");
			for(HrDto dto:dtos) {
				System.out.println(dto.managerIdSelect());
			}
			System.out.println();
			System.out.println("선택할 Manager ID입력>>");
		}else {
			System.out.println("선택  Manager가 없습니다.");
		}
		
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
}
