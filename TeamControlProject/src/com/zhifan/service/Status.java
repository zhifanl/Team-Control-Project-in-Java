package com.zhifan.service;
/**
 * @Description status of worker
 * @author lizhifan
 * @version 1.0
 * @since 1.0	
 */
//This can be replaced by using enum
public class Status {
	private final String NAME;
	//use a private constructor
	private Status(String name) {
		this.NAME = name;
	}
	public static final Status FREE = new Status("FREE");
	public static final Status VOCATION = new Status("VOCATION");
	public static final Status BUSY = new Status("BUSY");
	public String getNAME() {
		return NAME;
	}
	@Override
	public String toString() {
		return NAME;
	}
}
