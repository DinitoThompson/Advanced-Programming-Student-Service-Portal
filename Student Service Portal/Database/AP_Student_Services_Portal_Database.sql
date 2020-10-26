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

Create Table Student 
(
    student_id INT IDENTITY (1, 1) PRIMARY KEY, 
    student_first_name VARCHAR(20), 
    student_last_name VARCHAR(20), 
    student_email VARCHAR(30),
    student_password NVARCHAR(60)
);

Create Table Student_Contact
(
    student_id INT,
    student_contact_number INT, 
    PRIMARY KEY (student_id, student_contact_number), 
    FOREIGN KEY (student_id) REFERENCES Student (student_id)
);

Create Table Staff 
(
    staff_id INT IDENTITY (1, 1) PRIMARY KEY, 
    staff_first_name VARCHAR(20), 
    staff_last_name VARCHAR(20), 
    staff_email VARCHAR(30),
    staff_password VARCHAR(30)
);

Create Table Staff_Contact
(
    staff_id INT,
    staff_contact_number INT, 
    PRIMARY KEY (staff_id, staff_contact_number), 
    FOREIGN KEY (staff_id) REFERENCES Staff (staff_id)
);

Create Table Enquiry 
(
    enquiry_id INT IDENTITY (1, 1) Primary Key, 
    enquiry_nature VARCHAR(20),
    enquiry_complaint VARCHAR(20), 
    enquiry_detail VARCHAR(150), 
    enquiry_urgency BOOLEAN, 
    enquiry_date TIMESTAMP,
    enquiry_state VARCHAR(20)

    CONSTRAINT fk_student_id 
    FOREIGN KEY (student_id)
    REFERENCES Student (student_id)

    CONSTRAINT fk_staff_id
    FOREIGN KEY (staff_id)
    REFERENCES Staff(staff_id)
);  

/*Select Statements*/
SELECT * FROM Student 
SELECT * FROM Student_Telephone
SELECT * FROM Staff 
SELECT * FROM Staff_Contact 
SELECT * FROM Enquiry 


/* All Insert Statements */ 
INSERT INTO Student 
(
    student_first_name, 
    student_last_name, 
    student_email, 
    student_password
)

/*All Update Statement*/
UPDATE Student 
SET student_email = 'dinitothompson2@gmail.com'
WHERE student_id = 1

/*All Select Statements*/
SELECT * From Enquiry 

/*All Alter Statements*/
ALTER TABLE Student 
ADD 
CONSTRAINT fk_staff_id
FOREIGN KEY (staff_id)
REFERENCES Staff(staff_id)
ON DELETE SET NULL

/*All Delete Statements*/
DELETE FROM Student
Where student_id = 1 