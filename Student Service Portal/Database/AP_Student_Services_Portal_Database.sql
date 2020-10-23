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
    enquiry_date DATE,
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