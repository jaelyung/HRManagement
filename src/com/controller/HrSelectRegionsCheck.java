package com.controller;

import java.util.ArrayList;

import com.dao.HrDao;
import com.dto.HrDto;
import com.util.DBConn;
import com.util.Request;
import com.util.Response;

public class HrSelectRegionsCheck implements HrExecute{
	public static int regionId;
	@Override
	public void execute(Request request, Response response) {
		inputView(request, response);
		logic(request, response);
		outputView(request, response);
	}

	@Override
	public void inputView(Request request, Response response) {
		
	}	
	
	
	@Override
	public void logic(Request request, Response response) {
		HrDao dao=new HrDao();
		response.setArrHrDto(dao.selectRegions());
		ArrayList<HrDto> dtos=response.getArrHrDto();
		
		boolean flag=true;
		while(flag) {
			regionId = DBConn.inputInt();
			for(HrDto dto:dtos) {
				if(regionId
						==dto.getRegionId()) {
					System.out.println("�̹� �����ϴ� ID�Դϴ�.");
					System.out.println("�ٽ� �Է����ּ���.");
					regionId=-1;
					break;
				}
				//System.out.println(employeeId+2);//���Ҷ��� id �״��
			}
			//System.out.println(employeeId+1); //for�� Ż�� 
			if(regionId!=-1) {
				flag = false;
			}
		}
	}
	@Override
	public void outputView(Request request, Response response) {
//		if(response!=null) {
//			ArrayList<HrDto> dtos=response.getArrHrDto();
//			System.out.println("���� ������ Region�� ������ �����ϴ�.");
//			System.out.println("\t[Id]   [RegionName]");
//			for(HrDto dto:dtos) {
//				System.out.println(dto.regionName());
//			}
//			System.out.println("������ Region ID�Է�>>");
//		}else {
//			System.out.println("���� ������ Region�� �����ϴ�.");
//		}
//		
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
}
