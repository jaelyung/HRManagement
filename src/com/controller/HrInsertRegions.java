package com.controller;

import java.util.Scanner;

import com.dao.HrDao;
import com.dto.HrDto;
import com.util.DBConn;
import com.util.Request;
import com.util.Response;

public class HrInsertRegions implements HrExecute{

	@Override
	public void execute(Request request, Response response) {
		inputView(request, response);
		logic(request, response);
		outputView(request, response);
	}
	
	@Override
	public void inputView(Request request, Response response) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Region ������ �Է��ϼ���");
		System.out.println("Region ID �Է�");
		int regionId=DBConn.inputInt();
		
		System.out.println("Region Name �Է�");
		String regionName=DBConn.inputString();
				
		HrDto dto=new HrDto();
		dto.setRegionId(regionId);
		dto.setRegionName(regionName);
		
		request.setHrDto(dto);
	}	
	

	@Override
	public void logic(Request request, Response response) {
		HrDto dto=request.getHrDto();
		HrDao dao=new HrDao();
		int i=dao.insertRegions(dto);
		
		response.setResultValue(i);
	}

	@Override
	public void outputView(Request request, Response response) {
		System.out.println(response.getResultValue()+"���� �����͸� �߰��Ͽ����ϴ�.");
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
}
