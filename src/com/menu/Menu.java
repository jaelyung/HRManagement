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

	// 메인 첫페이지
	public void manager() {
		boolean flag = true;
		Scanner sc = new Scanner(System.in);
		while (flag) {
			System.out.println("휴먼 솔루션 사원관리 프로그램입니다");
			System.out.println("원하는 메뉴를 선택하세요");
			System.out.println("____________________________________________________");
			System.out.println("1.회사정보 2.관리자메뉴   3.개인 조회    0.종료");
			System.out.println("____________________________________________________");
			switch (sc.nextLine()) {
			case "1":
				company();
				break;
			case "2":
				System.out.println("관리자 아이디를 입력하세요");
				String id = sc.nextLine();
				System.out.println("관리자 패스워드를 입력하세요");
				String pw = sc.nextLine();
				if (HrDto.ADMIN_ID.equals(id) && HrDto.ADMIN_PW.equals(pw)) {
					managerChoice();
				} else {
					System.out.println("아이디와 비밀번호가 올바르지 않습니다.");
				}
				break;
			case "3":
				check();
				break;
			case "0":
				flag = false;
				sc.close();
				System.out.println("프로그램을 종료 합니다");
				break;
			default:
				System.out.println("잘못된 입력 입니다.");
				break;

			}

		}
	}

	// 회사 소개
	public void company() {
		boolean flag = true;
		Scanner sc = new Scanner(System.in);
		while (flag) {
			System.out.println("_____________________________________________________");
			System.out.println("1.회사소개   2.회사 비전   3.회사 경영 이념    0.뒤로");
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
				System.out.println("잘못된 입력 입니다.");
				break;

			}

		}
	}

	// 관리자 선택창
	public void managerChoice() {
		Scanner sc = new Scanner(System.in);
		String select;
		boolean flag = true;
		System.out.println("관리자 메뉴입니다");

		while (flag) {
			System.out.println("메뉴를 선택하세요");
			System.out.println("__________________________________________________________________");
			System.out
					.println("1.직원관리 2.부서관리  3.직무관리  4.지점관리   5.급여관리  0.뒤로가기 ");
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
				System.out.println("잘못 입력 하셨습니다.");
				break;
			}
		}

	}

	// 직원 메뉴 선택창
	public void employeesChoice() {
		Scanner sc = new Scanner(System.in);
		String select;
		HrExecute pe = null;
		Response response = new Response();
		Request request = new Request();
		boolean flag = true;
		System.out.println("직원 관리 메뉴 선택창입니다");

		while (flag) {
			System.out.println("직원 관련 원하시는 작업을 선택하세요");
			System.out.println("_______________________________________________________________");
			System.out.println("1.데이터 조회  2.변경사항 수정  3.신규 등록 4.퇴사처리  0.뒤로가기");
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
				System.out.println("잘못된 선택입니다.");
				break;
			}
		}

	}

	// 부서 메뉴 선택창
	public void departmentsChoice() {
		Scanner sc = new Scanner(System.in);
		String select;
		HrExecute pe = null;
		Response response = new Response();
		Request request = new Request();
		boolean flag = true;
		System.out.println("부서 관리 메뉴 선택창입니다");

		while (flag) {
			System.out.println("부서 관련 원하시는 작업을 선택하세요");
			System.out.println("__________________________________________________________________");
			System.out.println("1.데이터 조회  2.변경사항 수정  3.신규 등록 4.데이터 삭제  0.뒤로가기");
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

	// 직무 메뉴 선택창
	public void jobsChoice() {
		Scanner sc = new Scanner(System.in);
		String select;
		HrExecute pe = null;
		boolean flag = true;
		Response response = new Response();
		Request request = new Request();
		System.out.println("직무 관리 메뉴 선택창입니다");

		while (flag) {
			System.out.println("직무 관련 원하시는 작업을 선택하세요");
			System.out.println("__________________________________________________________________");
			System.out.println("1.데이터 조회  2.변경사항 수정  3.신규 등록 4.데이터 삭제  0.뒤로가기 ");
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
				// 직무추가시 employee insert switch문 변경필요 >> 인덱스로 추후 수정하기
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

	// 나라 메뉴 선택창
	public void countryChoice() {
		Scanner sc = new Scanner(System.in);
		String select;
		HrExecute pe = null;
		Response response = new Response();
		Request request = new Request();
		boolean flag = true;
		System.out.println("지점 관리 메뉴 선택창입니다");

		while (flag) {
			System.out.println("원하시는 작업을 선택하세요");
			System.out.println("__________________________________________________________________");
			System.out.println("1.데이터 조회  2.변경사항 수정  3.신규 등록  4.데이터 삭제 0.뒤로가기");
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

	// 조회 메뉴
	public void check() {
		Scanner sc = new Scanner(System.in);
		String select;
		HrExecute pe = null;
		Response response = new Response();
		Request request = new Request();
		boolean flag = true;
		System.out.println("원하시는 조회를 선택하세요");
		while (flag) {
			System.out.println("_________________________________");
			System.out.println("1.사원조회  2.부서조회  3.조직도   0.뒤로가기");
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
				System.out.println("잘못된 입력 입니다.");
				break;

			}
		}

	}

	// 개인조회 선택 메뉴창
	public void personMenu() {
		Scanner sc = new Scanner(System.in);
		String select;
		boolean flag = true;
		Response response = new Response();
		Request request = new Request();
		while (flag) {
			System.out.println("개인 조회 선택 메뉴 입니다");
			System.out.println("________________________________________________________________");
			System.out.println("1.이름 조회  2.이메일 조회  3.전화번호조회   4.직무조회  0.뒤로가기");
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
				System.out.println("잘못된 입력 입니다.");
				break;

			}
		}
	}

	// 부서원 조회 메뉴
	public void deptMenu() {
		Scanner sc = new Scanner(System.in);
		String select;
		HrExecute pe = null;
		Response response = new Response();
		Request request = new Request();
		boolean flag = true;
		while (flag) {
			System.out.println("부서 조회 메뉴입니다");
			System.out.println("_________________________________");
			System.out.println("1.부서명 조회  2.부서ID번호 조회     0.뒤로가기");
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
				System.out.println("잘못된 입력 입니다.");
				break;

			}
		}
	}

	// 이름 조회 메뉴
	public void nameSearch() {
		Scanner sc = new Scanner(System.in);
		String select;
		HrExecute pe = null;
		boolean flag = true;
		Response response = new Response();
		Request request = new Request();
		System.out.println("사원 조회 메뉴입니다");

		while (flag) {
			System.out.println("원하시는 조회를 선택하세요");
			System.out.println("______________________________________________________________________");
			System.out.println("1.FullName조회  2.FirstName 조회  3.LastName 조회   0.뒤로가기");
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

	// 조직도 출력 메소드

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
		System.out.println("조회할 부서를 선택하세요.");
		
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
				System.out.println("목록에 없습니다. 다시 입력해주세요.");
				break;
			}
		}
		System.out.println(request.getHrDto().getDepartmentName() + " 부서의 직원들을 모두 조회하시겠습니까?");
		System.out.println("______________");
		System.out.println("1.네   2.아니요");
		System.out.println("______________");
		String inputOrgSel = DBConn.inputString();
		if (inputOrgSel.equals("1")) {
			pe = new OrgDepartmentsName();
			pe.execute(request, response);
		} else if (inputOrgSel.equals("2")) {
			return;
		}

	}

	// 관리자모드>> 임금관리모드 메뉴
	public void salarySearchMenu() {
		Scanner sc = new Scanner(System.in);
		String select;
		int selectName;
		HrExecute pe = null;
		boolean flag = true;
		Response response = new Response();
		Request request = new Request();

		while (flag) {
			System.out.println("원하는 조회방법을 선택하세요.");
			System.out.println("_____________________________________________________________________________________________________________________");
			System.out.println("1.사원Id 검색  2.사원 이름 검색  3.임금 일괄조회  4.임금 범위조회  5.부서별 임금 조회  6.직무별 임금 조회  0.뒤로가기");
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
					System.out.println("1.FullName조회  2.FirstName 조회  3.LastName 조회  0.뒤로가기");
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
						System.out.println("잘못 입력 하셨습니다.");
						break;

					
				}
				}
				break;
			case "3":
				System.out.println("전체 사원 급여 정보조회");
				pe = new HrSelectSalEmp();
				pe.execute(request, response);
				break;
			case "4":
				System.out.println("급여 범위 선택 조회");
				pe = new SalRangeSearch();
				pe.execute(request, response);
				break;
			case "5":
				System.out.println("부서별 급여 조회");
//				System.out.println("1.부서 일괄 조회  2.부서내 최대 Salary  3.부서내 최소 Salary  4.부서 Salary 평균값");
				pe = new SalDeptSearch();
				pe.execute(request, response);
				break;
			case "6":
				System.out.println("직무별 급여 조회");
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
				System.out.println("잘못 입력 하셨습니다");
				break;
			}
		}

	}
}
