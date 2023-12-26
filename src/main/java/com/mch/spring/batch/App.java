package com.mch.spring.batch;
import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * Converting  CSV file (report.csv) file to XML file 
 * using Spring Bacth 3.0.8
 * MCH
 */
public class App 
{
    public static void main( String[] args )
    {

		String[] springConfig = { "spring/batch/jobs/job-batch-conf.xml" };

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(springConfig);

		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		Job job = (Job) context.getBean("JobConvertCsvToXML");
		 /*
		 JobParameters jobParameters = new JobParametersBuilder().addString("YOUR_PARAM1", "VALUE-1").addLong("time", System.currentTimeMillis()) 
				.toJobParameters(); //1703516744972
		
		JobParameters jobParameters = new JobParametersBuilder().addString("jobKey", null)
				.toJobParameters();
        /*
		JobParameters jobParameters = new JobParametersBuilder().addString("jobKey", "0fa01cf1ffafbbe8bb015f5244a7a7d2")
				.toJobParameters();
		*/
		 
		 JobParameters jobParameters = new JobParametersBuilder()
	            .addString("JobId", String.valueOf(System.currentTimeMillis()))
	            .addDate("date", new Date())
	            .addLong("time",System.currentTimeMillis()).toJobParameters();
		try {

			JobExecution execution = jobLauncher.run(job, jobParameters);
			System.out.println("Exit Status : " + execution.getStatus());

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Done");
		context.close();
    }
}
