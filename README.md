[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/pG3gvzt-)
# PCCCS495 – Term II Project

## Project Title
Payroll Management System

## Problem Statement (max 150 words)
Manual payroll calculation is time-consuming and error-prone. This system automates salary calculation for different types of employees efficiently.

## Target User
- Add employee details
- Calculate salary automatically
- Supports full-time and part-time employees

## Core Features
- Add employee details
- Calculate salary automatically
- Supports full-time and part-time employees

## OOP Concepts Used
- Abstraction
- Inheritance
- Polymorphism

## Proposed Architecture Description
The system follows an Object-Oriented architecture where a base class "Employee" defines common attributes like id and name, along with an abstract method calculateSalary().

Two subclasses extend this base class:
- FullTimeEmployee: calculates salary based on fixed monthly salary
- PartTimeEmployee: calculates salary based on hourly rate and hours worked

The application uses polymorphism to call the appropriate calculateSalary() method at runtime depending on the employee type.

A GUI (Graphical User Interface) is implemented using Java Swing, allowing users to input employee details and view salary results.

Overall flow:
User Input (GUI) → Create Employee Object → Salary Calculation → Display Output

## How to Run
1. Open Command Prompt or Terminal
2. Navigate to the project directory

3. Compile the Java files:
   javac payroll/*.java

4. Run the main class:
   java payroll.PayrollGUI

5. The GUI window will open
6. Enter employee details and calculate salary

## Git Discipline Notes
Maintained regular commits throughout development. 
The project includes more than 10 meaningful commits covering:
- Initial project setup
- Adding core classes (Employee, FullTimeEmployee, PartTimeEmployee)
- Implementing salary calculation logic
- GUI development
- Error handling
- Final testing and improvements
