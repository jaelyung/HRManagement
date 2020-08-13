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
		System.out.println("������ �׸��� �Է��ϼ���.");
		System.out.println("____________________________________________________________________________________");
		System.out.println("1.firstName 2.lastName 3.E-mail 4.��ȭ��ȣ 5.���� 6.�޿� 7.Ŀ�̼� 8.���Ŵ��� 9.�μ�(ID)  0.�ڷΰ���");
		System.out.println("____________________________________________________________________________________");
		inputUpEmp = DBConn.inputInt();
		switch (inputUpEmp) {
		case 1:
			System.out.println("����� �Է��ϼ���.");
			HrExecute he=new EmployeeSelectCheck2();
			he.execute(request, response);
			System.out.println("�̸��� �Է��ϼ���.");
			String firstName = DBConn.inputString();

			dto.setEmployeeId(EmployeeSelectCheck2.employeeId);
			dto.setFirstName(firstName);
			flag=false;
			break;
		case 2:
			System.out.println("����� �Է��ϼ���.");
			he=null;
			he=new EmployeeSelectCheck2();
			he.execute(request, response);
			System.out.println("��(lastName)�� �Է��ϼ���.");
			String lastName = DBConn.inputString();

			dto.setEmployeeId(EmployeeSelectCheck2.employeeId);
			dto.setLastName(lastName);
			flag=false;
			break;
		case 3:
			System.out.println("����� �Է��ϼ���.");
			he=null;
			he=new EmployeeSelectCheck2();
			he.execute(request, response);
			System.out.println("E-mail�� �Է��ϼ���.");

			he= new EmailCheck();
			he.execute(request, response);

			dto.setEmployeeId(EmployeeSelectCheck2.employeeId);
			dto.setEmail(EmailCheck.email);
			flag=false;
			break;
		case 4:
			System.out.println("����� �Է��ϼ���.");
			he=null;
			he=new EmployeeSelectCheck2();
			he.execute(request, response);
			boolean phoneFlag=true;
			String phoneNumber="";
			  do {
			   try {
			    System.out.println("��ȭ��ȣ �Է�  ex)000.000.0000");
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
			System.out.println("����� �Է��ϼ���.");
			he=null;
			he=new EmployeeSelectCheck2();
			he.execute(request, response);
			System.out.println("����(ID)�� �Է��ϼ���.");
			he=new JobIdCheck();
			he.execute(request, response);
			

			dto.setEmployeeId(EmployeeSelectCheck2.employeeId);
			dto.setJobId(JobIdCheck.jobId);
			flag=false;
			break;
		case 6://�޿��Է�
			System.out.println("����� �Է��ϼ���.");
			he=null;
			
			he= new HrSelectSalByEmpId();
			he.execute(request, response);
			//��� �Է½� �޿� ���� ������
//			int salary = DBConn.inputInt();
			
			dto.setEmployeeId(EmployeeSelectCheck2.employeeId);
			dto.setSalary(HrSelectSalByEmpId.salary);
			flag=false;
			break;
		case 7:
			System.out.println("����� �Է��ϼ���.");
			he=null;
			he=new EmployeeSelectCheck2();
			he.execute(request, response);
			System.out.println("Ŀ�̼��� �Է��ϼ���.");
			double commissionPct = DBConn.inputDouble();

			dto.setEmployeeId(EmployeeSelectCheck2.employeeId);
			dto.setCommissionPct(commissionPct);
			flag=false;
			break;
		case 8:
			System.out.println("����� �Է��ϼ���.");
			he=null;
			he=new EmployeeSelectCheck2();
			he.execute(request, response);
			System.out.println("���Ŵ����� ����� �Է��ϼ���.");
			he=null;
			he=new EmployeeSelectMgn();
			he.execute(request, response);

			dto.setEmployeeId(EmployeeSelectCheck2.employeeId);
			dto.setManagerId(EmployeeSelectMgn.managerId);
			flag=false;
			break;
		case 9:
			System.out.println("����� �Է��ϼ���.");
			he=null;
			he=new EmployeeSelectCheck2();
			he.execute(request, response);
			System.out.println("�μ�(ID)�� �Է��ϼ���.");
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
			System.out.println("�߸� �Է� �ϼ̽��ϴ�.");
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
			System.out.println("�ش� ��� �����Ͱ� �������� �ʽ��ϴ�.");
		}else {
			switch (inputUpEmp) {
			case 1:
				System.out.println(request.getHrDto().getEmployeeId() + " �� ������ �̸��� "
						+ request.getHrDto().getFirstName() + " ���� �����Ͽ����ϴ�.");
				break;
			case 2:
				System.out.println(request.getHrDto().getEmployeeId() + " �� ������ ��(lastName)�� "
						+ request.getHrDto().getLastName() + " ���� �����Ͽ����ϴ�.");
				break;
			case 3:
				System.out.println(request.getHrDto().getEmployeeId() + " �� ������ E-mail�� "
						+ request.getHrDto().getEmail() + " ���� �����Ͽ����ϴ�.");
				break;
			case 4:
				System.out.println(request.getHrDto().getEmployeeId() + " �� ������ ��ȭ��ȣ�� "
						+ request.getHrDto().getPhoneNumber() + " ���� �����Ͽ����ϴ�.");
				break;
			case 5:
				System.out.println(request.getHrDto().getEmployeeId() + " �� ������ ����(ID)�� "
						+ request.getHrDto().getJobId() + " ���� �����Ͽ����ϴ�.");
				break;
			case 6:
				System.out.println(request.getHrDto().getEmployeeId() + " �� ������ �޿��� " + request.getHrDto().getSalary()
						+ " ���� �����Ͽ����ϴ�.");
				break;
			case 7:
				System.out.println(request.getHrDto().getEmployeeId() + " �� ������ Ŀ�̼��� "
						+ request.getHrDto().getCommissionPct() + " ���� �����Ͽ����ϴ�.");
				break;
			case 8:
				System.out.println(request.getHrDto().getEmployeeId() + " �� ������ ���Ŵ����� "
						+ request.getHrDto().getManagerId() + " �� �������� �����Ͽ����ϴ�.");
				break;
			case 9:
				System.out.println(request.getHrDto().getEmployeeId() + " �� ������ �μ�(ID)�� "
						+ request.getHrDto().getDepartmentId() + " ���� �����Ͽ����ϴ�.");
				break;
			default:
				break;
			}
		}
	}
	

}
