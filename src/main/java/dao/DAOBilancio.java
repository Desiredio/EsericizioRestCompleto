package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import model.Bilancio;

public class DAOBilancio {

	private static final String SELECT_ALL_BILANCIO = "SELECT * FROM BILANCIO";

	public static List<Bilancio> getListaBilancio() throws ParseException {
		ArrayList<Bilancio> bilanci = new ArrayList<Bilancio>();

		try (
				Connection c= Connessione.getConnection();
				Statement st = c.createStatement();
				ResultSet rs = st.executeQuery(SELECT_ALL_BILANCIO)) {

			while (rs.next()) {

				Bilancio bilancio = new Bilancio();

				bilancio.setIdBilancio(Integer.parseInt(rs.getString(1)));
				bilancio.setImporto(Float.parseFloat(rs.getString(3)));
				bilancio.setMotivospesa(rs.getString(4));
				bilancio.setData(rs.getString(5));
				bilanci.add(bilancio);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bilanci;
	}

}
