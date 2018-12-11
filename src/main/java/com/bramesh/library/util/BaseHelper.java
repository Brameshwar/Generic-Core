package com.bramesh.library.util;

public class BaseHelper {

	public CustomProperties properties;
	public DBUtil dbUtil;
	public DateUtil dateUtil;
	public APIUtil apiUtil;
	public ExcelUtil excelUtil;
	public CSVUtil csvUtil;
	public TestDataUtil testDataUtil;

	public BaseHelper(CustomProperties _properties, DBUtil _dbUtil, DateUtil _dateUtil, APIUtil _apiUtil, ExcelUtil _excelUtil, CSVUtil _csvUtil, TestDataUtil _testDataUtil) {
		properties = _properties;
		dbUtil = _dbUtil;
		dateUtil = _dateUtil;
		apiUtil = _apiUtil;
		excelUtil = _excelUtil;
		csvUtil = _csvUtil;
		testDataUtil = _testDataUtil;
	}
}
