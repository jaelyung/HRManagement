package com.dto;

import java.util.Date;

public class HrDto {
public HrDto() {};
	//관리자 아이디는 하나면 충분할거같아 굳이 리스트나 배열에 안넣음 
	// 아무도 건드리지 못하게 상수로 묶어버림
	public static final String ADMIN_ID="admin";
	public static final String ADMIN_PW="admin";
	// jobs 테이블
	private String jobId;
	private String jobTitle;
	private int minSalary;
	private int maxSalary;
	private double sum;
	
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	// job_history 테이블
	private Date startDate;
	private Date endDate;
	
	// employees 테이블
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String hireDate;
	private int salary;
	private double commissionPct;

	// departments 테이블
	private int departmentId;
	private String departmentName;
	private int managerId;
		
	// locations 테이블
	private int locationId;
	private String streetAddress;
	private String postalCode;
	private String city;
	private String stateProvince;
		
	// countries 테이블
	private String countryId;
	private String countryName;
	
	// regions 테이블
	private int regionId;
	private String regionName;
	
	
	//jobs 출력 메소드
	public String jobsToString() {
		String result;
		result=String.format("   %-12s %-33s %-12d %d",
				jobId,jobTitle,minSalary,maxSalary);
		return result;
	}
	//jobs 출력 id, jobtitle
	public String jobSelect() {
		String result;
		result=String.format("\t%-12s %-20s", jobId, jobTitle);
		return result;
	}
	
	//jobs 직무별 최대 최소 급여 보여주는 용도 출력 
	public String jobMMSalSelect() {
		String result;
		result=String.format("\t%-12s %-40s \t%-8d  \t%-8d", jobId, jobTitle, minSalary, maxSalary);
		return result;
	}
	

	//employees 관리자모드>>insert
	public String managerIdSelect() {
		String result;
		result=String.format("\t%-10d %-15s %-15s", employeeId, firstName, lastName);
		return result;
	}
	//관리자모드>employee 일괄조회
			public String employeesToString() {
				String result;
				result=String.format("\t%-10d %-15s %-15s %-15s %-20s %-15s %-12s %-10d %.2f",
						employeeId,firstName,lastName,email,phoneNumber,hireDate, jobId, salary, commissionPct);
				return result;
				
			}
			//매니저 가능한 아이디 출력 employees
			public String employeesSelectString() {
				String result;
				result=String.format("\t%-10d %-15s %-15s",employeeId,firstName,lastName);
						return result;
			}
	
	
	//개인조회>employee 출력
		public String employeesPersonalToString() {
			String result;
			result=String.format("\t%-10d %-15s %-15s %-15s %-20s %-12s",
					employeeId,firstName,lastName,email,phoneNumber,jobId);
			return result;
			
		}
	

		//departments출력 메소드
		public String departmentsToString() {
			String result;
			result=String.format("\t%-10d %-22s %-15d %-15d %-48s %-15s %-3s",
					departmentId,departmentName,managerId,locationId,streetAddress, postalCode, countryId);
			return result;
		}
	//부서 개인정보 출력 메소드
			public String PersonalInquiryToString() {
				String result;
				result=String.format("\t%-7d \t%-15s \t%-10d %-15s %-15s %-15s %-20s %-10s %-15d",
						departmentId,departmentName,employeeId,firstName,lastName,email,phoneNumber,jobId,managerId);
				return result;
			}
			
	
			//country 관리자 일괄조회
			public String countryToString() {
				String result;
				result=String.format("%-20s %-15d %-43s %-14s %-20s %-20s %-10s %-28s " ,
						regionName,locationId,streetAddress,postalCode,city,stateProvince,countryId,countryName);
				return result;
			}

	//departments 관리자모드>신규입력 insert
	public String departmentSelect() {
		String result = String.format("\t%-7d %-15s", departmentId,departmentName);
		return result;
	}
	//locations 관리자모드> 신규입력 insert문에서 사용
	public String locationSelect() {
		String result = String.format("\t%-13s %-42s \t%-15s", locationId, streetAddress, city);
		return result; //출력시 select location과 함께 위치수정필요
	}
	
	//countries 관리자모드>신규입력 insert문에서 사용
	public String countrySelect() {
		String result = String.format("\t %-7s %-15s", countryId, countryName);
		return result;
	}
	
	//regions 관리자모드>신규입력 insert에서 사용
	public String regionName() {//selectRegions
		String result = String.format("\t %-7d %-15s", regionId, regionName);
		return result;
	}
	
	//salary & employee id, name
//	public String salEmpSelect() {
//		String result = String.format("\t%-9d %-15s %-15s %-7d", employeeId, firstName, lastName, salary);
//		return  result;
//	}
	public String salEmpSelect() {
		String result = String.format("\t%-9d %-15s %-15s %-10d %.2f \t%-15.1f",
		employeeId, firstName, lastName, salary, commissionPct, salary*12*(commissionPct+1));
		return result;
	}
	//salary & employee id, name, department name
//	public String salDeptSelect() {
//		String result = String.format("\t%-9d %-15s %-15s %-12d %-30s", 
//				employeeId, firstName, lastName, salary, departmentName);
//		return  result;
//	}
	//salary & employee id, name, department name
	public String salDeptSelect() {
	String result = String.format("\t%-9d %-15s %-15s %-12d %.2f \t%-15.1f %-30s",
	employeeId, firstName, lastName, salary, commissionPct, salary*12*(commissionPct+1), departmentName);
	return result;
	}
	//salary & employee id, name, department name
//	public String salJobSelect() {
//		String result = String.format("\t%-9d %-15s %-15s %-12d %-30s",
//				employeeId, firstName, lastName, salary, jobTitle);
//		return  result;
//	}
	//salary & employee id, name, department name
	public String salJobSelect() {
	String result = String.format("\t%-9d %-15s %-15s %-12d %.2f \t%-15.1f %-30s",
	employeeId, firstName, lastName, salary, commissionPct, salary*12*(commissionPct+1), jobTitle);
	return result;
	}
	
	
	// jobs 테이블
	
	public String getJobId() { // jobs테이블의 jobId
		return jobId;
	}
	public void setJobId(String jobId) { // jobs테이블의 jobId
		this.jobId = jobId;
	}
	public String getJobTitle() { // jobs테이블의 jobTitle
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) { //jobs테이블의 jobTitle
		this.jobTitle = jobTitle;
	}
	public int getMinSalary() { //jobs테이블의  MinSalary
		return minSalary;
	}
	public void setMinSalary(int minSalary) { //jobs테이블의  MinSalary
		this.minSalary = minSalary;
	}
	public int getMaxSalary() { //jobs테이블의  MaxSalary
		return maxSalary;
	}
	public void setMaxSalary(int maxSalary) { //jobs테이블의  MaxSalary
		this.maxSalary = maxSalary;
	}
	
	
	// job_history 테이블
	
	public Date getStartDate() { //job_history테이블의 StartDate
		return startDate;
	}
	public void setStartDate(Date startDate) { //job_history테이블의 StartDate
		this.startDate = startDate;
	}
	public Date getEndDate() { //job_history테이블의 EndDate
		return endDate;
	}
	public void setEndDate(Date endDate) { // job_history테이블의 EndDate
		this.endDate = endDate;
	}
	
	// employee 테이블
	
	
	public int getEmployeeId() { // employees테이블의 EmployeeId
		return employeeId;
	}
	public void setEmployeeId(int employeeId) { // employees테이블의 EmployeeId
		this.employeeId = employeeId;
	}
	public String getFirstName() { // employees테이블의 FirstName
		return firstName;
	}
	public void setFirstName(String firstName) { // employees테이블의 FirstName
		this.firstName = firstName;
	}
	public String getLastName() { // employees테이블의 LastName
		return lastName;
	}
	public void setLastName(String lastName) { // employees테이블의 LastName
		this.lastName = lastName;
	}
	public String getEmail() { // employees테이블의 Email
		return email;
	}
	public void setEmail(String email) { // employees테이블의 Email
		this.email = email;
	}
	public String getPhoneNumber() { // employees테이블의 PhoneNumber
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) { // employees테이블의 PhoneNumber
		this.phoneNumber = phoneNumber;
	}
	public String getHireDate() { // employees테이블의 HireDate
		return hireDate;
	}
	public void setHireDate(String hireDate) { // employees테이블의 HireDate
		this.hireDate = hireDate;
	}
	public int getSalary() {  // employees테이블의 Salary
		return salary;
	}
	public void setSalary(int salary) { // employees테이블의 Salary
		this.salary = salary;
	}
	public double getCommissionPct() { // employees테이블의 CommissionPct
		return commissionPct;
	}
	public void setCommissionPct(double commissionPct) { // employees테이블의 CommissionPct
		this.commissionPct = commissionPct;
	}
	
	
	// departments 테이블
	
	public int getDepartmentId() { 
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	
	
	// locations 테이블
	
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStateProvince() {
		return stateProvince;
	}
	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}
	
	
	// countries 테이블
	
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	
	// regions 테이블
	
	public int getRegionId() {
		return regionId;
	}
	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	//==============================0529 김보름====================================
	//조직도 - 지역 문자열 출력
	
	public String locToString() { 
		String result = null;
		
		result = String.format("%s", streetAddress);
		
		return result;
	}
	
	//조직도 - 매니저 문자열 출력
	public String mgnToString() {
		String result = null;
		
		result = String.format(" %-6d\t\t  %-30s", employeeId, lastName);
		
		return result;
	}
	
	//조직도 - 직무 문자열 출력
	public String deptJobsToString() {
		String result = null;
		
		result = String.format(" %-15s    %-10s     \t%-50s", departmentName, jobId, jobTitle);
		
		return result;
	}
	
	//==============================0529 김보름====================================
	
	//==============================0602 김재령====================================
	//jobs 직무별 최대 최소 급여 보여주는 용도 출력 
		public String jobMMSalUpdate() {
			String result;
			result=String.format("\t%-15s %-12s \t%-30s     %-12d   %-8d", 
					firstName, lastName, jobTitle, minSalary, maxSalary);
			return result;
		}
		
		//departments 개인조회> 부서명조회
		public String departmentNameSelect() {
			String result = String.format("\t%-15s", departmentName);
			return result;
		}
//		---------------0605 수정--------------
		public String salJobMMAvg() {
			String result = String.format("\t%-9d %-9d   %-9d", minSalary, maxSalary, salary);
			return result;
		}
		public String maxSalJob() {
			String result = String.format("이름 : %s 급여 : %d", firstName, salary);
			return result;
		}
		public String minSalJob() {
			String result = String.format("이름 : %s 급여 : %d", firstName, salary);
			return result;
		}
		public String avgSalJob() {
			String result = String.format("평균 급여 : %d", salary);
			return result;
		}
}
