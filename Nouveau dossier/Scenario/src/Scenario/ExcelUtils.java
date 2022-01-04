package Scenario;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	private int NbLignes;
	private Workbook wb;
	private Sheet feuille;
	private String CellValue;
	
	public void ouvertureFeuille(String fileURL,String feuilleName) {
		
		try (InputStream fileOut = new FileInputStream(fileURL)) {
			
			this.wb = new XSSFWorkbook(fileOut);
		    this.feuille = wb.getSheetAt(0);
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	public int RecupererLigne() {
	    NbLignes = this.feuille.getPhysicalNumberOfRows();
		return NbLignes;
	}
	
	public String LireCell(int ligne, int colonne) {
		Row row = this.feuille.getRow(ligne);
		Cell cell = row.getCell(colonne);
		CellValue = cell.getStringCellValue();
		return CellValue;
	}
	
	public void EcrireCell(int ligne, int colonne, String value) {
		Row row = this.feuille.getRow(ligne);
		if (row == null) {
			row = this.feuille.createRow(ligne);
		}
		
		Cell cell = row.getCell(colonne);
		if (cell == null) {
			cell = row.createCell(colonne);
		}
		cell.setCellValue(value);
	}
	
	public void Sauvegarder(String fileURL) {
        try {
            FileOutputStream out = new FileOutputStream(fileURL);
            this.wb.write(out);
            out.close();
        } catch (Exception e) {
			e.printStackTrace();
        }
	}
}
