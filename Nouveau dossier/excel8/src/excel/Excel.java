package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

	public static void main(String[] args) {
		
		try {
			
			String Username;
			String Password;
			String ResultatAttendu;
			boolean empty;
			
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/jeuxdedonnees","root","");  
			
			Statement stmt=con.createStatement();  
			
			ResultSet rs=stmt.executeQuery("select * from login");  
			
	        empty = true;
			
			while(rs.next()) {
				
				Username = rs.getString("Username");
				Password = rs.getString("Password");
				ResultatAttendu = rs.getString("ResultatAttendu");
					
				System.out.println(Username+"\t"+Password+"\t"+ResultatAttendu); 
				
				empty = false;
				
			}	
			
			if (empty) {
				throw new Exception("table vide");
			}
			
			con.close();  
	          
		} 
		
		catch (Exception e) {

            e.printStackTrace();
						
		}        

	}

}
