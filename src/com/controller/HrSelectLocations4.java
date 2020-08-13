package com.controller;

import java.util.ArrayList;

import com.dao.HrDao;
import com.dto.HrDto;
import com.util.DBConn;
import com.util.HrException;
import com.util.Request;
import com.util.Response;

public class HrSelectLocations4 extends HrSelectLocations{
	public static int locationId;	
	public static ArrayList<HrDto> dtos=new ArrayList<HrDto>();
	
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
		response.setArrHrDto(dao.selectLocationId());

	}
	
	@Override
	public void outputView(Request request, Response response) {
		HrExecute he=new HrSelectLocations();
		boolean flag=true;
		int count=0;
		if(response!=null) {
			dtos=response.getArrHrDto();
			
			he.execute(request, response);
			
			while(flag) {
				locationId = DBConn.inputInt();
				for(HrDto dto:dtos) {
					if(locationId
							==dto.getLocationId()) {
						count=0;
						break;
					}else {
						count=-1;
					}
					//System.out.println(employeeId+2);//비교할때는 id 그대로
				}
				//System.out.println(employeeId+1); //for문 탈출 
				if(count==0) {
					flag = false;
				}else {
					System.out.println("보기에 출력된 Id를 입력해주세요.");
				}
			}
		
		}else {
			System.out.println("선택 가능한 Location이 없습니다.");
		}
		
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
}
