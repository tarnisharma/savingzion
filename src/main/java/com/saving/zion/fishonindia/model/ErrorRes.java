package com.saving.zion.fishonindia.model;

import java.util.ArrayList;
import java.util.List;

public class ErrorRes {

	private boolean isError = false;
	private List<String> msg = new ArrayList<String>();
	
	public ErrorRes() {}
	
	public ErrorRes(boolean isError, List<String> msg) {
		this.isError = isError;
		this.msg = msg;
	}
	public boolean isError() {
		return isError;
	}
	public List<String> getMsg() {
		return msg;
	}
	public void setError(boolean isError) {
		this.isError = isError;
	}
	public void setMsg(List<String> msg) {
		this.msg = msg;
	}
}
