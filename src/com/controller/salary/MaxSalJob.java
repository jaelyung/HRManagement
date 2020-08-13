package com.controller.salary;

import java.util.ArrayList;
import java.util.Scanner;

import com.controller.HrExecute;
import com.controller.HrSelectJobs;
import com.controller.JobIdCheck;
import com.controller.JobIdInsertCheck;
import com.dao.HrDao;
import com.dto.HrDto;
import com.util.DBConn;
import com.util.Request;
import com.util.Response;

public class MaxSalJob implements HrExecute {

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
		response.setArrHrDto(dao.maxSalJob(JobIdCheck.jobId));
		
	}

	@Override
	public void outputView(Request request, Response response) {
		if(response!=null) {
			
			ArrayList<HrDto> dtos = response.getArrHrDto();
			System.out.println("");
			System.out.println(" [���� �� �ְ�޿�] ");
			for(HrDto dto:dtos) {
				System.out.println(dto.maxSalJob());
			}
			if(dtos.isEmpty()) {
				System.out.println("�ش��ϴ� �����Ͱ� �������� �ʽ��ϴ�");
				
			}
			
		}else {
			System.out.println("����� ������ �����ϴ�.");
		}

	}

}
