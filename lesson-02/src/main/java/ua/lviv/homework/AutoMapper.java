
package ua.lviv.homework;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AutoMapper {
	
	public static Vehicle map(ResultSet result) throws SQLException {
		int id = result.getInt("id");
		String manufacture = result.getString("manufacture");
		String model = result.getString("model");
		String color = result.getString("color");
		int year = result.getInt("year");
		
		return new Vehicle(id, manufacture, model, color, year);
	}

}
