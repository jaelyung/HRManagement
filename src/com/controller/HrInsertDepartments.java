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
		
		System.out.println("부서 정보를 입력하세요");
		System.out.println("부서 ID 입력");
		HrExecute he=null;
		he=new HrSelectDepartmentsCheck();
		he.execute(request, response);
		
		System.out.println("부서 이름 입력");
		String departmentName=DBConn.inputString();
		
		System.out.println("부서 담당자 ID 입력");
		he = new EmployeeSelectMgn();
		he.execute(request, response);
		//null허용 필요
		
		System.out.println("지점 선택");
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
		System.out.println(response.getResultValue()+"개의 데이터를 추가하였습니다.");

	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
}
