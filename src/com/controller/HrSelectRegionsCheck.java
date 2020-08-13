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
					System.out.println("이미 존재하는 ID입니다.");
					System.out.println("다시 입력해주세요.");
					regionId=-1;
					break;
				}
				//System.out.println(employeeId+2);//비교할때는 id 그대로
			}
			//System.out.println(employeeId+1); //for문 탈출 
			if(regionId!=-1) {
				flag = false;
			}
		}
	}
	@Override
	public void outputView(Request request, Response response) {
//		if(response!=null) {
//			ArrayList<HrDto> dtos=response.getArrHrDto();
//			System.out.println("선택 가능한 Region은 다음과 같습니다.");
//			System.out.println("\t[Id]   [RegionName]");
//			for(HrDto dto:dtos) {
//				System.out.println(dto.regionName());
//			}
//			System.out.println("선택할 Region ID입력>>");
//		}else {
//			System.out.println("선택 가능한 Region이 없습니다.");
//		}
//		
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
}
