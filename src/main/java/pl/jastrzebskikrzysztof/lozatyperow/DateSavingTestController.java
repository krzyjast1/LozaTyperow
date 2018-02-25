package pl.jastrzebskikrzysztof.lozatyperow;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DateSavingTestController {
	
	@Autowired
	private DateSavingTestRepository repo;
	
	@GetMapping("/{id}")
	public DateSavingTest getJavaDate(@PathVariable Long id) {
		return repo.findOne(id);
	}
	
	@GetMapping("/savetestdate")
	public @ResponseBody String addJavaDate() {
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		String strdate = "17/02/2018 17:00";
		DateSavingTest dst = new DateSavingTest();
		try {
			Date date = dateformat.parse(strdate);
			dst.setDate(date);
			repo.save(dst);
		} catch (Exception e) {
			return e.toString();
		}
		return "SAVED";
		
		/*String date = "2011-12-03T10:15:30+01:00[Europe/Paris]";
		try {
			ZonedDateTime zdt = ZonedDateTime.parse(date, DateTimeFormatter.ISO_ZONED_DATE_TIME);
			DateSavingTest dst = new DateSavingTest();
			dst.setDate(zdt);
			repo.save(dst);
		} catch(Exception e) {
			return e.toString();
		}
		return "SAVED"; */
	}
	
}
