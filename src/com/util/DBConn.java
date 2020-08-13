package com.util;

//�̱������� ����� �ϳ��� ���� �������� ����ϱ�
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.dao.HrDao;
import com.dto.HrDto;

public class DBConn {
	// .getInstance()
	// new DBConn();
	private DBConn() {
	};

	private static Connection dbConn = null;
	private static Statement st = null;
	private static ResultSet rs = null;
	private static Scanner sc = new Scanner(System.in);

	public static int inputInt() {
		boolean flag = true;
		int result = 0;
		System.out.println("���� �Է�>> ");
		while (flag) {
			String input = sc.nextLine();
			if (HrDao.numberOrNot(input)) {
				result = Integer.parseInt(input);
				if (result >= 0) {
					flag = false;
				}
			} else {
				System.out.println("�߸� �Է� �ϼ̽��ϴ�");
				System.out.println("��Ȯ�� �Է� ���ּ���");

			}
		}

		return result;
	}

	public static double inputDouble() {

		boolean flag = true;

		double result = 0;

		System.out.println("�Ǽ� �Է� >>");

		while (flag) {

			String input = sc.nextLine();

			if (HrDao.doubleOrNot(input)) {

				result = Double.parseDouble(input);

				if (result >= 0) {

					flag = false;

				}

			} else {

				System.out.println("�߸� �Է� �ϼ̽��ϴ�");

				System.out.println("��Ȯ�� �Է� ���ּ���");

			}

		}

		return result;

	}

	public static String inputString() {
		System.out.println("���� �Է� >>");
		return sc.nextLine();
	}

	// ���� �Է°�
	public static String inputCountry() {
		String countryId = "";
		boolean flag = true;
		while (flag) {
			String input = sc.nextLine();
			if (input.length() == 2) {
				countryId = input.substring(0, 2).toUpperCase();
				flag = false;
			} else {
				System.out.println("����ID�� 2���ڸ� �Է� ���� �մϴ�.");
			}
		}
		return countryId;
	}

	// �޿� �� �Է�
//	public static int inputMinSalary() {
//		ArrayList<HrDto> dtos =new ArrayList<HrDto>();
//		
//		for (HrDto dto : dtos) {
//
//			if (dto.get) {
//				
//			}
//		int returnValue = 0;
//		boolean flag=true;
//		while(flag) {
//			int inputMinSal = DBConn.inputInt();
//			if(inputMinSal>0 && ) {
//				returnValue = inputMinSal;
//				flag=false;
//			}else if(inputMinSal<0){
//				System.out.println("������ �Է��� �� �����ϴ�.");
//			}
//		}
//		
//		
//		return returnValue; 
//	}

	public static String inputDate() {
		System.out.print("��¥�Է�(yyyy-mm-dd)>>");

		return sc.nextLine();
	}
//	public static Date inputDate() {//�Է¹��� ���ڿ��� �ð����� ����
//		Date returnValue=null;
//		SimpleDateFormat transFormat= new SimpleDateFormat("yyyy-MM-dd");
//		
//		System.out.print("��¥�Է�(yyyy-mm-dd)>>");
//		String inputString=sc.nextLine();
//		
//		try {
//			returnValue=transFormat.parse(inputString);//���ڿ��� �ð���ü�� ����
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		return returnValue;
//	}

	public static String dateToString(Date d) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return df.format(d);
	}

	public static ResultSet statementQuery(String sql) {
		try {
			if (st == null) {
				st = dbConn.createStatement(); // �����͸� �ְ������ �ֵ��� ����
			}
			// 4.resultSet ������
			// resultSet ������ sql
			rs = st.executeQuery(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}
		return rs;
	}

	public static int statementUpdate(String sql) {
		int resultValue = 0;

//		DBConn.getInstance();

		try {
			if (st == null) {
				st = dbConn.createStatement();
			}
			// ���α׷������� ����Ŀ�� �ڵ����� Ŀ�Ե�

			resultValue = st.executeUpdate(sql); // ����� ����� ����
//			if(n==1) { //n�� ����� ������ ����  �ϳ� ������ 1���� 2���� 2
//				System.out.println("������");
//			} else {
//				System.out.println("��Ͼȵ�");
//			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // �����͸� �ְ������ �ֵ��� ����
		finally {
//			DBConn.dbClose();
		}

		return resultValue;
	}

	public static Connection getInstance() {
		if (dbConn == null) {
			try {
				// 1.�����ͺ��̽� ���
				Class.forName("oracle.jdbc.driver.OracleDriver");
				// 2.�ش� �����ͺ��̽� ���� url,user,pw
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "hr";
				String pw = "hr";
				dbConn = DriverManager.getConnection(url, user, pw);
//				System.out.println("�����ͺ��̽� ���� ����");

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dbConn;
	}

	// �ݾ��ִ� �޼ҵ�
	public static void dbClose() {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (dbConn != null)
				dbConn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rs = null;
			st = null;
			dbConn = null;
		}
	}

}
