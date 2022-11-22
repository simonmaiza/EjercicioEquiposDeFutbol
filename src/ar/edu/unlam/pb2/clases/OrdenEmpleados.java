package ar.edu.unlam.pb2.clases;

import java.util.Comparator;

public class OrdenEmpleados implements Comparator< Persona> {

	@Override
	public int compare(Persona o1, Persona o2) {
		if(o1.getNumeroCamiseta().compareTo(o2.getNumeroCamiseta())==0) {
			return o2.getNumeroCamiseta().compareTo(o1.getNumeroCamiseta());
		}
		return o1.getNumeroCamiseta().compareTo(o2.getNumeroCamiseta());
	}

}
