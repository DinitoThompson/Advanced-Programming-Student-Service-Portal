package jdbc.connection;

import java.sql.*;
import com.gui_demo.*;
import javax.swing.JButton;

public class SQLProvider 
{
	private Connection dbConn = null;
	private Statement stmt = null;
	private ResultSet result = null;
	private PreparedStatement prepStmt = null;
	private int numOfAffectedRows = 0;
	
	public SQLProvider(Connection dbConn)
	{
		this.dbConn = dbConn;
	}
	
	public void SignUp(int sign, )
	{
		switch()
		{
			case:
				
				break;
		}
	}
	
	public boolean Login(int log, int id, String pw)
	{
		String pass;
		int stud_id;
		
		switch(log)
		{
		case 1: // STUDENT
			String selectSQL = "SELECT student_id, student_password FROM Student WHERE student_id =" + id;
			try {
				stmt = (Statement) dbConn.createStatement();
				result = stmt.executeQuery(selectSQL);
				while(result.next())
				{
					stud_id = result.getInt("s_id");
					pass = result.getString("pass");
				}
				if (id == stud_id)
				{
					if (pw == pass)
					{
						return true;
					}
				}else{
					return false;
				}
			}catch(SQLException e){
				System.out.println("Error getting data .....  " + e.getMessage());
			}
			break;
			
		case 2: // STAFF
			String selectSQL2 = "SELECT staff_id, staff_password FROM Staff WHERE staff_id =" + id;
			try {
				stmt = (Statement) dbConn.createStatement();
				result = stmt.executeQuery(selectSQL);
				while(result.next())
				{
					stud_id = result.getInt("s_id");
					pass = result.getString("pass");
				}
				if (id == stud_id)
				{
					if (pw == pass)
					{
						return true;
					}
				}else{
					return false;
				}
			}catch(SQLException e){
				System.out.println("Error getting data .....  " + e.getMessage());
			}
			break;
		}
	}
	
	//	STUDENT FUNCTIONS
	public ResultSet StudentDashboardEnquiryList(int id)//FIND OUT IF CLASS IS NEEDED
	{
		String selectSQL = "SELECT * FROM Enquiry WHERE student_id = " + id; //FINISH THIS STATEMENT
		try {
			stmt = (Statement) dbConn.createStatement();
			result = stmt.executeQuery(selectSQL);
		}catch(SQLException e)
		{
			System.out.println("Error getting data .....  " + e.getMessage());
		}
		return result;
	}
	
	public ResultSet ViewStudentEnquiry(int s_id, int e_id)
	{
		String selectSQL = "SELECT * FROM Enquiry WHERE enquiry_id = " + e_id + "&& student_id = " + s_id;
		try {
			stmt = (Statement) dbConn.createStatement();
			result = stmt.executeQuery(selectSQL);
		}catch(SQLException e) {
			System.out.println("Error getting data ....." + e.getMessage());
		}
		return result;
	}
	
	public int CancelStudentEnquiry(int e_id) // RUNS DELETE BASED OFF STUDENT
	{
		String deleteSQL = "DELETE FROM Enquiry WHERE enquiry_id = " + e_i;
		try {
			stmt = (Statement) dbConn.createStatement();
			numOfAffectedRows = stmt.executeUpdate(deleteSQL);
			return numOfAffectedRows;
		}catch(SQLException e) {
			System.out.println("Error getting data ....." + e.getMessage());
		}
	}
	
	public boolean SubmitEnquiry(String En_name, String En_Email, int En_mobile, String complaint, String En_nature, String En_further)
	{
		String insertSQL = "INSERT INTO Enquiry VALUES (" + En_name + En_Email + En_mobile +  complaint + En_nature + En_further + ");";
		try {
			stmt = (Statement) dbConn.createStatement();
			numOfAffectedRows = stmt.executeUpdate(insertSQL);
			return(numOfAffectedRows == 1);
		}catch(SQLException e) { 
			System.out.println("Error getting data ....." + e.getMessage());
		}
		return false;
	}
	
	public void EditEnquiry(int id) //RUNS UPDATE BASED OFF ENQUIRY ID
	{
		String selectSQL = "SELECT * FROM Enquiry WHERE Enquiry_id = " + id;
		String UpdateSQL = 
	}
	
	//STAFF FUNCTIONS
	
	public ResultSet ViewALLenquiries()
	{
		String selectSQL = "SELECT * FROM Enquiry";
		try {
			stmt = (Statement) dbConn.createStatement();
			result = stmt.executeQuery(selectSQL);
		}catch(SQLException e)
		{
			System.out.println("Error getting data .....  " + e.getMessage());
		}
		return result;
	}
	
	
	public ResultSet viewEnquiry(int id)
	{
		
	}
	
	public ResultSet ViewEnquiryByState(int Case)
	{
		String selectSQL;
		switch(Case)
		{
		case 1: // RESOLVED
			selectSQL = "SELECT * FROM Enquiry WHERE enquiry_state = Resolved";
			break;
		case 2: // UNRESOLVED
			selectSQL = "SELECT * FROM Enquiry WHERE enquiry_state = Unresolved";
			break;
		}
		
		try {
			stmt = (Statement) dbConn.createStatement();
			result = stmt.executeQuery(selectSQL);	
		}catch(SQLException e)
		{
			System.out.println("Error getting data .....  " + e.getMessage());
		}
		return result;
	}
	
	
	public SubmitResponse() 
	{
		
	}
	
}
