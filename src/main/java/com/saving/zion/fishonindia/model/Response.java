package com.saving.zion.fishonindia.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;

public class Response {

	private ErrorRes err;
	private String createdAt;
	private long responseTimeInMilis;
	private int resCode;
	private Object payLoad;

	public Response() {
	};

	public Response(long resTime, int resCode) {
		this.resCode = resCode;
		this.responseTimeInMilis = resTime;
		this.payLoad = new JSONArray();
		this.err = new ErrorRes();
		this.createdAt = new Date().toString();
	}

	public Response(long resTime, int resCode, Object payLoad) {
		this.resCode = resCode;
		this.responseTimeInMilis = resTime;
		this.payLoad = payLoad == null ? new ArrayList<Object>() : payLoad;
		this.err = new ErrorRes();
		this.createdAt = new Date().toString();
	}

	public Response(long resTime, int resCode, Object payLoad, ErrorRes err) {
		this.resCode = resCode;
		this.responseTimeInMilis = resTime;
		this.payLoad = payLoad == null ? new ArrayList<Object>() : payLoad;
		this.err = err;
		this.createdAt = new Date().toString();
	}

	public Response(long resTime, int resCode, Object payLoad, boolean isError, List<String> msg) {
		this.resCode = resCode;
		this.responseTimeInMilis = resTime;
		this.payLoad = payLoad == null ? new ArrayList<Object>() : payLoad;
		this.err = new ErrorRes(isError, msg);
		this.createdAt = new Date().toString();
	}

	public ErrorRes getErr() {
		return err;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public long getResponseTimeInMilis() {
		return responseTimeInMilis;
	}

	public int getResCode() {
		return resCode;
	}

	public Object getPayLoad() {
		return payLoad;
	}

	public void setErr(ErrorRes err) {
		this.err = err;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public void setResponseTimeInMilis(long responseTimeInMilis) {
		this.responseTimeInMilis = responseTimeInMilis;
	}

	public void setResCode(int resCode) {
		this.resCode = resCode;
	}

	public void setPayLoad(Object payLoad) {
		this.payLoad = payLoad;
	}

	@Override
	public String toString() {
		return "Response [err=" + err + ", createdAt=" + createdAt + ", responseTimeInMilis=" + responseTimeInMilis
				+ ", resCode=" + resCode + ", payLoad=" + payLoad + "]";
	}
}
