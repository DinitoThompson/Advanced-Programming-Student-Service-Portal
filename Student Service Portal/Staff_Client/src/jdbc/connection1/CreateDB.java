package jdbc.connection1;

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

		String createDatabase = "Create Database student_services_portal"; 
		String useDatabase = "Use student_services_portal";  

		String StudentTable = 
		"CREATE TABLE student ( \r\n" + 
		"		student_id INT NOT NULL, \r\n" + 
		"		student_first_name VARCHAR(20), \r\n" + 
		"		student_last_name VARCHAR(20), \r\n" + 
		"		student_email VARCHAR(30), \r\n" + 
		"		student_password VARCHAR(30), \r\n" + 
		"		PRIMARY KEY (student_id));";

		String StudentContactTable = 
		"CREATE TABLE student_contact \r\n" + 
		"		(\r\n" + 
		"		student_id INT NOT NULL, \r\n" + 
		"		student_contact_number VARCHAR(20), \r\n" + 
		"		FOREIGN KEY (student_id)\r\n" + 
		"		REFERENCES student (student_id),\r\n" + 
		"		PRIMARY KEY (student_id, student_contact_number));\r\n"; 

		String EnquiryTable = 
		"CREATE TABLE enquiry ( \r\n" + 
		"		student_id INT, \r\n" + 
		"		enquiry_id INT(7) NOT NULL AUTO_INCREMENT,\r\n" + 
		"		enquiry_nature VARCHAR(20), \r\n" + 
		"		enquiry_complaint VARCHAR(20),\r\n" + 
		"		enquiry_detail VARCHAR(150), \r\n" + 
		"		enquiry_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,\r\n" + 
		"		enquiry_state VARCHAR(20) DEFAULT 'Unresolved', \r\n" + 
		"		FOREIGN KEY (student_id)\r\n" + 
		"		REFERENCES Student (student_id), \r\n" + 
		"		PRIMARY KEY(enquiry_id));";
		
		String EnquiryResponseTable = 
		"CREATE TABLE enquiry_response ( \r\n" + 
		"		enquiry_id INT(7) NOT NULL, \r\n" + 
		"		enquiry_response VARCHAR(50), \r\n" + 
		"		enquiry_response_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP, \r\n" + 
		"		FOREIGN KEY (enquiry_id)\r\n" + 
		"		REFERENCES Enquiry (enquiry_id),\r\n" + 
		"		PRIMARY KEY (enquiry_id, enquiry_response_date));";

		String StaffTable = 
		"CREATE TABLE staff ( \r\n" + 
		"		staff_id INT(7),\r\n" + 
		"		staff_first_name VARCHAR(20), \r\n" + 
		"		staff_last_name VARCHAR(20), \r\n" + 
		"		staff_email VARCHAR(30),  \r\n" + 
		"		staff_password VARCHAR(30),\r\n" + 
		"		PRIMARY KEY(staff_id));";

		String StaffContactTable = 
		"CREATE TABLE staff_contact ( \r\n" + 
		"		staff_id INT(7), \r\n" + 
		"		staff_contact_number VARCHAR(20), \r\n" + 
		"		FOREIGN KEY (staff_id)\r\n" + 
		"		REFERENCES Staff (staff_id),\r\n" + 
		"		PRIMARY KEY (staff_id, staff_contact_number));";
		
		String StaffRespond = 
		"CREATE TABLE respond ( \r\n" + 
		"		enquiry_id INT,\r\n" + 
		"		staff_id INT, \r\n" + 
		"		respond_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,\r\n" + 
		"		FOREIGN KEY (enquiry_id)\r\n" + 
		"		REFERENCES Enquiry(enquiry_id), \r\n" + 
		"		FOREIGN KEY (staff_id)\r\n" + 
		"		REFERENCES Staff(staff_id),\r\n" + 
		"		PRIMARY KEY (enquiry_id, staff_id, respond_date));";

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
			stmt.execute(StaffRespond, 0); 
			
			//If the program comes here database and table creation went well
			System.out.println("Database Created...");
			return true;
		} catch (SQLException e) {			
			System.out.println("SQLException: " + e.getMessage());
			return false;
		}			
	}
}
