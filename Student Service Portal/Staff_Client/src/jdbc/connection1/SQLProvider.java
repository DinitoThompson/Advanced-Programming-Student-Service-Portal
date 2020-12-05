package jdbc.connection1;

import java.sql.*;
import java.util.ArrayList;
import com.gui_demo.*;
import javax.swing.JOptionPane;

public class SQLProvider {
	private Connection dbConn = null;
	private Statement stmt = null;
	private ResultSet result = null;
	private PreparedStatement prepStmt = null;

	private int numOfAffectedRows = 0;
	private int numOfAffectedRows2 = 0; 
	private Sign_up s;

	public SQLProvider(Connection dbConn) {
		this.dbConn = dbConn;
	}

	// ============= SIGN UP FUNCTIONS ===============
	public boolean insertStudentUser(Sign_up s) // USED TO ENTER STUDENTS INTO THE DATABSE (FINISHED)
	{
		String insertSql = "INSERT INTO student_services_portal.student (student_id, student_first_name, student_last_name, student_email, student_password)"
				+ "values('" + s.getID() + "', '" + s.getFname() + "','" + s.getLname() + "','" + s.getEmail() + "','"
				+ s.getPassword() + "')";

		try {
			stmt = (Statement) dbConn.createStatement();
			numOfAffectedRows = stmt.executeUpdate(insertSql);
			return (numOfAffectedRows == 1);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "ID Number Already Registered", "Registration Status",
					JOptionPane.ERROR_MESSAGE);
			Sign_up sign_up = new Sign_up();
			sign_up.setVisible(true);
		}
		return false;
	}

	public boolean insertStudentContact(Sign_up s) // USED TO ENTER CONTACTS FOR STUDENTS (FINISHED)
	{
		String insertSql1 = "INSERT INTO student_services_portal.student_contact (student_id, student_contact_number)"
				+ "values('" + s.getID() + "', '" + s.getPhone() + "')";
		try {
			stmt = (Statement) dbConn.createStatement();
			numOfAffectedRows = stmt.executeUpdate(insertSql1);
			return (numOfAffectedRows == 1);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "ID Number Already Registered", "Registration Status",
					JOptionPane.ERROR_MESSAGE);
			Sign_up sign_up = new Sign_up();
			sign_up.setVisible(true);
		}
		return false;
	}

	public boolean insertStaffUser(com.staff_demo.Sign_up sign2) // USED TO ENTER STAFF INTO THE DATABSE (FINISHED)
	{
		String insertstaffSql = "INSERT INTO student_services_portal.staff (staff_id, staff_first_name, staff_last_name, staff_email, staff_password)"
				+ "values('" + sign2.getID() + "', '" + sign2.getFname() + "','" + sign2.getLname() + "','"
				+ sign2.getEmail() + "','" + sign2.getPassword() + "')";
		try {
			stmt = (Statement) dbConn.createStatement();
			numOfAffectedRows = stmt.executeUpdate(insertstaffSql);
			return (numOfAffectedRows == 1);
		} catch (SQLException e) {
			System.out.println("Error Inserting .....  " + e.getMessage());
		}
		return false;
	}

	public boolean insertStaffContact(com.staff_demo.Sign_up sign2)// USED TO ENTER CONTACTS FOR STAFF (FINISHED)
	{
		String insertstaffSql1 = "INSERT INTO student_services_portal.staff_contact (staff_id, staff_contact_number)"
				+ "values('" + sign2.getID() + "', '" + sign2.getPhone() + "')";
		try {
			stmt = (Statement) dbConn.createStatement();
			numOfAffectedRows = stmt.executeUpdate(insertstaffSql1);
			return (numOfAffectedRows == 1);
		} catch (SQLException e) {
			System.out.println("Error Inserting .....  " + e.getMessage());
		}
		return false;
	}

	// ============= LOG IN FUNCTIONS ================

	public Sign_up selectStudentUser(int id) {
		String selectsql = "SELECT *FROM student_services_portal.student WHERE id = '" + id;
		try {
			stmt = (Statement) dbConn.createStatement();
			result = stmt.executeQuery(selectsql);
			while (result.next()) {
				s = new Sign_up();
				// s.setId(result.getInt(1));
				s.setFname(result.getString(2));
				;
				s.setLname(result.getString(3));
				;
				s.setEmail(result.getString(4));
				s.setPhone(result.getString(5));
				;
				return s;

			}
		} catch (SQLException e) {
			System.out.println("Error Selecting .....: " + e.getMessage());
		}
		return null;
	}

	// ============= SQL FUNCTIONS ===============

	public ResultSet ViewStudentEnquiry(String e_id) // SELECTS THE ENQUIRY FOR A STUDENT
	{
		String selectSQL = "SELECT * FROM student_services_portal.enquiry WHERE enquiry_id = " + e_id;
		try {
			stmt = (Statement) dbConn.createStatement();
			result = stmt.executeQuery(selectSQL);
			result.next();
		} catch (SQLException e) {
			System.out.println("Error getting data: " + e.getMessage());
		}

		return result;
	}

	public boolean SubmitEnquiry(String student_id, String enquiry_nature, String enquiry_complaint,
			String enquiry_detail) {
		String insertSQL = "INSERT INTO student_services_portal.enquiry (student_id, enquiry_nature, enquiry_complaint, enquiry_detail) "
				+ "VALUES ('" + student_id + "', '" + enquiry_nature + "', '" + enquiry_complaint + "', '"
				+ enquiry_detail + "')";
		try {
			stmt = (Statement) dbConn.createStatement();
			numOfAffectedRows = stmt.executeUpdate(insertSQL);
			return (numOfAffectedRows == 1);
		} catch (SQLException e) {
			System.out.println("Error getting data ....." + e.getMessage());
		}
		return false;
	}

	public boolean SubmitResponse(String enquiry_id, String enquiry_response) {
		String insertSQL = "INSERT INTO student_services_portal.enquiry_response (enquiry_id, enquiry_response) "
				+ "VALUES ('" + enquiry_id + "', '" + enquiry_response + "')";
		String updateSQL = "Update student_services_portal.enquiry SET enquiry_state = 'Resolved' WHERE enquiry_id = "+enquiry_id ;
		try {
			stmt = (Statement) dbConn.createStatement();
			numOfAffectedRows = stmt.executeUpdate(insertSQL);
			numOfAffectedRows2 = stmt.executeUpdate(updateSQL);
		} catch (SQLException e) {
			System.out.println("Error Updating: " + e.getMessage());
		}
		return (numOfAffectedRows == 1 && numOfAffectedRows == 1);
	}

	public boolean UpdateEnquiry(String enquiry_id, String enquiry_complaint, String enquiry_nature,
			String enquiry_detail) {
		String updateSQL = "" + "UPDATE student_services_portal.enquiry " + "SET enquiry_complaint = '"
				+ enquiry_complaint + "', enquiry_nature = '" + enquiry_nature + "', enquiry_detail = '"
				+ enquiry_detail + "'" + "WHERE enquiry_id = '" + enquiry_id + "';";
		try {
			stmt = (Statement) dbConn.createStatement();
			numOfAffectedRows = stmt.executeUpdate(updateSQL);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Enquiry Status", JOptionPane.INFORMATION_MESSAGE);
		}
		return (numOfAffectedRows == 1);
	}

	public boolean CancelStudentEnquiry(String enquiry_id) // RUNS DELETE BASED OFF STUDENT (TO BE CHECKED)
	{
		String deleteSQL = "DELETE FROM Enquiry WHERE enquiry_id = " + enquiry_id;
		try {
			stmt = (Statement) dbConn.createStatement();
			numOfAffectedRows = stmt.executeUpdate(deleteSQL);
		} catch (SQLException e) {
			System.out.println("Error getting data ....." + e.getMessage());
		}
		return (numOfAffectedRows == 1);
	}

	@SuppressWarnings("deprecation")
	public ArrayList<Enquiry> EnquiryResponse(String enquiry_id) {
		ArrayList<Enquiry> enquiry_response = new ArrayList<>();
		String selectResponseSQL = "SELECT enquiry_response, enquiry_response_date From student_services_portal.enquiry_response WHERE enquiry_id = "
				+ enquiry_id;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_services_portal", "root",
					"");
			Statement stmt = (Statement) conn.createStatement();
			stmt = (Statement) dbConn.createStatement();
			result = stmt.executeQuery(selectResponseSQL);
			Enquiry per;
			while (result.next()) {
				per = new Enquiry(result.getString(1), result.getString(2));
				enquiry_response.add(per);
			}

		} catch (SQLException e) {
			System.out.println("Error Updating: " + e.getMessage());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return enquiry_response;
	}

	@SuppressWarnings("deprecation")
	public ArrayList<Enquiry> StudentEnquiryTable(String student_id)// USED FOR STUDENT ENQUIRY TABLE (FINISHED)
	{
		ArrayList<Enquiry> enquiryTable = new ArrayList<>();
		String selectSQL = "SELECT * FROM Enquiry WHERE student_id = " + student_id;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_services_portal", "root",
					"");
			Statement stmt = (Statement) conn.createStatement();
			result = stmt.executeQuery(selectSQL);
			Enquiry s;
			while (result.next()) {
				s = new Enquiry(result.getInt(2), result.getString(7), result.getString(3));
				enquiryTable.add(s);
			}
		} catch (SQLException e) {
			System.out.println("Error getting data: " + e.getMessage());
		} catch (Exception e) {
			System.out.println(": " + e.getMessage());
		}
		return enquiryTable;
	}

	@SuppressWarnings("deprecation")
	public ArrayList<Enquiry> ResolvedEnquiry()// USED FOR STAFF ENQUIRY TABLE (FINISHED)
	{
		ArrayList<Enquiry> EnquiryList = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_services_portal", "root",
					"");
			String selectSql = "SELECT * FROM student_services_portal.enquiry Where enquiry_state = 'Resolved'";
			Statement stmt = (Statement) conn.createStatement();
			ResultSet result = stmt.executeQuery(selectSql);
			Enquiry enq;
			while (result.next()) {
				enq = new Enquiry(result.getInt(2), result.getString(7), result.getString(3));
				// s.setID(result.getInt(1));
				EnquiryList.add(enq);
			}

		} catch (Exception e) {
			System.out.println("Error selecting All: " + e.getMessage());
		}
		return EnquiryList;
	}

	@SuppressWarnings("deprecation")
	public ArrayList<Enquiry> UnresolvedEnquiry()// USED FOR STAFF ENQUIRY TABLE (FINISHED)
	{
		ArrayList<Enquiry> EnquiryList = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_services_portal", "root",
					"");
			String selectSql = "SELECT * FROM student_services_portal.enquiry Where enquiry_state = 'Unresolved'";
			Statement stmt = (Statement) conn.createStatement();
			ResultSet result = stmt.executeQuery(selectSql);
			Enquiry enq;
			while (result.next()) {
				enq = new Enquiry(result.getInt(2), result.getString(7), result.getString(3));
				// s.setID(result.getInt(1));
				EnquiryList.add(enq);
			}

		} catch (Exception e) {
			System.out.println("Error selecting All: " + e.getMessage());
		}
		return EnquiryList;
	}

	public ResultSet EditEnquiry(String enquiry_id) // RUNS UPDATE BASED OFF ENQUIRY ID
	{
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_services_portal", "root",
					"");
			prepStmt = conn.prepareStatement("SELECT * FROM `enquiry` WHERE enquiry_id = " + enquiry_id);
			prepStmt.executeQuery();
		} catch (SQLException e) {
			System.out.println("Error Updating: " + e.getMessage());
		}
		return result;
	}

	public String SelectStudentName(String student_id) {
		String selectNameSQL = "SELECT student_first_name, student_last_name From student_services_portal.student WHERE student_id = "
				+ student_id;
		try {
			stmt = (Statement) dbConn.createStatement();
			result = stmt.executeQuery(selectNameSQL);
			result.next();
			String student_name = "" + result.getString("student_first_name") + " "
					+ result.getString("student_last_name") + "";
			return student_name;
		} catch (SQLException e) {
			System.out.println("Error Updating: " + e.getMessage());
		}
		return null;
	}

	public String SelectStaffName(String staff_id) {
		String selectNameSQL = "SELECT staff_first_name, staff_last_name From student_services_portal.staff WHERE staff_id = "
				+ staff_id;
		try {
			stmt = (Statement) dbConn.createStatement();
			result = stmt.executeQuery(selectNameSQL);
			result.next();
			String staff_name = "" + result.getString("staff_first_name") + " " + result.getString("staff_last_name")
					+ "";
			return staff_name;
		} catch (SQLException e) {
			System.out.println("Error Updating: " + e.getMessage());
		}
		return null;
	}

}
