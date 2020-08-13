package com.controller;

import java.util.ArrayList;

import com.dao.HrDao;
import com.dto.HrDto;
import com.util.DBConn;
import com.util.Request;
import com.util.Response;

public class EmployeesSelectCheck implements HrExecute {
	
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
		response.setArrHrDto(dao.employeesSelect());
		ArrayList<HrDto> dtos=response.getArrHrDto();

		while(flag) {
			employeeId = DBConn.inputInt();
			for(HrDto dto:dtos) {
				if(employeeId
						==dto.getEmployeeId()) {
					System.out.println("�̹� �����ϴ� ID�Դϴ�.");
					System.out.println("�ٽ� �Է����ּ���.");
					employeeId=-1;
					break;
				}
				//System.out.println(employeeId+2);//���Ҷ��� id �״��
			}
			//System.out.println(employeeId+1); //for�� Ż�� 
			if(employeeId!=-1) {
				flag = false;
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
//				System.out.println("�ش��ϴ� �����Ͱ� �������� �ʽ��ϴ�");
//				
//			}
//			for(HrDto dto:dtos) {
//				System.out.println(dto.employeesToString());
//			}
//			System.out.println("");
//		}else {
//			System.out.println("�����Ͱ� �����ϴ�");
//		}

	}

}