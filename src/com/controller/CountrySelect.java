package com.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.dao.HrDao;
import com.dto.HrDto;
import com.util.Request;
import com.util.Response;

public class CountrySelect implements HrExecute {
	java.util.Scanner sc=new java.util.Scanner(System.in);
	@Override
	public void execute() {
		HrDto request=new HrDto();
		ArrayList<HrDto> response=new ArrayList<HrDto>();
	
	}

	@Override
	public void execute(Request request,Response response) {
		inputView(request,response);
		logic(request,response);
		outputView(request,response);
	}

	@Override
	public void inputView(Request request,Response response) {
		System.out.println("Country ������ ����մϴ�");
	}

	@Override
	public void logic(Request request,Response response) {
		HrDao dao=new HrDao();
		Scanner sc=new Scanner(System.in);
		System.out.println("�˻��� ���ϴ� ���� �Է��ϼ���(����)");
		System.out.println("____________________________________________________");
		System.out.println("1.Europe 2.Americas 3.Asia 4.Middle East and Africa");
		System.out.println("____________________________________________________");
		String country=sc.nextLine();
		
		
		switch(country) {
		case "1":
			country="Europe";
			break;
		case "2":
			country="Americas";
			break;
		case "3":
			country="Asia";
			break;
		case "4":
			country="Middle East and Africa";
			break;
		default:
			System.out.println("�߸� �Է� �ϼ̽��ϴ�.");
				break;
		}
		
		response.setArrHrDto(dao.countrySelect(country));
		
		
	}

	@Override
	public void outputView(Request request,Response response) {
		
		if(response!=null) {
			ArrayList<HrDto> dtos=
					response.getArrHrDto();
		
			System.out.println("[RegionName]\t    [LocationId]\t[StreetAddress] \t\t\t[PostalCode]\t[City]\t\t[StateProvince]"
					+ "\t\t[CountryId] "
					+ " [CountryName]");
			if(dtos.isEmpty()) {
				System.out.println("�ش��ϴ� �����Ͱ� �������� �ʽ��ϴ�");
				
			}
			for(HrDto dto:dtos) {
				System.out.println(dto.countryToString());
			}
			System.out.println("");
		}else {
			System.out.println("�����Ͱ� �����ϴ�"); //�̹� �ڷᰡ �ִ� �����͸� ���⶧���� �ʿ伺 �� �𸣰���.
											   
		}
		

	}

	

}
