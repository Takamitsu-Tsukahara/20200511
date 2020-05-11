package demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class DemoController {
	@RequestMapping("/")
	public String index(Model model) {
		LocalDateTime today = LocalDateTime.now();
		model.addAttribute("modelYear", today.getYear());
		model.addAttribute("modelMonth", today.getMonthValue());
		model.addAttribute("modelDay", today.getDayOfMonth());
		model.addAttribute("modelWeek", today.getDayOfWeek());

		return "index";
	}

	@RequestMapping("/confirm")
	public String confirm(@ModelAttribute("msg") String arg,Model model) {

		LocalDateTime today = LocalDateTime.now();

		model.addAttribute("modelYear", today.getYear());
		model.addAttribute("modelMonth", today.getMonthValue());
		model.addAttribute("modelDay", today.getDayOfMonth());
		model.addAttribute("modelWeek", today.getDayOfWeek());

		System.out.println("msg:" + arg);

		int i = Integer.parseInt(arg);

		LocalDateTime plusYearToday = today.plusYears(i);
		model.addAttribute("year",	plusYearToday);

		LocalDateTime plusMonthToday = today.plusMonths(i);
		model.addAttribute("month",	plusMonthToday);

		LocalDateTime plusDayToday = today.plusDays(i);
		model.addAttribute("day",	plusDayToday);

		LocalDate lastDay1 = YearMonth.now().atEndOfMonth();
		model.addAttribute("last1",	lastDay1.getDayOfMonth());
		model.addAttribute("last2",	lastDay1);

		int lastDay2 = YearMonth.now().lengthOfMonth();
		model.addAttribute("last3",	lastDay2);



		return "add";
	}
}