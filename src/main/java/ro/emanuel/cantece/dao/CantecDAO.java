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
}
