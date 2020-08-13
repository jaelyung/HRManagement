package com.controller;

import java.util.ArrayList;

import com.dao.HrDao;
import com.dto.HrDto;
import com.util.DBConn;
import com.util.Request;
import com.util.Response;

public class HrSelectSalaryMtoMMaxCheck implements HrExecute{
	
	static String jobId;
	static int salary;
	public static int minSalary;
	public static int maxSalary;
	
	public void execute(Request request, Response response) {
		inputView(request, response);
		logic(request, response);
		outputView(request, response);
	}

	@Override
	public void inputView(Request request, Response response) {
		jobId=JobIdCheck.jobId;
	}
	
	@Override
	public void logic(Request request, Response response) {
		HrDao dao=new HrDao();
		response.setArrHrDto(dao.jobsSelect(jobId));

	}
	
	@Override
	public void outputView(Request request, Response response) {
		boolean flag = true;
		int inputMaxSalary = 0;
		if (response != null) {
			ArrayList<HrDto> dtos = response.getArrHrDto();
			for (HrDto dto : dtos) {
				minSalary = dto.getMinSalary();
//				maxSalary = dto.getMaxSalary();
			}
			System.out.println();
			System.out.println("�ִ�޿��� �Է��ϼ���.");
			while (flag) {
				inputMaxSalary = DBConn.inputInt();
				if (inputMaxSalary < minSalary) {
					System.out.println("_________________________________");
					System.out.println("���ּ� �޿� ���� ū �ݾ׸� �Է°��ɡ�");
					System.out.println("<�ּ�: " + minSalary +" ~ " + ">");
					System.out.println("_________________________________");
					System.out.println("�ٽ� �Է����ּ���");
				} else {
					flag = false;
				}
			}
			maxSalary = inputMaxSalary;
			
		} else {
			System.out.println("���������� �����ϴ�.");
		}

	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
}
