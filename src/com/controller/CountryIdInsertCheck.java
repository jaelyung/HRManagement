package com.controller;

import java.util.ArrayList;

import com.dao.HrDao;
import com.dto.HrDto;
import com.util.DBConn;
import com.util.Request;
import com.util.Response;

public class CountryIdInsertCheck implements HrExecute {

	static String countryId;
	boolean flag = true;

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

	}

	@Override
	public void logic(Request request, Response response) {
		HrDao dao = new HrDao();
		response.setArrHrDto(dao.selectCountries());
		ArrayList<HrDto> dtos = response.getArrHrDto();
		
		
		while (flag) {
			int count=0;
			countryId = DBConn.inputCountry();
			for (HrDto dto : dtos) {

				if (countryId.equals(dto.getCountryId())) {
					System.out.println("이미 등록된 나라ID 입니다.");
					System.out.println("다시 입력해주세요.");

					count=-1;
					break;
				}

			} if(count!=-1) {
				flag=false;
			}

		}
		
	}

	@Override
	public void outputView(Request request, Response response) {


	}

}