### &nbsp;      -- ================================================
-- Q.1) Create database CompanyDB
-- ================================================
CREATE DATABASE CompanyDB;

-- ================================================
-- Q.2) Create Employees table
-- ================================================
CREATE TABLE Employees (
   EmpID INT PRIMARY KEY,
   FirstName VARCHAR(50),
   LastName VARCHAR(50),
   DOB DATE,
   Salary DECIMAL(10,2)
);

-- ================================================
-- Q.3) Insert sample employee records
-- ================================================
INSERT INTO Employees (EmpID, FirstName, LastName, DOB, Salary)
VALUES
(1, 'Adhi', 'v', '1985-06-15', 55000),
(2, 'Aura', 'Doe', '1990-03-22', 45000),
(3, 'biggidy', 'Smoke', '1982-11-05', 70000),
(4, 'kiki', 'Williams', '1988-01-17', 50000),
(5, 'kendrick', 'lamar', '1995-09-09', 40000),
(6, 'David', 'Bourne', '1983-05-11', 80000),
(7, 'Stepen', 'Nedumpally', '1992-07-30', 35000),
(8, 'Sop', 'W', '1987-04-14', 90000),
(9, 'Lia', 'T', '1994-12-20', 60000),
(10, 'Ol', 'A', '1989-08-25', 75000);

-- ================================================
-- Q.4) Select all employees
-- ================================================
SELECT * FROM Employees;

-- ================================================
-- Q.5) Employees with salary greater than 50000
-- ================================================
SELECT * FROM Employees WHERE Salary > 50000;

-- ================================================
-- Q.6) Update salary of EmpID 5 to 60000
-- ================================================
UPDATE Employees SET Salary = 60000 WHERE EmpID = 5;

-- ================================================
-- Q.7) Delete employee with EmpID 10
-- ================================================
DELETE FROM Employees WHERE EmpID = 10;

-- ================================================
-- Q.8) Add Department column
-- ================================================
ALTER TABLE Employees ADD Department VARCHAR(50);

-- ================================================
-- Q.9) Rename Department column to DeptName
-- ================================================
ALTER TABLE Employees CHANGE Department DeptName VARCHAR(50);

-- ================================================
-- Q.10) Employees ordered by LastName ascending
-- ================================================
SELECT * FROM Employees ORDER BY LastName ASC;

-- ================================================
-- INTERMEDIATE QUERIES
-- ================================================

-- Q.11) Distinct department names
SELECT DISTINCT DeptName FROM Employees;

-- Q.12) Average salary of all employees
SELECT AVG(Salary) AS AverageSalary FROM Employees;

-- Q.13) Number of employees per department
SELECT DeptName, COUNT(*) AS NumEmployees
FROM Employees
GROUP BY DeptName;

-- Q.14) Employees whose LastName starts with 'S'
SELECT * FROM Employees WHERE LastName LIKE 'S%';

-- Q.15) Employees born between 1980-01-01 and 1990-12-31
SELECT * FROM Employees 
WHERE DOB BETWEEN '1980-01-01' AND '1990-12-31';

-- Q.16) Employees with salary between 40000 and 60000
SELECT * FROM Employees 
WHERE Salary BETWEEN 40000 AND 60000;

-- Q.17) Top 5 highest paid employees
SELECT * FROM Employees 
ORDER BY Salary DESC
LIMIT 5;

-- Q.18) Employees with 'an' in first name
SELECT * FROM Employees 
WHERE FirstName LIKE '%an%';

-- Q.19) Employees with non-null salary
SELECT * FROM Employees WHERE Salary IS NOT NULL;

-- Q.20) Full names of employees
SELECT CONCAT(FirstName, ' ', LastName) AS FullName FROM Employees;

-- ================================================
-- JOINS & RELATIONSHIPS
-- ================================================

-- Q.21) Create Departments table
CREATE TABLE Departments (
   DeptID INT PRIMARY KEY,
   DeptName VARCHAR(50)
);

-- Q.22) Add DeptID column and foreign key
ALTER TABLE Employees ADD DeptID INT;
ALTER TABLE Employees
ADD CONSTRAINT fk_Dept FOREIGN KEY (DeptID)
REFERENCES Departments(DeptID);

-- Q.23) Insert sample departments
INSERT INTO Departments (DeptID, DeptName)
VALUES
(1, 'Finance'),
(2, 'IT'),
(3, 'HR'),
(4, 'Marketing');

-- Q.24) Inner join employees with departments
SELECT e.EmpID, e.FirstName, e.LastName, d.DeptName
FROM Employees e
INNER JOIN Departments d ON e.DeptID = d.DeptID;

-- Q.25) Departments with no employees
SELECT d.DeptName
FROM Departments d
LEFT JOIN Employees e ON d.DeptID = e.DeptID
WHERE e.EmpID IS NULL;

-- Q.26) Employees in Finance department
SELECT * FROM Employees e
JOIN Departments d ON e.DeptID = d.DeptID
WHERE d.DeptName = 'Finance';

-- Q.27) Employee and manager relationship
SELECT e.FirstName AS Employee, m.FirstName AS Manager
FROM Employees e
LEFT JOIN Employees m ON e.ManagerID = m.EmpID;

-- Q.28) Create Projects table
CREATE TABLE Projects (
   ProjectID INT PRIMARY KEY,
   ProjectName VARCHAR(100),
   DeptID INT,
   FOREIGN KEY (DeptID) REFERENCES Departments(DeptID)
);

-- Q.29) Create EmployeeProjects table
CREATE TABLE EmployeeProjects (
   EmpID INT,
   ProjectID INT,
   PRIMARY KEY (EmpID, ProjectID),
   FOREIGN KEY (EmpID) REFERENCES Employees(EmpID),
   FOREIGN KEY (ProjectID) REFERENCES Projects(ProjectID)
);

-- Q.30) Employees working on projects
SELECT p.ProjectName, e.FirstName AS EmployeeName
FROM Projects p
JOIN EmployeeProjects ep ON p.ProjectID = ep.ProjectID
JOIN Employees e ON ep.EmpID = e.EmpID;

-- ================================================
-- AGGREGATION & GROUPING
-- ================================================

-- Q.31) Total salary per department
SELECT d.DeptName, SUM(e.Salary) AS TotalSalary
FROM Employees e
JOIN Departments d ON e.DeptID = d.DeptID
GROUP BY d.DeptName;

-- Q.32) Department with highest average salary
SELECT d.DeptName, AVG(e.Salary) AS AvgSalary
FROM Employees e
JOIN Departments d ON e.DeptID = d.DeptID
GROUP BY d.DeptName
ORDER BY AvgSalary DESC
LIMIT 1;

-- Q.34) Departments with more than 3 employees
SELECT d.DeptName, COUNT(e.EmpID) AS EmpCount
FROM Employees e
JOIN Departments d ON e.DeptID = d.DeptID
GROUP BY d.DeptName
HAVING COUNT(e.EmpID) > 3;

-- Q.35) Min and max salary per department
SELECT d.DeptName,
      MIN(e.Salary) AS MinSalary,
      MAX(e.Salary) AS MaxSalary
FROM Employees e
JOIN Departments d ON e.DeptID = d.DeptID
GROUP BY d.DeptName;

-- Q.36) Departments ordered by employee count
SELECT d.DeptName, COUNT(e.EmpID) AS EmpCount
FROM Employees e
JOIN Departments d ON e.DeptID = d.DeptID
GROUP BY d.DeptName
ORDER BY EmpCount DESC;

-- Q.37) Second highest salary in company
SELECT MAX(Salary) AS SecondHighestSalary
FROM Employees
WHERE Salary < (SELECT MAX(Salary) FROM Employees);

-- Q.38) Departments with average salary below 50000
SELECT d.DeptName, AVG(e.Salary) AS AvgSalary
FROM Employees e
JOIN Departments d ON e.DeptID = d.DeptID
GROUP BY d.DeptName
HAVING AVG(e.Salary) < 50000;

-- Q.39) Departments with total salary above 200000
SELECT d.DeptName, SUM(e.Salary) AS TotalSalary
FROM Employees e
JOIN Departments d ON e.DeptID = d.DeptID
GROUP BY d.DeptName
HAVING SUM(e.Salary) > 200000;

-- Q.40) Count of employees with NULL DeptID
SELECT COUNT(*) AS NullDeptEmployees
FROM Employees
WHERE DeptID IS NULL;
