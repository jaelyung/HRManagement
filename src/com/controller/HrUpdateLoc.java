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
		System.out.println("수정할 항목을 입력하세요.");
		System.out.println("1.주소 2.우편번호 3.도시 4.주(도) 5.국가 6.대륙  0.뒤로가기");
		inputUpLoc = DBConn.inputInt();
		switch (inputUpLoc) {
		case 1:
			System.out.println("지점ID를 입력하세요.");
			HrExecute he=null;
			he=new HrSelectLocations4();
			he.execute(request, response);
			System.out.println("주소를 입력하세요.");
			String streetAddress = DBConn.inputString();

			dto.setLocationId(HrSelectLocations4.locationId);
			dto.setStreetAddress(streetAddress);
			flag=false;
			break;
		case 2:
			System.out.println("지점ID를 입력하세요.");
			he=null;
			he=new HrSelectLocations4();
			he.execute(request, response);
			System.out.println("우편번호를 입력하세요.");
			String postalCode = DBConn.inputString();

			dto.setLocationId(HrSelectLocations4.locationId);
			dto.setPostalCode(postalCode);
			flag=false;
			break;
		case 3:
			System.out.println("지점ID를 입력하세요.");
			he=null;
			he=new HrSelectLocations4();
			he.execute(request, response);
			String city = "";
			boolean cityFlag = true;
			do {
				try {
					System.out.println("도시를 입력하세요.");
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
			System.out.println("지점ID를 입력하세요.");
			he=null;
			he=new HrSelectLocations4();
			he.execute(request, response);
			System.out.println("주(도)를 입력하세요.");
			String stateProvince = DBConn.inputString();

			dto.setLocationId(HrSelectLocations4.locationId);
			dto.setStateProvince(stateProvince);
			flag=false;
			break;
		case 5:
			System.out.println("나라(ID)를 입력하세요.");
			he= new CountryIdCheck();
			he.execute(request, response);
			System.out.println("이름을 입력하세요.");
			String countryName = DBConn.inputString();

			dto.setCountryId(CountryIdCheck.countryId);
			dto.setCountryName(countryName);
			flag=false;
			break;
		case 6:
			System.out.println("대륙(ID)를 입력하세요.");
			he = new HrSelectRegions2();
			he.execute(request, response);
			System.out.println("이름을 입력하세요.");
			String regionName = DBConn.inputString();

			dto.setRegionId(HrSelectRegions2.regionId);
			dto.setRegionName(regionName);
			flag=false;
			break;
		case 0:
			flag=false;
			break;
		default:
			System.out.println("잘못 입력 하셨습니다.");
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
			System.out.println("해당 지역ID 데이터가 존재하지 않습니다.");
		}else {
			switch (inputUpLoc) {
			case 1:
				System.out.println(request.getHrDto().getLocationId() + " 의 주소를 변경하였습니다.");
				break;
			case 2:
				System.out.println(request.getHrDto().getLocationId() + " 의 우편번호를 변경하였습니다.");
				break;
			case 3:
				System.out.println(request.getHrDto().getLocationId() + " 의 도시를 변경하였습니다.");
				break;
			case 4:
				System.out.println(request.getHrDto().getLocationId() + " 의 주(도)를 변경하였습니다.");
				break;
			case 5:
				System.out.println(request.getHrDto().getCountryId() + " 의 이름을 변경하였습니다.");
				break;
			case 6:
				System.out.println(request.getHrDto().getRegionId() + " 의 이름을 변경하였습니다.");
				break;
			default:
				break;
			}
		}
	}

}
