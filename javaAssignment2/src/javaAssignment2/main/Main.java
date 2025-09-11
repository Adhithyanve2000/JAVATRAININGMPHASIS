package javaAssignment2.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import javaAssignment2.Candidate;

import javaAssignment2.CandidateService;
public class Main {
	    public static void main(String[] args) {
	    
	    	        Scanner sc = new Scanner(System.in);

	    	        List<Candidate> candidates = new ArrayList<>();

	    	        System.out.print("Enter number of candidates: ");
	    	        int n = sc.nextInt();
	    	        sc.nextLine(); 

	    	        for (int i = 0; i < n; i++) {
	    	            System.out.println("\nEnter details of candidate " + (i + 1));

	    	            System.out.print("ID: ");
	    	            int id = sc.nextInt();
	    	            sc.nextLine();

	    	            System.out.print("Name: ");
	    	            String name = sc.nextLine();

	    	            System.out.print("Age: ");
	    	            int age = sc.nextInt();
	    	            sc.nextLine();

	    	            System.out.print("Gender (Male/Female): ");
	    	            String gender = sc.nextLine();

	    	            System.out.print("Department: ");
	    	            String department = sc.nextLine();

	    	            System.out.print("Year of Joining: ");
	    	            int yearOfJoining = sc.nextInt();

	    	            System.out.print("Salary: ");
	    	            double salary = sc.nextDouble();
	    	            sc.nextLine();

	    	            
	    	            candidates.add(new Candidate(id, name, age, gender, department, yearOfJoining, salary));
	    	        }

	    	        // Call methods from Service class
	    	        System.out.println("\n--- Results ---");

	    	        System.out.println("Count of Male/Female Employees:");
	    	        System.out.println(CandidateService.getCount(candidates));

	    	        System.out.println("\nAverage Age of Male/Female Employees:");
	    	        System.out.println(CandidateService.getAverageAge(candidates));

	    	        System.out.println("\nDepartment-wise Employee Count:");
	    	        System.out.println(CandidateService.countCandidatesDepartmentWise(candidates));

	    	        System.out.println("\nYoungest Male in Product Development:");
	    	        Optional<Candidate> youngest = CandidateService.getYoungestCandidateDetails(candidates);
	    	        youngest.ifPresentOrElse(
	    	                System.out::println,
	    	                () -> System.out.println("No male candidate found in Product Development department")
	    	        );

	    	        sc.close();
	    	    }
	    	

	    }

