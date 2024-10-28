package com.utility;


import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {
    public static Object[][] getTestData(String sheetName) {
        FileInputStream file;
        Workbook workbook;
        Sheet sheet;

        try {
            file = new FileInputStream("src/test/resources/TestData.xlsx");
            workbook = WorkbookFactory.create(file);
            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read Excel file", e);
        }

        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[rowCount][colCount];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
            }
        }

        return data;
    }
}




