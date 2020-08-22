Create a result set, that returns a list of all employees with an existing DepartmentID in the Department table.

Create a result set, that returns a list of group count of employees by department.

Create a result set, that returns a list of all employees that were enrolled in the past year and belongs to department HR. (Using CONVERT function, and adding style to ‘RegistrationDate’)

Create a result set, that returns a list of all employees younger than 26 years old. (Using DATEIFF function)

select EmployeeID from Employees where
 DepartmenID > 0;

select count(EmployeeID) from Employees where DepartmenID Between '1' and '3';

select EmployeeID from Employees where DATEIFF(YEAR, 26, D)

