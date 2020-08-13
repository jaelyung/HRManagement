package com.controller;

import java.util.ArrayList;

import com.dao.HrDao;
import com.dto.HrDto;
import com.util.DBConn;
import com.util.Request;
import com.util.Response;

public class HrUpdateJob implements HrExecute {

	static int inputUpJob;
	
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
		System.out.println("������ �׸��� �Է��ϼ���.");
		System.out.println("______________________________");
		System.out.println("1.������ 2.�ּұ޿� 3.�ִ�޿�  0.�ڷΰ���");
		System.out.println("______________________________");
		inputUpJob = DBConn.inputInt();
		switch (inputUpJob) {
		case 1:
			System.out.println("����(ID)�� �Է��ϼ���.");
			HrExecute he=null;
			he=new JobIdCheck();
			he.execute(request, response);
			System.out.println("�������� �Է��ϼ���.");
			String jobTitle = DBConn.inputString();

			dto.setJobId(JobIdCheck.jobId);
			dto.setJobTitle(jobTitle);
			flag=false;
			break;
		case 2:
			   System.out.println("����(ID)�� �Է��ϼ���.");
			   he=new JobIdCheck();
			   he.execute(request, response);
			   he=null;
			   he=new HrSelectSalaryMtoMCheck();
			   he.execute(request, response);

			   dto.setJobId(JobIdCheck.jobId);
			   dto.setMinSalary(HrSelectSalaryMtoMCheck.minSalary);
			   flag=false;
			   break;
			  case 3:
			   System.out.println("����(ID)�� �Է��ϼ���.");
			   he=new JobIdCheck();
			   he.execute(request, response);
			   he=null;
			   he=new HrSelectSalaryMtoMMaxCheck();
			   he.execute(request, response);

			   dto.setJobId(JobIdCheck.jobId);
			   dto.setMaxSalary(HrSelectSalaryMtoMMaxCheck.maxSalary);
			   flag=false;
			   break;
		case 0:
			flag=false;
			break;
		default:
			System.out.println("�߸� �Է� �ϼ̽��ϴ�");
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
		switch(inputUpJob){
		case 1:
			i = dao.updateJob(dto.getJobId(),"job_title", dto.getJobTitle());
			break;
		case 2:
			i = dao.updateJob(dto.getJobId(),"min_salary", dto.getMinSalary());
			break;
		case 3:
			i = dao.updateJob(dto.getJobId(),"max_salary", dto.getMaxSalary());
			break;
		default:
			break;
		}
		
		response.setResultValue(i);
		

	}

	@Override
	public void outputView(Request request, Response response) {
		
		if(response.getResultValue()<0) {
			System.out.println("�ش� ���� ID �����Ͱ� �������� �ʽ��ϴ�.");
		}else {
			switch (inputUpJob) {
			case 1:
				System.out.println(
						request.getHrDto().getJobId() + " �� �������� " + request.getHrDto().getJobTitle() + " ���� �����Ͽ����ϴ�.");
				break;
			case 2:
				System.out.println(request.getHrDto().getJobId() + " �� �ּұ޿��� �����Ͽ����ϴ�.");
				break;
			case 3:
				System.out.println(request.getHrDto().getJobId() + " �� �ִ�޿��� �����Ͽ����ϴ�.");
				break;
			default:
				break;
			}
		}
	}

}
