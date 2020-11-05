package jdbc.connection;

import java.sql.*;
import javax.swing.JButton;

public class SQLProvider 
{
	private Connection dbConn = null;
	private Statement stmt = null;
	private ResultSet result = null;
	private PreparedStatement prepStmt = null;
	private boolean numOfAffectedRows = 0;
	
	public SQLProvider(Connection dbConn)
	{
		this.dbConn = dbConn;
	}
	
	public void SignUp(JButton btnNewButton)
	{
		switch()
		{
			case:
				
				break;
		}
	}
	
	public Login()
	{
		switch(staff or student)
	}
	
	//	STUDENT FUNCTIONS
	public void StudentDashboardEnquiryList(int id)//FIND OUT IF CLASS IS NEEDED
	{
		String selectSQL = "SELECT * FROM Enquiry WHERE student_id = " + id; //FINISH THIS STATEMENT
		try {
			stmt = (Statement) dbConn.createStatement();
			stmt.execute(selectSQL);
		}catch(SQLException e)
		{
			System.out.println("Error getting data .....  " + e.getMessage());
		}
	}
	
	public void ViewStudentEnquiry(int s_id, int e_id)
	{
		String selectSQL = "SELECT * FROM Enquiry WHERE enquiry_id = " + e_id;
		try {
			stmt = (Statement) dbConn.createStatement();
			stmt.execute(selectSQL);
		}catch(SQLException e) {
			System.out.println("Error getting data ....." + e.getMessage());
		}
	}
	
	public boolean CancelStudentEnquiry(int e_id) // RUNS DELETE BASED OFF STUDENT
	{
		String deleteSQL = "DELETE FROM Enquiry WHERE enquiry_id = " + e_id;
		try {
			stmt = (Statement) dbConn.createStatement();
			numOfAffectedRows = stmt.execute(deleteSQL);
			return (numOfAffectedRows = 1)
		}catch(SQLException e) {
			System.out.println("Error getting data ....." + e.getMessage());
		}
	}
	
	public SubmitEnquiry()
	{
		
	}
	
	public EditEnquiry(enqiry id) //RUNS UPDATE BASED OFF ENQUIRY ID
	{
		
	}
	
	//STAFF FUNCTIONS
	
	public void ViewALLenquiries()
	{
		String selectSQL = "SELECT * FROM Enquiry";
		try {
			stmt = (Statement) dbConn.createStatement();
			stmt.execute(selectSQL);
		}catch(SQLException e)
		{
			System.out.println("Error getting data .....  " + e.getMessage());
		}
	}
	
	public ViewAllResolved()
	{
		
	}
	
	public ViewAllUnresolved()
	{
		
	}
	
	public viewEnquiry(enquiry id)
	{
		
	}
	
	public SubmitResponse() 
	{
		
	}
	
}
