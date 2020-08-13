package com.controller;

import java.util.ArrayList;

import com.dao.HrDao;
import com.dto.HrDto;
import com.util.DBConn;
import com.util.Request;
import com.util.Response;

public class HrSelectSalaryMtoMCheck implements HrExecute{
	
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
		int inputMinSalary = 0;
		
		if (response != null) {
			ArrayList<HrDto> dtos = response.getArrHrDto();
			for (HrDto dto : dtos) {
//				minSalary = dto.getMinSalary();
				maxSalary = dto.getMaxSalary();
			}
			System.out.println();
			System.out.println("�ּұ޿��� �Է��ϼ���.");
			while (flag) {
				inputMinSalary = DBConn.inputInt();
				if (inputMinSalary > maxSalary) {
					System.out.println("_________________________________");
					System.out.println("���ִ� �޿� ���� ���� �ݾ׸� �Է°��ɡ�");
					System.out.println("< ~ " + "�ִ�:" + maxSalary + ">");
					System.out.println("_________________________________");
					System.out.println("�ٽ� �Է����ּ���");
				} else {
					
					flag = false;
				}
			}
			minSalary = inputMinSalary;
			
		} else {
			System.out.println("���������� �����ϴ�.");
		}

	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
}
