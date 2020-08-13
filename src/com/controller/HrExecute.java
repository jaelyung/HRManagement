package com.controller;

import com.util.Request;
import com.util.Response;

public interface HrExecute {
	public void execute();
	public void execute(Request request,Response response);
	public void inputView(Request request,Response response);
	public void logic(Request request,Response response);
	public void outputView(Request request,Response response);
	
	
}
 