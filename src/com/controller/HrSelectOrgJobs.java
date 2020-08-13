package com.controller;

import java.util.ArrayList;

import com.dao.HrDao;
import com.dto.HrDto;
import com.util.DBConn;
import com.util.Request;
import com.util.Response;

public class HrSelectOrgJobs implements HrExecute {

	static int inputSelOrg;
	
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


	}

	@Override
	public void logic(Request request, Response response) {
		
		HrDao dao = new HrDao();

		response.setArrHrDto(dao.orgTableJobs(request.getHrDto().getDepartmentName()));
		
		
	}


	@Override
	public void outputView(Request request, Response response) {
		
		if(response!=null) {
			ArrayList<HrDto> dtos=
					response.getArrHrDto();
			
			
			if(dtos.isEmpty()) {
				System.out.println("�ش��ϴ� �����Ͱ� �������� �ʽ��ϴ�");
				
			}
			System.out.println("=== Dept Jobs ===");
			System.out.println(" [Dept Name] \t    [Job ID] \t\t[Job Title]");
			for(HrDto dto:dtos) {
				
				System.out.println(dto.deptJobsToString());
				
			}
			System.out.println("");
		}else {
			System.out.println("�����Ͱ� �����ϴ�");
		}

	}

}