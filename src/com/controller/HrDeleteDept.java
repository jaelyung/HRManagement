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
		System.out.println("������ ������ �μ��� ID�� �Է��ϼ���.");
		System.out.println("�����Է�>>");
		String input =sc.nextLine();
		if(HrDao.numberOrNot(input)) {
			departmentId=Integer.parseInt(input);
		
		}else {
			System.out.println("�߸� �Է� �ϼ̽��ϴ�.");
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
			System.out.println("�ش� �μ� ID �����Ͱ� �������� �ʽ��ϴ�.");
		} else {
			System.out.println("�ش� �μ��� ������ �����Ͽ����ϴ�.");
		}
	}

}
