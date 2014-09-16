package loops;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	 public static void main(String[] args) throws IOException {
		try (FileInputStream fXLSX = new FileInputStream("./src/loops/Incomes-Report.xlsx")) {
			
			ArrayList<Office> officeArray = new ArrayList<Office>();
			XSSFWorkbook wb = new XSSFWorkbook(fXLSX);			
			XSSFSheet sh = wb.getSheet("Incomes");
			float grandTotal = 0;
			
			for (int i = 1; i <= sh.getLastRowNum(); i++) {
				String town = sh.getRow(i).getCell(0).getStringCellValue();
				float totalIncomes = (float)sh.getRow(i).getCell(5).getNumericCellValue();
				boolean notInList = true;
				for (Office office : officeArray) {
	            	if (office.getTown().equals(town)) {
	            		office.setTotalIncomes(office.getTotalIncomes() + totalIncomes);
	            		notInList = false;
	            		break;
	            	}
	            }
				if (notInList) {
					officeArray.add(new Office(town, totalIncomes));
				}
			}
			
			Collections.sort(officeArray);
			for (Office office : officeArray) {
				System.out.println(office.ToStrig());
				grandTotal += office.getTotalIncomes();
			}
			System.out.println("Grand Total -> " + grandTotal);
			 
		} catch (Exception e) {
			 System.out.println("File not found.");
		}
	 }
}
