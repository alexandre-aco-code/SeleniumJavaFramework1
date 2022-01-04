package Exo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Exo {
	
	

	public static void main(String[] args) {
		
		try {
			int a,b,c;
			a=10;
			b=0;
			c=a/b;
		}

		catch(ArithmeticException e) {
			System.out.println("Arithmetic erreur : "+e.getMessage());
		}
		
		catch(Exception e) {
			System.out.println("On ne peut pas diviser par zéro, erreur : "+e);
		}
	}

}
