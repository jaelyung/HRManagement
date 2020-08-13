package com.controller;


import java.util.ArrayList;

import com.dao.HrDao;
import com.dto.HrDto;
import com.util.DBConn;
import com.util.HrException;
import com.util.Request;
import com.util.Response;

public class HrUpdateLoc implements HrExecute {
	HrException hex = new HrException();
	static int inputUpLoc;
	
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
		System.out.println("1.�ּ� 2.�����ȣ 3.���� 4.��(��) 5.���� 6.���  0.�ڷΰ���");
		inputUpLoc = DBConn.inputInt();
		switch (inputUpLoc) {
		case 1:
			System.out.println("����ID�� �Է��ϼ���.");
			HrExecute he=null;
			he=new HrSelectLocations4();
			he.execute(request, response);
			System.out.println("�ּҸ� �Է��ϼ���.");
			String streetAddress = DBConn.inputString();

			dto.setLocationId(HrSelectLocations4.locationId);
			dto.setStreetAddress(streetAddress);
			flag=false;
			break;
		case 2:
			System.out.println("����ID�� �Է��ϼ���.");
			he=null;
			he=new HrSelectLocations4();
			he.execute(request, response);
			System.out.println("�����ȣ�� �Է��ϼ���.");
			String postalCode = DBConn.inputString();

			dto.setLocationId(HrSelectLocations4.locationId);
			dto.setPostalCode(postalCode);
			flag=false;
			break;
		case 3:
			System.out.println("����ID�� �Է��ϼ���.");
			he=null;
			he=new HrSelectLocations4();
			he.execute(request, response);
			String city = "";
			boolean cityFlag = true;
			do {
				try {
					System.out.println("���ø� �Է��ϼ���.");
					city=DBConn.inputString();
					hex.stringFormat(city);
					cityFlag = false;
				}catch(Exception e) {
					System.out.println(e.toString());
				}
			}while(cityFlag);

			dto.setLocationId(HrSelectLocations4.locationId);
			dto.setCity(city);
			flag=false;
			break;
		case 4:
			System.out.println("����ID�� �Է��ϼ���.");
			he=null;
			he=new HrSelectLocations4();
			he.execute(request, response);
			System.out.println("��(��)�� �Է��ϼ���.");
			String stateProvince = DBConn.inputString();

			dto.setLocationId(HrSelectLocations4.locationId);
			dto.setStateProvince(stateProvince);
			flag=false;
			break;
		case 5:
			System.out.println("����(ID)�� �Է��ϼ���.");
			he= new CountryIdCheck();
			he.execute(request, response);
			System.out.println("�̸��� �Է��ϼ���.");
			String countryName = DBConn.inputString();

			dto.setCountryId(CountryIdCheck.countryId);
			dto.setCountryName(countryName);
			flag=false;
			break;
		case 6:
			System.out.println("���(ID)�� �Է��ϼ���.");
			he = new HrSelectRegions2();
			he.execute(request, response);
			System.out.println("�̸��� �Է��ϼ���.");
			String regionName = DBConn.inputString();

			dto.setRegionId(HrSelectRegions2.regionId);
			dto.setRegionName(regionName);
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
		switch(inputUpLoc){
		case 1:
			i = dao.updateLoc(dto.getLocationId(),"street_address", dto.getStreetAddress());
			break;
		case 2:
			i = dao.updateLoc(dto.getLocationId(),"postal_code", dto.getPostalCode());
			break;
		case 3:
			i = dao.updateLoc(dto.getLocationId(),"city", dto.getCity());
			break;
		case 4:
			i = dao.updateLoc(dto.getLocationId(),"state_province", dto.getStateProvince());
			break;
		case 5:
			i = dao.updateCountry(dto.getCountryId(),"country_name", dto.getCountryName());
			break;
		case 6:
			i = dao.updateRegion(dto.getRegionId(),"region_name", dto.getRegionName());
			break;
		default:
			break;
		}
		
		response.setResultValue(i);
		

	}

	@Override
	public void outputView(Request request, Response response) {
		
		if(response.getResultValue()<0) {
			System.out.println("�ش� ����ID �����Ͱ� �������� �ʽ��ϴ�.");
		}else {
			switch (inputUpLoc) {
			case 1:
				System.out.println(request.getHrDto().getLocationId() + " �� �ּҸ� �����Ͽ����ϴ�.");
				break;
			case 2:
				System.out.println(request.getHrDto().getLocationId() + " �� �����ȣ�� �����Ͽ����ϴ�.");
				break;
			case 3:
				System.out.println(request.getHrDto().getLocationId() + " �� ���ø� �����Ͽ����ϴ�.");
				break;
			case 4:
				System.out.println(request.getHrDto().getLocationId() + " �� ��(��)�� �����Ͽ����ϴ�.");
				break;
			case 5:
				System.out.println(request.getHrDto().getCountryId() + " �� �̸��� �����Ͽ����ϴ�.");
				break;
			case 6:
				System.out.println(request.getHrDto().getRegionId() + " �� �̸��� �����Ͽ����ϴ�.");
				break;
			default:
				break;
			}
		}
	}

}
