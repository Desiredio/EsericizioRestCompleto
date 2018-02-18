package dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Connessione {

	private static Connection conn;
	

	private Connessione() {	
	}

	public static synchronized Connection getConnection() {
		if (conn == null) {
			try {
				Context ctx = new InitialContext();
				DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/rest_bilancio_familiare");
				conn = ds.getConnection();

			} catch (NamingException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return conn;

	}
}
