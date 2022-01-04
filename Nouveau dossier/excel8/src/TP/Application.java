package TP;

public class Application {

	public static void main(String[] args) {
		Voiture toto=new Voiture();
		Voiture toto2=new Voiture();
		Voiture toto3=new Voiture();
		Voiture toto4=new Voiture();
		toto.arreter();
		toto.setMarque("BMW");
		String Marque=toto.getMarque();
		System.out.println(Voiture.getCompteur());		
		
		
		
		
		/*
		 * NombreDeLigne=ExcelUtils.RecupererLigne("");
		 * 
		 * for (int i=2,i<=NombreDeLigne,i++) { Username=ExcelUtils.LireCell("");
		 * Password=ExcelUtils.LireCell(""); ResultatAttendu=ExcelUtils.LireCell("");
		 * 
		 * ExcelUtils.EcrireCell("","Feuil1",i,3,"toto");
		 * 
		 * }
		 */


	}

}
