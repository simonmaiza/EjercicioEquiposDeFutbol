package ar.edu.unlam.pb2.clases;

public abstract class Persona {
	private String nombre;
	private Integer numeroCamiseta;
	private Double costo;
	
	
	public Persona(String nombre, Integer numeroCamiseta, Double costo) {
		
		this.nombre = nombre;
		this.numeroCamiseta = numeroCamiseta;
		this.costo = costo;
	}



	public abstract Double calcularPuntaje () ;

	

	public Double getCosto() {
		return costo;
	}



	public void setCosto(Double costo) {
		this.costo = costo;
	}



	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Integer getNumeroCamiseta() {
		return numeroCamiseta;
	}


	public void setNumeroCamiseta(Integer numeroCamiseta) {
		this.numeroCamiseta = numeroCamiseta;
	}
	
	

}
