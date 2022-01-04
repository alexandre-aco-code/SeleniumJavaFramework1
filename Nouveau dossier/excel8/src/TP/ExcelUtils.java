package TP;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelUtils {
	
	private static int NbLignes;
	private static POIFSFileSystem fichier;
	private static HSSFWorkbook workbook;
	private static HSSFSheet feuille;
	private static String CellValue;
		
	public static HSSFSheet ouvertureFeuille(String FileURL, String FeuilleName) {
		try {
			fichier = new POIFSFileSystem(new FileInputStream(FileURL));
			try {
				workbook = new HSSFWorkbook(fichier);
			} catch (Exception e) {
				e.printStackTrace();
			}
		    feuille = workbook.getSheet(FeuilleName);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return feuille;
	}
	
	public static int RecupererLigne() {
	    NbLignes = feuille.getPhysicalNumberOfRows();
		return NbLignes;
	}
	
	public static String LireCell(int ligne, int colonne) {

		Row row = feuille.getRow(ligne);
		Cell cell = row.getCell(colonne);
		CellValue = cell.getStringCellValue();
		return CellValue;

	}
	

	public static void EcrireCell(int ligne, int colonne, String value) {
		
		Row row = feuille.getRow(ligne);
		if (row == null) {
			row = feuille.createRow(ligne);
		}
		Cell cell = row.getCell(colonne);
		
		if (cell == null) {
			cell = row.createCell(colonne);
		}
		cell.setCellValue(value);
	    
	}
	
}
