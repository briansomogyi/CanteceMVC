package ro.emanuel.cantece.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ro.emanuel.cantece.helper.DataBaseHelper;
import ro.emanuel.cantece.pojo.Cantec;

public class CantecDAO {
	public static Cantec getById(int id) throws SQLException, ClassNotFoundException {
		Connection connection = DataBaseHelper.getConnection();
		String query = "select * from cantec where id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);

		ResultSet resultSet = preparedStatement.executeQuery();
		Cantec cantec = null;
		if (resultSet.next())
			cantec = new Cantec(resultSet.getInt("id"), resultSet.getString("titlu"), resultSet.getString("autor"),
					resultSet.getString("linkPartitura"), resultSet.getString("versuri"), resultSet.getInt("nrVoturi"));
		DataBaseHelper.closeConnection();
		return cantec;

	}

	public static List<Cantec> getAll() throws SQLException, ClassNotFoundException {
		Connection connection = DataBaseHelper.getConnection();
		String query = "select * from cantec";
		Statement statement = connection.createStatement();

		ResultSet resultSet = statement.executeQuery(query);
		List<Cantec> cantece = new ArrayList<Cantec>();
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String titlu = resultSet.getString("titlu");
			String autor = resultSet.getString("autor");
			String linkPartitura = resultSet.getString("linkPartitura");
			String versuri = resultSet.getString("versuri");
			int nrVoturi = resultSet.getInt("nrVoturi");
			cantece.add(new Cantec(id, titlu, autor, linkPartitura, versuri, nrVoturi));
		}
		DataBaseHelper.closeConnection();
		return cantece;

	}

	public static void update(Cantec cantec) throws ClassNotFoundException, SQLException {
		// Conexiune
		Connection connection = DataBaseHelper.getConnection();

		// Update
		String query = "update cantec set titlu=?, autor=?, linkPartitura=?, versuri=?, nrVoturi=? where id=?";

		// Prepared statement
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, cantec.getTitle());
		preparedStatement.setString(2, cantec.getAuthor());
		preparedStatement.setString(3, cantec.getScoreLink());
		preparedStatement.setString(4, cantec.getLyrics());
		preparedStatement.setInt(5, cantec.getNumberOfVotes());
		preparedStatement.setInt(6, cantec.getId());

		// Execute statement
		preparedStatement.executeUpdate();

		DataBaseHelper.closeConnection();

	}

	public static void create(Cantec c) throws ClassNotFoundException, SQLException {
		String create = "insert into cantec(titlu,autor,linkPartitura,versuri,nrVoturi) values (?,?,?,?,?)";
		Connection connection = DataBaseHelper.getConnection();
		PreparedStatement statement = connection.prepareStatement(create);
		statement.setString(1, c.getTitle());
		statement.setString(2, c.getAuthor());
		statement.setString(3, c.getScoreLink());
		statement.setString(4, c.getLyrics());
		statement.setInt(5, c.getNumberOfVotes());
		statement.executeUpdate();
		DataBaseHelper.closeConnection();
	}

	public static void delete(int id) throws ClassNotFoundException, SQLException {
		String query = "delete from cantec where id=" + id;
		Connection connection = DataBaseHelper.getConnection();
		Statement statement = connection.createStatement();
		statement.executeUpdate(query);
		DataBaseHelper.closeConnection();
	}

}
