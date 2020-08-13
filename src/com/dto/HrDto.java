package com.dto;

import java.util.Date;

public class HrDto {
public HrDto() {};
	//������ ���̵�� �ϳ��� ����ҰŰ��� ���� ����Ʈ�� �迭�� �ȳ��� 
	// �ƹ��� �ǵ帮�� ���ϰ� ����� �������
	public static final String ADMIN_ID="admin";
	public static final String ADMIN_PW="admin";
	// jobs ���̺�
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
	// job_history ���̺�
	private Date startDate;
	private Date endDate;
	
	// employees ���̺�
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String hireDate;
	private int salary;
	private double commissionPct;

	// departments ���̺�
	private int departmentId;
	private String departmentName;
	private int managerId;
		
	// locations ���̺�
	private int locationId;
	private String streetAddress;
	private String postalCode;
	private String city;
	private String stateProvince;
		
	// countries ���̺�
	private String countryId;
	private String countryName;
	
	// regions ���̺�
	private int regionId;
	private String regionName;
	
	
	//jobs ��� �޼ҵ�
	public String jobsToString() {
		String result;
		result=String.format("   %-12s %-33s %-12d %d",
				jobId,jobTitle,minSalary,maxSalary);
		return result;
	}
	//jobs ��� id, jobtitle
	public String jobSelect() {
		String result;
		result=String.format("\t%-12s %-20s", jobId, jobTitle);
		return result;
	}
	
	//jobs ������ �ִ� �ּ� �޿� �����ִ� �뵵 ��� 
	public String jobMMSalSelect() {
		String result;
		result=String.format("\t%-12s %-40s \t%-8d  \t%-8d", jobId, jobTitle, minSalary, maxSalary);
		return result;
	}
	

	//employees �����ڸ��>>insert
	public String managerIdSelect() {
		String result;
		result=String.format("\t%-10d %-15s %-15s", employeeId, firstName, lastName);
		return result;
	}
	//�����ڸ��>employee �ϰ���ȸ
			public String employeesToString() {
				String result;
				result=String.format("\t%-10d %-15s %-15s %-15s %-20s %-15s %-12s %-10d %.2f",
						employeeId,firstName,lastName,email,phoneNumber,hireDate, jobId, salary, commissionPct);
				return result;
				
			}
			//�Ŵ��� ������ ���̵� ��� employees
			public String employeesSelectString() {
				String result;
				result=String.format("\t%-10d %-15s %-15s",employeeId,firstName,lastName);
						return result;
			}
	
	
	//������ȸ>employee ���
		public String employeesPersonalToString() {
			String result;
			result=String.format("\t%-10d %-15s %-15s %-15s %-20s %-12s",
					employeeId,firstName,lastName,email,phoneNumber,jobId);
			return result;
			
		}
	

		//departments��� �޼ҵ�
		public String departmentsToString() {
			String result;
			result=String.format("\t%-10d %-22s %-15d %-15d %-48s %-15s %-3s",
					departmentId,departmentName,managerId,locationId,streetAddress, postalCode, countryId);
			return result;
		}
	//�μ� �������� ��� �޼ҵ�
			public String PersonalInquiryToString() {
				String result;
				result=String.format("\t%-7d \t%-15s \t%-10d %-15s %-15s %-15s %-20s %-10s %-15d",
						departmentId,departmentName,employeeId,firstName,lastName,email,phoneNumber,jobId,managerId);
				return result;
			}
			
	
			//country ������ �ϰ���ȸ
			public String countryToString() {
				String result;
				result=String.format("%-20s %-15d %-43s %-14s %-20s %-20s %-10s %-28s " ,
						regionName,locationId,streetAddress,postalCode,city,stateProvince,countryId,countryName);
				return result;
			}

	//departments �����ڸ��>�ű��Է� insert
	public String departmentSelect() {
		String result = String.format("\t%-7d %-15s", departmentId,departmentName);
		return result;
	}
	//locations �����ڸ��> �ű��Է� insert������ ���
	public String locationSelect() {
		String result = String.format("\t%-13s %-42s \t%-15s", locationId, streetAddress, city);
		return result; //��½� select location�� �Բ� ��ġ�����ʿ�
	}
	
	//countries �����ڸ��>�ű��Է� insert������ ���
	public String countrySelect() {
		String result = String.format("\t %-7s %-15s", countryId, countryName);
		return result;
	}
	
	//regions �����ڸ��>�ű��Է� insert���� ���
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
	
	
	// jobs ���̺�
	
	public String getJobId() { // jobs���̺��� jobId
		return jobId;
	}
	public void setJobId(String jobId) { // jobs���̺��� jobId
		this.jobId = jobId;
	}
	public String getJobTitle() { // jobs���̺��� jobTitle
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) { //jobs���̺��� jobTitle
		this.jobTitle = jobTitle;
	}
	public int getMinSalary() { //jobs���̺���  MinSalary
		return minSalary;
	}
	public void setMinSalary(int minSalary) { //jobs���̺���  MinSalary
		this.minSalary = minSalary;
	}
	public int getMaxSalary() { //jobs���̺���  MaxSalary
		return maxSalary;
	}
	public void setMaxSalary(int maxSalary) { //jobs���̺���  MaxSalary
		this.maxSalary = maxSalary;
	}
	
	
	// job_history ���̺�
	
	public Date getStartDate() { //job_history���̺��� StartDate
		return startDate;
	}
	public void setStartDate(Date startDate) { //job_history���̺��� StartDate
		this.startDate = startDate;
	}
	public Date getEndDate() { //job_history���̺��� EndDate
		return endDate;
	}
	public void setEndDate(Date endDate) { // job_history���̺��� EndDate
		this.endDate = endDate;
	}
	
	// employee ���̺�
	
	
	public int getEmployeeId() { // employees���̺��� EmployeeId
		return employeeId;
	}
	public void setEmployeeId(int employeeId) { // employees���̺��� EmployeeId
		this.employeeId = employeeId;
	}
	public String getFirstName() { // employees���̺��� FirstName
		return firstName;
	}
	public void setFirstName(String firstName) { // employees���̺��� FirstName
		this.firstName = firstName;
	}
	public String getLastName() { // employees���̺��� LastName
		return lastName;
	}
	public void setLastName(String lastName) { // employees���̺��� LastName
		this.lastName = lastName;
	}
	public String getEmail() { // employees���̺��� Email
		return email;
	}
	public void setEmail(String email) { // employees���̺��� Email
		this.email = email;
	}
	public String getPhoneNumber() { // employees���̺��� PhoneNumber
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) { // employees���̺��� PhoneNumber
		this.phoneNumber = phoneNumber;
	}
	public String getHireDate() { // employees���̺��� HireDate
		return hireDate;
	}
	public void setHireDate(String hireDate) { // employees���̺��� HireDate
		this.hireDate = hireDate;
	}
	public int getSalary() {  // employees���̺��� Salary
		return salary;
	}
	public void setSalary(int salary) { // employees���̺��� Salary
		this.salary = salary;
	}
	public double getCommissionPct() { // employees���̺��� CommissionPct
		return commissionPct;
	}
	public void setCommissionPct(double commissionPct) { // employees���̺��� CommissionPct
		this.commissionPct = commissionPct;
	}
	
	
	// departments ���̺�
	
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
	
	
	// locations ���̺�
	
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
	
	
	// countries ���̺�
	
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
	
	
	// regions ���̺�
	
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

	//==============================0529 �躸��====================================
	//������ - ���� ���ڿ� ���
	
	public String locToString() { 
		String result = null;
		
		result = String.format("%s", streetAddress);
		
		return result;
	}
	
	//������ - �Ŵ��� ���ڿ� ���
	public String mgnToString() {
		String result = null;
		
		result = String.format(" %-6d\t\t  %-30s", employeeId, lastName);
		
		return result;
	}
	
	//������ - ���� ���ڿ� ���
	public String deptJobsToString() {
		String result = null;
		
		result = String.format(" %-15s    %-10s     \t%-50s", departmentName, jobId, jobTitle);
		
		return result;
	}
	
	//==============================0529 �躸��====================================
	
	//==============================0602 �����====================================
	//jobs ������ �ִ� �ּ� �޿� �����ִ� �뵵 ��� 
		public String jobMMSalUpdate() {
			String result;
			result=String.format("\t%-15s %-12s \t%-30s     %-12d   %-8d", 
					firstName, lastName, jobTitle, minSalary, maxSalary);
			return result;
		}
		
		//departments ������ȸ> �μ�����ȸ
		public String departmentNameSelect() {
			String result = String.format("\t%-15s", departmentName);
			return result;
		}
//		---------------0605 ����--------------
		public String salJobMMAvg() {
			String result = String.format("\t%-9d %-9d   %-9d", minSalary, maxSalary, salary);
			return result;
		}
		public String maxSalJob() {
			String result = String.format("�̸� : %s �޿� : %d", firstName, salary);
			return result;
		}
		public String minSalJob() {
			String result = String.format("�̸� : %s �޿� : %d", firstName, salary);
			return result;
		}
		public String avgSalJob() {
			String result = String.format("��� �޿� : %d", salary);
			return result;
		}
}
