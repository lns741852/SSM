package com.jay.crud.bean;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.aspectj.weaver.patterns.ThisOrTargetPointcut;

import com.github.pagehelper.PageInfo;

public class Msg {

	private int code;
	
	private String msString;
	
	private Map<String, Object> extend = new HashMap<String, Object>();
	
	
	public static Msg success(){
		Msg result = new Msg();
		result.setCode(200);
		result.setMsString("成功");
		return result;
	}
	
	public static Msg fail(){
		Msg result = new Msg();
		result.setCode(100);
		result.setMsString("失敗");
		return result;
	}
	
	public Msg add(String key, Object value){
		this.getExtend().put(key,value);
		return this;
	}
	

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsString() {
		return msString;
	}

	public void setMsString(String msString) {
		this.msString = msString;
	}

	public Map<String, Object> getExtend() {
		return extend;
	}

	public void setExtend(Map<String, Object> extend) {
		this.extend = extend;
	}


	
}
