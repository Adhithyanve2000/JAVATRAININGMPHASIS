package com.example.BatchAPIorders.controller;

import java.time.Duration;
import java.time.LocalDate;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	


	/*
	 * JobParametersBuilder - a framework used to process large volumes of data in
	 * batch jobs - It will helps to build & manage JobParameter for job execution
	 * 
	 * Key Methods in JobParametersBuilder
	 *   addString(String key, String value): Adds a String parameter. 
	 *   addLong(String key, Long value): Adds a Long parameter. 
	 *   addDouble(String key, Double value): Adds a Double parameter. 
	 *   addDate(String key, Date value): Adds a Date parameter. 
	 *   addBoolean(String key, Boolean value): Adds a Boolean parameter.
	 * 
	 * JobParameters - is used to pass parameters to job. 
	 * - it includes various types of parameters, such as String, Long, Date, and Double. 
	 * 
	 * 
	 * 
	 * JobLauncher(I): used to launch Spring batch job
	 *  - provides run() method to trigger job execution with set of parameters
	 *  - JobLauncher takes care of launching jobs, tracking job execution, 
	 *    and ensuring that jobs can be executed in a controlled manner.
	 *    Key Methods - 
	 *     run(Job job, JobParameters jobParameters): 
	 *       job - The actual job to execute.
	 *       jobParameters - Parameters passed to the job (e.g., input files, execution date).
	 */



		// JobLauncher - To launch job
		@Autowired
		private JobLauncher jobLauncher;

		@Autowired
		private Job job;

		// End point to start job
		@PostMapping("/import/orders")
		void importCSVtoDBJob() {

			// Create JobParameter Object using JobParametersBuilder  
			// toJobParameters() - Converts JobParametersBuilder object to JobParameters object,
			// 						which can be passed to jobLauncher.
			JobParameters jobParameters = 
					new JobParametersBuilder()
					.addLocalDate("startDate", LocalDate.now())
					.addLong("startAt", System.currentTimeMillis())
					.toJobParameters();

			try {
				// Launching job with job parameters
				// jobExecution: is an object, which contains information about the execution status of the job 
				//    	(whether it was successful or failed).
				JobExecution jobExecution = jobLauncher.run(job, jobParameters);
				
				// Logging job execution details
		        System.out.println("Job Start Time: " + jobExecution.getStartTime());
		        System.out.println("Job Status: " + jobExecution.getStatus());
		        System.out.println("Job Exit Status: " + jobExecution.getExitStatus());
		        System.out.println("Job End Time: " + jobExecution.getEndTime());
		        
		        // Calculate the difference
		        Duration duration = Duration.between(jobExecution.getStartTime(), jobExecution.getEndTime());
		        System.out.println("Duration: " +duration);
		     // Get the hours and minutes from the duration
		        long hours = duration.toHours();
		        long minutes = duration.toMinutes() % 60;
		        long seconds = duration.toSeconds();

		        // Print the difference
		        System.out.println("Time difference: " + hours + " hours, " + minutes + " minutes and " + seconds + " seconds. ");
		    
		        
				
			} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
					| JobParametersInvalidException e) {

				e.printStackTrace();
			}
		}
}
	
