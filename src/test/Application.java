package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Application {

	public static void main(String[] args) throws ParseException  {
		
		IAppareil appareil = new Appareil();
		
		appareil.enregistrer(new Contact(1, "c1", "06664987"));
		appareil.enregistrer(new Contact(2, "c2", "06664888"));
		appareil.enregistrer(new AppelEmi(1, new Date(), 66),"06664987");
		appareil.enregistrer(new AppelEmi(2, new Date(), 125),"06664987");
		appareil.enregistrer(new AppelEmi(3, new Date(), 66),"06664888");
		appareil.enregistrer(new AppelRecu(4, new Date(), 98),"06664987");
		
		System.out.println("-------------------");
		System.out.println("Consulter un Contact sachant son numéro");
		
		try {
			Contact c = appareil.consulter(1);
			System.out.println("Num : "+c.getNumero());
			System.out.println("Nom : "+c.getNom());
			System.out.println("NumTel : "+c.getNumeroTel());
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		System.out.println("-------------------");
		System.out.println("Consulter un Contact par mot clé");
		
		List<Contact> contacts = appareil.consulter("c");
		
		for (Contact c : contacts) {
			System.out.println("Nom : "+c.getNom());
			System.out.println("NumTel : "+c.getNumeroTel());
		}
		
		System.out.println("-------------------");
		System.out.println("Consulter les cout total des appels");
		System.out.println("cout total :"+appareil.coutTotalAppels());
		
		System.out.println("-------------------");
		System.out.println("Consulter les cout appels d'un contact");
		System.out.println("cout total :"+appareil.coutAppel(1));
		
		System.out.println("-------------------");
		System.out.println("Consulter les cout total entre deux date");
		SimpleDateFormat sdf = new SimpleDateFormat("MM/DD/YYYY");
		Date d1 = sdf.parse("27/05/2020");
		Date d2 = sdf.parse("28/05/2020");
		
		System.out.println("Cout :" +appareil.coutAppel(d1, d2));

	}

}
