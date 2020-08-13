package com.util;

import java.util.ArrayList;

import com.dto.HrDto;



public class Response {
	private ArrayList<HrDto> arrHrDto=null;
	private int resultValue=0;
	public ArrayList<HrDto> getArrHrDto() {
		return arrHrDto;
	}
	public void setArrHrDto(ArrayList<HrDto> arrHrDto) {
		this.arrHrDto= arrHrDto;
	}
	public int getResultValue() {
		return resultValue;
	}
	public void setResultValue(int resultValue) {
		this.resultValue = resultValue;
	}
	
}
