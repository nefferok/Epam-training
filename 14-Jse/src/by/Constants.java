package by;

public class Constants {
    public static final String PROPERTIES_FILE = "resourses/properties/database";
    public static final String PROPERIES_DB_URL = "db.url";
    public static final String PROPERIES_USER_NAME = "db.user";
    public static final String PROPERTIES_PASSWORD = "db.password";

    public static final int INDEX_NAME_COLUMN = 1;
    public static final int INDEX_TEST_COLUMN = 2;
    public static final int INDEX_DATE_COLUMN = 3;
    public static final int INDEX_MARK_COLUMN = 4;
    public static final int INDEX_MEAN_COLUMN = 2;
    public static final int ID_INDEX = 1;
    public static final int NAME_IND = 0;
    public static final int TEST_IND = 1;
    public static final int DATE_IND = 2;
    public static final int MARK_IND = 3;

    public final static String SQL_DELETE_RESULTS = "DELETE FROM results";
    public final static String SQL_DELETE_LOGINS = "DELETE FROM logins";
    public final static String SQL_DELETE_TESTS = "DELETE FROM results.tests";

    public static final String SQL_SELECT_ID_LOGIN = "SELECT results.logins.idLogins from results.logins where name=?";
    public static final String SQL_SELECT_ID_TEST = "SELECT results.tests.idTests from results.tests where name=?";
    public static final String SQL_INSERT_LOGINS ="insert ignore into results.logins (name) values (?)";
    public static final String SQL_INSERT_TESTS = "insert ignore into results.tests (name) values (?)";
    public static final String SQL_INSERT_RESULTS = "insert into results.results (loginId, testId, date, mark) values (?, ?, ?, ?)";

    public static final String SQL_SELECT_MEAN_MARK = "select name as login, avg(mark) as mean\n" +
            "from logins\n" +
            "join results\n" +
            "on loginId = idLogins\n" +
            "group by name;";
    public static final String SQL_SELECT_SORT_MARK_IN_MONTH = "select logins.name,tests.name, date, mark\n" +
            "from results\n" +
            "join tests\n" +
            "on idTests = testId\n" +
            "join logins\n" +
            "on loginId = idLogins\n" +
            "where MONTH(date) = MONTH(NOW()) and YEAR(date) = YEAR(NOW())\n" +
            "order by DAY(date)";

    public static final String DELIMITER = ";";
    public static final String ARROW = " => ";
    public static final String SPLITTER = "\\.";
    public static final String OUT_PATTERN = "%.2f";

    public static final String EXCEPTION_DB_BODY = ". Cause: ";
    public static final String EXCEPTION_DATA_HEAD = "Illegal argument: ";
    public static final String EXCEPTION_DATA_BODY = ", caused: ";
    public static final String EXCEPTION_CREATE_CONNECTION = "Erroк while creating connection";
    public static final String EXCEPTION_SEARC_MEAN = "Error while finding the mean value";
    public static final String EXCEPTION_LOAD_LIST = "Error while loading into list";
    public static final String EXCEPTION_LOAD_BASE = "Error while loding into DataBase";
    public static final String EXCEPTION_SAX_CREATE = "Error whille creating SAX parse";
    public static final String EXCEPTION_CLOSE_CONNECTION ="Error while closing connection";
    public static final String EXCEPTION_CLOSE_RESULT_SET ="Error while closing result set";
    public static final String EXCEPTION_CLOSE_STATEMENT ="Error while closing statement";
    public static final String EXCEPTION_SCANNER_CREATE = "File wasn't found";
    public static final String NOT_FOUND_ELEMENT = "No exams in the current month";

}
