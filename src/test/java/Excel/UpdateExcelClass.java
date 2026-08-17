package Excel;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class UpdateExcelClass {

    public static void main(String[] args) throws IOException {
        //Update Existing Excel Data and Delete Cell Data, add data and delete entire row
        String filePath = System.getProperty("user.dir") + "//src//test//resources//OutputData.xlsx";

        //Open existing Excel file
        FileInputStream fileInputStream = new FileInputStream(filePath);

        //Load existing workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        //Get existing sheet
        XSSFSheet sheet = workbook.getSheet("UsersData");
        if (sheet==null){
            throw new RuntimeException("Sheet 'UsersData' not found in OutputData.xlsx");
        }

        //Update existing cell
        sheet.getRow(2).getCell(1).setCellValue("reevanshChinnaKoti@gmail.com");
        sheet.getRow(3).getCell(1).setCellValue("eshanthChinnaKoti@gmail.com");

        //Add data
        sheet.createRow(4);
        sheet.createRow(5);
        sheet.getRow(4).createCell(0).setCellValue("Azure");
        sheet.getRow(4).createCell(1).setCellValue("azure@gmail.com");
        sheet.getRow(4).createCell(2).setCellValue("9865432959");
        sheet.getRow(4).createCell(3).setCellValue("Visakhapatnam");
        sheet.getRow(4).createCell(4).setCellValue("Female");

        sheet.getRow(5).createCell(0).setCellValue("Koti");
        sheet.getRow(5).createCell(1).setCellValue("kotideepusunnychinna@gmail.com");
        sheet.getRow(5).createCell(2).setCellValue("9865432459");
        sheet.getRow(5).createCell(3).setCellValue("Visakhapatnam");
        sheet.getRow(5).createCell(4).setCellValue("Female");

        //Delete the Cell Data
        sheet.getRow(2).getCell(3).setCellValue("");

        //Delete an entire row
        int rowNumber = 4;

        //Get the row
        if (sheet.getRow(rowNumber) != null){
            //Delete the row
            sheet.removeRow(sheet.getRow(rowNumber));
            System.out.println("Deleted the row");

            // Shift remaining rows upward
            if (rowNumber<sheet.getLastRowNum()){
                sheet.shiftRows(rowNumber+1, sheet.getLastRowNum(),-1);
            }
            System.out.println("Row deleted successfully");
        }

        fileInputStream.close();

        //Write changes back to same Excel file
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        workbook.close();
        System.out.println("Excel data updated successfully!");
    }
}
