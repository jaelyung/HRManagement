package com.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.dao.HrDao;
import com.dto.HrDto;
import com.util.DBConn;
import com.util.Request;
import com.util.Response;



public class HrDeleteDept implements HrExecute {

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
		int departmentId=0;
		System.out.println("정보를 삭제할 부서의 ID를 입력하세요.");
		System.out.println("숫자입력>>");
		String input =sc.nextLine();
		if(HrDao.numberOrNot(input)) {
			departmentId=Integer.parseInt(input);
		
		}else {
			System.out.println("잘못 입력 하셨습니다.");
			inputView(request,response);
			
		}
		dto.setDepartmentId(departmentId);
		request.setHrDto(dto);

	}

	@Override
	public void logic(Request request, Response response) {
		
		int i = 0;
		HrDto dto = request.getHrDto();
		HrDao dao = new HrDao();
		i = dao.deleteDept(dto.getDepartmentId());
		
		response.setResultValue(i);
	}

	@Override
	public void outputView(Request request, Response response) {
		
		if (response.getResultValue() <= 0) {
			System.out.println("해당 부서 ID 데이터가 존재하지 않습니다.");
		} else {
			System.out.println("해당 부서의 정보를 삭제하였습니다.");
		}
	}

}
