package com.controller.salary;

import java.util.ArrayList;

import com.controller.EmployeeSelectCheck2;
import com.controller.HrExecute;
import com.dao.HrDao;
import com.dto.HrDto;
import com.util.DBConn;
import com.util.Request;
import com.util.Response;

public class HrSelectSalByEmpId implements HrExecute{

	public static int employeeId=0;
	public static int salary=0;
	boolean flag=true;
	int maxSalary=0;
	int minSalary=0;
	
	public void execute(Request request, Response response) {
		inputView(request, response);
		logic(request, response);
		outputView(request, response);
	}

	@Override
	public void inputView(Request request, Response response) {
		HrExecute he = new EmployeeSelectCheck2();
		he.execute(request, response);
	}
	
	@Override
	public void logic(Request request, Response response) {
		HrDao dao=new HrDao();
		response.setArrHrDto(dao.jobsSelectByEmpId(EmployeeSelectCheck2.employeeId));

	}
	
	@Override
	public void outputView(Request request, Response response) {
		if(response!=null) {
			ArrayList<HrDto> dtos=response.getArrHrDto();
			System.out.println("해당 사원의 급여 범위입니다.");
			System.out.println("\t[First Name] \t[Last Name] \t[Job Title] \t\t\t[Min Salary] \t[Max Salary]");
			for(HrDto dto:dtos) {
				System.out.println(dto.jobMMSalUpdate());
				minSalary=dto.getMinSalary();
				maxSalary=dto.getMaxSalary();
			}
			System.out.println();
			System.out.println("변경할 급여를 입력하세요.");
			while(flag) {
				salary = DBConn.inputInt();
				if(salary>maxSalary||salary<minSalary) {
					System.out.println("__________________________________________");
				    System.out.println("※최소 ~ 최대 범위 안에서만 입력가능※");
				    System.out.println("<최소:"+minSalary+" ~ "+"최대:"+maxSalary+">");
				    System.out.println("__________________________________________");
				    System.out.println("다시 입력해주세요");
				}
				else {
					flag=false;
				}
			}
		}else {
			System.out.println("직무정보가 없습니다.");
		}
		
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
}
