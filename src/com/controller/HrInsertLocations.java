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
		System.out.println("지점 정보를 입력하세요");
		System.out.println("지점 ID 입력");
		HrExecute he=null;
		he=new LocationIdInCheck();
		he.execute(request, response);
		
		System.out.println("상세주소 입력");
		String streetAddress=DBConn.inputString();
		
		System.out.println("우편번호 입력");
		String postalCode=DBConn.inputString();
		
		System.out.println("도시명 입력");
		String city=DBConn.inputString();
		
		System.out.println("State Province 입력 (없으면 입력X)");
		String stateProvince=DBConn.inputString();
		
		System.out.println("나라 선택");
		
//		he=new HrSelectCountries();
//		he.execute(request, response);
		System.out.println("나라 ID 입력");
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
		System.out.println(response.getResultValue()+"개의 데이터를 추가하였습니다.");
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
}