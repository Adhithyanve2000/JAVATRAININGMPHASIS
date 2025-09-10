-- ================================================
-- Q.1) Get all employees
-- Creates a stored procedure to select all records from 'employees' table
-- ================================================
DELIMITER //
CREATE PROCEDURE GetAllEmployees()
BEGIN
    SELECT * FROM employees;
END//
DELIMITER ;

-- ================================================
-- Q.2) Get employees by department
-- Selects employees from a specific department passed as input parameter
-- ================================================
DELIMITER //
CREATE PROCEDURE Getemployeesbydepartment(IN department11 VARCHAR(50))
BEGIN
    SELECT * FROM employees WHERE department = department11;
END//
DELIMITER ;

-- ================================================
-- Q.3) Add a new employee
-- Inserts a new record into the 'employees' table using input parameters
-- ================================================
DELIMITER //
CREATE PROCEDURE AddEmployee(
    IN p_emp_id INT,
    IN p_name VARCHAR(50),
    IN p_department VARCHAR(50),
    IN p_salary DECIMAL(10,2)
)
BEGIN
    INSERT INTO employees (emp_id, name, department, salary)
    VALUES (p_emp_id, p_name, p_department, p_salary);
END//
DELIMITER ;

-- ================================================
-- Q.4) Update employee salary
-- Updates the salary of an employee identified by name
-- ================================================
DELIMITER //
CREATE PROCEDURE Updatesalary(
    IN namep VARCHAR(50),
    IN salaryp DECIMAL(10,2)
)
BEGIN
    UPDATE employees SET salary = salaryp WHERE name = namep;
END//
DELIMITER ;

-- ================================================
-- Q.5) Delete employee by ID
-- Deletes a record from 'employees' table using employee ID
-- ================================================
DELIMITER //
CREATE PROCEDURE DeleteEmployeeById(IN p_emp_id INT)
BEGIN
    DELETE FROM employees WHERE emp_id = p_emp_id;
END//
DELIMITER ;

-- ================================================
-- Q.6) Get total salary by department
-- Aggregates salaries grouped by department
-- ================================================
DELIMITER //
CREATE PROCEDURE GetTotalSalaryByDept()
BEGIN
    SELECT department, SUM(salary) AS total_salary
    FROM employees
    GROUP BY department;
END//
DELIMITER ;

-- ================================================
-- Q.7) Get orders above a specific amount
-- Selects orders with amount greater than input parameter
-- ================================================
DELIMITER //
CREATE PROCEDURE GetOrdersAboveAmount(IN min_amount DECIMAL(10,2))
BEGIN
    SELECT * FROM orders WHERE amount > min_amount;
END//
DELIMITER ;

-- ================================================
-- Q.8) Get department location
-- Retrieves the location of a department by its name
-- ================================================
DELIMITER //
CREATE PROCEDURE GetDepartmentLocation(IN dept_name VARCHAR(50))
BEGIN
    SELECT location
    FROM departments1 
    WHERE name = dept_name;
END//
DELIMITER ;

-- ================================================
-- Q.9) Get highest paid employee
-- Selects the employee with the highest salary
-- ================================================
DELIMITER //
CREATE PROCEDURE GetHighestPaidEmployee()
BEGIN
    SELECT *
    FROM employees
    ORDER BY salary DESC
    LIMIT 1;
END//
DELIMITER ;

-- ================================================
-- Q.10) Count employees by department
-- Returns the number of employees in each department
-- ================================================
DELIMITER //
CREATE PROCEDURE CountEmployeesByDepartment()
BEGIN
    SELECT department, COUNT(*) AS employee_count
    FROM employees
    GROUP BY department;
END//
DELIMITER ;
