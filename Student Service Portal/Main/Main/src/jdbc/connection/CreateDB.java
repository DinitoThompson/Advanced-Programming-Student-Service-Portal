package jdbc.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDB {
private Connection dbConn = null;
	
	public CreateDB(Connection dbConn){
		this.dbConn = dbConn;				
	}
	// Shanice: DINITO ADD THE FOREIGN KEY CONSTRAINTS !!!!! - SINCERLY SHAN
	// Dinito: DONE, THIS SHOULD WORK WELL (^_^)
	
	   public boolean createDataBaseAndTable() {
		String createDatabase = "CREATE DATABASE student_services_portal";
		String useDatabase = "USE student_services_portal";
		
		String StudentTable = 
			"CREATE TABLE student_services_portal.student ( "
			+ "student_id INT(7) NOT NULL AUTO_INCREMENT , "
			+ "student_first_name VARCHAR(20) NOT NULL , "
			+ "student_last_name VARCHAR(25) NOT NULL , "
			+ "student_email VARCHAR(30) NOT NULL , "
			+ "student_password VARCHAR(60) NOT NULL  , "
			+ "PRIMARY KEY (student_id)) ENGINE = InnoDB";

		String StudentContactTable = 
			"CREATE TABLE student_services_portal.student_contact ( "
			+ "student_id INT(7) NOT NULL, "
			+ "student_contact_number VARCHAR(20) NOT NULL DEFAULT \'0(876) 000-0000\', "
			+ "CONSTRAINT fk_student_id"
			+ "FOREIGN KEY (student_id)"
			+ "REFERENCES Student (student_id)"
			+ "PRIMARY KEY (student_id, student_contact_number)) ENGINE = InnoDB";

		String StaffTable = 
			"CREATE TABLE student_services_portal.staff ( "
			+ "staff_id INT(7) NOT NULL AUTO_INCREMENT , "
			+ "staff_first_name VARCHAR(20) NOT NULL , "
			+ "staff_last_name VARCHAR(20) NOT NULL , "
			+ "staff_email VARCHAR(30) NOT NULL , "
			+ "staff_password VARCHAR(60) NOT NULL ' , "
			+ "PRIMARY KEY (staff_id)) ENGINE = InnoDB";

		String StaffContactTable = 
			"CREATE TABLE student_services_portal.staff_contact ( "
			+ "staff_id INT(7) NOT NULL, "
			+ "staff_contact_number VARCHAR(20) NOT NULL DEFAULT \'0(876) 000-0000\', "
			+ "CONSTRAINT fk_staff_id"
			+ "FOREIGN KEY (staff_id)"
			+ "REFERENCES Staff (staff_id)"
			+ "PRIMARY KEY (staff_id, staff_contact_number))  ENGINE = InnoDB";
	
		String EnquiryTable = 
			"CREATE TABLE student_services_portal.enquiry ( "
			+ "student_id INT(7) NOT NULL  , "
			+ "enquiry_id Int(7) NOT NULL AUTO_INCREMENT, "
			+ "enquiry_nature VARCHAR(20) NOT NULL , "
			+ "enquiry_complaint VARCHAR(20) NOT NULL , "
			+ "enquiry_detail VARCHAR(150) NOT NULL ' , "
			+ "enquiry_urgency INT NOT NULL  , "
			+ "enquiry_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP, "
			+ "enquiry_state VARCHAR(20) DEFAULT 'Unresolved' , "
			+ "CONSTRAINT fk_student_id"
			+ "FOREIGN KEY (student_id)"
			+ "REFERENCES Student (student_id)"
			+ "PRIMARY KEY (enquiry_id)) ENGINE = InnoDB";
		
		String EnquiryResponseTable = 
			"CREATE TABLE student_services_portal.respond ( "
			+ "enquiry_id INT(7) NOT NULL , "
			+ "staff_id INT(7) NOT NULL , "
			+ "respond_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP , "
			+ "FOREIGN KEY (enquiry_id)"
			+ "REFERENCES enquiry(enquiry_id)"
			+ "FOREIGN KEY (staff_id)"
			+ "REFERENCES staff(staff_id)"
			+ "PRIMARY KEY (enquiry_id, staff_id)) ENGINE = InnoDB";

		Statement stmt;
		try {
			stmt = (Statement) dbConn.createStatement();
			stmt.execute(createDatabase, 0);
			stmt.execute(useDatabase, 0);
			stmt.execute(StudentTable, 0);
			stmt.execute(StudentContactTable, 0);
			stmt.execute(StaffTable,0);
			stmt.execute(StaffContactTable, 0);
			stmt.execute(EnquiryTable, 0);
			stmt.execute(EnquiryResponseTable, 0);
			
			//If the program comes here database and table creation went well
			System.out.println("Database Created...");
			return true;
		} catch (SQLException e) {			
			System.out.println("SQLException: " + e.getMessage());
			return false;
		}			
	}
}
