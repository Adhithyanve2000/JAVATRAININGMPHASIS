package com.example.BatchAPIorders.config;


import java.util.logging.Logger;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileParseException;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.example.BatchAPIorders.entity.Order;
import com.example.BatchAPIorders.repository.OrderRepository;




@Configuration
public class BatchConfig {

	@Autowired
	private PlatformTransactionManager transactionManager;
	
	@Autowired
	private JobRepository jobRepository;

	@Autowired
	OrderRepository orderRepository;
	

	Logger logger = Logger.getLogger("BatchConfig");

	// Item Reader
	// FlatFileItemReader - reads content from CSV file
	@Bean
	FlatFileItemReader<Order> reader() {
		FlatFileItemReader<Order> fileReader = new FlatFileItemReader<>();
		fileReader.setStrict(false);
		
		logger.info("Created FlatFileItemReader object");
		
		// Specify csv path
		fileReader.setResource(new FileSystemResource("C:\\Users\\adhithyan.ellathu\\Downloads\\Orders 1.csv"));

		logger.info("Configured resource path");
		
		// set name to fileReader
		fileReader.setName("csvReader");
		
		// Ignore header from csv
		fileReader.setLinesToSkip(1);
		
	
		
		// define Line mapper - maps each line in csv to java obj
		fileReader.setLineMapper(lineMapper());

		return fileReader;
	}

	// LineMapper: to read content from csv and map to java object
	private LineMapper<Order> lineMapper() {

		// Create Line mapper object
		DefaultLineMapper<Order> lineMapper = new DefaultLineMapper<>();

		// LineTokenizer extract values from csv
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

		// Tokenize each line with delimiter
		lineTokenizer.setDelimiter(",");
		
		// Don't follow strict rule, some columns may not have data
		lineTokenizer.setStrict(false);

		// Setting header information
		lineTokenizer.setNames("id","order_date","ship_mode","customer_id", "sales");

		// FieldSetMapper maps CSV to Customer Object
		BeanWrapperFieldSetMapper<Order> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(Order.class);

		// Update fieldSetMapper & lineTokenizer in lineMapper
		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(fieldSetMapper);

		return lineMapper;
	}
	

	// Item Processor
	//@Bean
	/*OrderProcessor processor() {
		return new OrderProcessor();
	}*/
	

	// Item Writer - writes data to DB
	RepositoryItemWriter<Order> writer() {
		RepositoryItemWriter<Order> itemWriter = new RepositoryItemWriter<>();

		// set repository to be used to write data in db
		itemWriter.setRepository(orderRepository);

		// set method to be used to save the data in db
		itemWriter.setMethodName("save");

		return itemWriter;
	}


	/*
	 * faultTolerant - handle faults (errors) gracefully, without crashing or interrupting the operation.
	 * skipLimit - tells the system to "skip" or ignore any FlatFileParseException errors that occur
	 * skip - system should allow a maximum of 30 FlatFileParseException exceptions to be skipped.
	 *  JobRepository
	 *   - is responsible for persisting and tracking the state of jobs and steps during execution. 
	 *   - It stores metadata such as the status of job executions, the number of items processed, and any errors that occurred.
	 *  StepBuilder - creates a StepBuilder object for configuring a new step, named "step1", which will be part of a batch job.
	 *  transactionManager - reference to the transaction manager
	 *   - handles the transactions for the chunk of work
	 *   - ensures that processing is atomic — meaning either all items in the chunk are processed successfully, 
	 *     or if something goes wrong, none of them are committed (rolled back).
	 *  chunk(10, transactionManager) - Chunk based processing
	 *   - breaks the processing into chunks of 10 items at a time
	 *   - 10 - chunk size 
	 */
	// Step
//	@Bean
//	Step step1() {
//		return new StepBuilder("step1", jobRepository)
//				.<Customer, Customer>chunk(10, transactionManager)
//				.reader(reader())
//				.processor(processor())
//				.writer(writer()) // Your ItemWriter implementation
//				.listener(new CustomerSkipListner())  // Register the SkipListener here
//				.listener(new CustomerReaderListner())
//				.faultTolerant()
//				.skip(FlatFileParseException.class)
//				.skipLimit(50)
//				.retry(Exception.class)
//				.retryLimit(3)
//				.build();
//	}
	
	@Bean
	Step step1() {
		return new StepBuilder("step1", jobRepository)
				.<Order, Order>chunk(10, transactionManager)
				.reader(reader())
				.writer(writer()) // Your ItemWriter implementation
				.faultTolerant()
				.skip(FlatFileParseException.class)
				.skipLimit(50)
				.build();
	}

	// Dummy
//	@Bean
//	Step step() {
//		return new StepBuilder("step", jobRepository)
//				.<Customer, Customer>chunk(10, transactionManager) // Defines the chunk size as 10
//				.reader(reader()) // Your ItemReader implementation
//				.processor(processor()) // Your ItemProcessor implementation
//				.writer(writer()) // Your ItemWriter implementation
//				.faultTolerant()
//				.skip(FlatFileParseException.class)
//				.skipLimit(100)
//				.retry(Exception.class)
//		        .retryLimit(3)
//				.build();
//	}

	// Job
	// customerJob - name of the job
	
	@Bean
	Job job() {
		//JobBuilder(String name, JobRepository jobRepository)
		return new JobBuilder("orderJob", jobRepository)
				.incrementer(new RunIdIncrementer())
				.start(step1())
				.build();
	}
}
