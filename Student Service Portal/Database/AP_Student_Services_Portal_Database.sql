/*
    Advanced Programming 
    Student Services Portal 
    Database 
    Group Members 
    Dinito Thompson 
    Shanice Facey 
    Tyree Tinka 
*/

Create Database Student_Services_Portal; 
Use Student_Services_Portal; 
Drop Database Student_Services_Portal; 


CREATE TABLE Student 
(
    student_id INT IDENTITY (1, 1) PRIMARY KEY, 
    student_first_name VARCHAR(20), 
    student_last_name VARCHAR(20), 
    student_email VARCHAR(30),
    student_password NVARCHAR(60)
);

CREATE TABLE Student_Contact
(
    student_id INT,
    student_contact_number VARCHAR(20), 

    PRIMARY KEY (student_id, student_contact_number), 

    FOREIGN KEY (student_id) 
    REFERENCES Student (student_id)
);

CREATE TABLE Staff 
(
    staff_id INT IDENTITY (1, 1) PRIMARY KEY, 
    staff_first_name VARCHAR(20), 
    staff_last_name VARCHAR(20), 
    staff_email VARCHAR(30),
    staff_password VARCHAR(30)
);

CREATE TABLE Staff_Contact
(
    staff_id INT,
    staff_contact_number VARCHAR(20), 

    PRIMARY KEY (staff_id, staff_contact_number), 

    FOREIGN KEY (staff_id) 
    REFERENCES Staff (staff_id)
);

CREATE TABLE Enquiry 
(
	student_id INT,
    enquiry_id INT IDENTITY (1, 1) Primary Key, 
    enquiry_nature VARCHAR(20),
    enquiry_complaint VARCHAR(20), 
    enquiry_detail VARCHAR(150), 
    enquiry_urgency INT, 
    enquiry_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    enquiry_state VARCHAR(20),

    CONSTRAINT fk_student_id 
    FOREIGN KEY (student_id)
    REFERENCES Student (student_id)
);  

CREATE TABLE Respond
(
    enquiry_id INT, 
    student_id INT,
    staff_id INT, 
    respond_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP, 

    PRIMARY KEY (enquiry_id, staff_id, student_id), 
    
    FOREIGN KEY (enquiry_id)
    REFERENCES Enquiry(enquiry_id),
    
    FOREIGN KEY (staff_id)
    REFERENCES Staff (staff_id), 

    FOREIGN KEY (student_id)
    REFERENCES Student (student_id)
);

/*Select Statements*/
SELECT * FROM Student 
SELECT * FROM Student_Contact
SELECT * FROM Staff 
SELECT * FROM Staff_Contact 
SELECT * FROM Enquiry 
SELECT * FROM Respond 

/*Drop Statements*/
Drop Table Student
Drop Table Student_Contact
Drop Table Staff
Drop Table Staff_Contact
Drop Table Enquiry
Drop Table Respond

/* All Insert Statements */ 
INSERT INTO Student 
(
    student_first_name,
    student_last_name, 
    student_email, 
    student_password
)
VALUES
(
    'Dinito',
    'Thompson', 
    'dinitothompson@gmail.com', 
    'DeniToSenPai'
)
INSERT INTO Student_Contact
VALUES
(
    1, 
    '1-876-357-1273'
)
INSERT INTO Staff 
(
    staff_first_name, 
    staff_last_name, 
	staff_email, 
	staff_password
)
VALUES
(
    'Shanice', 
    'Facey', 
    'shanicefacey@gmail.com', 
    'ShaNiceSenPai'
)
INSERT INTO Enquiry 
(
	student_id,
    enquiry_nature,
    enquiry_complaint, 
    enquiry_detail, 
    enquiry_urgency,
    enquiry_state
)
VALUES
(
    1,
	'Website', 
	'Moodle',
    'I am trying to log in but moodle wont allow me.',  
	1,
	'Unresolved'
)
INSERT INTO Respond 
(
	enquiry_id, 
	staff_id, 
    student_id
)
VALUES
(
	1, 
	1, 
    1
)

/*All Update Statement*/

/*All Alter Statements*/

/*All Delete Statements*/