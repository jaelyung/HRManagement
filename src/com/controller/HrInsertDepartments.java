package com.controller;

import com.dao.HrDao;
import com.dto.HrDto;
import com.util.DBConn;
import com.util.Request;
import com.util.Response;

public class HrInsertDepartments implements HrExecute{
	@Override
	public void execute(Request request, Response response) {
		inputView(request, response);
		logic(request, response);
		outputView(request, response);
	}

	@Override
	public void inputView(Request request, Response response) {
		
		System.out.println("�μ� ������ �Է��ϼ���");
		System.out.println("�μ� ID �Է�");
		HrExecute he=null;
		he=new HrSelectDepartmentsCheck();
		he.execute(request, response);
		
		System.out.println("�μ� �̸� �Է�");
		String departmentName=DBConn.inputString();
		
		System.out.println("�μ� ����� ID �Է�");
		he = new EmployeeSelectMgn();
		he.execute(request, response);
		//null��� �ʿ�
		
		System.out.println("���� ����");
		he=null;
//		he=new HrSelectLocations();
		he=new HrSelectLocations4();
		he.execute(request, response);
		
//		int locationId=DBConn.inputInt();
		
		HrDto dto=new HrDto();
		dto.setDepartmentId(HrSelectDepartmentsCheck.departmentId);
		dto.setDepartmentName(departmentName);
		dto.setManagerId(EmployeeSelectMgn.managerId);
		dto.setLocationId(HrSelectLocations4.locationId);
		
		request.setHrDto(dto);
	}	
	
	
	@Override
	public void logic(Request request, Response response) {
		HrDto dto=request.getHrDto();
		HrDao dao=new HrDao();
		int i=dao.insertDepartments(dto);
		
		response.setResultValue(i);

	}

	@Override
	public void outputView(Request request, Response response) {
		System.out.println(response.getResultValue()+"���� �����͸� �߰��Ͽ����ϴ�.");

	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
}
