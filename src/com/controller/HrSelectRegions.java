package com.controller;

import java.util.ArrayList;

import com.dao.HrDao;
import com.dto.HrDto;
import com.util.Request;
import com.util.Response;

public class HrSelectRegions implements HrExecute{
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
		response.setArrHrDto(dao.selectRegions());

	}
	@Override
	public void outputView(Request request, Response response) {
		if(response!=null) {
			ArrayList<HrDto> dtos=response.getArrHrDto();
			System.out.println("선택 가능한 Region은 다음과 같습니다.");
			System.out.println("\t[Id]   [RegionName]");
			for(HrDto dto:dtos) {
				System.out.println(dto.regionName());
			}
			System.out.println("선택할 Region ID입력>>");
		}else {
			System.out.println("선택 가능한 Region이 없습니다.");
		}
		
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
}
