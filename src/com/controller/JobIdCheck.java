package com.controller;

import java.util.ArrayList;

import com.dao.HrDao;
import com.dto.HrDto;
import com.util.DBConn;
import com.util.Request;
import com.util.Response;

public class JobIdCheck implements HrExecute {

	public static String jobId;
	

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
		HrExecute he=null;
		he=new HrSelectJobs();
		he.execute(request, response);
	}

	@Override
	public void logic(Request request, Response response) {
		HrDao dao = new HrDao();
		response.setArrHrDto(dao.selectJobs());
		ArrayList<HrDto> dtos = response.getArrHrDto();
		boolean flag=true;
		while (flag) {
			int count=0;
			jobId = DBConn.inputString().toUpperCase();
			
			for (HrDto dto : dtos) {
				
				if (jobId.equals(dto.getJobId())) {
					count=0;
					break;
				}else if(jobId.equals("RESIGN")) {
					System.out.println("��� �� �� ���� ���� �Դϴ�.");
					count=-1;
					break;
				}
				else  {
					count=-1;
				}
				// System.out.println(employeeId+2);//���Ҷ��� id �״��
			}
			// System.out.println(employeeId+1); //for�� Ż��
			if (count==0) {
				flag = false;
			}else {
				System.out.println("���⿡ ��µ� ID�� �Է����ּ���.");
			}
		}
	}

	@Override
	public void outputView(Request request, Response response) {


	}

}