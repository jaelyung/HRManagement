package com.controller;

import java.util.ArrayList;

import com.dao.HrDao;
import com.dto.HrDto;
import com.util.DBConn;
import com.util.Request;
import com.util.Response;

public class EmployeeSelectCheck2 implements HrExecute {
	
	public static int employeeId;
	boolean flag=true;
	
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

	}

	@Override
	public void logic(Request request,Response response) {
		HrDao dao=new HrDao();
		response.setArrHrDto(dao.employeesSelectNot());
		ArrayList<HrDto> dtos=response.getArrHrDto();
		
		int count=0;
		while(flag) {
			employeeId = DBConn.inputInt();
			for(HrDto dto:dtos) {
				if(employeeId
						==dto.getEmployeeId()) {
					
					count=0;
					break;
				}else {
					count=-1;
				}
				//System.out.println(employeeId+2);//비교할때는 id 그대로
			}
			//System.out.println(employeeId+1); //for문 탈출 
			if(count==0) {
				flag = false;
			}else {
				System.out.println("해당하는 사원이 없습니다. 다시 입력해주세요.");
			}
		}
	}

	@Override
	public void outputView(Request request,Response response) {
//		if(response!=null) {
//			ArrayList<HrDto> dtos=
//					response.getArrHrDto();
//			
//			System.out.println("  [EmployeeId]   [FirstName]   [LastName] \t   [Email]"
//					+ "\t   [PhoneNumber]\t"
//					+ "[HireDate]\t[JobId]    [Salary]   [CommissionPct]");
//			if(dtos.isEmpty()) {
//				System.out.println("해당하는 데이터가 존재하지 않습니다");
//				
//			}
//			for(HrDto dto:dtos) {
//				System.out.println(dto.employeesToString());
//			}
//			System.out.println("");
//		}else {
//			System.out.println("데이터가 없습니다");
//		}

	}

}