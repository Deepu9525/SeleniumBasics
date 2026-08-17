package Excel;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteMultipleRowsClass {
    public static void main(String[] args) throws IOException {
        //Write Multiple Rows Dynamically into to existing Excel
        //Existing file
        String filePath = System.getProperty("user.dir") + "//src//test//resources//OutputData.xlsx";

        //Open existing Excel file
        FileInputStream fileInputStream = new FileInputStream(filePath);

        //Load existing workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        //Get existing sheet
        XSSFSheet sheet = workbook.getSheet("UsersData");

        if (sheet == null) {
            throw new RuntimeException("Sheet 'UsersData' not found in OutputData.xlsx");
        }

        //Data to add
        String[][] data = {
                {"Reevansh", "reevansh@gmail.com", "9865432189", "Visakhapatnam", "Male"},
                {"Eshanth", "eshanth@gmail.com", "9865430249", "Visakhapatnam", "Male"},
        };

        //Find next empty row
        int row = sheet.getLastRowNum()+1;

        //Add multiple rows dynamically
        for (int i=0; i<data.length; i++){
            //Create new row
            sheet.createRow(row+i);

            //Create cells and write data
            for (int j=0; j<data[i].length;j++){
                sheet.getRow(row+i).createCell(j).setCellValue(data[i][j]);
            }

        }

        fileInputStream.close();

        //Write changes back to same Excel file
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        workbook.close();
        System.out.println("Multiple rows added successfully!");
    }
}
