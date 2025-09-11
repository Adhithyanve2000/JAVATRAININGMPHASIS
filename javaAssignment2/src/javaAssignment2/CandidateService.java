package javaAssignment2;

import java.util.*;
import java.util.stream.Collectors;

public class CandidateService {


	
         

	    // 1. Get count of male and female employees
	    public static Map<String, Long> getCount(List<Candidate> list) {
	        return list.stream()
	                .collect(Collectors.groupingBy(Candidate::getGender, Collectors.counting()));
	    }

	    // 2. Get average age of male and female employees
	    public static Map<String, Double> getAverageAge(List<Candidate> list) {
	        return list.stream()
	                .collect(Collectors.groupingBy(Candidate::getGender, Collectors.averagingInt(Candidate::getAge)));
	    }

	    // 3. Count employees department-wise
	    public static Map<String, Long> countCandidatesDepartmentWise(List<Candidate> list) {
	        return list.stream()
	                .collect(Collectors.groupingBy(Candidate::getDepartment, Collectors.counting()));
	    }

	    // 4. Get youngest male candidate in product development department
	    public static Optional<Candidate> getYoungestCandidateDetails(List<Candidate> list) {
	        return list.stream()
	                .filter(c -> c.getGender().equalsIgnoreCase("Male"))
	                .filter(c -> c.getDepartment().equalsIgnoreCase("Product Development"))
	                .min(Comparator.comparingInt(Candidate::getAge));
	    }
	}


