package com.menu;

import java.util.Scanner;

import com.controller.CountrySelect;
import com.controller.DepartmentsName;
import com.controller.DepartmentsNum;
import com.controller.DepartmentsSelect;
import com.controller.EmployeesSelect;
import com.controller.FirstNameSearch;
import com.controller.HrDeleteDept;
import com.controller.HrDeleteEmp;
import com.controller.HrDeleteJob;
import com.controller.HrDeleteLoc;
import com.controller.HrEmailSearch;
import com.controller.HrExecute;
import com.controller.HrInsertCountries;
import com.controller.HrInsertDepartments;
import com.controller.HrInsertEmployees;
import com.controller.HrInsertJobs;
import com.controller.HrInsertLocations;
import com.controller.HrInsertRegions;
import com.controller.HrPhoneSearch;
import com.controller.HrSelectOrgJobs;
import com.controller.HrSelectOrgLoc;
import com.controller.HrSelectOrgMgn;
import com.controller.HrUpdateDept;
import com.controller.HrUpdateEmp;
import com.controller.HrUpdateJob;
import com.controller.HrUpdateLoc;
import com.controller.JobsSelect;
import com.controller.LastNameSearch;
import com.controller.OrgDepartmentsName;
import com.controller.PersonalInquirySelect;
import com.controller.salary.AvgSalJob;
import com.controller.salary.HrJobSearch;
import com.controller.salary.HrSelectSalEmp;
import com.controller.salary.SalDeptSearch;
import com.controller.salary.SalEmpIdSearch;
import com.controller.salary.SalFirstNameSearch;
import com.controller.salary.SalFullNameSearch;
import com.controller.salary.MaxSalJob;
import com.controller.salary.MinSalJob;
import com.controller.salary.SalJobSearch;
import com.controller.salary.SalLastNameSearch;
import com.controller.salary.SalRangeSearch;
import com.dto.Company;
import com.dto.HrDto;
import com.util.DBConn;
import com.util.Request;
import com.util.Response;

public class Menu {

	// ���� ù������
	public void manager() {
		boolean flag = true;
		Scanner sc = new Scanner(System.in);
		while (flag) {
			System.out.println("�޸� �ַ�� ������� ���α׷��Դϴ�");
			System.out.println("���ϴ� �޴��� �����ϼ���");
			System.out.println("____________________________________________________");
			System.out.println("1.ȸ������ 2.�����ڸ޴�   3.���� ��ȸ    0.����");
			System.out.println("____________________________________________________");
			switch (sc.nextLine()) {
			case "1":
				company();
				break;
			case "2":
				System.out.println("������ ���̵� �Է��ϼ���");
				String id = sc.nextLine();
				System.out.println("������ �н����带 �Է��ϼ���");
				String pw = sc.nextLine();
				if (HrDto.ADMIN_ID.equals(id) && HrDto.ADMIN_PW.equals(pw)) {
					managerChoice();
				} else {
					System.out.println("���̵�� ��й�ȣ�� �ùٸ��� �ʽ��ϴ�.");
				}
				break;
			case "3":
				check();
				break;
			case "0":
				flag = false;
				sc.close();
				System.out.println("���α׷��� ���� �մϴ�");
				break;
			default:
				System.out.println("�߸��� �Է� �Դϴ�.");
				break;

			}

		}
	}

	// ȸ�� �Ұ�
	public void company() {
		boolean flag = true;
		Scanner sc = new Scanner(System.in);
		while (flag) {
			System.out.println("_____________________________________________________");
			System.out.println("1.ȸ��Ұ�   2.ȸ�� ����   3.ȸ�� �濵 �̳�    0.�ڷ�");
			System.out.println("_____________________________________________________");
			switch (sc.nextLine()) {
			case "1":
				Company.companyInfo();
				break;
			case "2":
				Company.companyVision();
				break;
			case "3":
				Company.companyideology();
				break;
			case "0":
				flag = false;

				break;
			default:
				System.out.println("�߸��� �Է� �Դϴ�.");
				break;

			}

		}
	}

	// ������ ����â
	public void managerChoice() {
		Scanner sc = new Scanner(System.in);
		String select;
		boolean flag = true;
		System.out.println("������ �޴��Դϴ�");

		while (flag) {
			System.out.println("�޴��� �����ϼ���");
			System.out.println("__________________________________________________________________");
			System.out
					.println("1.�������� 2.�μ�����  3.��������  4.��������   5.�޿�����  0.�ڷΰ��� ");
			System.out.println("__________________________________________________________________");
			select = sc.nextLine();
			switch (select) {
			case "1":
				employeesChoice();
				break;
			case "2":
				departmentsChoice();
				break;
			case "3":
				jobsChoice();
				break;
			case "4":
				countryChoice();
				break;
			case "5":
				salarySearchMenu();
				break;
			case "0":
				flag = false;
				break;
			default:
				System.out.println("�߸� �Է� �ϼ̽��ϴ�.");
				break;
			}
		}

	}

	// ���� �޴� ����â
	public void employeesChoice() {
		Scanner sc = new Scanner(System.in);
		String select;
		HrExecute pe = null;
		Response response = new Response();
		Request request = new Request();
		boolean flag = true;
		System.out.println("���� ���� �޴� ����â�Դϴ�");

		while (flag) {
			System.out.println("���� ���� ���Ͻô� �۾��� �����ϼ���");
			System.out.println("_______________________________________________________________");
			System.out.println("1.������ ��ȸ  2.������� ����  3.�ű� ��� 4.���ó��  0.�ڷΰ���");
			System.out.println("_______________________________________________________________");
			select = sc.nextLine();
			switch (select) {
			case "1":
				pe = new EmployeesSelect();
				pe.execute(request, response);
				break;
			case "2":
				pe = new HrUpdateEmp();
				pe.execute(request, response);
				break;
			case "3":
				pe = new HrInsertEmployees();
				pe.execute(request, response);
				break;
			case "4":
				pe = new HrDeleteEmp();
				pe.execute(request, response);
				break;

			case "0":
				flag = false;
				break;
			default:
				System.out.println("�߸��� �����Դϴ�.");
				break;
			}
		}

	}

	// �μ� �޴� ����â
	public void departmentsChoice() {
		Scanner sc = new Scanner(System.in);
		String select;
		HrExecute pe = null;
		Response response = new Response();
		Request request = new Request();
		boolean flag = true;
		System.out.println("�μ� ���� �޴� ����â�Դϴ�");

		while (flag) {
			System.out.println("�μ� ���� ���Ͻô� �۾��� �����ϼ���");
			System.out.println("__________________________________________________________________");
			System.out.println("1.������ ��ȸ  2.������� ����  3.�ű� ��� 4.������ ����  0.�ڷΰ���");
			System.out.println("__________________________________________________________________");
			select = sc.nextLine();
			switch (select) {
			case "1":
				pe = new DepartmentsSelect();
				pe.execute(request, response);
				break;
			case "2":
				pe = new HrUpdateDept();
				pe.execute(request, response);
				break;
			case "3":
				pe = new HrInsertDepartments();
				pe.execute(request, response);
				break;
			case "4":
				pe = new HrDeleteDept();
				pe.execute(request, response);
				break;
			case "0":
				flag = false;
				break;
			default:
				break;
			}
		}

	}

	// ���� �޴� ����â
	public void jobsChoice() {
		Scanner sc = new Scanner(System.in);
		String select;
		HrExecute pe = null;
		boolean flag = true;
		Response response = new Response();
		Request request = new Request();
		System.out.println("���� ���� �޴� ����â�Դϴ�");

		while (flag) {
			System.out.println("���� ���� ���Ͻô� �۾��� �����ϼ���");
			System.out.println("__________________________________________________________________");
			System.out.println("1.������ ��ȸ  2.������� ����  3.�ű� ��� 4.������ ����  0.�ڷΰ��� ");
			System.out.println("__________________________________________________________________");
			select = sc.nextLine();
			switch (select) {
			case "1":
				pe = new JobsSelect();
				pe.execute(request, response);
				break;
			case "2":
				pe = new HrUpdateJob();
				pe.execute(request, response);
				break;
			case "3":
				pe = new HrInsertJobs();
				pe.execute(request, response);
				// �����߰��� employee insert switch�� �����ʿ� >> �ε����� ���� �����ϱ�
				break;
			case "4":
				pe = new HrDeleteJob();
				pe.execute(request, response);
				break;
			case "0":
				flag = false;
				break;
			default:
				break;
			}
		}
	}

	// ���� �޴� ����â
	public void countryChoice() {
		Scanner sc = new Scanner(System.in);
		String select;
		HrExecute pe = null;
		Response response = new Response();
		Request request = new Request();
		boolean flag = true;
		System.out.println("���� ���� �޴� ����â�Դϴ�");

		while (flag) {
			System.out.println("���Ͻô� �۾��� �����ϼ���");
			System.out.println("__________________________________________________________________");
			System.out.println("1.������ ��ȸ  2.������� ����  3.�ű� ���  4.������ ���� 0.�ڷΰ���");
			System.out.println("__________________________________________________________________");
			select = sc.nextLine();
			switch (select) {
			case "1":
				pe = new CountrySelect();
				pe.execute(request, response);
				break;
			case "2":
				pe = new HrUpdateLoc();
				pe.execute(request, response);
				break;
			case "3":
				pe = new HrInsertCountries();
				pe.execute(request, response);
				break;
			case "4":
				pe = new HrDeleteLoc();
				pe.execute(request, response);
				break;
			case "0":
				flag = false;
			default:
				break;
			}
		}
	}

	// ��ȸ �޴�
	public void check() {
		Scanner sc = new Scanner(System.in);
		String select;
		HrExecute pe = null;
		Response response = new Response();
		Request request = new Request();
		boolean flag = true;
		System.out.println("���Ͻô� ��ȸ�� �����ϼ���");
		while (flag) {
			System.out.println("_________________________________");
			System.out.println("1.�����ȸ  2.�μ���ȸ  3.������   0.�ڷΰ���");
			System.out.println("_________________________________");
			select = sc.nextLine();
			switch (select) {
			case "1":
				personMenu();
				break;
			case "2":
				deptMenu();
				break;
			case "3":
				showOrgTable();
				break;
			case "0":
				flag = false;
				break;
			default:
				System.out.println("�߸��� �Է� �Դϴ�.");
				break;

			}
		}

	}

	// ������ȸ ���� �޴�â
	public void personMenu() {
		Scanner sc = new Scanner(System.in);
		String select;
		boolean flag = true;
		Response response = new Response();
		Request request = new Request();
		while (flag) {
			System.out.println("���� ��ȸ ���� �޴� �Դϴ�");
			System.out.println("________________________________________________________________");
			System.out.println("1.�̸� ��ȸ  2.�̸��� ��ȸ  3.��ȭ��ȣ��ȸ   4.������ȸ  0.�ڷΰ���");
			System.out.println("________________________________________________________________");
			select = sc.nextLine();
			switch (select) {
			case "1":
				nameSearch();
				break;
			case "2":
				HrExecute pe = new HrEmailSearch();
				pe.execute(request, response);
				break;
			case "3":
				pe = new HrPhoneSearch();
				pe.execute(request, response);
				break;
			case "4":
				pe = new HrJobSearch();
				pe.execute(request, response);
				break;
			case "0":
				flag = false;
				break;
			default:
				System.out.println("�߸��� �Է� �Դϴ�.");
				break;

			}
		}
	}

	// �μ��� ��ȸ �޴�
	public void deptMenu() {
		Scanner sc = new Scanner(System.in);
		String select;
		HrExecute pe = null;
		Response response = new Response();
		Request request = new Request();
		boolean flag = true;
		while (flag) {
			System.out.println("�μ� ��ȸ �޴��Դϴ�");
			System.out.println("_________________________________");
			System.out.println("1.�μ��� ��ȸ  2.�μ�ID��ȣ ��ȸ     0.�ڷΰ���");
			System.out.println("_________________________________");
			select = sc.nextLine();
			switch (select) {
			case "1":
				pe = new DepartmentsName();
				pe.execute(request, response);
				break;
			case "2":
				pe = new DepartmentsNum();
				pe.execute(request, response);
				break;
			case "0":
				flag = false;
				break;
			default:
				System.out.println("�߸��� �Է� �Դϴ�.");
				break;

			}
		}
	}

	// �̸� ��ȸ �޴�
	public void nameSearch() {
		Scanner sc = new Scanner(System.in);
		String select;
		HrExecute pe = null;
		boolean flag = true;
		Response response = new Response();
		Request request = new Request();
		System.out.println("��� ��ȸ �޴��Դϴ�");

		while (flag) {
			System.out.println("���Ͻô� ��ȸ�� �����ϼ���");
			System.out.println("______________________________________________________________________");
			System.out.println("1.FullName��ȸ  2.FirstName ��ȸ  3.LastName ��ȸ   0.�ڷΰ���");
			System.out.println("______________________________________________________________________");
			select = sc.nextLine();
			switch (select) {
			case "1":
				pe = new PersonalInquirySelect();
				pe.execute(request, response);
				break;
			case "2":
				pe = new FirstNameSearch();
				pe.execute(request, response);
				break;
			case "3":
				pe = new LastNameSearch();
				pe.execute(request, response);
				break;
			case "0":
				flag = false;
				break;
			}
		}
	}

	// ������ ��� �޼ҵ�

	public void showOrgTable() {
		int inputOrg = 0;

		HrExecute pe = null;
		Response response = new Response();
		Request request = new Request();
		HrDto dto = new HrDto();
		System.out.println("________________");
		System.out.println(
				"1.Accounting\n2.Administration\n3.Executive\n" + "4.Finance\n5.Human Resources\n6.IT\n7.Marketing\n"
						+ "8.Public Relations\n9.Purchasing\n10.Sales\n11.Shipping");
		System.out.println("________________");
		System.out.println("��ȸ�� �μ��� �����ϼ���.");
		
		boolean flag = true;
		while(flag) {
			inputOrg = DBConn.inputInt();
			switch (inputOrg) {
			case 1:
				dto.setDepartmentName("Accounting");
				request.setHrDto(dto);
				System.out.println();
				System.out.println("***** Accounting *****");
				System.out.println();
				pe = new HrSelectOrgLoc();
				pe.execute(request, response);
				pe = new HrSelectOrgMgn();
				pe.execute(request, response);
				pe = new HrSelectOrgJobs();
				pe.execute(request, response);
				flag = false;
				break;
			case 2:
				dto.setDepartmentName("Administration");
				request.setHrDto(dto);
				System.out.println();
				System.out.println("***** Administration *****");
				System.out.println();
				pe = new HrSelectOrgLoc();
				pe.execute(request, response);
				pe = new HrSelectOrgMgn();
				pe.execute(request, response);
				pe = new HrSelectOrgJobs();
				pe.execute(request, response);
				flag = false;
				break;
			case 3:
				dto.setDepartmentName("Executive");
				request.setHrDto(dto);
				System.out.println();
				System.out.println("***** Executive *****");
				System.out.println();
				pe = new HrSelectOrgLoc();
				pe.execute(request, response);
				pe = new HrSelectOrgMgn();
				pe.execute(request, response);
				pe = new HrSelectOrgJobs();
				pe.execute(request, response);
				flag = false;
				break;
			case 4:
				dto.setDepartmentName("Finance");
				request.setHrDto(dto);
				System.out.println();
				System.out.println("***** Finance *****");
				System.out.println();
				pe = new HrSelectOrgLoc();
				pe.execute(request, response);
				pe = new HrSelectOrgMgn();
				pe.execute(request, response);
				pe = new HrSelectOrgJobs();
				pe.execute(request, response);
				flag = false;
				break;
			case 5:
				dto.setDepartmentName("Human Resources");
				request.setHrDto(dto);
				System.out.println();
				System.out.println("***** Human Resources *****");
				System.out.println();
				pe = new HrSelectOrgLoc();
				pe.execute(request, response);
				pe = new HrSelectOrgMgn();
				pe.execute(request, response);
				pe = new HrSelectOrgJobs();
				pe.execute(request, response);
				flag = false;
				break;
			case 6:
				dto.setDepartmentName("IT");
				request.setHrDto(dto);
				System.out.println();
				System.out.println("***** IT *****");
				System.out.println();
				pe = new HrSelectOrgLoc();
				pe.execute(request, response);
				pe = new HrSelectOrgMgn();
				pe.execute(request, response);
				pe = new HrSelectOrgJobs();
				pe.execute(request, response);
				flag = false;
				break;
			case 7:
				dto.setDepartmentName("Marketing");
				request.setHrDto(dto);
				System.out.println();
				System.out.println("***** Marketing *****");
				System.out.println();
				pe = new HrSelectOrgLoc();
				pe.execute(request, response);
				pe = new HrSelectOrgMgn();
				pe.execute(request, response);
				pe = new HrSelectOrgJobs();
				pe.execute(request, response);
				flag = false;
				break;
			case 8:
				dto.setDepartmentName("Public Relations");
				request.setHrDto(dto);
				System.out.println();
				System.out.println("***** Public Relations *****");
				System.out.println();
				pe = new HrSelectOrgLoc();
				pe.execute(request, response);
				pe = new HrSelectOrgMgn();
				pe.execute(request, response);
				pe = new HrSelectOrgJobs();
				pe.execute(request, response);
				flag = false;
				break;
			case 9:
				dto.setDepartmentName("Purchasing");
				request.setHrDto(dto);
				System.out.println();
				System.out.println("***** Purchasing *****");
				System.out.println();
				pe = new HrSelectOrgLoc();
				pe.execute(request, response);
				pe = new HrSelectOrgMgn();
				pe.execute(request, response);
				pe = new HrSelectOrgJobs();
				pe.execute(request, response);
				flag = false;
				break;
			case 10:
				dto.setDepartmentName("Sales");
				request.setHrDto(dto);
				System.out.println();
				System.out.println("***** Sales *****");
				System.out.println();
				pe = new HrSelectOrgLoc();
				pe.execute(request, response);
				pe = new HrSelectOrgMgn();
				pe.execute(request, response);
				pe = new HrSelectOrgJobs();
				pe.execute(request, response);
				flag = false;
				break;
			case 11:
				dto.setDepartmentName("Shipping");
				request.setHrDto(dto);
				System.out.println();
				System.out.println("***** Shipping *****");
				System.out.println();
				pe = new HrSelectOrgLoc();
				pe.execute(request, response);
				pe = new HrSelectOrgMgn();
				pe.execute(request, response);
				pe = new HrSelectOrgJobs();
				pe.execute(request, response);
				flag = false;
				break;
			default:
				System.out.println("��Ͽ� �����ϴ�. �ٽ� �Է����ּ���.");
				break;
			}
		}
		System.out.println(request.getHrDto().getDepartmentName() + " �μ��� �������� ��� ��ȸ�Ͻðڽ��ϱ�?");
		System.out.println("______________");
		System.out.println("1.��   2.�ƴϿ�");
		System.out.println("______________");
		String inputOrgSel = DBConn.inputString();
		if (inputOrgSel.equals("1")) {
			pe = new OrgDepartmentsName();
			pe.execute(request, response);
		} else if (inputOrgSel.equals("2")) {
			return;
		}

	}

	// �����ڸ��>> �ӱݰ������ �޴�
	public void salarySearchMenu() {
		Scanner sc = new Scanner(System.in);
		String select;
		int selectName;
		HrExecute pe = null;
		boolean flag = true;
		Response response = new Response();
		Request request = new Request();

		while (flag) {
			System.out.println("���ϴ� ��ȸ����� �����ϼ���.");
			System.out.println("_____________________________________________________________________________________________________________________");
			System.out.println("1.���Id �˻�  2.��� �̸� �˻�  3.�ӱ� �ϰ���ȸ  4.�ӱ� ������ȸ  5.�μ��� �ӱ� ��ȸ  6.������ �ӱ� ��ȸ  0.�ڷΰ���");
			System.out.println("_____________________________________________________________________________________________________________________");
			select = sc.nextLine();
			switch (select) {

			case "1":
				pe = new SalEmpIdSearch();
				pe.execute(request, response);
				break;
			case "2":
				boolean flag2 = true;
				while (flag2) {
					System.out.println("______________________________________________________________________");
					System.out.println("1.FullName��ȸ  2.FirstName ��ȸ  3.LastName ��ȸ  0.�ڷΰ���");
					System.out.println("______________________________________________________________________");
					selectName = DBConn.inputInt();
					switch(selectName) {
					case 1: 
						pe = new SalFullNameSearch();
						pe.execute(request, response);
						flag2 = false;
						break;
					case 2: 
						pe = new SalFirstNameSearch();
						pe.execute(request, response);
						flag2 = false;
						break;
					case 3: 
						pe = new SalLastNameSearch();
						pe.execute(request, response);
						flag2 = false;
						break;
					case 0:
						flag2=false;
						break;
					default:
						System.out.println("�߸� �Է� �ϼ̽��ϴ�.");
						break;

					
				}
				}
				break;
			case "3":
				System.out.println("��ü ��� �޿� ������ȸ");
				pe = new HrSelectSalEmp();
				pe.execute(request, response);
				break;
			case "4":
				System.out.println("�޿� ���� ���� ��ȸ");
				pe = new SalRangeSearch();
				pe.execute(request, response);
				break;
			case "5":
				System.out.println("�μ��� �޿� ��ȸ");
//				System.out.println("1.�μ� �ϰ� ��ȸ  2.�μ��� �ִ� Salary  3.�μ��� �ּ� Salary  4.�μ� Salary ��հ�");
				pe = new SalDeptSearch();
				pe.execute(request, response);
				break;
			case "6":
				System.out.println("������ �޿� ��ȸ");
				pe = new SalJobSearch();
				pe.execute(request, response);
				pe = new MaxSalJob();
				pe.execute(request, response);
				pe = new MinSalJob();
				pe.execute(request, response);
//				pe = new AvgSalJob();
//				pe.execute(request, response);
				break;
			case "0":
				flag = false;
				break;
			default:
				System.out.println("�߸� �Է� �ϼ̽��ϴ�");
				break;
			}
		}

	}
}
