package com.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.dao.HrDao;
import com.dto.HrDto;
import com.util.DBConn;
import com.util.Request;
import com.util.Response;

public class HrDeleteEmp implements HrExecute {

	@Override
	public void execute() {
		new HrDto();
		new ArrayList<Integer>();

	}

	@Override
	public void execute(Request request, Response response) {
		inputView(request, response);
		logic(request, response);
		outputView(request, response);

	}

	@Override
	public void inputView(Request request, Response response) {
		HrDto dto = new HrDto();
		Scanner sc=new Scanner(System.in);
		int employeeId=0;
		
		System.out.println("퇴사처리 할 직원의 사번을 입력하세요.");
		System.out.println("숫자입력>>");
		String input =sc.nextLine();
		if(HrDao.numberOrNot(input)) {
			employeeId=Integer.parseInt(input);
		
		}else {
			System.out.println("잘못 입력 하셨습니다.");
			inputView(request,response);
			
		}
		
		
		dto.setEmployeeId(employeeId);
		request.setHrDto(dto);

	}

	@Override
	public void logic(Request request, Response response) {
		
		int i = 0;
		HrDto dto = request.getHrDto();
		HrDao dao = new HrDao();
		i = dao.deleteEmp(dto.getEmployeeId());
		
		response.setResultValue(i);
	}

	@Override
	public void outputView(Request request, Response response) {
		
		if (response.getResultValue() <= 0) {
			System.out.println("퇴사처리가 수행되지 않았습니다.");
		} else {
			System.out.println(request.getHrDto().getEmployeeId()+"번 사원이 퇴사처리 되었습니다.");
		}
	}

}
