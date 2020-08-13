package com.controller;

import java.util.ArrayList;

import com.dao.HrDao;
import com.dto.HrDto;
import com.util.DBConn;
import com.util.Request;
import com.util.Response;

public class HrSelectRegions2 implements HrExecute{
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

	}
	@Override
	public void outputView(Request request, Response response) {
		HrExecute he=new HrSelectRegions();
		boolean flag=true;
		int count=0;
		
		if(response!=null) {
			ArrayList<HrDto> dtos=response.getArrHrDto();
			he.execute(request, response);
			while(flag) {
				regionId = DBConn.inputInt();
				for(HrDto dto:dtos) {
					if(regionId
							==dto.getRegionId()) {
						count=0;
						break;
					}else {
						count=-1;
					}
				}
				if(count==0) {
					flag = false;
				}else {
					System.out.println("보기에 출력된 Id를 입력해주세요.");
				}
			}
		}else {
			System.out.println("선택 가능한 Region이 없습니다.");
		}
		
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
}
