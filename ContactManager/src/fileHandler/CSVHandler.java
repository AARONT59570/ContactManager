package fileHandler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVHandler {
	private boolean newFile = false;
	@SuppressWarnings("unchecked")
	public ArrayList<String[]> ReadFile(String path)
	{
		String csvFilePath = path;
		File csvFile = null;
		try {
			csvFile = new File(csvFilePath);
			if(csvFile.createNewFile())
			{
				System.out.println("New CSV File Created");
				newFile = true;
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		try {
			BufferedReader br = new BufferedReader(new FileReader(csvFile));
			br.readLine();
			String line;
			String[] row;
			List list = new ArrayList<String[]>();
			while((line = br.readLine()) != null)
			{
				row = line.split(",");
				list.add(row);
			}
			return (ArrayList<String[]>)list;
		} catch (IOException e)
		{ 
			e.printStackTrace();
		}
		return null;
	}
	public void WriteFile(String path, String header, ArrayList<String[]> list, boolean append)
	{
		String csvFilePath = path;
		File csvFile = null;
		try {
			csvFile = new File(csvFilePath);
			if(csvFile.createNewFile())
			{
				System.out.println("New CSV File Created");
				append = false;
				newFile = true;
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		try {
			FileWriter bw = new FileWriter(csvFile, append);
			if (!append)
			{
				bw.append(header);
			}
			bw.append("\n");
			for (int i = 0; i < list.size(); i++) {
				String[] row = list.get(i);
				for (int j = 0; j < row.length; j++) {
					bw.append(row[j] + ",");
				}
				bw.append("\n");
			}
			bw.close();
		} catch (IOException e)
		{ 
			e.printStackTrace();
		}
	}
}
