package Excel;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcelClass {
    //Read single row
    //Read all rows dynamically
    //Write data to Excel
    //Write multiple rows
    //Append rows to existing Excel
    //Update existing Excel data and Delete Cell Data, add data and delete entire row
    //Read data from multiple Excel files
    //Excel + Selenium Data-Driven Testing

    public static void main(String[] args) throws IOException {
        //single-row data from excel
        //File path
        String filePath = System.getProperty("user.dir")+ "//src//test//resources//TestData.xlsx";

        //open excel file
        FileInputStream fileInputStream = new FileInputStream(filePath);

        //create workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        // DataFormatter
        DataFormatter formatter = new DataFormatter();

        //Get sheet
        XSSFSheet sheet = workbook.getSheet("Users");

        //read first row and first cell
        String name = sheet.getRow(1).getCell(0).getStringCellValue();
        String email = sheet.getRow(1).getCell(1).getStringCellValue();
        String phone = formatter.formatCellValue(sheet.getRow(1).getCell(2));
        String address = sheet.getRow(1).getCell(3).getStringCellValue();
        String gender = sheet.getRow(1).getCell(4).getStringCellValue();

        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Address: " + address);
        System.out.println("Gender: " + gender);

        workbook.close();
        fileInputStream.close();
    }
}
