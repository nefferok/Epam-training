package by.gsu.epamlab.model.implementation;

import by.gsu.epamlab.controller.ConstantsJSP;
import by.gsu.epamlab.model.interfaces.NumberDAO;
import by.gsu.epamlab.exceptions.InitException;

import javax.servlet.ServletConfig;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NumberImplDb implements NumberDAO {
    private final String url;
    private final String user;
    private final String pass;

    private List<Double> numbers = new ArrayList<>();

    public NumberImplDb(String param){
        final int URL_DB_NAME_IND = 0;
        final int USER_PARAM_IND = 1;
        final int PASS_PARAM_IND = 1;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String [] params = param.split(ConstantsJSP.SPLITTER);
            url = ConstantsJSP.DATA_BASE_PATH + params[URL_DB_NAME_IND];
            user = params[USER_PARAM_IND];
            pass = params[PASS_PARAM_IND];
        } catch (SQLException e) {
            throw new InitException(ConstantsJSP.EXCEPTION_DB_CONNECTION + e);
        }
    }

    @Override
    public List<Double> getNumbers() throws InitException {
        final int NUMBER_IND = 1;
        try (Connection cn = DriverManager.getConnection(url, user, pass);
             Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery(ConstantsJSP.SQL_SELECT_NUMBERS)){
            while(rs.next()){
                numbers.add(rs.getDouble(NUMBER_IND));
            }
            return numbers;
        } catch (SQLException e) {
            throw new InitException(ConstantsJSP.EXCEPTION_DB_READING + e);
        }
    }
}
