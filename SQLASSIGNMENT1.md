### &nbsp;                                   SQL ASSIGNMENT-1







-- ================================================
-- Q.1) Create database and select it
-- ================================================
CREATE DATABASE SchoolDB;
USE SchoolDB;

-- ================================================
-- Q.2) Create Students table
-- ================================================
CREATE TABLE Students (
   StudentID INT PRIMARY KEY,
   Name VARCHAR(100),
   Age INT,
   Grade VARCHAR(5)
);

-- ================================================
-- Q.3) Insert sample students
-- ================================================
INSERT INTO Students (StudentID, Name, Age, Grade) VALUES
(1, 'Anas', 16, 'B'),
(2, 'Bob', 14, 'C'),
(3, 'Charlie', 17, 'A'),
(4, 'David', 18, 'B'),
(5, 'Messi', 15, 'A');

-- ================================================
-- Q.4) Select students older than 15
-- ================================================
SELECT * FROM Students
WHERE Age > 15;

-- ================================================
-- Q.5) Update grade of StudentID 3 to 'A'
-- ================================================
UPDATE Students
SET Grade = 'A'
WHERE StudentID = 3;

-- ================================================
-- Q.6) Delete student with StudentID 5
-- ================================================
DELETE FROM Students
WHERE StudentID = 5;

-- ================================================
-- Q.7) Create Courses table
-- ================================================
CREATE TABLE Courses (
  CourseID INT PRIMARY KEY,
  CourseName VARCHAR(50),
  Instructor VARCHAR(50)
);

-- ================================================
-- Q.8) Insert sample courses
-- ================================================
INSERT INTO Courses (CourseID, CourseName, Instructor) VALUES
(1, 'Mathematics', 'Dr. Allen'),
(2, 'Physics', 'Prof. Baker'),
(3, 'Computer Science', 'Dr. Clark');

-- ================================================
-- Q.9) Create Enrollments table with foreign keys
-- ================================================
CREATE TABLE Enrollments (
   EnrollmentID INT PRIMARY KEY,
   StudentID INT,
   CourseID INT,
   FOREIGN KEY (StudentID) REFERENCES Students(StudentID),
   FOREIGN KEY (CourseID) REFERENCES Courses(CourseID)
);

-- ================================================
-- Q.10) Select students enrolled in Mathematics
-- ================================================
SELECT s.*
FROM Students s
JOIN Enrollments e ON s.StudentID = e.StudentID
JOIN Courses c ON e.CourseID = c.CourseID
WHERE c.CourseName = 'Mathematics';

-- ================================================
-- Q.11) Count students per course
-- ================================================
SELECT c.CourseName, COUNT(e.StudentID) AS StudentCount
FROM Courses c
LEFT JOIN Enrollments e ON c.CourseID = e.CourseID
GROUP BY c.CourseName;

-- ================================================
-- Q.12) Select all students with their courses
-- ================================================
SELECT s.Name, c.CourseName
FROM Students s
JOIN Enrollments e ON s.StudentID = e.StudentID
JOIN Courses c ON e.CourseID = c.CourseID;

-- ================================================
-- Q.13) Select students not enrolled in any course
-- ================================================
SELECT s.*
FROM Students s
LEFT JOIN Enrollments e ON s.StudentID = e.StudentID
WHERE e.StudentID IS NULL;

-- ================================================
-- Q.14) Add Email column to Students table
-- ================================================
ALTER TABLE Students
ADD Email VARCHAR(100);

-- ================================================
-- Q.15) Average age of students per grade
-- ================================================
SELECT Grade, AVG(Age) AS AverageAge
FROM Students
GROUP BY Grade;

-- ================================================
-- Q.16) Select all students ordered by name descending
-- ================================================
SELECT *
FROM Students
ORDER BY Name DESC;

-- ================================================
-- Q.17) Create a view for student courses
-- ================================================
CREATE VIEW StudentCourseView AS
SELECT s.Name,
     c.CourseName,
     c.Instructor
FROM Students s
JOIN Enrollments e ON s.StudentID = e.StudentID
JOIN Courses c ON e.CourseID = c.CourseID;

-- ================================================
-- Q.18) Select courses with no enrollments
-- ================================================
SELECT c.CourseID, c.CourseName
FROM Courses c
LEFT JOIN Enrollments e ON c.CourseID = e.CourseID
WHERE e.EnrollmentID IS NULL;

-- ================================================
-- Q.19) Create index on Students name
-- ================================================
CREATE INDEX idx_students_name
ON Students(Name);

-- ================================================
-- Q.20) Select top 3 youngest students
-- ================================================
SELECT *
FROM Students
ORDER BY Age ASC
LIMIT 3;

-- ================================================
-- Q.21) Stored procedure to insert a student
-- ================================================
DELIMITER //
CREATE PROCEDURE insstud3(
  IN s_StudentId INT,
  IN s_Name VARCHAR(100),
  IN s_Age INT,
  IN s_Grade VARCHAR(100)
)
BEGIN
  INSERT INTO Students (StudentId, Name, Age, Grade)
  VALUES (s_StudentId, s_Name, s_Age, s_Grade);
END //
DELIMITER ;

CALL insstud3(1, 'John W', 20, 'A');

-- ================================================
-- Q.22) Add LastUpdated column and trigger
-- ================================================
ALTER TABLE Students ADD COLUMN LastUpdated DATETIME NULL;

CREATE TRIGGER update_last_updated
BEFORE UPDATE ON Students
FOR EACH ROW
SET NEW.LastUpdated = CURRENT_TIMESTAMP;

-- ================================================
-- Q.23) Create Departments table
-- ================================================
CREATE TABLE Departments (
   DepartmentID INT PRIMARY KEY,
   DepartmentName VARCHAR(255)
);

-- ================================================
-- Q.24) Add DepartmentID to Courses and create FK
-- ================================================
ALTER TABLE Courses
ADD COLUMN DepartmentID INT;

ALTER TABLE Courses
ADD CONSTRAINT fk_department
FOREIGN KEY (DepartmentID) REFERENCES Departments(DepartmentID);

-- ================================================
-- Q.25) Select courses in Science department
-- ================================================
SELECT c.CourseName
FROM Courses c
JOIN Departments d ON c.DepartmentID = d.DepartmentID
WHERE d.DepartmentName = 'Science';

-- ================================================
-- Q.26) Count courses per department
-- ================================================
SELECT d.DepartmentName, COUNT(c.CourseID) AS CourseCount
FROM Departments d
LEFT JOIN Courses c ON d.DepartmentID = c.DepartmentID
GROUP BY d.DepartmentName;

-- ================================================
-- Q.27) Normalization from StudentCourses table
-- ================================================

-- Original denormalized table
CREATE TABLE StudentCourses (
   StudentID INT,
   StudentName VARCHAR(100),
   Age INT,
   Grade VARCHAR(10),
   CourseID INT,
   CourseName VARCHAR(100),
   Instructor VARCHAR(100),
   PRIMARY KEY (StudentID, CourseID)
);

INSERT INTO StudentCourses VALUES
(1, 'John Doe', 20, 'A', 101, 'Mathematics', 'Dr. Smith'),
(1, 'John Doe', 20, 'A', 102, 'Physics', 'Dr. Johnson'),
(2, 'Jane Smith', 19, 'B', 101, 'Mathematics', 'Dr. Smith'),
(3, 'Bob Wilson', 21, 'A', 103, 'Chemistry', 'Dr. Brown');

-- Normalized Students table
CREATE TABLE Students (
   StudentID INT PRIMARY KEY,
   StudentName VARCHAR(100) NOT NULL,
   Age INT,
   Grade VARCHAR(10)
);

-- Normalized Courses table
CREATE TABLE Courses (
   CourseID INT PRIMARY KEY,
   CourseName VARCHAR(100) NOT NULL,
   Instructor VARCHAR(100)
);

-- Insert data from denormalized table
INSERT INTO Students (StudentID, StudentName, Age, Grade)
SELECT DISTINCT StudentID, StudentName, Age, Grade
FROM StudentCourses;

INSERT INTO Courses (CourseID, CourseName, Instructor)
SELECT DISTINCT CourseID, CourseName, Instructor
FROM StudentCourses;

-- ================================================
-- Q.28) Students enrolled in more than 2 courses
-- ================================================
SELECT s.StudentID, s.Name, COUNT(e.CourseID) AS CourseCount
FROM Students s
JOIN Enrollments e ON s.StudentID = e.StudentID
GROUP BY s.StudentID, s.Name
HAVING COUNT(e.CourseID) > 2;

-- ================================================
-- Q.29) Courses with more than 5 students
-- ================================================
SELECT c.CourseID, c.CourseName, COUNT(e.StudentID) AS StudentCount
FROM Courses c
JOIN Enrollment e ON c.CourseID = e.CourseID
GROUP BY c.CourseID, c.CourseName
HAVING COUNT(e.StudentID) > 5;

-- ================================================
-- Q.30) Delete students not enrolled in any course
-- ================================================
DELETE FROM Students
WHERE StudentID NOT IN (
   SELECT DISTINCT StudentID FROM Enrollment
);
