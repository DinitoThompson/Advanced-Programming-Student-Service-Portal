/*
    Advanced Programming 
    Student Services Portal 
    Database 
    Group Members 
    Dinito Thompson 1801202
    Shanice Facey 
    Tyree Tinka 
*/
Create Database student_services_portal; 
Use student_services_portal;  

CREATE TABLE student 
(
    student_id INT(7) PRIMARY KEY AUTO_INCREMENT, 
    student_first_name VARCHAR(20), 
    student_last_name VARCHAR(20), 
    student_email VARCHAR(30),
    student_password VARCHAR(30)
);

CREATE TABLE student_contact
(
    student_id INT,
    student_contact_number VARCHAR(20), 

    PRIMARY KEY (student_id, student_contact_number), 

    FOREIGN KEY (student_id) 
    REFERENCES student (student_id)
);

CREATE TABLE enquiry 
(
	student_id INT,
    enquiry_id INT(7) PRIMARY KEY AUTO_INCREMENT, 
    enquiry_nature VARCHAR(20),
    enquiry_complaint VARCHAR(20), 
    enquiry_detail VARCHAR(150),
    enquiry_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    enquiry_state VARCHAR(20) DEFAULT 'Unresolved',

    CONSTRAINT fk_student_id 
    FOREIGN KEY (student_id)
    REFERENCES Student (student_id)
);  
CREATE TABLE enquiry_response
(
    enquiry_id INT, 
    enquiry_response VARCHAR(50), 
    enquiry_response_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    PRIMARY KEY (enquiry_id, enquiry_response_date), 

    FOREIGN KEY (enquiry_id) 
    REFERENCES Enquiry (enquiry_id)
); 

CREATE TABLE staff 
(
    staff_id INT(7) PRIMARY KEY AUTO_INCREMENT, 
    staff_first_name VARCHAR(20), 
    staff_last_name VARCHAR(20), 
    staff_email VARCHAR(30),
    staff_password VARCHAR(30)
);

CREATE TABLE staff_contact
(
    staff_id INT,
    staff_contact_number VARCHAR(20), 

    PRIMARY KEY (staff_id, staff_contact_number), 

    FOREIGN KEY (staff_id) 
    REFERENCES Staff (staff_id)
);

CREATE TABLE respond
(
    enquiry_id INT(7),
    staff_id INT(7), 
    respond_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP, 

    PRIMARY KEY (enquiry_id, staff_id, respond_date), 
    
    FOREIGN KEY (enquiry_id)
    REFERENCES Enquiry(enquiry_id),
    
    FOREIGN KEY (staff_id)
    REFERENCES Staff(staff_id)
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
