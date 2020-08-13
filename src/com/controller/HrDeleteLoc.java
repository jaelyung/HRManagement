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
		System.out.println("������ ������ �׸��� �����ϼ���.");
		System.out.println("________________");
		System.out.println("1.���� 2.���� 3.���");
		System.out.println("________________");
		inputDelLoc =sc.nextLine();
		switch (inputDelLoc) {
		case "1":
			System.out.println("���� ID�� �Է��ϼ���.");
			he = new HrSelectLocations4();
			he.execute(request, response);
			dto.setLocationId(HrSelectLocations4.locationId);
			break;
		case "2":
			System.out.println("������ ID�� �Է��ϼ���.");
			he = new CountryIdCheck();
			he.execute(request, response);
			dto.setCountryId(CountryIdCheck.countryId);
			break;
		case "3":
			System.out.println("����� ID�� �Է��ϼ���.");
			he = new HrSelectRegions2();
			he.execute(request, response);
			dto.setRegionId(HrSelectRegions2.regionId);
			break;
		default:
			System.out.println("�߸� �Է��Ͽ����ϴ�.");
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
			System.out.println("�ش� ���� ID �����Ͱ� �������� �ʽ��ϴ�.");
		} else {
			switch (inputDelLoc) {
			case "1":
				System.out.println("�ش� ������ ������ �����Ͽ����ϴ�.");
				break;
			case "2":
				System.out.println("�ش� ������ ������ �����Ͽ����ϴ�.");
				break;
			case "3":
				System.out.println("�ش� ����� ������ �����Ͽ����ϴ�.");
				break;
			default:
				break;
			}
		}
	}

}
