package com.controller;

import java.util.ArrayList;

import com.dao.HrDao;
import com.dto.HrDto;
import com.util.DBConn;
import com.util.Request;
import com.util.Response;

public class CountryIdCheck implements HrExecute {

	static String countryId;
	static String countryName;
	

	@Override
	public void execute() {
		HrDto request = new HrDto();
		ArrayList<HrDto> response = new ArrayList<HrDto>();

	}

	@Override
	public void execute(Request request, Response response) {
		inputView(request, response);
		logic(request, response);
		outputView(request, response);
	}

	@Override
	public void inputView(Request request, Response response) {
		HrExecute he=null;
		he=new HrSelectCountries();
		he.execute(request, response);
	}

	@Override
	public void logic(Request request, Response response) {
		HrDao dao = new HrDao();
		response.setArrHrDto(dao.selectCountries());
		ArrayList<HrDto> dtos = response.getArrHrDto();
		boolean flag=true;
		while (flag) {
			int count=0;
			countryId = DBConn.inputCountry();
			for (HrDto dto : dtos) {
				if (countryId.equals(dto.getCountryId())) {
					count=0;
					break;
				}else  {
					count=-1;
				}
				// System.out.println(employeeId+2);//비교할때는 id 그대로
			}
			// System.out.println(employeeId+1); //for문 탈출
			if (count==0) {
				flag = false;
			}else {
				System.out.println("보기에 출력된 ID를 입력해주세요.");
			}
		}
	}

	@Override
	public void outputView(Request request, Response response) {


	}

}