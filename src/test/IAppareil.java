package test;

import java.util.Date;
import java.util.List;

public interface IAppareil {
	public void enregistrer(Contact c);
	public void enregistrer(Appel a,String numTel);
	public Contact consulter(int numero) throws Exception;
	public List<Contact>consulter(String mc);
	public double coutTotalAppels();
	public double coutAppel(Date d1,Date d2);
	public double coutAppel(int numero);

}
