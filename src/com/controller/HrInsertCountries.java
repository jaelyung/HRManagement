package com.controller;

import java.sql.ResultSet;
import java.util.Scanner;

import com.dao.HrDao;
import com.dto.HrDto;
import com.util.AuthenException;
import com.util.DBConn;
import com.util.HrException;
import com.util.Request;
import com.util.Response;

public class HrInsertCountries implements HrExecute {
	static String inputInsert;
	@Override
	public void execute(Request request, Response response) {
		inputView(request, response);
		logic(request, response);
		outputView(request, response);
	}

	@Override
	public void inputView(Request request, Response response) {
		HrDto dto=new HrDto();
		Scanner sc=new Scanner(System.in);
		System.out.println("����� �׸��� �Է��ϼ���.");
		System.out.println("________________________________________");
		System.out.println("1.Country ���  2.Location ���  3.Region ���");
		System.out.println("________________________________________");
		inputInsert = sc.nextLine();
		switch(inputInsert) {
		case "1":
			System.out.println("���� ������ �Է��ϼ���");
			System.out.println("���� ID �Է�");
			HrExecute he=null;
			he=new CountryIdInsertCheck();
			he.execute(request, response);
			
			System.out.println("���� �Է�");
			String temp=DBConn.inputString();
			String countryName=temp.substring(0,1).toUpperCase()+temp.substring(1).toLowerCase();
			System.out.println("Region_Id ����");
			
			he=new HrSelectRegions();
			he.execute(request, response);
			
			int regionId=DBConn.inputInt(); 
			dto.setCountryId(CountryIdInsertCheck.countryId);
			dto.setCountryName(countryName);
			dto.setRegionId(regionId);
			
			break;
		case "2":
			System.out.println("���� ������ �Է��ϼ���");
			System.out.println("���� ID �Է�");
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
			System.out.println("���� ID �Է�");
			he=null;
			he=new CountryIdCheck();
			he.execute(request, response);
					
			dto.setLocationId(LocationIdInCheck.locationId);
			dto.setStreetAddress(streetAddress);
			dto.setPostalCode(postalCode);
			dto.setCity(city);
			dto.setStateProvince(stateProvince);
			dto.setCountryId(CountryIdCheck.countryId);
			
			break;
		case "3":
			System.out.println("Region ������ �Է��ϼ���");
			System.out.println("Region ID �Է�");
			he=null;
			he=new HrSelectRegionsCheck();
			he.execute(request, response);
			
			System.out.println("Region Name �Է�");
			String regionName=DBConn.inputString();
					
			dto.setRegionId(HrSelectRegionsCheck.regionId);
			dto.setRegionName(regionName);
			break;
		
		default:
			System.out.println("�߸��� �Է��Դϴ�.");
			break;
		}
		request.setHrDto(dto);
	}	
	

	@Override
	public void logic(Request request, Response response) {
		HrDto dto=request.getHrDto();
		HrDao dao=new HrDao();
		
		int i=0;
		switch(inputInsert) {
		case "1":
			i=dao.insertCountries(dto);
			break;
		case "2":
			i=dao.insertLocations(dto);
			break;
		case "3":
			i=dao.insertRegions(dto);
			break;
		default:
			System.out.println("�߸��� �Է��Դϴ�.");
			break;
		}
		
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
