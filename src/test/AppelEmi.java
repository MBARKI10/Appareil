package test;

import java.util.Date;

public class AppelEmi extends Appel{

	@Override
	public double cout() {
		
		return dureeAppel *2;
	}

	public AppelEmi() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AppelEmi(int numero, Date dateAppel, double dureeAppel) {
		super(numero, dateAppel, dureeAppel);
		// TODO Auto-generated constructor stub
	}

}
