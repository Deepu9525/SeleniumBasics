package Excel;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadMultipleExcelFilesClass {
    //Read Multiple Excel Files
    public static void readExcelData(String filePath, String sheetName) throws IOException {
        System.out.println("===================");
        System.out.println("File Path: " + filePath);
        System.out.println("Sheet name: " + sheetName);
        System.out.println("===================");

        //Open Excel file
        FileInputStream fileInputStream = new FileInputStream(filePath);

        //Load Workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        //Get data from Excel file
        XSSFSheet sheet = workbook.getSheet(sheetName);
        if (sheet==null){
            throw new RuntimeException("Sheet: '" + sheetName + "' not found");
        }

        //DataFormater(Any data in string format)
        DataFormatter formatter = new DataFormatter();

        //Get last row number
        int lastRowNum = sheet.getLastRowNum();
        //Get row data dynamically
        System.out.println("Values from excel: ");
        for (int i=0; i<=lastRowNum; i++){
            //Get last cell num
            int lastCellNum = sheet.getRow(i).getLastCellNum();
            //Get cell data dynamically
            for (int j= 0; j<lastCellNum; j++){
                String value = formatter.formatCellValue(sheet.getRow(i).getCell(j));
                System.out.print(value + "|");
            }
            System.out.println();
        }
        fileInputStream.close();
        workbook.close();
    }
    public static void main(String[] args) throws IOException {
        //Files location
        String testDataFilePath = System.getProperty("user.dir")+"//src//test//resources//TestData.xlsx";
        String outputDataFilePath = System.getProperty("user.dir")+"//src//test//resources//OutputData.xlsx";

        readExcelData(testDataFilePath, "Users");
        readExcelData(outputDataFilePath, "UsersData");

    }
}
