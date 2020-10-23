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
    student_id INT Primary Key, 
    student_first_name VARCHAR(20), 
    student_last_name VARCHAR(20), 
    student_email VARCHAR(30),
    student_contact_number INT, 
    student_password VARCHAR(30)
);

Create Table Staff 
(
    staff_id INT Primary Key, 
    staff_first_name VARCHAR(20), 
    staff_last_name VARCHAR(20), 
    staff_email VARCHAR(30),
    staff_contact_number INT,
    staff_password VARCHAR(30)
);

Create Table Enquiry 
(
    enquiry_id INT Primary Key, 
    enquiry_nature VARCHAR(20),
    enquiry_complaint VARCHAR(20), 
    enquiry_detail VARCHAR(150), 
    enquiry_urgency BOOLEAN, 
    enquiry_date TIMESTAMP,
    enquiry_state VARCHAR(20)

    CONSTRAINT fk_student_id 
    FOREIGN KEY (student_id)
    REFERENCES Student (student_id)
    ON DELETE SET NULL

    CONSTRAINT fk_staff_id
    FOREIGN KEY (staff_id)
    REFERENCES Staff(staff_id)
    ON DELETE SET NULL
);  

/* All Insert Statements */ 
INSERT INTO Student 
(
student_id,
student_password,
student_first_name,
student_last_name,
student_email,
student_contact_number
)
VALUES
(
    1,
    'Password', 
    'Dinito', 
    'Thompson', 
    'dinitothompson@gmail.com', 
    18763571273
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