package utilities;


	
	import org.apache.poi.ss.usermodel.*;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import java.io.*;

	public class ExcelUtils {
	    private String filePath;
	    private Workbook workbook;
	    private Sheet sheet;

	    public ExcelUtils(String filePath, String sheetName) {
	        this.filePath = filePath;
	        try (FileInputStream fis = new FileInputStream(filePath)) {
	            workbook = new XSSFWorkbook(fis);
	            sheet = workbook.getSheet(sheetName);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public String getCellData(int rowNum, int colNum) {
	        Row row = sheet.getRow(rowNum);
	        Cell cell = row.getCell(colNum);
	        return new DataFormatter().formatCellValue(cell);
	    }

	    public void setCellData(int rowNum, int colNum, String data) {
	        Row row = sheet.getRow(rowNum);
	        if (row == null) {
	            row = sheet.createRow(rowNum);
	        }
	        Cell cell = row.getCell(colNum, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
	        cell.setCellValue(data);
	    }

	    public void saveExcelFile() {
	        try (FileOutputStream fos = new FileOutputStream(filePath)) {
	            workbook.write(fos);
	            workbook.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public int getRowCount() {
	        return sheet.getPhysicalNumberOfRows();
	    }

	    public int getColumnCount(int rowNum) {
	        Row row = sheet.getRow(rowNum);
	        return (row == null) ? 0 : row.getPhysicalNumberOfCells();
	    }
	}



