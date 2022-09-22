package ua.lviv.homework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class VehicleDao {
	
	private static String READ_ALL = "select * from auto";
	private static String CREATE = "insert into auto(manufacture, model, color, year) values (?,?,?,?)";
	private static String READ_BY_ID = "select * from auto where id = ?";
	private static String READ_BY_MANUFACTURA = "select * from auto where manufacture like ?";
	private static String UPDATE_BY_ID = "update auto set manufacture = ?, model = ?, color = ?, year = ? where id = ?";
	private static String DELETE_BY_ID = "delete from auto where id =?";
	
	private Connection connection;
	private PreparedStatement ps = null;
	
	public VehicleDao(Connection connection) {
		this.connection = connection;
	}
	
	public PreparedStatement getPrepareStatement(String sql) {

		try {
			ps = connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;		
	}
	
	public List<Vehicle> readAll() throws SQLException {
		List<Vehicle> listOfAuto = new ArrayList<>();	
		getPrepareStatement(READ_ALL); 
		ResultSet result = ps.executeQuery();

		while(result.next()) {
			listOfAuto.add(AutoMapper.map(result));		
		}
		return listOfAuto;
	}
	
	public void insert(Vehicle auto) throws SQLException {
		getPrepareStatement(CREATE);   
		ps.setString(1, auto.getManufacture());
		ps.setString(2, auto.getModel());
		ps.setString(3, auto.getColor());
		ps.setInt(4, auto.getYear());
		ps.executeUpdate();
	}
	
	public Vehicle readId(int id) throws SQLException {
		ps = connection.prepareStatement(READ_BY_ID);		
		ps.setInt(1, id);	
		ResultSet result = ps.executeQuery();
		result.next();
		return AutoMapper.map(result);
	}
	
	public Vehicle readManufacture(String manufacture) throws SQLException {
		ps = connection.prepareStatement(READ_BY_MANUFACTURA);		
		ps.setString(1, manufacture);	
		ResultSet result = ps.executeQuery();
		result.next();
		return AutoMapper.map(result);
	}	
	
	public void update(Vehicle auto) throws SQLException {
		ps = connection.prepareStatement(UPDATE_BY_ID);	

		ps.setString(1, auto.getManufacture());
		ps.setString(2, auto.getModel());
		ps.setString(3, auto.getColor());
		ps.setInt(4, auto.getYear());
		ps.setInt(5, auto.getId());

		ps.executeUpdate();
	}
	
	
	public void delete(int id) throws SQLException {
		ps = connection.prepareStatement(DELETE_BY_ID);
		ps.setInt(1, id);
		ps.executeUpdate();		
	}
	

}
