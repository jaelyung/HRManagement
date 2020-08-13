package com.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.dao.HrDao;
import com.dto.HrDto;
import com.util.DBConn;
import com.util.Request;
import com.util.Response;

public class HrDeleteLoc implements HrExecute {

	static String inputDelLoc;
	
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
		HrExecute he= null;
		Scanner sc=new Scanner(System.in);
		System.out.println("정보를 삭제할 항목을 선택하세요.");
		System.out.println("________________");
		System.out.println("1.지역 2.국가 3.대륙");
		System.out.println("________________");
		inputDelLoc =sc.nextLine();
		switch (inputDelLoc) {
		case "1":
			System.out.println("지점 ID를 입력하세요.");
			he = new HrSelectLocations4();
			he.execute(request, response);
			dto.setLocationId(HrSelectLocations4.locationId);
			break;
		case "2":
			System.out.println("나라의 ID를 입력하세요.");
			he = new CountryIdCheck();
			he.execute(request, response);
			dto.setCountryId(CountryIdCheck.countryId);
			break;
		case "3":
			System.out.println("대륙의 ID를 입력하세요.");
			he = new HrSelectRegions2();
			he.execute(request, response);
			dto.setRegionId(HrSelectRegions2.regionId);
			break;
		default:
			System.out.println("잘못 입력하였습니다.");
			break;
				
		}
		request.setHrDto(dto);
	}

	@Override
	public void logic(Request request, Response response) {
		
		int i = 0;
		HrDto dto = request.getHrDto();
		HrDao dao = new HrDao();
		
		switch (inputDelLoc) {
		case "1":
			i = dao.deleteLoc(dto.getLocationId());
			break;
		case "2":
			i = dao.deleteCountry(dto.getCountryId());
			break;
		case "3":
			i = dao.deleteRegion(dto.getRegionId());
			break;
		default:
			break;		
		}
		response.setResultValue(i);
	}

	@Override
	public void outputView(Request request, Response response) {

		if (response.getResultValue() <= 0) {
			System.out.println("해당 지역 ID 데이터가 존재하지 않습니다.");
		} else {
			switch (inputDelLoc) {
			case "1":
				System.out.println("해당 지역의 정보를 삭제하였습니다.");
				break;
			case "2":
				System.out.println("해당 국가의 정보를 삭제하였습니다.");
				break;
			case "3":
				System.out.println("해당 대륙의 정보를 삭제하였습니다.");
				break;
			default:
				break;
			}
		}
	}

}
