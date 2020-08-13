package com.controller;

import java.util.ArrayList;

import com.dao.HrDao;
import com.dto.HrDto;
import com.util.DBConn;
import com.util.Request;
import com.util.Response;

public class HrSelectSalaryMtoM implements HrExecute{
	
	static String jobId;
	static int salary;
	int minSalary;
	int maxSalary;
	
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
		if (response != null) {
			ArrayList<HrDto> dtos = response.getArrHrDto();
			System.out.println("�ش� ������ �޿� �����Դϴ�.");
			System.out.println("\t[ID] \t\t[Job Title] \t\t\t[Min Salary] \t[Max Salary]");
			for (HrDto dto : dtos) {
				System.out.println(dto.jobMMSalSelect());
				minSalary = dto.getMinSalary();
				maxSalary = dto.getMaxSalary();
			}
			System.out.println();
			System.out.println("�޿��� �Է��ϼ���.");
			while (flag) {
				salary = DBConn.inputInt();
				if (salary > maxSalary || salary < minSalary) {
					System.out.println("___________________________________________________");
					System.out.println("���ּ� ~ �ִ� ���� �ȿ����� �Է°��ɡ�");
					System.out.println("<�ּ�:" + minSalary + " ~ " + "�ִ�:" + maxSalary + ">");
					System.out.println("___________________________________________________");
					System.out.println("�ٽ� �Է����ּ���");
				} else {
					flag = false;
				}
			}

		} else {
			System.out.println("���������� �����ϴ�.");
		}

	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
}
