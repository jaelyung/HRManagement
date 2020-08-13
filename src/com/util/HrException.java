package com.util;

import java.util.regex.Pattern;

import com.util.AuthenException;

public class HrException {
	// by 재령 예외처리
	// 날짜 확인
	public void dateCheck(String date)  throws AuthenException{
		
		boolean check = Pattern.matches( //insertEmployees 수정
					"(\\d{4})-(\\d{2})-(\\d{2})", date);
		
		if (!check) 
			throw new AuthenException("※날짜 입력 형식은 [YYYY-MM-DD]입니다");
		
	}
	
	// 연도 확인
	public void yearCheck(String date) throws AuthenException {
		String [] arrDate = date.split("-");
		String arrDate1 = arrDate[0];
		boolean check = Pattern.matches(
				"(\\d{4})", arrDate1);
		int a=Integer.parseInt(arrDate1);
		if(a>=0000&&a<=9999) {
			
		}else {
			throw new AuthenException("※연도를 정확히 입력해주세요.");
		}
		if (!check)
			throw new AuthenException("※연도를 정확히 입력해주세요.");
	}
	
	// 월 확인
	public void monthCheck(String date) throws AuthenException {
		String [] arrDate = date.split("-");
		String arrDate1 = arrDate[1];
		
		boolean check = Pattern.matches(
				"01|02|03|04|05|06|07|08|09|10|11|12", arrDate1);
		
		if (!check)
			throw new AuthenException("※월을 정확히 입력해주세요. 입력 형식은 1월의 경우 [01]입니다.");
	}
	//전화번호 확인
	public static void phoneNumber(String phoneNumber) throws AuthenException{
	   boolean check =Pattern.matches("(\\d{3}).(\\d{3}).(\\d{4})", phoneNumber);
	   if(!check)
		   throw new AuthenException("※전화번호를 정확히 입력해주세요. 입력형식은  000.000.0000 입니다.");
    
	}
	//job_id 문자만 입력
	public void stringFormat(String jobId) throws AuthenException {
		
		int cnt1 = 0;

		for (int i = 0; i < jobId.length(); i++) {
			char ch = jobId.charAt(i);
			if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
				cnt1++;
		}

		if (cnt1 == 0)
			throw new AuthenException("\n영문자를 이용해서 만들어주세요");

	}
	
}
