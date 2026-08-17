package Excel;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadAllRowsDynamicallyClass {
    public static void main(String[] args) throws IOException {
        //Read ALL rows dynamically
        //filepath
        String filePath = System.getProperty("user.dir")+ "//src//test//resources//TestData.xlsx";

        //file opening
        FileInputStream fileInputStream = new FileInputStream(filePath);

        //Create Workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        //DataFormatter
        DataFormatter formatter = new DataFormatter();

        //Create sheet
        XSSFSheet sheet = workbook.getSheet("Users");
        int rows = sheet.getLastRowNum();
        System.out.println("Last Row number: " + rows);
        for (int i=1; i<=rows; i++){
            /*String name = sheet.getRow(i).getCell(0).getStringCellValue();
            String email = sheet.getRow(i).getCell(1).getStringCellValue();
            String phone = formatter.formatCellValue(sheet.getRow(i).getCell(2));
            String address = sheet.getRow(i).getCell(3).getStringCellValue();
            String gender = sheet.getRow(i).getCell(4).getStringCellValue();*/

            //Read all rows & columns dynamically using DataFormatter
            String name = formatter.formatCellValue(sheet.getRow(i).getCell(0));
            String email = formatter.formatCellValue(sheet.getRow(i).getCell(1));
            String phone = formatter.formatCellValue(sheet.getRow(i).getCell(2));
            String address = formatter.formatCellValue(sheet.getRow(i).getCell(3));
            String gender = formatter.formatCellValue(sheet.getRow(i).getCell(4));

            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
            System.out.println("Phone: " + phone);
            System.out.println("Address: " + address);
            System.out.println("Gender: " + gender);
            System.out.println("=========");
        }
        workbook.close();
        fileInputStream.close();
    }
}
