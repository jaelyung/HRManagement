package com.controller;

import java.util.ArrayList;

import com.dao.HrDao;
import com.dto.HrDto;
import com.util.DBConn;
import com.util.Request;
import com.util.Response;
public class HrDeleteJob implements HrExecute {

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
		
		System.out.println("정보를 삭제할 직무의 ID를 입력하세요.");
		HrExecute he = null;
		he=new JobIdCheck();
		he.execute(request, response);
		String jobId = DBConn.inputString().toUpperCase();
		
		dto.setJobId(jobId);
		request.setHrDto(dto);

	}

	@Override
	public void logic(Request request, Response response) {
		
		int i = 0;
		HrDto dto = request.getHrDto();
		HrDao dao = new HrDao();
		i = dao.deleteJob(dto.getJobId());
		
		response.setResultValue(i);
	}

	@Override
	public void outputView(Request request, Response response) {
		
		if (response.getResultValue() <= 0) {
			System.out.println("해당 직무 ID 데이터가 존재하지 않습니다.");
		} else {
			System.out.println("해당 직무의 정보를 삭제하였습니다.");
		}
	}

}
