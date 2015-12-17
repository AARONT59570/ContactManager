package contactManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class MeetingImpl implements Meeting {
	int iD;
	String strdate;
	String contacts;
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
	public int getID()
	{
		return this.iD;
	}
	public Set<Contact> getContacts(Set<Contact> allContacts)
	{
		String[] contactsSlit = contacts.split(" ");
		Set<Contact> contactSet = new LinkedHashSet<Contact>();
		for (int j = 0; j < contactsSlit.length; j++) {
			for (Iterator iterator  = allContacts.iterator(); iterator.hasNext();) {
				Contact contact = (Contact)iterator.next();
				if (contact.getID() == Integer.parseInt(contactsSlit[j]))
					contactSet.add(contact);
			}
		}
		return contactSet;
	}
	public MeetingImpl(int ID, String date, String contacts)
	{
		this.iD = ID;
		this.strdate = date;
		this.contacts = contacts;
	}
}
