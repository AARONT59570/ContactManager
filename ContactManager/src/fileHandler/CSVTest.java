package fileHandler;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CSVTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CSVHandler csv = new CSVHandler();
		ArrayList<String[]> list = new ArrayList<String[]>();
		String[] str = {"test1", "test2", "test3", "test4"};
		list.add(str);
		list.add(str);
		list.add(str);
		list.add(str);
		csv.WriteFile(System.getProperty("user.home") + File.separatorChar + "Documents" + File.separatorChar + "records2.csv", "1,2,3,4", list, true);
	}

}
