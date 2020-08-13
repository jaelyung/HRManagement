package com.util;

//싱글턴으로 디비컨 하나만 만들어서 여럿에서 사용하기
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
		System.out.println("정수 입력>> ");
		while (flag) {
			String input = sc.nextLine();
			if (HrDao.numberOrNot(input)) {
				result = Integer.parseInt(input);
				if (result >= 0) {
					flag = false;
				}
			} else {
				System.out.println("잘못 입력 하셨습니다");
				System.out.println("정확히 입력 해주세요");

			}
		}

		return result;
	}

	public static double inputDouble() {

		boolean flag = true;

		double result = 0;

		System.out.println("실수 입력 >>");

		while (flag) {

			String input = sc.nextLine();

			if (HrDao.doubleOrNot(input)) {

				result = Double.parseDouble(input);

				if (result >= 0) {

					flag = false;

				}

			} else {

				System.out.println("잘못 입력 하셨습니다");

				System.out.println("정확히 입력 해주세요");

			}

		}

		return result;

	}

	public static String inputString() {
		System.out.println("문자 입력 >>");
		return sc.nextLine();
	}

	// 나라 입력값
	public static String inputCountry() {
		String countryId = "";
		boolean flag = true;
		while (flag) {
			String input = sc.nextLine();
			if (input.length() == 2) {
				countryId = input.substring(0, 2).toUpperCase();
				flag = false;
			} else {
				System.out.println("나라ID는 2글자만 입력 가능 합니다.");
			}
		}
		return countryId;
	}

	// 급여 값 입력
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
//				System.out.println("음수는 입력할 수 없습니다.");
//			}
//		}
//		
//		
//		return returnValue; 
//	}

	public static String inputDate() {
		System.out.print("날짜입력(yyyy-mm-dd)>>");

		return sc.nextLine();
	}
//	public static Date inputDate() {//입력받은 문자열을 시간으로 변경
//		Date returnValue=null;
//		SimpleDateFormat transFormat= new SimpleDateFormat("yyyy-MM-dd");
//		
//		System.out.print("날짜입력(yyyy-mm-dd)>>");
//		String inputString=sc.nextLine();
//		
//		try {
//			returnValue=transFormat.parse(inputString);//문자열을 시간객체로 변경
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
				st = dbConn.createStatement(); // 데이터를 주고받을수 있도록 연결
			}
			// 4.resultSet 얻어오기
			// resultSet 실행결과 sql
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
			// 프로그램에서는 오토커밋 자동으로 커밋됨

			resultValue = st.executeUpdate(sql); // 변경된 계수를 리턴
//			if(n==1) { //n은 변경된 개수가 리턴  하나 넣으면 1리턴 2개는 2
//				System.out.println("정상등록");
//			} else {
//				System.out.println("등록안되");
//			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 데이터를 주고받을수 있도록 연결
		finally {
//			DBConn.dbClose();
		}

		return resultValue;
	}

	public static Connection getInstance() {
		if (dbConn == null) {
			try {
				// 1.데이터베이스 등록
				Class.forName("oracle.jdbc.driver.OracleDriver");
				// 2.해당 데이터베이스 접속 url,user,pw
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "hr";
				String pw = "hr";
				dbConn = DriverManager.getConnection(url, user, pw);
//				System.out.println("데이터베이스 접속 성공");

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

	// 닫아주는 메소드
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
