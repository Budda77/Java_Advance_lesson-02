/*
 * LOGOS It Academy home work 02
 * 
 *  * @author Oleksandr
 * */

package ua.lviv.homework;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		VehicleDao autoDao = new VehicleDao(ConnectionUtils.openConnection());
		
		//READ-ALL
		autoDao.readAll().stream().forEach(System.out::println);
//		
//		List<Vehicle> listOfAuto = new ArrayList<>();
//		listOfAuto.add(new Vehicle("Mercedes","CLA Shooting Brake","red", 2019));
//		listOfAuto.add(new Vehicle("Mercedes","R129 SL-Class","red", 1980));
//		listOfAuto.add(new Vehicle("Mercedes","W901 Sprinter","white", 1993));
//		listOfAuto.add(new Vehicle("Toyota","Camry","white", 1997));
//		listOfAuto.add(new Vehicle("Toyota","ALLION","black", 1980));
//		listOfAuto.add(new Vehicle("Toyota","Surpa","oring", 2003));
//		listOfAuto.add(new Vehicle("Renault","Megane","silver", 1995));
//		listOfAuto.add(new Vehicle("Nissan","GTR","blue", 2007));
//		listOfAuto.add(new Vehicle("Mazda","CX-9","green", 2009));
//		listOfAuto.add(new Vehicle("Mazda","RX-7","black", 1993));
//		listOfAuto.add(new Vehicle("Ford","Mustang","red", 1968));
		
		//INSERT	
		System.out.println("_____INSERT DATA_____");
		
//		listOfAuto.forEach(auto->{
//			try {
//				autoDao.insert(auto);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		});
		
		//READ-ALL
		autoDao.readAll().stream().forEach(System.out::println);
		
		//READ-BY-ID
		
		System.out.println("_____READ-BY-ID_____");	

		Vehicle autoFromBD = autoDao.readId(1);		
		System.out.println(autoFromBD);
		System.out.println("____________________");
		
		System.out.println("_____READ-BY-MANUFACTURE_____");	
		
		autoFromBD = autoDao.readManufacture("Toyota");	
		System.out.println(autoFromBD);
		System.out.println("____________________");
		
		//UPDATE_BY_ID
		System.out.println("_____UPDATE_BY_ID_____");
		autoFromBD.setId(1);
		autoFromBD.setManufacture("Ford");
		autoFromBD.setModel("Shelby");
		autoFromBD.setColor("yellow");
		autoFromBD.setYear(2020);
		
		autoDao.update(autoFromBD);
		
		
		//READ-ALL
		autoDao.readAll().stream().forEach(System.out::println);
		
		//DELETE	
		System.out.println("_____AFTER DELETE_____");
		autoDao.delete(7);

		
		//READ-ALL
		autoDao.readAll().stream().forEach(System.out::println);
		
		
	}

}
