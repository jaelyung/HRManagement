package com.controller;

import java.util.ArrayList;

import com.dao.HrDao;
import com.dto.HrDto;
import com.util.Request;
import com.util.Response;

public class HrSelectJobs implements HrExecute{
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
		response.setArrHrDto(dao.selectJobs());

	}
	
	@Override
	public void outputView(Request request, Response response) {
		if(response!=null) {
			ArrayList<HrDto> dtos=response.getArrHrDto();
			System.out.println("선택 가능한 직무는 다음과 같습니다.");
			System.out.println("\t[ID] \t\t[Job Title] ");
			for(HrDto dto:dtos) {
				System.out.println(dto.jobSelect());
			}
			System.out.println();
			System.out.println("선택할 직무 ID입력>>");
		}else {
			System.out.println("선택 가능한 직무가 없습니다.");
		}
		
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
}
