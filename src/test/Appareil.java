package test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Appareil implements IAppareil{
	
	private List<Contact> contacts = new ArrayList<Contact>();
	private Map<Integer, Appel> appel= new HashMap<Integer, Appel>();

	@Override
	public void enregistrer(Contact c) {
		
		contacts.add(c);
		
	}

	@Override
	public void enregistrer(Appel a, String numTel) {
		Contact c1=null;
		
		for (Contact c : contacts) 
			if(c.getNumeroTel().equals(numTel)) {
				c1=c;
				break;
			}
		a.setContact(c1);
		appel.put(a.getNumero(), a);
		
	}

	@Override
	public Contact consulter(int numero) throws Exception {
		for (Contact c : contacts) {
			if(c.getNumero()==numero) 
				return c;
		}
			throw new Exception("Contact "+numero+" introuvable");
	}

	@Override
	public List<Contact> consulter(String mc) {
		List<Contact> cts= new ArrayList<Contact>();
		for (Contact c1 : contacts) {
			if(c1.getNom().indexOf(mc)>=0) 
				
				cts.add(c1);		
		}
		return cts;
	}

	@Override
	public double coutTotalAppels() {
      double total=0;
		
		for (Appel a : appel.values()) {
			total=total+a.cout();
		}
		return total;
	}

	@Override
	public double coutAppel(Date d1, Date d2) {
		  double total=0;
			
			for (Appel a : appel.values()) {
				if((a.getDateAppel().getTime()>=d1.getTime())&&
						(a.getDateAppel().getTime()<=d1.getTime()))
				total=total+a.cout();
			}
			return total;
	}

	@Override
	public double coutAppel(int numero) {
		
		double total=0;
		
		for (Appel a : appel.values()) {
			if(a.getContact().getNumero()==numero)
			total=total+a.cout();
		}
		return total;
	}

}
