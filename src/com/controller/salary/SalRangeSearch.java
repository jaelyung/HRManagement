package com.controller.salary;

import java.util.ArrayList;
import java.util.Scanner;

import com.controller.HrExecute;
import com.dao.HrDao;
import com.dto.HrDto;
import com.util.DBConn;
import com.util.Request;
import com.util.Response;

public class SalRangeSearch implements HrExecute {

	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

	@Override
	public void execute(Request request, Response response) {
		inputView(request,response);
		logic(request,response);
		outputView(request,response);
	}

	@Override
	public void inputView(Request request, Response response) {
		// TODO Auto-generated method stub

	}

	@Override
	public void logic(Request request, Response response) {
		HrDao dao=new HrDao();
		Scanner sc=new Scanner(System.in);
		System.out.println("\n�˻��� Salary ���� ���� MinSalary ~ MaxSalary �Է�");
		System.out.print("\nMinSalary = ");
		int minSalary=DBConn.inputInt();
		System.out.print(" ~ MaxSalary = ");
		int maxSalary=DBConn.inputInt();
		
		response.setArrHrDto(dao.salRangeSearch(minSalary, maxSalary));
	}

	@Override
	public void outputView(Request request, Response response) {
		if(response!=null) {
			ArrayList<HrDto> dtos = response.getArrHrDto();
			System.out.println("   [Employee Id] [FirstName] \t[LastName] \t[Salary] [commission]  [Annual Income]");
			for(HrDto dto:dtos) {
				System.out.println(dto.salEmpSelect());
			}
			if(dtos.isEmpty()) {
				System.out.println("�ش��ϴ� �����Ͱ� �������� �ʽ��ϴ�");
				
			}
			System.out.println("");
		}else {
			System.out.println("����� ������ �����ϴ�.");
		}

	}

}
