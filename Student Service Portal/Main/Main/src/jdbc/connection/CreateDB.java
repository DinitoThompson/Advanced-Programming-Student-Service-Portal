package jdbc.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDB {
private Connection dbConn = null;
	
	public CreateDB(Connection dbConn){
		this.dbConn = dbConn;				
	}
	// DINITO ADD THE FOREIGN KEY CONSTRAINTS !!!!! - SINCERLY SHAN
	
	   public boolean createDataBaseAndTable() {
		String dbSql = "CREATE DATABASE student_services_portal";
		String useSql = "USE student_services_portal";
		String tableSql = "CREATE TABLE student_services_portal.`student` ( "
				+ "`student_id` INT(7) NOT NULL AUTO_INCREMENT , "
				+ "`student_first_name` VARCHAR(20) NOT NULL , "
				+ "`student_last_name` VARCHAR(25) NOT NULL , "
				+ "`student_email` VARCHAR(30) NOT NULL , "
				+ "`student_password` VARCHAR(60) NOT NULL  , "
				+ "PRIMARY KEY (`student_id`)) ENGINE = InnoDB";
		
		String StaffSql = "CREATE TABLE student_services_portal.`staff` ( "
				+ "`staff_id` INT(7) NOT NULL AUTO_INCREMENT , "
				+ "`staff_first_name` VARCHAR(20) NOT NULL , "
				+ "`staff_last_name` VARCHAR(25) NOT NULL , "
				+ "`staff_email` VARCHAR(30) NOT NULL , "
				+ "`staff_password` VARCHAR(60) NOT NULL ' , "
				+ "PRIMARY KEY (`staff_id`)) ENGINE = InnoDB";
		
		String Student_ContSql = "CREATE TABLE student_services_portal.`student_contact` ( "
				+ "`student_id` INT, "
				+ "`student_contact_number` VARCHAR(20) NOT NULL DEFAULT \'0(876) 000-0000\', "
				+ "PRIMARY KEY (`student_id`, `student_contact_number`)) ENGINE = InnoDB";
		
		String Staff_ContSql = "CREATE TABLE student_services_portal.`staff_contact` ( "
				+ "`staff_id` INT(7) , "
				+ "`staff_contact_number` VARCHAR(20) NOT NULL DEFAULT \'0(876) 000-0000\', "
				+ "PRIMARY KEY (`staff_id`, `staff_contact_number`))  ENGINE = InnoDB";
		
		String EnquirySql = "CREATE TABLE student_services_portal.`enquiry` ( "
				+ "`student_id` INT NOT NULL  , "
				+ "`enquiry_id` Int(7) NOT NULL AUTO_INCREMENT, "
				+ "`enquiry_nature` VARCHAR(20) NOT NULL , "
				+ "`enquiry_complaint` VARCHAR(20) NOT NULL , "
				+ "`enquiry_detail` VARCHAR(150) NOT NULL ' , "
				+ "`enquiry_urgency` INT NOT NULL  , "
				+ "`enquiry_date`  DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP, "
				+ "`enquiry_state` VARCHAR(20) NOT NULL , "
				+ "PRIMARY KEY (`enquiry_id`)) ENGINE = InnoDB";
		
		String Response1Sql = "CREATE TABLE student_services_portal.`respond` ( "

			    + "	`enquiry_id` Int NOT NULL , "
			    + "	`staff_id` INT NOT NULL , "
			    + "	`respond_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP , "
			    + "	PRIMARY KEY (`enquiry_id`, `staff_id`)) ENGINE = InnoDB";

		

		
		Statement stmt;
		try {
			stmt = (Statement) dbConn.createStatement();
			stmt.execute(dbSql, 0);
			stmt.execute(useSql, 0);
			stmt.execute(tableSql, 0);
			stmt = (Statement) dbConn.createStatement();
			stmt.execute(StaffSql,0);
			stmt.execute(Student_ContSql, 0);
			stmt.execute(Staff_ContSql, 0);
			stmt.execute(EnquirySql, 0);
			stmt.execute(Response1Sql, 0);
			//If the program comes here database and table creation went well
			System.out.println("created successfully");
			return true;
		} catch (SQLException e) {			
			//System.out.println("SQLException: " + e.getMessage());
			return false;
		}			
	}
}
