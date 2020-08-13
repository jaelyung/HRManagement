package com.util;

import java.util.regex.Pattern;

import com.util.AuthenException;

public class HrException {
	// by ��� ����ó��
	// ��¥ Ȯ��
	public void dateCheck(String date)  throws AuthenException{
		
		boolean check = Pattern.matches( //insertEmployees ����
					"(\\d{4})-(\\d{2})-(\\d{2})", date);
		
		if (!check) 
			throw new AuthenException("�س�¥ �Է� ������ [YYYY-MM-DD]�Դϴ�");
		
	}
	
	// ���� Ȯ��
	public void yearCheck(String date) throws AuthenException {
		String [] arrDate = date.split("-");
		String arrDate1 = arrDate[0];
		boolean check = Pattern.matches(
				"(\\d{4})", arrDate1);
		int a=Integer.parseInt(arrDate1);
		if(a>=0000&&a<=9999) {
			
		}else {
			throw new AuthenException("�ؿ����� ��Ȯ�� �Է����ּ���.");
		}
		if (!check)
			throw new AuthenException("�ؿ����� ��Ȯ�� �Է����ּ���.");
	}
	
	// �� Ȯ��
	public void monthCheck(String date) throws AuthenException {
		String [] arrDate = date.split("-");
		String arrDate1 = arrDate[1];
		
		boolean check = Pattern.matches(
				"01|02|03|04|05|06|07|08|09|10|11|12", arrDate1);
		
		if (!check)
			throw new AuthenException("�ؿ��� ��Ȯ�� �Է����ּ���. �Է� ������ 1���� ��� [01]�Դϴ�.");
	}
	//��ȭ��ȣ Ȯ��
	public static void phoneNumber(String phoneNumber) throws AuthenException{
	   boolean check =Pattern.matches("(\\d{3}).(\\d{3}).(\\d{4})", phoneNumber);
	   if(!check)
		   throw new AuthenException("����ȭ��ȣ�� ��Ȯ�� �Է����ּ���. �Է�������  000.000.0000 �Դϴ�.");
    
	}
	//job_id ���ڸ� �Է�
	public void stringFormat(String jobId) throws AuthenException {
		
		int cnt1 = 0;

		for (int i = 0; i < jobId.length(); i++) {
			char ch = jobId.charAt(i);
			if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
				cnt1++;
		}

		if (cnt1 == 0)
			throw new AuthenException("\n�����ڸ� �̿��ؼ� ������ּ���");

	}
	
}
