package by;

public class Constants {
	
	public static final String PROPERTIES_FILE = "database";
	public static final String DB_URL_PROP = "db.url";
	public static final String USER_PROP = "db.user";
	public static final String PASSWORD_PROP = "db.password";
	public static final String SELECT_QUERY = "select round(abs(x2-x1)) as len, count(*) as num from coordinates group by len order by num desc";
	public static final int LEN_COL = 1;
	public static final int NUM_COL = 2;
	public static final String DELETE_QUERY = "delete from frequencies";
	public static final String INSERT_QUERY = "insert into frequencies (len, num) values (?, ?)";
	public static final String SELECT_LEN_GR_NUM_QUERY = "select len, num from frequencies where len > num order by num desc";

	public static final String SQL_EXCEPTION_MESSAGE = "an error occurred while reading DB";
	
	public static final String DELIMITER = ";";
}
