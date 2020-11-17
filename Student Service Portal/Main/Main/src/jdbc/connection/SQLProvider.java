package jdbc.connection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.gui_demo.*;
import javax.swing.JButton;

public class SQLProvider 
{
	private Connection dbConn = null;
	private Statement stmt = null;
	private ResultSet result = null;
	private PreparedStatement prepStmt = null;
	private int numOfAffectedRows = 0;
	private Sign_up s;
	
	public SQLProvider(Connection dbConn)
	{
		this.dbConn = dbConn;
	}

	// SIGN UP FUNCTIONS
	public boolean insertStudentUser(Sign_up s)
	{
		String insertSql = "INSERT INTO student_services_portal.student (firstname, lastname, email, phone)"
				+"values('"+s.getFname()+"','"+s.getLname()+"','"+s.getEmail()+"','"+s.getPhone()+"')";
		try {
			stmt = (Statement) dbConn.createStatement();
			numOfAffectedRows = stmt.executeUpdate(insertSql);
			return (numOfAffectedRows == 1);
		}catch(SQLException e)
		{
			System.out.println("Error Inserting .....  " + e.getMessage());
		}
		return false;
	}

	public boolean insertStaffUser(Sign_up s)
	{
		String insertstaffSql = "INSERT INTO student_services_portal.staff (firstname, lastname, email, phone)"
				+"values('"+s.getFname()+"','"+s.getLname()+"','"+s.getEmail()+"','"+s.getPhone()+"')";
		try {
			stmt = (Statement) dbConn.createStatement();
			numOfAffectedRows = stmt.executeUpdate(insertstaffSql);
			return (numOfAffectedRows == 1);
		}catch(SQLException e)
		{
			System.out.println("Error Inserting .....  " + e.getMessage());
		}
		return false;
	}

	// STUDENT FUNCTIONS 

	// SELECT STATEMENTS 
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
	
	/*public boolean Login(int log, int id, String pw)
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
	}*/
	
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
	
	
	
	public boolean CancelStudentEnquiry(int enquiry_id) // RUNS DELETE BASED OFF STUDENT
	{
		String deleteSQL = "DELETE FROM Enquiry WHERE enquiry_id = " + enquiry_id;
		try {
			stmt = (Statement) dbConn.createStatement();
			numOfAffectedRows = stmt.executeUpdate(deleteSQL);
			return (numOfAffectedRows ==1);
		}catch(SQLException e) {
			System.out.println("Error getting data ....." + e.getMessage());
		}
		return false;
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
		//String UpdateSQL = 
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
	
	
	/*public ResultSet viewEnquiry(int id)
	{
		
	}*/
	
	/*public ResultSet ViewEnquiryByState(int Case)
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
	}*/
	
	
	/*public SubmitResponse() 
	{
		
	}*/ // shanice's might be working idk
	
	public Sign_up selectStudentUser(int id)
	 {
		 String selectsql = "SELECT *FROM student_services_portal.student WHERE id = '" +id;
		 try {
			 stmt = (Statement) dbConn.createStatement();
			 result = stmt.executeQuery(selectsql);
			 while(result.next())
			 {
				s= new Sign_up();
				//s.setId(result.getInt(1));
				s.setFname(result.getString(2));;
				s.setLname(result.getString(3));;
				s.setEmail(result.getString(4));
				s.setPhone(result.getString(5));;
			  return s;
				
			 } 
		 }catch(SQLException e)
			{
				System.out.println("Error Selecting .....: " + e.getMessage());
			}
		 return null;
	 }
	public List<Sign_up> selectAllStudent()
	 {
		 List<Sign_up> contactList = new ArrayList<Sign_up>();
		 String selectSql = "SELECT * FROM student_services_portal.student where 1 = 1";
		 try {
			 stmt = (Statement) dbConn.createStatement();
			 result = stmt.executeQuery(selectSql);
			 while (result.next())
			 {
				 s = new Sign_up(result.getString(2),result.getString(3),result.getString(4),result.getString(5));
				 s.setID(result.getInt(1));
			     contactList.add(s);
			 }	
			 return contactList;
		  }catch(SQLException e)
			{
				System.out.println("Error selecting All: " + e.getMessage());
			}
		 		return null;
	 }
	public boolean updateStudent(int id)
	 {
		 String updateSql = "UPDATE student SET student_email = 'testupdate@ymail.com' where id = "+ id;
		 try {
			 stmt = (Statement) dbConn.createStatement();
			 numOfAffectedRows = stmt.executeUpdate(updateSql);
			 return(numOfAffectedRows ==1);
		 }catch(SQLException e)
			{
				System.out.println("Error Updating: " + e.getMessage());
			}
		 		return false;
	 }
	public boolean deleteStudent(int id)
   {
  	 String deleteSql = "DELETE student.* FROM student where id = "+ id ;
  	 try {
  		 stmt = (Statement) dbConn.createStatement();
  		 numOfAffectedRows = stmt.executeUpdate(deleteSql);
  		 return(numOfAffectedRows ==1);
  	 }catch(SQLException e)
			{
				System.out.println("Error Deleting: " + e.getMessage());
			}
  	 return false;
   }	
	
	
}
