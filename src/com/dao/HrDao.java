package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.controller.CountrySelect;
import com.controller.DepartmentsSelect;
import com.controller.EmployeesSelect;
import com.controller.HrExecute;
import com.controller.JobsSelect;
import com.controller.PersonalInquirySelect;
import com.dto.HrDto;
import com.util.DBConn;
import com.util.Request;
import com.util.Response;

public class HrDao {

	// 인트를 문자로 입력했을�� 예외처리할 메소드

	public static boolean numberOrNot(String input) {

		int result;

		try {
			if (Integer.parseInt(input) < 0) {
				System.out.println("양수를 입력 해주세요");
			}
		}
		catch (NumberFormatException ex){
			return false;
		}
		return true;
	}

	// 더블을 문자로 입력했을�� 예외처리할 메소드
	public static boolean doubleOrNot(String input) {
		double result;
		try {
			if (Double.parseDouble(input) < 0) {
				System.out.println("양수를 입력 해주세요");
			}
		} catch (NumberFormatException ex) {
			return false;
		}
		return true;
	}

	// EMPLOYEES 조회(직원)
	public ArrayList<HrDto> employeesSelect() {
		ArrayList<HrDto> dtos = new ArrayList<HrDto>();
		DBConn.getInstance();
		String sql = "select employee_id, first_name, last_name, email, phone_number, "
				+ "to_char(hire_date,'YYYY-MM-DD'), job_id, salary, commission_pct from Employees";
		ResultSet rs = DBConn.statementQuery(sql);

		try {
			while (rs.next()) {
				HrDto dto = new HrDto();

				dto.setEmployeeId(rs.getInt(1));
				dto.setFirstName(rs.getString(2));
				dto.setLastName(rs.getString(3));
				dto.setEmail(rs.getString(4));
				dto.setPhoneNumber(rs.getString(5));
				dto.setHireDate(rs.getString(6));
				dto.setJobId(rs.getString(7));
				dto.setSalary(rs.getInt(8));
				dto.setCommissionPct(rs.getDouble(9));

				dtos.add(dto);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;
	}

	// DEPARTMENTS 조회(부서)
	public ArrayList<HrDto> departmentsSelect() {
		ArrayList<HrDto> dtos = new ArrayList<HrDto>();
		DBConn.getInstance();
		String sql = "select d.department_id, d.department_name, d.manager_id, d.location_id, l.street_address,"
				+ "l.postal_code, l.country_id from departments d left join locations l "
				+ "on d.location_id=l.location_id order by d.department_id";
		ResultSet rs = DBConn.statementQuery(sql);

		try {
			while (rs.next()) {
				HrDto dto = new HrDto();

				dto.setDepartmentId(rs.getInt(1));
				dto.setDepartmentName(rs.getString(2));
				dto.setManagerId(rs.getInt(3));
				dto.setLocationId(rs.getInt(4));
				dto.setStreetAddress(rs.getString("street_address"));
				dto.setPostalCode(rs.getString("postal_code"));
				dto.setCountryId(rs.getString("country_id"));

				dtos.add(dto);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;
	}

	// departmentName 조회(개인조회 부서)
	public ArrayList<HrDto> departmentName(String deptName) {
		ArrayList<HrDto> dtos = new ArrayList<HrDto>();
		DBConn.getInstance();
		String sql = "select b.department_id,b.department_name,a.employee_id,a.first_name,a.last_name,a.email,a.phone_number,\r\n"
				+ "        a.job_id,a.manager_id\r\n"
				+ "from employees a, departments b where a.DEPARTMENT_ID=b.department_id\r\n"
				+ "and b.department_name like '" + deptName + "%'";
		ResultSet rs = DBConn.statementQuery(sql);

		try {
			while (rs.next()) {
				HrDto dto = new HrDto();

				dto.setDepartmentId(rs.getInt(1));
				dto.setDepartmentName(rs.getString(2));
				dto.setEmployeeId(rs.getInt(3));
				dto.setFirstName(rs.getString(4));
				dto.setLastName(rs.getString(5));
				dto.setEmail(rs.getString(6));
				dto.setPhoneNumber(rs.getString(7));
				dto.setJobId(rs.getString(8));
				dto.setManagerId(rs.getInt(9));
				dtos.add(dto);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;
	}

	// departmentNum 조회(개인조회 부서)
	public ArrayList<HrDto> departmentNum(int deptNum) {
		ArrayList<HrDto> dtos = new ArrayList<HrDto>();
		DBConn.getInstance();
		String sql = "select b.department_id,b.department_name,a.employee_id,a.first_name,a.last_name,a.email,a.phone_number,\r\n"
				+ "        a.job_id,a.manager_id\r\n"
				+ "from employees a, departments b where a.DEPARTMENT_ID=b.department_id\r\n" + "and b.department_id ="
				+ deptNum;
		sql = String.format(sql);
		ResultSet rs = DBConn.statementQuery(sql);

		try {
			while (rs.next()) {
				HrDto dto = new HrDto();
				dto.setDepartmentId(rs.getInt(1));
				dto.setDepartmentName(rs.getString(2));
				dto.setEmployeeId(rs.getInt(3));
				dto.setFirstName(rs.getString(4));
				dto.setLastName(rs.getString(5));
				dto.setEmail(rs.getString(6));
				dto.setPhoneNumber(rs.getString(7));
				dto.setJobId(rs.getString(8));
				dto.setManagerId(rs.getInt(9));
				dtos.add(dto);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;
	}

	// JOBS 조회(직무)
	public ArrayList<HrDto> jobsSelect() {
		ArrayList<HrDto> dtos = new ArrayList<HrDto>();
		DBConn.getInstance();
		String sql = "select * from jobs";
		ResultSet rs = DBConn.statementQuery(sql);

		try {
			while (rs.next()) {
				HrDto dto = new HrDto();

				dto.setJobId(rs.getString(1));
				dto.setJobTitle(rs.getString(2));
				dto.setMinSalary(rs.getInt(3));
				dto.setMaxSalary(rs.getInt(4));
				dtos.add(dto);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;
	}

	// 매개변수 받아서 해당 직무의 급여정보 출력
	public ArrayList<HrDto> jobsSelect(String jobId) {
		ArrayList<HrDto> dtos = new ArrayList<HrDto>();
		DBConn.getInstance();
		String sql = "select * from jobs where job_id like '" + jobId + "'";
		ResultSet rs = DBConn.statementQuery(sql);

		try {
			while (rs.next()) {
				HrDto dto = new HrDto();

				dto.setJobId(rs.getString(1));
				dto.setJobTitle(rs.getString(2));
				dto.setMinSalary(rs.getInt(3));
				dto.setMaxSalary(rs.getInt(4));
				dtos.add(dto);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;
	}

	// Country조회(지역정보)
	public ArrayList<HrDto> countrySelect(String country) {
		ArrayList<HrDto> dtos = new ArrayList<HrDto>();
		DBConn.getInstance();
		String sql = "select a.location_id,a.street_address,a.postal_code,a.city,a.state_province,b.country_id,\r\n"
				+ "b.country_name,c.region_name from locations a,countries b,regions c where a.country_id=b.country_id\r\n"
				+ "and b.region_id=c.region_id and c.region_name='%s'";
		sql = String.format(sql, country);
		ResultSet rs = DBConn.statementQuery(sql);

		try {
			while (rs.next()) {
				HrDto dto = new HrDto();

				dto.setLocationId(rs.getInt(1));
				dto.setStreetAddress(rs.getString(2));
				dto.setPostalCode(rs.getString(3));
				dto.setCity(rs.getString(4));
				dto.setStateProvince(rs.getString(5));
				dto.setCountryId(rs.getString(6));
				dto.setCountryName(rs.getString(7));
				dto.setRegionName(rs.getString(8));
				dtos.add(dto);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;
	}

	// PersonalInquirySelect조회 (풀네임 조회)
	public ArrayList<HrDto> personalInquirySelect(String firstName, String lastName) {
		ArrayList<HrDto> dtos = new ArrayList<HrDto>();
		DBConn.getInstance();
		String sql = "select * from Employees where first_name like '" + firstName + "' " + "and last_name like '"
				+ lastName + "'";
		sql = String.format(sql, firstName, lastName);
		ResultSet rs = DBConn.statementQuery(sql);

		try {
			while (rs.next()) {
				HrDto dto = new HrDto();

				dto.setEmployeeId(rs.getInt(1));
				dto.setFirstName(rs.getString(2));
				dto.setLastName(rs.getString(3));
				dto.setEmail(rs.getString(4));
				dto.setPhoneNumber(rs.getString(5));
				dto.setHireDate(rs.getString(6));
				dto.setJobId(rs.getString(7));
				dto.setSalary(rs.getInt(8));
				dto.setCommissionPct(rs.getDouble(9));

				dtos.add(dto);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;
	}

	// FirstNameSearch조회 (firstName 조회)
	public ArrayList<HrDto> firstNameSearch(String firstName) {
		ArrayList<HrDto> dtos = new ArrayList<HrDto>();
		DBConn.getInstance();
		String sql = "select * from Employees where first_name like '" + firstName + "%'";
		ResultSet rs = DBConn.statementQuery(sql);

		try {
			while (rs.next()) {
				HrDto dto = new HrDto();

				dto.setEmployeeId(rs.getInt(1));
				dto.setFirstName(rs.getString(2));
				dto.setLastName(rs.getString(3));
				dto.setEmail(rs.getString(4));
				dto.setPhoneNumber(rs.getString(5));
				dto.setHireDate(rs.getString(6));
				dto.setJobId(rs.getString(7));
				dto.setSalary(rs.getInt(8));
				dto.setCommissionPct(rs.getDouble(9));

				dtos.add(dto);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;
	}

	// LastNameSearch조회 (lastName 조회)
	public ArrayList<HrDto> lastNameSearch(String lastName) {
		ArrayList<HrDto> dtos = new ArrayList<HrDto>();
		DBConn.getInstance();
		String sql = "select * from Employees where last_name like '" + lastName + "%'";
		ResultSet rs = DBConn.statementQuery(sql);

		try {
			while (rs.next()) {
				HrDto dto = new HrDto();

				dto.setEmployeeId(rs.getInt(1));
				dto.setFirstName(rs.getString(2));
				dto.setLastName(rs.getString(3));
				dto.setEmail(rs.getString(4));
				dto.setPhoneNumber(rs.getString(5));
				dto.setHireDate(rs.getString(6));
				dto.setJobId(rs.getString(7));
				dto.setSalary(rs.getInt(8));
				dto.setCommissionPct(rs.getDouble(9));

				dtos.add(dto);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;
	}

	// department 부서명으로조회

	// ================================김보름========================================
	// 직원 정보 수정
	// 사번은 고정, 입사일도 고정, 변경가능 - 1.firstName, 2.lastName 3.E-mail 4.전화번호 5.직무 6.급여
	// 7.커미션 8.담당매니저 9.부서(ID)

	// 대상이 문자열일 경우 - 1,2,3,4,5
	public int updateEmp(int employeeId, String inputStr, String updateStr) {
		int returnValue = 0;
		DBConn.getInstance();
		// inputStr = "first_name";
		// inputStr = "last_name";
		// inputStr = "email";
		// inputStr = "phone_number";
		// inputStr = "job_id";
		String sql = "update employees set " + inputStr + " = '%s' where employee_id = %d";
		sql = String.format(sql, updateStr, employeeId);
		returnValue = DBConn.statementUpdate(sql);

		DBConn.dbClose();
		return returnValue;

	}

	// 대상이 정수형일 경우 - 6,8,9
	public int updateEmp(int employeeId, String inputStr, int updateInt) {
		int returnValue = 0;
		DBConn.getInstance();
		// inputStr = "salary";
		// inputStr = "manager_id";
		// inputStr = "department_id";

		String sql = "update employees set " + inputStr + " = %d where employee_id = %d";
		sql = String.format(sql, updateInt, employeeId);
		returnValue = DBConn.statementUpdate(sql);

		DBConn.dbClose();
		return returnValue;

	}

	// 대상이 소수점형일 경우 - 7
	public int updateEmp(int employeeId, String inputStr, double updateDouble) {
		int returnValue = 0;
		DBConn.getInstance();
		// inputStr = "commission_pct";

		String sql = "update employees set " + inputStr + " = %f where employee_id = %d";
		sql = String.format(sql, updateDouble, employeeId);
		returnValue = DBConn.statementUpdate(sql);

		DBConn.dbClose();
		return returnValue;

	}

	// 부서정보 수정
	// 부서(ID)는 고정 / 변경가능 - 1.부서명, 2.담당매니저 사번, 3.위치(ID)번호

	// 대상이 문자열일 경우 - 1
	public int updateDept(int departmentId, String inputStr, String updateStr) {
		int returnValue = 0;
		DBConn.getInstance();

		String sql = "update departments set " + inputStr + " = '%s' where department_id = %d";
		sql = String.format(sql, updateStr, departmentId);
		returnValue = DBConn.statementUpdate(sql);

		DBConn.dbClose();
		return returnValue;
	}

	// 대상이 정수형일 경우 - 2,3
	public int updateDept(int departmentId, String inputStr, int updateInt) {
		int returnValue = 0;
		DBConn.getInstance();

		String sql = "update departments set " + inputStr + " = %d where department_id = %d";
		sql = String.format(sql, updateInt, departmentId);
		returnValue = DBConn.statementUpdate(sql);

		DBConn.dbClose();
		return returnValue;
	}

	// 부서 정보 삭제
	public int deleteDept(int departmentId) {
		int returnValue = 0;
		DBConn.getInstance();

		String sql = "delete from departments where department_id = %d";
		sql = String.format(sql, departmentId);
		returnValue = DBConn.statementUpdate(sql);

		DBConn.dbClose();
		return returnValue;
	}

	// 직무 정보 수정
	// 직무(id)는 고정 // 변경 가능 - 1.job_title 2.min_salary 3.max_salary

	// 대상이 문자열일 경우 -1
	public int updateJob(String jobId, String inputStr, String updateStr) {
		int returnValue = 0;
		DBConn.getInstance();

		String sql = "update jobs set " + inputStr + " = '%s' where job_id = '%s'";
		sql = String.format(sql, updateStr, jobId);
		returnValue = DBConn.statementUpdate(sql);

		DBConn.dbClose();
		return returnValue;
	}

	// 대상이 정수형일 경우 - 2,3
	public int updateJob(String jobId, String inputStr, int updateInt) {
		int returnValue = 0;
		DBConn.getInstance();

		String sql = "update jobs set " + inputStr + " = %d where job_id = '%s'";
		sql = String.format(sql, updateInt, jobId);
		returnValue = DBConn.statementUpdate(sql);

		DBConn.dbClose();
		return returnValue;
	}

	// 직무 정보 삭제
	public int deleteJob(String jobId) {
		int returnValue = 0;
		DBConn.getInstance();

		String sql = "delete from jobs where job_id = '%s'";
		sql = String.format(sql, jobId);
		returnValue = DBConn.statementUpdate(sql);

		DBConn.dbClose();
		return returnValue;
	}

	// 지역 정보 수정
	// 지역 ID 고정 / 변동 가능 - 주소,우편번호,도시,주(도)
	public int updateLoc(int locationId, String inputStr, String updateStr) {
		int returnValue = 0;
		DBConn.getInstance();

		String sql = "update locations set " + inputStr + " = '%s' where location_id = '%s'";
		sql = String.format(sql, updateStr, locationId);
		returnValue = DBConn.statementUpdate(sql);
		return returnValue;
	}

	// 지역 정보 삭제
	public int deleteLoc(int locationId) {
		int returnValue = 0;
		DBConn.getInstance();

		String sql = "delete from locations where location_id = %d";
		sql = String.format(sql, locationId);
		returnValue = DBConn.statementUpdate(sql);

		DBConn.dbClose();
		return returnValue;
	}

	// 국가 정보 수정
	public int updateCountry(String countryId, String inputStr, String updateStr) {
		int returnValue = 0;
		DBConn.getInstance();

		String sql = "update countries set " + inputStr + " = '%s' where country_id = '%s'";
		sql = String.format(sql, updateStr, countryId);
		returnValue = DBConn.statementUpdate(sql);
		return returnValue;
	}

	// 국가 정보 삭제
	public int deleteCountry(String countryId) {
		int returnValue = 0;
		DBConn.getInstance();

		String sql = "delete from countries where country_id = '%s'";
		sql = String.format(sql, countryId);
		returnValue = DBConn.statementUpdate(sql);

		DBConn.dbClose();
		return returnValue;
	}

	// 대륙 정보 수정
	public int updateRegion(int regionId, String inputStr, String updateStr) {
		int returnValue = 0;
		DBConn.getInstance();

		String sql = "update regions set " + inputStr + " = '%s' where region_id = '%s'";
		sql = String.format(sql, updateStr, regionId);
		returnValue = DBConn.statementUpdate(sql);
		return returnValue;
	}

	// 대륙 정보 삭제
	public int deleteRegion(int regionId) {
		int returnValue = 0;
		DBConn.getInstance();

		String sql = "delete from regions where region_id = %d";
		sql = String.format(sql, regionId);
		returnValue = DBConn.statementUpdate(sql);

		DBConn.dbClose();
		return returnValue;
	}
	// =================================김보름==========================================

	// =================================김재령==========================================
	// Search phoneNumber
	public ArrayList<HrDto> phoneNumberSearch(String phoneNumber) {
		ArrayList<HrDto> dtos = new ArrayList<HrDto>();
		DBConn.getInstance();
		String sql = "select * from Employees where phone_number like '%" + phoneNumber + "%'";
		ResultSet rs = DBConn.statementQuery(sql);
		try {
			while (rs.next()) {
				HrDto dto = new HrDto();
				dto.setEmployeeId(rs.getInt("employee_id"));
				dto.setFirstName(rs.getString("first_name"));
				dto.setLastName(rs.getString("last_name"));
				dto.setEmail(rs.getString("email"));
				dto.setPhoneNumber(rs.getString("phone_number"));
				dto.setJobId(rs.getString("job_id"));

				dtos.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dtos;
	}

	// Search Email
	public ArrayList<HrDto> emailSearch(String email) {
		ArrayList<HrDto> dtos = new ArrayList<HrDto>();
		DBConn.getInstance();
		String sql = "select * from Employees where email like '%" + email + "%'";
		// 조인 추가
		ResultSet rs = DBConn.statementQuery(sql);
		try {
			while (rs.next()) {
				HrDto dto = new HrDto();
				dto.setEmployeeId(rs.getInt("employee_id"));
				dto.setFirstName(rs.getString("first_name"));
				dto.setLastName(rs.getString("last_name"));
				dto.setEmail(rs.getString("email"));
				dto.setPhoneNumber(rs.getString("phone_number"));
				dto.setJobId(rs.getString("job_id"));

				dtos.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dtos;
	}

	// Select ManagerId
	public ArrayList<HrDto> selectManagerId() {
		ArrayList<HrDto> dtos = new ArrayList<HrDto>();
		DBConn.getInstance();
		String sql = "select distinct(e2.employee_id), e2.first_name,e2.last_name from employees e1, employees e2 "
				+ "where e1.manager_id=e2.employee_id order by employee_id";
		ResultSet rs = DBConn.statementQuery(sql);
		try {
			while (rs.next()) {
				HrDto dto = new HrDto();
				dto.setEmployeeId(rs.getInt("employee_id"));
				dto.setFirstName(rs.getString("first_name"));
				dto.setLastName(rs.getString("last_name"));

				dtos.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dtos;
	}

	// Select Departments
	public ArrayList<HrDto> selectDepartments() {
		ArrayList<HrDto> dtos = new ArrayList<HrDto>();
		DBConn.getInstance();
		String sql = "select department_id, department_name from departments";
		ResultSet rs = DBConn.statementQuery(sql);
		try {
			while (rs.next()) {
				HrDto dto = new HrDto();
				dto.setDepartmentId(rs.getInt("department_id"));
				dto.setDepartmentName(rs.getString("department_name"));

				dtos.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dtos;

	}

	// Select Jobs
	public ArrayList<HrDto> selectJobs() {
		ArrayList<HrDto> dtos = new ArrayList<HrDto>();
		DBConn.getInstance();
		String sql = "select job_id, job_title from jobs";
		ResultSet rs = DBConn.statementQuery(sql);
		try {
			while (rs.next()) {
				HrDto dto = new HrDto();
				dto.setJobId(rs.getString("job_id"));
				dto.setJobTitle(rs.getString("job_title"));

				dtos.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dtos;
	}

	// Select Locations
	// location id, street address, city
	public ArrayList<HrDto> selectLocations() {
		ArrayList<HrDto> dtos = new ArrayList<HrDto>();
		DBConn.getInstance();
		String sql = "select location_id, street_address, city from locations";
		ResultSet rs = DBConn.statementQuery(sql);
		try {
			while (rs.next()) {
				HrDto dto = new HrDto();
				dto.setLocationId(rs.getInt("location_id"));
				dto.setStreetAddress(rs.getString("street_address"));
				dto.setCity(rs.getString("city"));

				dtos.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dtos;

	}

	// Select Regions
	public ArrayList<HrDto> selectRegions() {
		ArrayList<HrDto> dtos = new ArrayList<HrDto>();
		DBConn.getInstance();
		String sql = "select * from regions";
		ResultSet rs = DBConn.statementQuery(sql);
		try {
			while (rs.next()) {
				HrDto dto = new HrDto();
				dto.setRegionId(rs.getInt("region_id"));
				dto.setRegionName(rs.getString("region_name"));

				dtos.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dtos;
	}

	// Select employees
	public ArrayList<HrDto> selectEmployees() {
		ArrayList<HrDto> dtos = new ArrayList<HrDto>();
		DBConn.getInstance();
		String sql = "select employee_id,first_name,last_name from Employees";
		ResultSet rs = DBConn.statementQuery(sql);
		try {
			while (rs.next()) {
				HrDto dto = new HrDto();
				dto.setEmployeeId(rs.getInt("employee_id"));
				dto.setFirstName(rs.getString("first_name"));
				dto.setLastName(rs.getString("last_name"));
				dtos.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dtos;
	}

	// Select Countries
	public ArrayList<HrDto> selectCountries() {
		ArrayList<HrDto> dtos = new ArrayList<HrDto>();
		DBConn.getInstance();
		String sql = "select country_id, country_name from countries";
		ResultSet rs = DBConn.statementQuery(sql);
		try {
			while (rs.next()) {
				HrDto dto = new HrDto();
				dto.setCountryId(rs.getString("country_id"));
				dto.setCountryName(rs.getString("country_name"));
//					dto.setRegionId(rs.getInt("region_id"));

				dtos.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dtos;
	}

	// 1.직원
	public int insertEmployees(HrDto dto) {
		int returnValue = 0;
		DBConn.getInstance();
		String sql = "insert into employees values"
				+ "(%d,'%s','%s','%s','%s',to_date('%s','yyyy-mm-dd'),'%s',%d,%f,%d,%d)";
		sql = String.format(sql, dto.getEmployeeId(), dto.getFirstName(), dto.getLastName(), dto.getEmail(),
				dto.getPhoneNumber(), dto.getHireDate(), dto.getJobId(), dto.getSalary(), dto.getCommissionPct(),
				dto.getManagerId(), dto.getDepartmentId());

		returnValue = DBConn.statementUpdate(sql);
		DBConn.dbClose();
		return returnValue;
	}

	// 2.부서
	public int insertDepartments(HrDto dto) {
		int returnValue = 0;
		DBConn.getInstance();
		String sql = "insert into departments values" + "(%d,'%s',%d,%d)";
		sql = String.format(sql, dto.getDepartmentId(), dto.getDepartmentName(), dto.getManagerId(),
				dto.getLocationId());

		returnValue = DBConn.statementUpdate(sql);
		DBConn.dbClose();
		return returnValue;

	}

	// 3.직무
	public int insertJobs(HrDto dto) {// 새로운 직무 추가 필요 없을듯 //minSal, maxSal은 변경 필요할수도...
		int returnValue = 0;
		DBConn.getInstance();
		String sql = "insert into jobs values" + "('%s','%s',%d,%d)";
		sql = String.format(sql, dto.getJobId(), dto.getJobTitle(), dto.getMinSalary(), dto.getMaxSalary());

		returnValue = DBConn.statementUpdate(sql);
		DBConn.dbClose();
		return returnValue;
	}

	// 4.지역(국가, 대륙포함)
	public int insertLocations(HrDto dto) {
		int returnValue = 0;
		DBConn.getInstance();
		String sql = "insert into locations values" + "(%d,'%s','%s','%s','%s','%s')";
		sql = String.format(sql, dto.getLocationId(), dto.getStreetAddress(), dto.getPostalCode(), dto.getCity(),
				dto.getStateProvince(), dto.getCountryId());

		returnValue = DBConn.statementUpdate(sql);
		DBConn.dbClose();
		return returnValue;
	}

	public int insertCountries(HrDto dto) {
		int returnValue = 0;
		DBConn.getInstance();
		String sql = "insert into countries values" + "('%s','%s',%d)";
		sql = String.format(sql, dto.getCountryId(), dto.getCountryName(), dto.getRegionId());

		returnValue = DBConn.statementUpdate(sql);
		DBConn.dbClose();
		return returnValue;
	}

	public int insertRegions(HrDto dto) {
		int returnValue = 0;
		DBConn.getInstance();
		String sql = "insert into regions values" + "(%d,'%s')";
		sql = String.format(sql, dto.getRegionId(), dto.getRegionName());

		returnValue = DBConn.statementUpdate(sql);
		DBConn.dbClose();
		return returnValue;
	}

	// =================================김재령==========================================
	// =================================김재령=0529====================================
	// Select Salary&EmployeeId, Employee Names
	public ArrayList<HrDto> selectSalEmp() {
		ArrayList<HrDto> dtos = new ArrayList<HrDto>();
		DBConn.getInstance();
		String sql = "select employee_id, first_name, last_name, salary,commission_pct, salary*(commission_pct+1) from employees";
		ResultSet rs = DBConn.statementQuery(sql);
		try {
			while (rs.next()) {
				HrDto dto = new HrDto();
				dto.setEmployeeId(rs.getInt("employee_id"));
				dto.setFirstName(rs.getString("first_name"));
				dto.setLastName(rs.getString("last_name"));
				dto.setSalary(rs.getInt("salary"));
				dto.setCommissionPct(rs.getDouble("commission_pct"));
				dtos.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dtos;
	}
	// =================================김재령=0529=====================================

	// ==============================0529 김보름====================================

	// 조직도 - 위치 조회 함수
	public ArrayList<HrDto> orgTableLoc(String DepartmentName) {
		ArrayList<HrDto> dtos = new ArrayList<HrDto>();
		DBConn.getInstance();
		String sql = "select l.street_address||', '||l.city||', '||l.state_province||', '||l.country_id location "
				+ "from departments d, locations l where d.location_id = l.location_id "
				+ "and d.department_name like '" + DepartmentName + "'";

		ResultSet rs = DBConn.statementQuery(sql);

		try {
			while (rs.next()) {

				HrDto dto = new HrDto();

				dto.setStreetAddress(rs.getString(1));

				dtos.add(dto);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dtos;
	}

	// 조직도 - 매니저 출력메소드

	public ArrayList<HrDto> orgTableMgn(String DepartmentName) {
		ArrayList<HrDto> dtos = new ArrayList<HrDto>();
		DBConn.getInstance();
		String sql = "select e.employee_id, e.first_name||' '||e.last_name from employees e, departments d "
				+ "where e.department_id = d.department_id and d.manager_id = e.employee_id "
				+ "and d.department_name like '" + DepartmentName + "'";

		ResultSet rs = DBConn.statementQuery(sql);

		try {
			while (rs.next()) {

				HrDto dto = new HrDto();

				dto.setEmployeeId(rs.getInt(1));
				dto.setLastName(rs.getString(2));

				dtos.add(dto);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dtos;
	}

	// 조직도 - 직무

	public ArrayList<HrDto> orgTableJobs(String DepartmentName) {
		ArrayList<HrDto> dtos = new ArrayList<HrDto>();
		DBConn.getInstance();
		String sql = "select distinct d.department_name, j.job_id, j.job_title "
				+ "from employees e, departments d, jobs j where e.department_id = d.department_id "
				+ "and e.job_id = j.job_id and d.department_name like '" + DepartmentName + "'";

		ResultSet rs = DBConn.statementQuery(sql);

		try {
			while (rs.next()) {

				HrDto dto = new HrDto();

				dto.setDepartmentName(rs.getString(1));
				dto.setJobId(rs.getString(2));
				dto.setJobTitle(rs.getString(3));

				dtos.add(dto);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dtos;
	}
	// ==============================0529 김보름====================================

	// ==============================0530 김재령====================================
	public ArrayList<HrDto> employeeIdSearch(int employeeId) {
		ArrayList<HrDto> dtos = new ArrayList<HrDto>();
		DBConn.getInstance();
		String sql = "select employee_id, first_name, last_name, salary from employees " + "where employee_id ="
				+ employeeId;
		ResultSet rs = DBConn.statementQuery(sql);
		try {
			while (rs.next()) {
				HrDto dto = new HrDto();
				dto.setEmployeeId(rs.getInt("employee_id"));
				dto.setFirstName(rs.getString("first_name"));
				dto.setLastName(rs.getString("last_name"));
				dto.setSalary(rs.getInt("salary"));

				dtos.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dtos;
	}

	public ArrayList<HrDto> salRangeSearch(int minSalary, int maxSalary) {
		ArrayList<HrDto> dtos = new ArrayList<HrDto>();
		DBConn.getInstance();
		String sql = "select employee_id, first_name, last_name, salary from employees " + "where salary >= "
				+ minSalary + " and salary <= " + maxSalary;
		ResultSet rs = DBConn.statementQuery(sql);
		try {
			while (rs.next()) {
				HrDto dto = new HrDto();
				dto.setEmployeeId(rs.getInt("employee_id"));
				dto.setFirstName(rs.getString("first_name"));
				dto.setLastName(rs.getString("last_name"));
				dto.setSalary(rs.getInt("salary"));

				dtos.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;
	}

	public ArrayList<HrDto> salDepartmentSearch(int departmentId) {
		ArrayList<HrDto> dtos = new ArrayList<HrDto>();
		DBConn.getInstance();
		String sql = "select e.employee_id, e.first_name, e.last_name, e.salary, d.department_name "
				+ "from employees e, departments d" + " where e.department_id = " + departmentId
				+ " and e.department_id = d.department_id";
		ResultSet rs = DBConn.statementQuery(sql);
		try {
			while (rs.next()) {
				HrDto dto = new HrDto();
				dto.setEmployeeId(rs.getInt("employee_id"));
				dto.setFirstName(rs.getString("first_name"));
				dto.setLastName(rs.getString("last_name"));
				dto.setSalary(rs.getInt("salary"));
				dto.setDepartmentName(rs.getString("department_name"));

				dtos.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;
	}

	public ArrayList<HrDto> salJobSearch(String jobId) {
		ArrayList<HrDto> dtos = new ArrayList<HrDto>();
		DBConn.getInstance();
		String sql = "select e.employee_id, e.first_name, e.last_name, e.salary, j.job_title "
				+ "from employees e, jobs j" + " where e.job_id like '" + jobId + "%' and e.job_id = j.job_id";
		ResultSet rs = DBConn.statementQuery(sql);
		try {
			while (rs.next()) {
				HrDto dto = new HrDto();
				dto.setEmployeeId(rs.getInt("employee_id"));
				dto.setFirstName(rs.getString("first_name"));
				dto.setLastName(rs.getString("last_name"));
				dto.setSalary(rs.getInt("salary"));
				dto.setJobTitle(rs.getString("job_title"));

				dtos.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;
	}

	public ArrayList<HrDto> salJobMMAvg(String jobId) {
		ArrayList<HrDto> dtos = new ArrayList<HrDto>();
		DBConn.getInstance();
		String sql = "select distinct j.min_salary, j.max_salary, avg(e.salary) from employees e, jobs j \r\n"
				+ "where e.job_id = j.job_id and j.job_id like '" + jobId + "' group by j.min_salary, j.max_salary";
		ResultSet rs = DBConn.statementQuery(sql);
		try {
			while (rs.next()) {
				HrDto dto = new HrDto();
				dto.setMinSalary(rs.getInt(1));
				dto.setMaxSalary(rs.getInt(2));
				dto.setSalary(rs.getInt(3));

				dtos.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dtos;
	}

	public ArrayList<HrDto> jobSearch(String jobId) {
		ArrayList<HrDto> dtos = new ArrayList<HrDto>();
		DBConn.getInstance();
		String sql = "select * from Employees where job_id like '%" + jobId + "%'";
		// 조인 추가
		ResultSet rs = DBConn.statementQuery(sql);
		try {
			while (rs.next()) {
				HrDto dto = new HrDto();
				dto.setEmployeeId(rs.getInt("employee_id"));
				dto.setFirstName(rs.getString("first_name"));
				dto.setLastName(rs.getString("last_name"));
				dto.setEmail(rs.getString("email"));
				dto.setPhoneNumber(rs.getString("phone_number"));
				dto.setJobId(rs.getString("job_id"));

				dtos.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dtos;
	}

	// =====================================0602 김재령

	public ArrayList<HrDto> jobsSelectByEmpId(int empId) {
		ArrayList<HrDto> dtos = new ArrayList<HrDto>();
		DBConn.getInstance();
		String sql = "select e.first_name, e.last_name, j.job_title, j.min_salary, j.max_salary"
				+ " from employees e, jobs j where e.job_id=j.job_id and employee_id = " + empId;
		ResultSet rs = DBConn.statementQuery(sql);

		try {
			while (rs.next()) {
				HrDto dto = new HrDto();

				dto.setFirstName(rs.getString("first_name"));
				dto.setLastName(rs.getString("last_name"));
				dto.setJobTitle(rs.getString("job_title"));
				dto.setMinSalary(rs.getInt("min_salary"));
				dto.setMaxSalary(rs.getInt("max_salary"));
				dtos.add(dto);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;
	}

//=========================================0603 김재령==========================================
	// 직원 정보 삭제
	public int deleteEmp(int employeeId) {
		int returnValue = 0;
		DBConn.getInstance();

		String sql = "update employees set job_id='RESIGN' where employee_id = %d";
		sql = String.format(sql, employeeId);
		returnValue = DBConn.statementUpdate(sql);

		DBConn.dbClose();
		return returnValue;
	}

	// Select Departments only Name
	public ArrayList<HrDto> selectDepartmentName() {
		ArrayList<HrDto> dtos = new ArrayList<HrDto>();
		DBConn.getInstance();
		String sql = "select department_name from departments";
		ResultSet rs = DBConn.statementQuery(sql);
		try {
			while (rs.next()) {
				HrDto dto = new HrDto();
				dto.setDepartmentName(rs.getString("department_name"));

				dtos.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;

	}

	// Select Departments only Name
	public ArrayList<HrDto> selectJobResign() {
		ArrayList<HrDto> dtos = new ArrayList<HrDto>();
		DBConn.getInstance();
		String sql = "select job_id from jobs where job_id like 'RESIGN'";
		ResultSet rs = DBConn.statementQuery(sql);
		try {
			while (rs.next()) {
				HrDto dto = new HrDto();
				dto.setJobId(rs.getString("job_id"));
				dtos.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;

	}

	// location Id만
	public ArrayList<HrDto> selectLocationId() {
		ArrayList<HrDto> dtos = new ArrayList<HrDto>();
		DBConn.getInstance();
		String sql = "select location_id from locations";
		ResultSet rs = DBConn.statementQuery(sql);
		try {
			while (rs.next()) {
				HrDto dto = new HrDto();
				dto.setLocationId(rs.getInt("location_id"));
				dtos.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;

	}

	// Select Departments Id only
	public ArrayList<HrDto> selectDepartmentId() {
		ArrayList<HrDto> dtos = new ArrayList<HrDto>();
		DBConn.getInstance();
		String sql = "select department_id from departments";
		ResultSet rs = DBConn.statementQuery(sql);
		try {
			while (rs.next()) {
				HrDto dto = new HrDto();
				dto.setDepartmentId(rs.getInt("department_id"));

				dtos.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;

	}

	// EMPLOYEES 조회(직원) 퇴사자 빼고
	public ArrayList<HrDto> employeesSelectNot() {
		ArrayList<HrDto> dtos = new ArrayList<HrDto>();
		DBConn.getInstance();
		String sql = "select employee_id, first_name, last_name, email, phone_number, "
				+ "to_char(hire_date,'YYYY-MM-DD'), job_id, salary, commission_pct from Employees "
				+ " where job_id not like 'RESIGN'";
		ResultSet rs = DBConn.statementQuery(sql);

		try {
			while (rs.next()) {
				HrDto dto = new HrDto();

				dto.setEmployeeId(rs.getInt(1));
				dto.setFirstName(rs.getString(2));
				dto.setLastName(rs.getString(3));
				dto.setEmail(rs.getString(4));
				dto.setPhoneNumber(rs.getString(5));
				dto.setHireDate(rs.getString(6));
				dto.setJobId(rs.getString(7));
				dto.setSalary(rs.getInt(8));
				dto.setCommissionPct(rs.getDouble(9));

				dtos.add(dto);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;
	}

	public ArrayList<HrDto> maxSalJob(String jobId) {
		ArrayList<HrDto> dtos = new ArrayList<HrDto>();
		DBConn.getInstance();
		String sql = "select distinct e1.first_name, e1.salary from employees e1, jobs j \r\n"
				+ "where e1.salary = (select max(salary) from employees e, jobs j "
				+ "where e.job_id= j.job_id and j.job_id like'" + jobId + "') and e1.job_id like '" + jobId + "'";
		ResultSet rs = DBConn.statementQuery(sql);
		try {
			while (rs.next()) {
				HrDto dto = new HrDto();
				dto.setFirstName(rs.getString("first_name"));
				dto.setSalary(rs.getInt("salary"));

				dtos.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dtos;
	}

	public ArrayList<HrDto> minSalJob(String jobId) {
		ArrayList<HrDto> dtos = new ArrayList<HrDto>();
		DBConn.getInstance();
		String sql = "select distinct e1.first_name, e1.salary from employees e1, jobs j \r\n"
				+ "where e1.salary = (select min(salary) from employees e, jobs j "
				+ "where e.job_id= j.job_id and j.job_id like'" + jobId + "') and e1.job_id like '" + jobId + "'";
		ResultSet rs = DBConn.statementQuery(sql);
		try {
			while (rs.next()) {
				HrDto dto = new HrDto();
				dto.setFirstName(rs.getString("first_name"));
				dto.setSalary(rs.getInt("salary"));

				dtos.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dtos;
	}

	public ArrayList<HrDto> avgSalJob(String jobId) {
		ArrayList<HrDto> dtos = new ArrayList<HrDto>();
		DBConn.getInstance();
		String sql = "select avg(e.salary) from employees e, jobs j " + "where e.job_id = j.job_id and j.job_id like '"
				+ jobId + "'";
		ResultSet rs = DBConn.statementQuery(sql);
		try {
			while (rs.next()) {
				HrDto dto = new HrDto();
				dto.setSalary(rs.getInt("salary"));

				dtos.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dtos;
	}
}
