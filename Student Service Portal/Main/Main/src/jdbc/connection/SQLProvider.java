package jdbc.connection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.gui_demo.*;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SQLProvider 
{
	private Connection dbConn = null;
	private Statement stmt = null;
	private ResultSet result = null;
	private PreparedStatement prepStmt = null;
	private int numOfAffectedRows = 0;
	private Sign_up s;
	private Submit_Enquiry sign;
	
	public SQLProvider(Connection dbConn)
	{
		this.dbConn = dbConn;
	}

	// SIGN UP FUNCTIONS
	public boolean insertStudentUser(Sign_up s)
	{
		String insertSql = "INSERT INTO student_services_portal.student (student_first_name, student_last_name, student_email, student_password)"
							+"values('"+s.getFname()+"','"+s.getLname()+"','"+s.getEmail()+"','"+s.getPassword()+"')";
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

	public boolean insertStudentContact(Sign_up s)
	{
		String insertSql1 = "INSERT INTO student_services_portal.student_contact (student_contact_number)" + "values('"+s.getPhone()+"')";
		try {
			stmt = (Statement) dbConn.createStatement();
			numOfAffectedRows = stmt.executeUpdate(insertSql1);
			return (numOfAffectedRows == 1);
		}catch(SQLException e)
		{
			System.out.println("Error Inserting .....  " + e.getMessage());
		}
		return false;
	}

	public boolean insertStaffUser(Sign_up s)
	{
		String insertstaffSql = "INSERT INTO student_services_portal.staff (staff_first_name, staff_last_name, staff_email, staff_password)"
				+"values('"+s.getFname()+"','"+s.getLname()+"','"+s.getEmail()+"','"+s.getPassword()+"')";
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

	public boolean insertStaffContact(Sign_up s)
	{
		String insertstaffSql1 = "INSERT INTO student_services_portal.staff_contact (staff_contact_number)" + "values('"+s.getPhone()+"')";
		try {
			stmt = (Statement) dbConn.createStatement();
			numOfAffectedRows = stmt.executeUpdate(insertstaffSql1);
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
				 s = new Sign_up(result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6));
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

	public boolean updateStudent(int id) //????
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

    public ArrayList<Enquiry> StudentEnquiryTable(int student_id)// USED FOR STUDENT ENQUIRY TABLE
	{
		ArrayList<Enquiry> enquiryTable = new ArrayList<>();
		String selectSQL = "SELECT * FROM Enquiry WHERE student_id = " + student_id;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_services_portal","root","");
			Statement stmt = (Statement) conn.createStatement();
			result = stmt.executeQuery(selectSQL);
			Enquiry s;
			while (result.next())
			{
				s = new Enquiry(result.getInt(2), result.getString(7), result.getString(3));
				enquiryTable.add(s); 
			}
		}catch(SQLException e){
			System.out.println("Error getting data: " + e.getMessage());
		}catch(Exception e)
		{
			System.out.println(": " + e.getMessage());
		}
		return enquiryTable;
	}

	public ArrayList<Enquiry> EnquiryList()//USED FOR STAFF ENQUIRY TABLE
	{
		 ArrayList<Enquiry> EnquiryList = new ArrayList<>();
		 try {
			 Class.forName("com.mysql.jdbc.Driver").newInstance();
			 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_services_portal","root","");
			 String selectSql = "SELECT * FROM student_services_portal.enquiry";
			 Statement stmt = (Statement) conn.createStatement();
			 ResultSet result = stmt.executeQuery(selectSql);
			 Enquiry enq;
			 while (result.next())
			 {
				 enq = new Enquiry(result.getInt(2),result.getString(7),result.getString(3));
				 //s.setID(result.getInt(1));
			     EnquiryList.add(enq);
		 }	
			 
		  }catch(Exception e)
			{
				System.out.println("Error selecting All: " + e.getMessage());
			}
		 return EnquiryList;
	 }
}

	
