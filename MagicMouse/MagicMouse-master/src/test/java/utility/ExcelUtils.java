/** This Class contains the methods to read test data from excel data source for implementing Data Driver component in the test automation framework.
 */
package utility;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	public String getTestData(int RowNum, int ColNum) {
		try {

			// System.out.println(testDataFilePath);
			// Open the Excel file

			FileInputStream ExcelFile = new FileInputStream(
					"C://work/SeleniumWorkspaces/WS3/DemoStoreQA/src/test/java/testData/TestData.xlsx");

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet("ContactDtls");

		} catch (Exception e) {

			e.printStackTrace();

		}

		Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

		String CellData = Cell.getStringCellValue();

		return CellData;

	}

	public String getCellValue(int r, int c)

	{

		try

		{
			FileInputStream ExcelFile = new FileInputStream(
					"C://work/SeleniumWorkspaces/WS3/DemoStoreQA/src/test/java/testData/TestData.xlsx");

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet("ContactDtls");

		} catch (Exception e) {

			e.printStackTrace();

		}

		// Cell cell = wb.getSheet(Sheet).getRow(r).getCell(c);
		Cell = ExcelWSheet.getRow(r).getCell(c);
		return Cell.getStringCellValue();

	}

	public int getRowCount()

	{

		try

		{
			FileInputStream fis = new FileInputStream(
					"C://work/SeleniumWorkspaces/WS3/DemoStoreQA/src/test/java/testData/TestData.xlsx");
			ExcelWBook = new XSSFWorkbook(fis);
			ExcelWSheet = ExcelWBook.getSheet("ContactDtls");
			return ExcelWSheet.getLastRowNum();

		}

		catch (Exception e)

		{

			return 0;

		}

	}

	// This method is to set the File path and to open the Excel file, Pass
	// Excel Path and Sheetname as Arguments to this method
	public static void setExcelFile(String Path, String SheetName)
			throws Exception {
		try {
			// Open the Excel file
			FileInputStream ExcelFile = new FileInputStream(Path);
			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			System.out.println("Excel sheet opened");
		} catch (Exception e) {
			throw (e);
		}
	}

	public static int getRowContains(String sTestCaseName, int colNum)
			throws Exception {
		int i;
		try {
			int rowCount = ExcelUtils.getRowUsed();
			for (i = 0; i < rowCount; i++) {
				if (ExcelUtils.getCellData(i, colNum).equalsIgnoreCase(
						sTestCaseName)) {
					break;
				}
			}
			return i;
		} catch (Exception e) {
			System.out
					.println("Class ExcelUtil | Method getRowContains | Exception desc : "
							+ e.getMessage());
			throw (e);
		}
	}

	public static int getRowUsed() throws Exception {
		try {
			int RowCount = ExcelWSheet.getLastRowNum();
			System.out.println("Total number of Row used return as < "
					+ RowCount + " >.");
			return RowCount;
		} catch (Exception e) {
			System.out
					.println("Class ExcelUtil | Method getRowUsed | Exception desc : "
							+ e.getMessage());
			System.out.println(e.getMessage());
			throw (e);
		}

	}

	// This method is to read the test data from the Excel cell, in this we are
	// passing parameters as Row num and Col num
	public static String getCellData(int RowNum, int ColNum) throws Exception {
		try {
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			return CellData;
		} catch (Exception e) {
			return "";
		}
	}

}
