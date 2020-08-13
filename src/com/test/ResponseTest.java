package com.test;

import com.controller.DepartmentsSelect;
import com.controller.HrExecute;
import com.controller.salary.SalDeptSearch;
import com.controller.salary.SalFirstNameSearch;
import com.controller.salary.SalFullNameSearch;
import com.controller.salary.SalJobSearch;
import com.controller.salary.SalLastNameSearch;
import com.util.Request;
import com.util.Response;

public class ResponseTest {

	public static void main(String[] args) {
		int select=4;
		HrExecute he=null;
		
		Request request = new Request();
		Response response = new Response();
		switch(select) {
		case 0:
			he = new SalFullNameSearch();
			break;
		case 1:
			he = new SalFirstNameSearch();
			break;
		case 2:
			he = new SalLastNameSearch();
			break;
		case 3:
			he = new DepartmentsSelect();
			break;
		case 4:
			he = new SalJobSearch();
		default:
			break;
		}
		he.execute(request, response);
	}

}
