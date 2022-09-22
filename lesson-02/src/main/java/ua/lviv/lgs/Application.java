package ua.lviv.lgs;

//import java.sql.Connection;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Application {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
//		Connection connection = ConnectionUtils.openConnection();
//		Statement statement = connection.createStatement();
//		ResultSet result = statement.executeQuery(READ_ALL);
		
//		while(result.next()) {
//		System.out.println(EmployeeMapper.map(result));
//		}
		
		EmployeeDao employeeDao = new EmployeeDao(ConnectionUtils.openConnection());
		
		//READ-ALL
		employeeDao.readAll().stream().forEach(System.out::println);
		System.out.println("*********************");
		
		List<Employee> listOfEmployee = new ArrayList<>();
		
		listOfEmployee.add(new Employee("Andrew","Teron"));
		listOfEmployee.add(new Employee("Bruce","Willis"));
		listOfEmployee.add(new Employee("Canibal","King"));
		listOfEmployee.add(new Employee("Daniel","Rossi"));
		listOfEmployee.add(new Employee("Enga","Still"));
		
		//INSERT	
//		listOfEmployee.forEach(employee->{
//			try {
//				employeeDao.insert(employee);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		});
//		
//		//READ-ALL
//		employeeDao.readAll().stream().forEach(System.out::println);
//		System.out.println("*********************");
		
		//READ-ById
		Employee employeeFromBD = employeeDao.read(2);
		System.out.println(employeeFromBD);
		System.out.println("*********************");
		
		//UPDATE-ById	
//		employeeFromBD.setLastName(employeeFromBD.getLastName()+"-DelordRossi");
//		employeeDao.update(employeeFromBD);
		
//		//READ-ById
//		employeeFromBD = employeeDao.read(2);
//		System.out.println(employeeFromBD);
		
		employeeDao.delete(6);
		
		//READ-ALL
		employeeDao.readAll().stream().forEach(System.out::println);
		System.out.println("*********************");
		
		
		
	}

}
