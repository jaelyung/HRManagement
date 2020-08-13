package com.controller;

import java.util.ArrayList;

import com.dao.HrDao;
import com.dto.HrDto;
import com.util.Request;
import com.util.Response;

public class HrFindJobResign implements HrExecute{
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
		response.setArrHrDto(dao.selectJobResign());

	}

	@Override
	public void outputView(Request request, Response response) {
		if(response!=null) {
			ArrayList<HrDto> dtos=response.getArrHrDto();
			if(dtos.isEmpty()) {
				HrExecute he=new HrInsertResignation();
				he.execute(request, response);
			}
			
		}else {
			System.out.println("선택 가능한 나라가 없습니다.");
		}
		
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

}
