package com.controller;

import java.util.ArrayList;

import com.dao.HrDao;
import com.dto.HrDto;
import com.util.DBConn;
import com.util.HrException;
import com.util.Request;
import com.util.Response;

public class JobIdInsertCheck implements HrExecute {
	HrException hex = new HrException();
	static String jobId;
	

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
		response.setArrHrDto(dao.selectJobs());
		ArrayList<HrDto> dtos = response.getArrHrDto();
		
		
		boolean flag = true;
		boolean jobIdFlag = true;
		while (flag) {
			int count=0;
			do {
				try {
					jobId = DBConn.inputString().toUpperCase();
					hex.stringFormat(jobId);
					jobIdFlag=false;
				}catch(Exception e) {
					System.out.println(e.toString());
				}
				
			}while(jobIdFlag);
			
			
			for (HrDto dto : dtos) {
				
				if (jobId.equals(dto.getJobId())) {
					System.out.println("이미 등록된 직업ID 입니다.");
					System.out.println("다시 입력해주세요.");

					count=-1;
					break;
				}

			} if(count!=-1) {
				flag=false;
			}

		}
		
	}

	@Override
	public void outputView(Request request, Response response) {


	}

}