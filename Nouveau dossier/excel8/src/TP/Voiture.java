package TP;

public class Voiture {
	
	private String marque;
	private String couleur;
	private int NombrePlaces;
	private static int compteur;
	
	public Voiture() {
		compteur++;

	}

	public Voiture(String marque, String couleur, int nombrePlaces) {
		System.out.println("Constructeur");
		this.marque = marque;
		this.setCouleur(couleur);
		this.NombrePlaces = nombrePlaces;
	}
	

	public static int getCompteur() {
		return compteur;
	}

	public void setCompteur(int compteur) {
		this.compteur = compteur;
	}

	void demarrer() {
		System.out.println("Demarrage de la voiture");
	}
	
	void arreter() {
		System.out.println("arret de la voiture");
	}
	
	void accelerer() {
		System.out.println("acceleration de la voiture");
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public int getNombrePlaces() {
		return NombrePlaces;
	}

	public void setNombrePlaces(int nombrePlaces) {
		NombrePlaces = nombrePlaces;
	}
	
	
	

}
