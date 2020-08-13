package com.controller;

import java.util.ArrayList;

import com.dao.HrDao;
import com.dto.HrDto;
import com.util.DBConn;
import com.util.Request;
import com.util.Response;

public class HrUpdateDept implements HrExecute {

	static int inputUpDept;
	
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
		System.out.println("1.�μ��� 2.���Ŵ��� 3.���� 0.�ڷΰ���");
		System.out.println("______________________________");
		inputUpDept = DBConn.inputInt();
		switch (inputUpDept) {
		case 1:
			System.out.println("�μ�(ID)�� �Է��ϼ���.");
			HrExecute he=null;
			he=new HrSelectDepartments2();
			he.execute(request, response);
			System.out.println("�μ����� �Է��ϼ���.");
			String departmentName = DBConn.inputString();

			dto.setDepartmentId(HrSelectDepartments2.departmentId);
			dto.setDepartmentName(departmentName);
			flag=false;
			break;
		case 2:
			System.out.println("�μ�(ID)�� �Է��ϼ���.");
			he=null;
			he=new HrSelectDepartments2();
			he.execute(request, response);
			System.out.println("���Ŵ����� ����� �Է��ϼ���.");
			he=null;
			he=new EmployeeSelectMgn();
			he.execute(request, response);

			dto.setDepartmentId(HrSelectDepartments2.departmentId);
			dto.setManagerId(EmployeeSelectMgn.managerId);
			flag=false;
			break;
		case 3:
			System.out.println("�μ�(ID)�� �Է��ϼ���.");
			he=null;
			he=new HrSelectDepartments2();
			he.execute(request, response);
//			departmentId = DBConn.inputInt();
			System.out.println("������ ID�� �Է��ϼ���.");
			he=null;
			he=new HrSelectLocations4();
			he.execute(request, response);

			dto.setDepartmentId(HrSelectDepartments2.departmentId);
			dto.setLocationId(HrSelectLocations4.locationId);
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
		switch(inputUpDept){
		case 1:
			i = dao.updateDept(dto.getDepartmentId(),"department_name", dto.getDepartmentName());
			break;
		case 2:
			i = dao.updateDept(dto.getDepartmentId(),"manager_id", dto.getManagerId());
			break;
		case 3:
			i = dao.updateDept(dto.getDepartmentId(),"location_id", dto.getLocationId());
			break;
		default:
			break;
		}
		
		response.setResultValue(i);
		

	}

	@Override
	public void outputView(Request request, Response response) {
		
		if(response.getResultValue()<0) {
			System.out.println("�ش� �μ�ID �����Ͱ� �������� �ʽ��ϴ�.");
		}else {
			switch (inputUpDept) {
			case 1:
				System.out.println(request.getHrDto().getDepartmentId() + " �μ��� �μ����� "
						+ request.getHrDto().getDepartmentName() + " ���� �����Ͽ����ϴ�.");
				break;
			case 2:
				System.out.println(request.getHrDto().getDepartmentId() + " �μ��� ���Ŵ����� �����Ͽ����ϴ�.");
				break;
			case 3:
				System.out.println(request.getHrDto().getDepartmentId() + " �μ��� ������ �����Ͽ����ϴ�.");
				break;
			default:
				break;
			}
		}
	}

}
