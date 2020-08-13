package com.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.dao.HrDao;
import com.dto.HrDto;
import com.util.Request;
import com.util.Response;

public class DepartmentsName implements HrExecute {

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
		System.out.println("�μ�  ������ ����մϴ�");
	}

	@Override
	 public void logic(Request request,Response response) {
	  HrDao dao=new HrDao();
	  Scanner sc=new Scanner(System.in);
	  HrExecute he = new HrSelectDepartmentsName();
	  he.execute(request, response);
	  he = new HrSelectDepartmentsNameCheck();
	  he.execute(request, response);
	  
	  response.setArrHrDto(dao.departmentName(HrSelectDepartmentsNameCheck.departmentName));
	  
	 }

	@Override
	public void outputView(Request request,Response response) {
		if(response!=null) {
			ArrayList<HrDto> dtos=
					response.getArrHrDto();
			
			System.out.println("  [DepartmentId]      [DepartmentName] \t   [EmployeeId]  [FirstName]    [LastName]"
					+ "\t  [Email] \t  [PhoneNumber] \t[JobId]  [ManagerId]");
			if(dtos.isEmpty()) {
				System.out.println("�ش��ϴ� �����Ͱ� �������� �ʽ��ϴ�");
				
			}
			for(HrDto dto:dtos) {
				System.out.println(dto.PersonalInquiryToString());
			}
			System.out.println("");
		}else {
			System.out.println("�����Ͱ� �����ϴ�");
		}

	}

}
