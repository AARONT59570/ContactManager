package contactManager;

import java.util.Calendar;
import java.util.Set;

public interface Meeting {
	int getID();
	Calendar getDate();
	Set<Contact> getContacts();
}
