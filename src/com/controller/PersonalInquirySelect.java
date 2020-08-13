package com.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.dao.HrDao;
import com.dto.HrDto;
import com.util.Request;
import com.util.Response;

public class PersonalInquirySelect implements HrExecute {

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
		System.out.println("���� ���� ������ ����մϴ�");
	}

	@Override
	public void logic(Request request,Response response) {
		HrDao dao=new HrDao();
		Scanner sc=new Scanner(System.in);
		System.out.println("firstName�� �Է��ϼ���");
		String first=sc.nextLine();
		String firstName=first.substring(0,1).toUpperCase()+first.substring(1).toLowerCase();
		System.out.println("lastName�� �Է��ϼ���");
		String last=sc.nextLine();
		String lastName=last.substring(0,1).toUpperCase()+last.substring(1).toLowerCase();
		
		response.setArrHrDto(dao.personalInquirySelect(firstName,lastName));

	}

	@Override
	public void outputView(Request request,Response response) {
		if(response!=null) {
			ArrayList<HrDto> dtos=
					response.getArrHrDto();
			System.out.println("  [EmployeeId]   [FirstName]   [LastName] \t   [Email]"
					+ "\t   [PhoneNumber]"
					+ "\t[JobId]  ");
			for(HrDto dto:dtos) {
				System.out.println(dto.employeesPersonalToString());
			}
			
			if(dtos.isEmpty()) {
				System.out.println("�ش��ϴ� �����Ͱ� �������� �ʽ��ϴ�");
				
			}
			System.out.println("");
		}else {
			System.out.println("�����Ͱ� �����ϴ�");
		}

	}

}
