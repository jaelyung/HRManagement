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
		
		System.out.println("������ ������ ������ ID�� �Է��ϼ���.");
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
			System.out.println("�ش� ���� ID �����Ͱ� �������� �ʽ��ϴ�.");
		} else {
			System.out.println("�ش� ������ ������ �����Ͽ����ϴ�.");
		}
	}

}
