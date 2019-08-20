package com.ac.mylib.constants;

/**
 * @Description Constant-Class for NtkService
 * @Author Created by Echo on 2018/04/20
 */
public class TestConstants {

	public static final String NO_CACHE_TO_CLEAN = "没有缓存清除";
	public static final String BREAKDOWN_LEVEL_TWO_CACHE = "击穿二级缓存";
	
	/**
	 * The Sets of return-result including return_msg, return_data and return_state
	 */
	public static final String RETURN_MSG = "return_msg";
	public static final String RETURN_DATA = "return_data";
	public static final String RETURN_STATE = "return_state";
	
	/**
	 * The sets of return sate:  SUCCESS|FAIL
	 */
	public static final String RETURN_STATE_SUCCESS = "SUCCESS";
	public static final String RETURN_STATE_FAIL = "FAIL";
	
	/**
	 * Message for return_msg
	 */
	public static final String EMPTY_STRING = "";
	public static final String SERVICE_EXCEPTION = "服务异常...";
	public static final String NOT_FOUND_THE_COMMODITY = "未找到该商品";

	/**
	 * Utility classes should not have public constructors
	 */
	private TestConstants() {
	}

}
