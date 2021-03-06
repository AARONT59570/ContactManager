package contactManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MeetingImpl {
	private String[] record;
	@SuppressWarnings("finally")
	public Calendar getDate()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Calendar calendarDate = null;

		try {
			calendarDate = Calendar.getInstance();
			Date date = null;
			if (calendarDate!= null) {
				date = sdf.parse(record[1]);
				calendarDate.setTime(date);
			}
			

		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			return calendarDate;
		}
	}
}
