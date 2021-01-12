import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.gsu.epamlab.beans.SegmentCounter;
import by.gsu.epamlab.connectors.ConnectorDB;

import static by.Constants.*;

public class Runner {
	public static void main(String[] args) {
		try (Connection cn = ConnectorDB.getConnection();
				Statement st = cn.createStatement();
				PreparedStatement ps = cn.prepareStatement(INSERT_QUERY)) {
			
			
			// Create list using SQL query
			List<SegmentCounter> list = new ArrayList<>();
			try(ResultSet rs = st.executeQuery(SELECT_QUERY)) {
				while (rs.next()) {
					SegmentCounter seg = new SegmentCounter(rs.getInt(LEN_COL), rs.getInt(NUM_COL));
					list.add(seg);
					System.out.println(seg);
				}
			}

			// Clean the table
			st.executeUpdate(DELETE_QUERY);

			// Insert data in table;
			for (SegmentCounter e : list) {
				ps.setInt(LEN_COL, e.getLen());
				ps.setInt(NUM_COL, e.getNum());
				ps.addBatch();
			}
			ps.executeBatch();

			// find the records where len>num
			System.out.println();
			try(ResultSet rs = st.executeQuery(SELECT_LEN_GR_NUM_QUERY)){
				while (rs.next()) {
					System.out.println(rs.getInt(LEN_COL) + DELIMITER + rs.getInt(NUM_COL));
				}
			}
		} catch (SQLException e) {
			System.err.println(SQL_EXCEPTION_MESSAGE + e);
		}
	}}
