package by.gsu.epamlab.controller;

public class ConstantsJSP {
	public static final String DATA_BASE_PATH = "jdbc:mysql://127.0.0.1:3306/";
	public static final String SPLITTER = ";";

	public static final String EXCEPTION_FEW_NUMBER = "Few numbers found...";
	public static final String EXCEPTION_READ_CSV = "Error while reading csv...";
	public static final String EXCEPTION_DB_CONNECTION = "Error while reading csv...";
	public static final String EXCEPTION_DB_READING = "Error during reading DataBase...";

	public static final String CONTROLLER_MIN_SIZE = "min.size";
	public static final String CONTROLLER_MIN_VALUE = "12";
	public static final String CONTROLLER_FACTORY = "factory.number";
	public static final String CONTROLLER_MEMORY_PARAM = "memory";
	public static final String CONTROLLER_CSV_PARAM = "csv;C:\\Epam\\jsStat2\\WebContent\\WEB-INF\\resources\\numbers.csv";
	public static final String CONTROLLER_DB_PARAM = "db;mvcStat2;epamlab;111";

	public static final String SQL_SELECT_NUMBERS ="select number from mvcstat2";


	public static final String REAL_PATH = "/WEB-INF";
	public final static String STAT_NAME = "StatController";
	public final static String STAT_URL = "/stat";

}
