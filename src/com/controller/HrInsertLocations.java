package com.controller;

import java.util.Scanner;

import com.dao.HrDao;
import com.dto.HrDto;
import com.util.DBConn;
import com.util.Request;
import com.util.Response;

public class HrInsertLocations implements HrExecute{
	
	@Override
	public void execute(Request request, Response response) {
		inputView(request, response);
		logic(request, response);
		outputView(request, response);
	}

	@Override
	public void inputView(Request request, Response response) {
		Scanner sc=new Scanner(System.in);
		System.out.println("���� ������ �Է��ϼ���");
		System.out.println("���� ID �Է�");
		HrExecute he=null;
		he=new LocationIdInCheck();
		he.execute(request, response);
		
		System.out.println("���ּ� �Է�");
		String streetAddress=DBConn.inputString();
		
		System.out.println("�����ȣ �Է�");
		String postalCode=DBConn.inputString();
		
		System.out.println("���ø� �Է�");
		String city=DBConn.inputString();
		
		System.out.println("State Province �Է� (������ �Է�X)");
		String stateProvince=DBConn.inputString();
		
		System.out.println("���� ����");
		
//		he=new HrSelectCountries();
//		he.execute(request, response);
		System.out.println("���� ID �Է�");
		he=new CountryIdCheck();
		he.execute(request, response);
		String countryId=DBConn.inputCountry();
	
	
		HrDto dto=new HrDto();
		dto.setLocationId(LocationIdInCheck.locationId);
		dto.setStreetAddress(streetAddress);
		dto.setPostalCode(postalCode);
		dto.setCity(city);
		dto.setStateProvince(stateProvince);
		dto.setCountryId(CountryIdCheck.countryId);
		
		request.setHrDto(dto);
	}	
	

	@Override
	public void logic(Request request, Response response) {
		HrDto dto=request.getHrDto();
		HrDao dao=new HrDao();
		int i=dao.insertLocations(dto);
		
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