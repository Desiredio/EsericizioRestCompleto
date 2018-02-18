package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Utente;

public class DAOUtente {

	private static final String SELECT_ALL_UTENTE = "SELECT * FROM UTENTE";
	private static final String DELETE_UTENTE = "DELETE FROM UTENTE WHERE idUtente= ?";
	private static final String INSERT_UTENTE = "INSERT INTO UTENTE (nome,cognome) VALUES(?,?)";
	private static final String PUT_UTENTE = "UPDATE utente SET nome = ? WHERE  idutente=?";

	public static List<Utente> getListaUtente() {
		ArrayList<Utente> utenti = new ArrayList<Utente>();
		try {
			Connection c = Connessione.getConnection();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(SELECT_ALL_UTENTE);

			while (rs.next()) {

				Utente utente = new Utente();

				utente.setIdUtente(Integer.parseInt(rs.getString(1)));
				utente.setNome(rs.getString(2));
				utente.setCognome(rs.getString(3));
				utenti.add(utente);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return utenti;
	}

	public static void cancUtente(int idUtenteDaCanc) {

		PreparedStatement pS = null;

		try {
			Connection c = Connessione.getConnection();
			pS = c.prepareStatement(DELETE_UTENTE);
			pS.setInt(1, idUtenteDaCanc);
			pS.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public static void insUtente(String nome, String cognome) {
		PreparedStatement ps = null;
		try {
			Connection c = Connessione.getConnection();
			ps = c.prepareStatement(INSERT_UTENTE);
			ps.setString(1, nome);
			ps.setString(2, cognome);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void putUtente(int id, String nome) {
		PreparedStatement pS = null;
		try {
			Connection c = Connessione.getConnection();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(SELECT_ALL_UTENTE);

			while (rs.next()) {
				Utente utente = new Utente();
				utente.setIdUtente(Integer.parseInt(rs.getString(1)));
				utente.setNome(rs.getString(2));
				utente.setCognome(rs.getString(3));

				if (utente.getIdUtente() == id) {
					pS = c.prepareStatement(PUT_UTENTE);
					pS.setString(1, nome);
					pS.setInt(2, id);
					pS.executeUpdate();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
