package Excel;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcelClass {
    public static void main(String[] args) throws IOException {
        //Write data into excel
        //create workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        //create sheet
        XSSFSheet sheet = workbook.createSheet("UsersData");

        //create header row
        sheet.createRow(0);
        sheet.getRow(0).createCell(0).setCellValue("Name");
        sheet.getRow(0).createCell(1).setCellValue("Email");
        sheet.getRow(0).createCell(2).setCellValue("Phone");
        sheet.getRow(0).createCell(3).setCellValue("Address");
        sheet.getRow(0).createCell(4).setCellValue("Gender");

        //create first row data
        sheet.createRow(1);
        sheet.getRow(1).createCell(0).setCellValue("Chinna");
        sheet.getRow(1).createCell(1).setCellValue("chinnakoti@gmail.com");
        sheet.getRow(1).createCell(2).setCellValue("9856432689");
        sheet.getRow(1).createCell(3).setCellValue("Visakhapatnam");
        sheet.getRow(1).createCell(4).setCellValue("Male");

        String filePath = System.getProperty("user.dir")+"//src//test//resources//OutputData.xlsx";

        //write workbook to a file
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        workbook.write(fileOutputStream);

        fileOutputStream.close();
        workbook.close();
        System.out.println("Data written successfully into Excel");
    }
}
