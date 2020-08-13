package com.controller;

import java.util.ArrayList;

import com.dao.HrDao;
import com.dto.HrDto;
import com.util.DBConn;
import com.util.Request;
import com.util.Response;

public class HrUpdateDept implements HrExecute {

	static int inputUpDept;
	
	@Override
	public void execute() {
		new HrDto();
		new ArrayList<Integer>();

	}

	@Override
	public void execute(Request request, Response response) {
		inputView(request, response);
		logic(request, response);
		outputView(request, response);

	}

	@Override
	public void inputView(Request request, Response response) {

		HrDto dto = new HrDto();
		boolean flag=true;
		while(flag) {
		System.out.println("수정할 항목을 입력하세요.");
		System.out.println("______________________________");
		System.out.println("1.부서명 2.담당매니저 3.지역 0.뒤로가기");
		System.out.println("______________________________");
		inputUpDept = DBConn.inputInt();
		switch (inputUpDept) {
		case 1:
			System.out.println("부서(ID)를 입력하세요.");
			HrExecute he=null;
			he=new HrSelectDepartments2();
			he.execute(request, response);
			System.out.println("부서명을 입력하세요.");
			String departmentName = DBConn.inputString();

			dto.setDepartmentId(HrSelectDepartments2.departmentId);
			dto.setDepartmentName(departmentName);
			flag=false;
			break;
		case 2:
			System.out.println("부서(ID)를 입력하세요.");
			he=null;
			he=new HrSelectDepartments2();
			he.execute(request, response);
			System.out.println("담당매니저의 사번을 입력하세요.");
			he=null;
			he=new EmployeeSelectMgn();
			he.execute(request, response);

			dto.setDepartmentId(HrSelectDepartments2.departmentId);
			dto.setManagerId(EmployeeSelectMgn.managerId);
			flag=false;
			break;
		case 3:
			System.out.println("부서(ID)를 입력하세요.");
			he=null;
			he=new HrSelectDepartments2();
			he.execute(request, response);
//			departmentId = DBConn.inputInt();
			System.out.println("지역의 ID를 입력하세요.");
			he=null;
			he=new HrSelectLocations4();
			he.execute(request, response);

			dto.setDepartmentId(HrSelectDepartments2.departmentId);
			dto.setLocationId(HrSelectLocations4.locationId);
			flag=false;
			break;
		case 0:
			flag=false;
			break;
		default:
			System.out.println("잘못 입력 하셨습니다.");
			break;
		}

		request.setHrDto(dto);
	}
	}

	@Override
	public void logic(Request request, Response response) {
		
		int i = 0;
		HrDto dto = request.getHrDto();
		HrDao dao = new HrDao();
		switch(inputUpDept){
		case 1:
			i = dao.updateDept(dto.getDepartmentId(),"department_name", dto.getDepartmentName());
			break;
		case 2:
			i = dao.updateDept(dto.getDepartmentId(),"manager_id", dto.getManagerId());
			break;
		case 3:
			i = dao.updateDept(dto.getDepartmentId(),"location_id", dto.getLocationId());
			break;
		default:
			break;
		}
		
		response.setResultValue(i);
		

	}

	@Override
	public void outputView(Request request, Response response) {
		
		if(response.getResultValue()<0) {
			System.out.println("해당 부서ID 데이터가 존재하지 않습니다.");
		}else {
			switch (inputUpDept) {
			case 1:
				System.out.println(request.getHrDto().getDepartmentId() + " 부서의 부서명을 "
						+ request.getHrDto().getDepartmentName() + " 으로 변경하였습니다.");
				break;
			case 2:
				System.out.println(request.getHrDto().getDepartmentId() + " 부서의 담당매니저를 변경하였습니다.");
				break;
			case 3:
				System.out.println(request.getHrDto().getDepartmentId() + " 부서의 지역을 변경하였습니다.");
				break;
			default:
				break;
			}
		}
	}

}
