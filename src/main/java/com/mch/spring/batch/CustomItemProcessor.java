package  com.mch.spring.batch;

import org.springframework.batch.item.ItemProcessor;
 
import  com.mch.spring.batch.model.Report;
/**
 * 
 * @author mahdi
 *
 */
public class CustomItemProcessor implements ItemProcessor<Report, Report> {

	public Report process(Report item) throws Exception {
		
		System.out.println("Processing..." + item);
		String fname = item.getFirstName();
		String lname = item.getLastName();
		
		item.setFirstName(fname.toUpperCase());
		item.setLastName(lname.toUpperCase());
		return item;
	}

}