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
		
		System.out.println("���ó�� �� ������ ����� �Է��ϼ���.");
		System.out.println("�����Է�>>");
		String input =sc.nextLine();
		if(HrDao.numberOrNot(input)) {
			employeeId=Integer.parseInt(input);
		
		}else {
			System.out.println("�߸� �Է� �ϼ̽��ϴ�.");
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
			System.out.println("���ó���� ������� �ʾҽ��ϴ�.");
		} else {
			System.out.println(request.getHrDto().getEmployeeId()+"�� ����� ���ó�� �Ǿ����ϴ�.");
		}
	}

}
