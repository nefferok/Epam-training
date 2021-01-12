package by.gsu.epamlab.controller;

public class ConstantsJSP {
	public static final String DATA_BASE_PATH = "jdbc:mysql://127.0.0.1:3306/";
	public static final String SPLITTER = ";";

	public static final double MAX_NUMBER_VALUE = 1000;
	public static final double MIN_NUMBER_VALUE = -1000;

	public static final String EXCEPTION_FEW_NUMBER = "Few numbers found...";
	public static final String EXCEPTION_READ_CSV = "Error while reading csv...";
	public static final String EXCEPTION_DB_CONNECTION = "Error while reading csv...";
	public static final String EXCEPTION_DB_READING = "Error during reading DataBase...";

	public static final String CONTROLLER_MIN_SIZE = "min.size";
	public static final String CONTROLLER_MIN_VALUE = "12";
	public static final String CONTROLLER_FACTORY = "factory.number";
	public static final String CONTROLLER_MEMORY_PARAM = "memory";
	public static final String CONTROLLER_CSV_PARAM = "csv;\\resources\\numbers.csv";
	public static final String CONTROLLER_DB_PARAM = "db;mvcStat2;epamlab;111";

	public static final String SQL_SELECT_NUMBERS ="select number from mvcstat2";

	public static final String PROPERTIES_PATH = "resourses/in";
	public static final String PROPERTIES_CSV_PATH = "csv.path";
	public static final String PROPERIES_DB_DRIVER = "db.driver";
    public static final String PROPERIES_DB_URL = "db.url";
	public static final String PROPERIES_USER_NAME = "db.user";
	public static final String PROPERTIES_PASSWORD = "db.password";

	public static final String REAL_PATH = "/WEB-INF";
	public final static String OPERATION_NAME = "operation";
	public final static String STAT_NAME = "stats";
	public final static String NUMBER_NAME = "number";
	public final static String RESULT_NAME = "result";
	public final static String NUMBERS_NAME = "numbers";
	public final static String MAX_VALUE_NAME = "maxValue";
	
	public final static String START_PAGE_URL = "/start.jsp";
	public final static String RESULT_PAGE_URL = "/result.jsp";
}
