package parseCSV;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

public class Uppgift4FJ {
	private static String COMMA_DELIMITER = ",";
	public static void main(String[] args) {
		List<List<String>> records = new ArrayList<>();
		List<String> nameColumn = new ArrayList<String>(); // Since it's used multiple times, I declare it here and pass to methods.
		try (Scanner scanner = new Scanner(new File("sample.csv"));) {
			while (scanner.hasNextLine()) {
				records.add(getRecordFromLine(scanner.nextLine()));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		// Adds the names from both columns to the list.
		for(List<String> row:records){ 
			nameColumn.add(row.get(1));
			nameColumn.add(row.get(2));
		}
		countAs(nameColumn);
		findDuplicateDates(records, nameColumn);
		countAndroids(records);

	}

	// Using uniocity parser I get only the needed columns from the sample.csv file. 
	private static List<String[]> getColumns(String name, String email, String name2, String email2) {
		List<String[]> parsedRows = new ArrayList<String[]>();
		try (Reader inputReader = new InputStreamReader(new FileInputStream(
			new File("sample.csv")), "UTF-8")) {
				CsvParserSettings settings = new CsvParserSettings();
				settings.getFormat().setLineSeparator("\n");
				settings.setHeaderExtractionEnabled(true);
				settings.selectFields(name, email, name2, email2);
				settings.setSkipEmptyLines(true);
				settings.setNullValue("NULL");
				settings.setEmptyValue("EMPTY");
			  CsvParser parser = new CsvParser(settings);
			  
			  parsedRows = parser.parseAll(inputReader);
			  
		  } catch (IOException e) {
			  // handle exception
		  }
		  return parsedRows;
	}

	private static List<String> getRecordFromLine(String line) {
		List<String> values = new ArrayList<String>();
		try (Scanner rowScanner = new Scanner(line)) {
			rowScanner.useDelimiter(COMMA_DELIMITER);
			while (rowScanner.hasNext()) {
				values.add(rowScanner.next());
			}
		}
		return values;
	}

	private static void countAs(List<String> nameColumn) {
		int count = 0;
		for(int i=1; i<nameColumn.size(); i++) {
			if (nameColumn.get(i).contains("a") || nameColumn.get(i).contains("A")) {
				count++;
			}
		}
		System.out.println(count + " names contains \"a or A\".");
	}

	
	private static void countAndroids(List<List<String>> records) {
		List<String> androidColumn = new ArrayList<String>();
		int count = 0;
		for(List<String> row : records){ 
			androidColumn.add(row.get(6));
		}
		// If the row indicates the user has "Android app" increase count
		for(String android : androidColumn) {
			if (android.equals("Android App")){
				count++;
			}	
		}
		System.out.println(count * 2 + " individuals have decided work with Android"); // Two names on each row, so the count needs to be doubled.
	}


	private static void findDuplicateDates(List<List<String>> records, List<String> nameColumn) {
		Map<Integer, String> uniqueDates = new HashMap<>();
		Map<Integer, String> duplicateDates = new HashMap<>();

		List<String> dateColumn = new ArrayList<String>();
		
		// Using two hashmaps, it checks when adding to first if value already exists, then add it to second (duplicateDates) 
		// together with the index as key (the index corresponds to the namecolumns index.)
		int z = 0;
		for(List<String> row : records){ 
			dateColumn.add(row.get(0));
			if(uniqueDates.containsValue(dateColumn.get(z)) && !dateColumn.get(z).equals("")) {
				duplicateDates.put(z, dateColumn.get(z));
			}
			else {
				uniqueDates.put(z, dateColumn.get(z));
			}
			z++;
		}

		// Using the list of duplicate dates, check where the date matches in the whole date column and print names corresponding to the (duplicate) indices
		for (Map.Entry<Integer, String> entry : duplicateDates.entrySet()) {
			for(int i=1; i<dateColumn.size(); i++) {
				if (duplicateDates.get(entry.getKey()).equals(dateColumn.get(i)) && !dateColumn.get(i).equals("") && !nameColumn.get(entry.getKey() * 2).equals(nameColumn.get(i * 2))) {
					System.out.println(nameColumn.get(entry.getKey() * 2) + " and " + nameColumn.get(entry.getKey() * 2 + 1) + " have the same timestamp as " + nameColumn.get(i * 2)  + " and " + nameColumn.get(i * 2 + 1));
				}
			}
		}
	}

}