package com.controller;

import java.util.ArrayList;

import com.controller.salary.HrSelectSalByEmpId;
import com.dao.HrDao;
import com.dto.HrDto;
import com.util.DBConn;
import com.util.HrException;
import com.util.Request;
import com.util.Response;

public class HrUpdateEmp implements HrExecute {

	static int inputUpEmp;
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
		System.out.println("____________________________________________________________________________________");
		System.out.println("1.firstName 2.lastName 3.E-mail 4.전화번호 5.직무 6.급여 7.커미션 8.담당매니저 9.부서(ID)  0.뒤로가기");
		System.out.println("____________________________________________________________________________________");
		inputUpEmp = DBConn.inputInt();
		switch (inputUpEmp) {
		case 1:
			System.out.println("사번을 입력하세요.");
			HrExecute he=new EmployeeSelectCheck2();
			he.execute(request, response);
			System.out.println("이름을 입력하세요.");
			String firstName = DBConn.inputString();

			dto.setEmployeeId(EmployeeSelectCheck2.employeeId);
			dto.setFirstName(firstName);
			flag=false;
			break;
		case 2:
			System.out.println("사번을 입력하세요.");
			he=null;
			he=new EmployeeSelectCheck2();
			he.execute(request, response);
			System.out.println("성(lastName)을 입력하세요.");
			String lastName = DBConn.inputString();

			dto.setEmployeeId(EmployeeSelectCheck2.employeeId);
			dto.setLastName(lastName);
			flag=false;
			break;
		case 3:
			System.out.println("사번을 입력하세요.");
			he=null;
			he=new EmployeeSelectCheck2();
			he.execute(request, response);
			System.out.println("E-mail을 입력하세요.");

			he= new EmailCheck();
			he.execute(request, response);

			dto.setEmployeeId(EmployeeSelectCheck2.employeeId);
			dto.setEmail(EmailCheck.email);
			flag=false;
			break;
		case 4:
			System.out.println("사번을 입력하세요.");
			he=null;
			he=new EmployeeSelectCheck2();
			he.execute(request, response);
			boolean phoneFlag=true;
			String phoneNumber="";
			  do {
			   try {
			    System.out.println("전화번호 입력  ex)000.000.0000");
			    phoneNumber=DBConn.inputString();
			    
			    HrException.phoneNumber(phoneNumber);
			    phoneFlag=false;
			   }catch(Exception e) {
			    System.out.println(e.toString());
			   }
			  }while(phoneFlag);

			dto.setEmployeeId(EmployeeSelectCheck2.employeeId);
			dto.setPhoneNumber(phoneNumber);
			flag=false;
			break;
		case 5:
			System.out.println("사번을 입력하세요.");
			he=null;
			he=new EmployeeSelectCheck2();
			he.execute(request, response);
			System.out.println("직무(ID)를 입력하세요.");
			he=new JobIdCheck();
			he.execute(request, response);
			

			dto.setEmployeeId(EmployeeSelectCheck2.employeeId);
			dto.setJobId(JobIdCheck.jobId);
			flag=false;
			break;
		case 6://급여입력
			System.out.println("사번을 입력하세요.");
			he=null;
			
			he= new HrSelectSalByEmpId();
			he.execute(request, response);
			//사번 입력시 급여 범위 보여줌
//			int salary = DBConn.inputInt();
			
			dto.setEmployeeId(EmployeeSelectCheck2.employeeId);
			dto.setSalary(HrSelectSalByEmpId.salary);
			flag=false;
			break;
		case 7:
			System.out.println("사번을 입력하세요.");
			he=null;
			he=new EmployeeSelectCheck2();
			he.execute(request, response);
			System.out.println("커미션을 입력하세요.");
			double commissionPct = DBConn.inputDouble();

			dto.setEmployeeId(EmployeeSelectCheck2.employeeId);
			dto.setCommissionPct(commissionPct);
			flag=false;
			break;
		case 8:
			System.out.println("사번을 입력하세요.");
			he=null;
			he=new EmployeeSelectCheck2();
			he.execute(request, response);
			System.out.println("담당매니저의 사번을 입력하세요.");
			he=null;
			he=new EmployeeSelectMgn();
			he.execute(request, response);

			dto.setEmployeeId(EmployeeSelectCheck2.employeeId);
			dto.setManagerId(EmployeeSelectMgn.managerId);
			flag=false;
			break;
		case 9:
			System.out.println("사번을 입력하세요.");
			he=null;
			he=new EmployeeSelectCheck2();
			he.execute(request, response);
			System.out.println("부서(ID)를 입력하세요.");
			he=null;
			he= new HrSelectDepartments2();
			he.execute(request, response);
			
			dto.setEmployeeId(EmployeeSelectCheck2.employeeId);
			dto.setDepartmentId(HrSelectDepartments2.departmentId);
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
		switch(inputUpEmp){
		case 1:
			i = dao.updateEmp(dto.getEmployeeId(),"first_name", dto.getFirstName());
			break;
		case 2:
			i = dao.updateEmp(dto.getEmployeeId(),"last_name", dto.getLastName());
			break;
		case 3:
			i = dao.updateEmp(dto.getEmployeeId(),"email", dto.getEmail());
			break;
		case 4:
			i = dao.updateEmp(dto.getEmployeeId(),"phone_number", dto.getPhoneNumber());
			break;
		case 5:
			i = dao.updateEmp(dto.getEmployeeId(),"job_id", dto.getJobId());
			break;
		case 6:
			i = dao.updateEmp(dto.getEmployeeId(),"salary", dto.getSalary());
			break;
		case 7:
			i = dao.updateEmp(dto.getEmployeeId(),"commission_pct", dto.getCommissionPct());
			break;
		case 8:
			i = dao.updateEmp(dto.getEmployeeId(),"manager_id", dto.getManagerId());
			break;
		case 9:
			i = dao.updateEmp(dto.getEmployeeId(),"department_id", dto.getDepartmentId());
			break;	
		default:
			break;
		}
		
		response.setResultValue(i);
		

	}

	@Override
	public void outputView(Request request, Response response) {
		
		if(response.getResultValue()<0) {
			System.out.println("해당 사번 데이터가 존재하지 않습니다.");
		}else {
			switch (inputUpEmp) {
			case 1:
				System.out.println(request.getHrDto().getEmployeeId() + " 번 직원의 이름을 "
						+ request.getHrDto().getFirstName() + " 으로 변경하였습니다.");
				break;
			case 2:
				System.out.println(request.getHrDto().getEmployeeId() + " 번 직원의 성(lastName)을 "
						+ request.getHrDto().getLastName() + " 으로 변경하였습니다.");
				break;
			case 3:
				System.out.println(request.getHrDto().getEmployeeId() + " 번 직원의 E-mail을 "
						+ request.getHrDto().getEmail() + " 으로 변경하였습니다.");
				break;
			case 4:
				System.out.println(request.getHrDto().getEmployeeId() + " 번 직원의 전화번호를 "
						+ request.getHrDto().getPhoneNumber() + " 으로 변경하였습니다.");
				break;
			case 5:
				System.out.println(request.getHrDto().getEmployeeId() + " 번 직원의 직무(ID)를 "
						+ request.getHrDto().getJobId() + " 으로 변경하였습니다.");
				break;
			case 6:
				System.out.println(request.getHrDto().getEmployeeId() + " 번 직원의 급여를 " + request.getHrDto().getSalary()
						+ " 으로 변경하였습니다.");
				break;
			case 7:
				System.out.println(request.getHrDto().getEmployeeId() + " 번 직원의 커미션을 "
						+ request.getHrDto().getCommissionPct() + " 으로 변경하였습니다.");
				break;
			case 8:
				System.out.println(request.getHrDto().getEmployeeId() + " 번 직원의 담당매니저를 "
						+ request.getHrDto().getManagerId() + " 번 직원으로 변경하였습니다.");
				break;
			case 9:
				System.out.println(request.getHrDto().getEmployeeId() + " 번 직원의 부서(ID)를 "
						+ request.getHrDto().getDepartmentId() + " 으로 변경하였습니다.");
				break;
			default:
				break;
			}
		}
	}
	

}
