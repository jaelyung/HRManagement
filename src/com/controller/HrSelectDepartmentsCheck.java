package com.controller;

import java.util.ArrayList;

import com.dao.HrDao;
import com.dto.HrDto;
import com.util.DBConn;
import com.util.Request;
import com.util.Response;

public class HrSelectDepartmentsCheck implements HrExecute{
	public static int departmentId;	
	
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
		HrDao dao=new HrDao();
		response.setArrHrDto(dao.selectDepartmentId());
		ArrayList<HrDto> dtos=response.getArrHrDto();
		
		boolean flag=true;
		while(flag) {
			departmentId = DBConn.inputInt();
			for(HrDto dto:dtos) {
				if(departmentId
						==dto.getDepartmentId()) {
					System.out.println("�̹� �����ϴ� ID�Դϴ�.");
					System.out.println("�ٽ� �Է����ּ���.");
					departmentId=-1;
					break;
				}
				//System.out.println(employeeId+2);//���Ҷ��� id �״��
			}
			//System.out.println(employeeId+1); //for�� Ż�� 
			if(departmentId!=-1) {
				flag = false;
			}
		}
	}

	@Override
	public void outputView(Request request, Response response) {
//		HrExecute he=new HrSelectDepartments();
//		boolean flag=true;
//		int count=0;
//		if(response!=null) {
//			dtos = response.getArrHrDto();
//			
//			he.execute(request, response);
//			while(flag) {
//				departmentId = DBConn.inputInt();
//				for(HrDto dto:dtos) {
//					if(departmentId
//							==dto.getDepartmentId()) {
//						count=0;
//						break;
//					}else {
//						count=-1;
//					}
//				}
//				if(count==0) {
//					flag = false;
//				}else {
//					System.out.println("���⿡ ��µ� Id�� �Է����ּ���.");
//				}
//			}
//		}else {
//			System.out.println("���� ������ ���� �����ϴ�.");
//		}
		
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
}
