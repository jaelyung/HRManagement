package com.controller;

import java.util.ArrayList;

import com.dao.HrDao;
import com.dto.HrDto;
import com.util.DBConn;
import com.util.Request;
import com.util.Response;

public class DeptIdCheck implements HrExecute {

	static int departmentId;
	boolean flag = true;

	@Override
	public void execute() {
		HrDto request = new HrDto();
		ArrayList<HrDto> response = new ArrayList<HrDto>();

	}

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
		HrDao dao = new HrDao();
		response.setArrHrDto(dao.departmentsSelect());
		ArrayList<HrDto> dtos = response.getArrHrDto();

		while (flag) {
			departmentId = DBConn.inputInt();
			for (HrDto dto : dtos) {
				if (departmentId != dto.getDepartmentId()) {
					System.out.println("존재하지 않는 부서입니다.");
					System.out.println("다시 입력해주세요.");
					departmentId = -1;
					break;
				}
				// System.out.println(employeeId+2);//비교할때는 id 그대로
			}
			// System.out.println(employeeId+1); //for문 탈출
			if (departmentId != -1) {
				flag = false;
			}
		}
	}

	@Override
	public void outputView(Request request, Response response) {


	}

}