package contactManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import fileHandler.CSVHandler;

public class ContactController {
	private static String documentsPath = System.getProperty("user.home") + File.separatorChar + "Documents" + File.separatorChar;
	private static Set<Contact> contacts;
	private static Set<Meeting> meetings;
	private static CSVHandler csv;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		csv = new CSVHandler();
		ArrayList<String[]> contactsRaw = csv.ReadFile(documentsPath + "Contacts.csv");
		contacts = new LinkedHashSet<Contact>();
		for (Iterator iterator = contactsRaw.iterator(); iterator.hasNext();) {
			String[] strings = (String[]) iterator.next();
			Contact c = new ContactImpl(Integer.parseInt(strings[0]), strings[1], strings[2]);
			contacts.add(c);
		}
		meetings = new LinkedHashSet<Meeting>();
		ArrayList<String[]> meetingsRaw = csv.ReadFile(documentsPath + "Meetings.csv");
		for (Iterator iterator = meetingsRaw.iterator(); iterator.hasNext();) {
			String[] strings = (String[]) iterator.next();
			Meeting c = new MeetingImpl(Integer.parseInt(strings[0]), strings[1], strings[2]);
			meetings.add(c);
		}
		
		

	}

}
