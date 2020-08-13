package com.controller.salary;

import java.util.ArrayList;
import java.util.Scanner;

import com.controller.HrExecute;
import com.dao.HrDao;
import com.dto.HrDto;
import com.util.DBConn;
import com.util.Request;
import com.util.Response;

public class HrSelectSalEmp implements HrExecute{
	String inputOrder;
	@Override
	public void execute(Request request, Response response) {
		inputView(request, response);
		logic(request, response);
		outputView(request, response);
	}

	@Override
	public void inputView(Request request, Response response) {
		HrDto dto=new HrDto();
		
		
		request.setHrDto(dto);
	}	
	
	@Override
	public void logic(Request request, Response response) {
		HrDao dao=new HrDao();
		response.setArrHrDto(dao.selectSalEmp());

	}
	
	@Override
	public void outputView(Request request, Response response) {
		if(response!=null) {
			ArrayList<HrDto> dtos=response.getArrHrDto();
			System.out.println("   [EmployeeId] [FirstName]\t[LastName] \t[Salary]  [COMMISSION] \t[Annual Income]");
			for(HrDto dto:dtos) {
				System.out.println(dto.salEmpSelect());
			}
		}else {
			System.out.println("출력할 정보가 없습니다.");
		}
		
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
}
