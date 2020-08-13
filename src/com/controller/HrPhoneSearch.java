package com.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.dao.HrDao;
import com.dto.HrDto;
import com.util.Request;
import com.util.Response;

public class HrPhoneSearch implements HrExecute{
	@Override
	public void execute(Request request, Response response) {
		inputView(request, response);
		logic(request, response);
		outputView(request, response);
	}
	@Override
	public void inputView(Request request, Response response) {
		System.out.println("���� ���� ������ ����մϴ�");
		
	}
	@Override
	public void logic(Request request, Response response) {
		HrDao dao=new HrDao();
		Scanner sc=new Scanner(System.in);
		System.out.println("�˻��� ��ȭ��ȣ�� �Է��ϼ���");
		String userInput=sc.nextLine();
		String phoneNumber=userInput;
		
		response.setArrHrDto(dao.phoneNumberSearch(phoneNumber));
	}
	@Override
	public void outputView(Request request, Response response) {
		if(response!=null) {
			ArrayList<HrDto> dtos=response.getArrHrDto();
			System.out.println("  [EmployeeId]   [FirstName]   [LastName] \t   [Email]"
					+ "\t   [PhoneNumber]\t[JobId]");
			if(dtos.isEmpty()) {
				System.out.println("�ش��ϴ� �����Ͱ� �������� �ʽ��ϴ�");
			}
			for(HrDto dto:dtos) {
				System.out.println(dto.employeesPersonalToString());
			}
			System.out.println("");
		}else {
			System.out.println("�����Ͱ� �����ϴ�");
		}
		
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
}
