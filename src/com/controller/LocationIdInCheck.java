package com.controller;

import java.util.ArrayList;

import com.dao.HrDao;
import com.dto.HrDto;
import com.util.DBConn;
import com.util.Request;
import com.util.Response;

public class LocationIdInCheck implements HrExecute {

	static int locationId;
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
		response.setArrHrDto(dao.selectLocations());
		ArrayList<HrDto> dtos = response.getArrHrDto();

		while (flag) {
			int count=0;
			locationId = DBConn.inputInt();
			for (HrDto dto : dtos) {
//				System.out.println(dto.getLocationId());
				if (locationId == dto.getLocationId()) {
					System.out.println("�̹� �����ϴ� ����ID �Դϴ�.");
					System.out.println("�ٽ� �Է����ּ���.");
					count=-1;
					break;
				}
				// System.out.println(employeeId+2);//���Ҷ��� id �״��
			}
			// System.out.println(employeeId+1); //for�� Ż��
			if (count != -1) {
				flag = false;
			}
		}
	}

	@Override
	public void outputView(Request request, Response response) {


	}

}