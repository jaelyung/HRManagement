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
			System.out.println("���� ������ ������ ������ �����ϴ�.");
			System.out.println("\t[ID] \t\t[Job Title] ");
			for(HrDto dto:dtos) {
				System.out.println(dto.jobSelect());
			}
			System.out.println();
			System.out.println("������ ���� ID�Է�>>");
		}else {
			System.out.println("���� ������ ������ �����ϴ�.");
		}
		
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
}
