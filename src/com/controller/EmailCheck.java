package com.controller;

import java.util.ArrayList;

import com.dao.HrDao;
import com.dto.HrDto;
import com.util.DBConn;
import com.util.Request;
import com.util.Response;

public class EmailCheck implements HrExecute {
	public static String email;
	
	@Override
	public void execute() {
		HrDto request = new HrDto();
		ArrayList<HrDto> response = new ArrayList<HrDto>();

	}

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
		HrDao dao = new HrDao();
		response.setArrHrDto(dao.employeesSelect());
		ArrayList<HrDto> dtos = response.getArrHrDto();
		boolean flag = true;
		while (flag) {
			int count=0;
			email = DBConn.inputString().toUpperCase();
			for (HrDto dto : dtos) {
				if (email.equals(dto.getEmail())) {
					count=-1;
					break;
				}
				// System.out.println(employeeId+2);//���Ҷ��� id �״��
			}
			// System.out.println(employeeId+1); //for�� Ż��
			if (count!=-1) {
				flag = false;
			}else {
				System.out.println("�̹� �����ϴ� Email �ּ��Դϴ�.");
				System.out.println("�ٽ� �Է����ּ���.");
			}
		}
	}

	@Override
	public void outputView(Request request, Response response) {
		// TODO Auto-generated method stub
		
	}
}
