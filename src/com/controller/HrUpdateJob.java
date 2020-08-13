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
		System.out.println("수정할 항목을 입력하세요.");
		System.out.println("______________________________");
		System.out.println("1.직무명 2.최소급여 3.최대급여  0.뒤로가기");
		System.out.println("______________________________");
		inputUpJob = DBConn.inputInt();
		switch (inputUpJob) {
		case 1:
			System.out.println("직무(ID)를 입력하세요.");
			HrExecute he=null;
			he=new JobIdCheck();
			he.execute(request, response);
			System.out.println("직무명을 입력하세요.");
			String jobTitle = DBConn.inputString();

			dto.setJobId(JobIdCheck.jobId);
			dto.setJobTitle(jobTitle);
			flag=false;
			break;
		case 2:
			   System.out.println("직무(ID)를 입력하세요.");
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
			   System.out.println("직무(ID)를 입력하세요.");
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
			System.out.println("잘못 입력 하셨습니다");
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
			System.out.println("해당 직무 ID 데이터가 존재하지 않습니다.");
		}else {
			switch (inputUpJob) {
			case 1:
				System.out.println(
						request.getHrDto().getJobId() + " 의 직무명을 " + request.getHrDto().getJobTitle() + " 으로 변경하였습니다.");
				break;
			case 2:
				System.out.println(request.getHrDto().getJobId() + " 의 최소급여를 변경하였습니다.");
				break;
			case 3:
				System.out.println(request.getHrDto().getJobId() + " 의 최대급여를 변경하였습니다.");
				break;
			default:
				break;
			}
		}
	}

}
