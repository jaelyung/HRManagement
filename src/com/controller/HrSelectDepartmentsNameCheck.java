package com.controller;

import java.util.ArrayList;

import com.dao.HrDao;
import com.dto.HrDto;
import com.util.DBConn;
import com.util.Request;
import com.util.Response;

public class HrSelectDepartmentsNameCheck implements HrExecute{
	public static String departmentName;	
	
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
		response.setArrHrDto(dao.selectDepartments());

	}

	@Override
	public void outputView(Request request, Response response) {
		boolean flag=true;
		int count=0;
		if(response!=null) {
			ArrayList<HrDto> dtos = response.getArrHrDto();
			while(flag) {
				System.out.println("대소문자 구분해서 입력해주세요.");
				departmentName = DBConn.inputString();
				for(HrDto dto:dtos) {
					if(departmentName.equals(dto.getDepartmentName())) {
						count=0;
						break;
					}else {
						count=-1;
					}
				}
				if(count==0) {
					flag = false;
				}else {
					System.out.println("보기에 출력된 Id를 입력해주세요.");
				}
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
