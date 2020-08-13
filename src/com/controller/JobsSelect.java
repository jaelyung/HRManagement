package com.controller;

import java.util.ArrayList;

import com.dao.HrDao;
import com.dto.HrDto;
import com.util.Request;
import com.util.Response;

public class JobsSelect implements HrExecute {

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
		System.out.println("Jobs 정보를 출력합니다");
	}

	@Override
	public void logic(Request request,Response response) {
		HrDao dao=new HrDao();
		response.setArrHrDto(dao.jobsSelect());

	}

	@Override
	public void outputView(Request request,Response response) {
		if(response!=null) {
			ArrayList<HrDto> dtos=
					response.getArrHrDto();
		
			System.out.println("  [JobId]\t [JobTitle]\t  "
					+ "\t\t[MinSalary]   [MaxSalary]");
			if(dtos.isEmpty()) {
				System.out.println("해당하는 데이터가 존재하지 않습니다");
				
			}
			for(HrDto dto:dtos) {
				System.out.println(dto.jobsToString());
				
			}
			System.out.println("");
		}else {
			System.out.println("데이터가 없습니다");
		}

	}

	

}
