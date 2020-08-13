package com.test;

import com.controller.HrExecute;
import com.controller.HrFindJobResign;
import com.menu.Menu;
import com.util.Request;
import com.util.Response;

public class test {

	public static void main(String[] args) {
		Request request=new Request();
		Response response=new Response();
		HrExecute he = new HrFindJobResign();
		he.execute(request, response);
		Menu menu=new Menu();
		menu.manager();

		//DBConn의 user Id와 Password가 본인 오라클과 일치하는지 확인

//		System.out.println("select * from Employees where first_name like " +"'%s%'");
	

	}

}
