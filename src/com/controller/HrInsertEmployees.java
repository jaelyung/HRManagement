package com.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.dao.HrDao;
import com.dto.HrDto;
import com.util.DBConn;
import com.util.HrException;
import com.util.Request;
import com.util.Response;

public class HrInsertEmployees implements HrExecute {
	HrException hex = new HrException();
	@Override
	public void execute(Request request, Response response) {
		inputView(request, response);
		logic(request, response);
		outputView(request, response);
	}

	@Override
	public void inputView(Request request, Response response) {
		Scanner sc=new Scanner(System.in);
		boolean flag=true;
		
		String date="";
		System.out.println("사원 정보를 입력하세요");
		System.out.println("사원 ID입력");
		HrExecute he=null;
		he = new EmployeesSelectCheck();
		he.execute(request, response);
		
		System.out.println("이름(First_Name) 입력");
		String firstName=DBConn.inputString();
		firstName=firstName.substring(0,1).toUpperCase()+firstName.substring(1).toLowerCase();
		
		System.out.println("성(Last_Name) 입력");
		String lastName=DBConn.inputString();
		lastName=lastName.substring(0,1).toUpperCase()+lastName.substring(1).toLowerCase();
		
		System.out.println("이메일 입력");
		he= new EmailCheck();
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
		  }while(phoneFlag);		do {
			try {
				System.out.println("입사일 입력");
				date=DBConn.inputDate();
				hex.dateCheck(date);
				hex.yearCheck(date);
				hex.monthCheck(date);
				flag=false;
			} catch(Exception e) {
				System.out.println(e.toString());
			}
		}while(flag);
		
//		Date date=DBConn.inputDate();
//		SimpleDateFormat formatter = new SimpleDateFormat ( "yyyy-MM-dd");
//		String dtype=formatter.format(date);
		
//		System.out.println("직무 선택\n1.AD_PRES\n2.AD_VP\n3.AD_ASST\n4.FI_MGR\n5.FI_ACCOUNT\n"
//				+ "6.AC_MGR\n7.AC_ACCOUNT\n8.SA_MAN\n9.SA_REP\n10.PU_MAN\n11.PU_CLERK\n"
//				+ "12.ST_MAN\n13.ST_CLERK\n14.SH_CLERK\n15.IT_PROG\n16.MK_MAN\n17.MK_REP\n"
//				+ "18.HR_REP\n19.PR_REP");
		System.out.println("직무선택");
		he=new JobIdCheck();
		he.execute(request, response);
		
		he = new HrSelectSalaryMtoM();
		he.execute(request, response);
		//String jobId=DBConn.inputString();
		//switch 번호입력시 선택가능
		//select 출력해서 직접 입력시 에러
	
//		String userInput=sc.nextLine();
//		String jobId=selectJobs(userInput);
		//잘못된 입력 했을시 무한반복되는 것 수정
		 
		
//		System.out.println("급여 입력");

		  
		System.out.println("성과급 입력 (20%일 경우 0.2로 입력)");
		double commissionPct=DBConn.inputDouble();
		  
		System.out.println("매니저 ID 입력");
		he=null;
		he=new EmployeeSelectMgn();
		he.execute(request, response);
		
//		int managerId=DBConn.inputInt();
		  
		System.out.println("부서 ID 입력");
		he=null;
		he=new HrSelectDepartments2();
		he.execute(request, response);
		
		
		  
		HrDto dto=new HrDto();
		dto.setEmployeeId(EmployeesSelectCheck.employeeId);
		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setEmail(EmailCheck.email);
		dto.setPhoneNumber(phoneNumber);
		dto.setHireDate(date);
		dto.setJobId(JobIdCheck.jobId);
		dto.setSalary(HrSelectSalaryMtoM.salary);
		dto.setCommissionPct(commissionPct);
		dto.setManagerId(EmployeeSelectMgn.managerId);
		dto.setDepartmentId(HrSelectDepartments2.departmentId);
		request.setHrDto(dto);
	}	
	
//	public String selectJobs(String userInput) {
//		
//		boolean flag=true;
//		String returnValue=null;
//		while(flag) {
//			switch(userInput) {
//			case "1":
//				returnValue="AD_PRES";
//				flag=false;
//				break;
//			case "2":
//				returnValue="AD_VP";
//				flag=false;
//				break;
//			case "3":
//				returnValue="AD_ASST";
//				flag=false;
//				break;
//			case "4":
//				returnValue="FI_MGR";
//				flag=false;
//				break;
//			case "5":
//				returnValue="FI_ACCOUNT";
//				flag=false;
//				break;
//			case "6":
//				returnValue="AC_MGR";
//				flag=false;
//				break;
//			case "7":
//				returnValue="AC_ACCOUNT";
//				flag=false;
//				break;
//			case "8":
//				returnValue="SA_MAN";
//				flag=false;
//				break;
//			case "9":
//				returnValue="SA_REP";
//				flag=false;
//				break;
//			case "10":
//				returnValue="PU_MAN";
//				flag=false;
//				break;
//			case "11":
//				returnValue="PU_CLERK";
//				flag=false;
//				break;
//			case "12":
//				returnValue="ST_MAN";
//				flag=false;
//				break;
//			case "13":
//				returnValue="ST_CLERK";
//				flag=false;
//				break;
//			case "14":
//				returnValue="SH_CLERK";
//				flag=false;
//				break;
//			case "15":
//				returnValue="IT_PROG";
//				flag=false;
//				break;
//			case "16":
//				returnValue="MK_MAN";
//				flag=false;
//				break;
//			case "17":
//				returnValue="MK_REP";
//				flag=false;
//				break;
//			case "18":
//				returnValue="HR_REP";
//				flag=false;
//				break;
//			case "19":
//				returnValue="PR_REP";
//				flag=false;
//				break;
//			default:
//				System.out.println("잘못된 입력입니다.");
//				break;
//			}
//		}
//		return returnValue;
//	}
	@Override
	public void logic(Request request, Response response) {
		HrDto dto=request.getHrDto();
		HrDao dao=new HrDao();
		int i=dao.insertEmployees(dto);
		
		response.setResultValue(i);

	}

	@Override
	public void outputView(Request request, Response response) {
		System.out.println(response.getResultValue()+"개의 데이터를 추가하였습니다.");

	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

}
