package ar.edu.unlam.pb2.clases;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import ar.edu.unlam.pb2.exceptions.EquipoNoEncontradoException;
import ar.edu.unlam.pb2.exceptions.EquipoYaRegistradoEnLaLigaException;
import ar.edu.unlam.pb2.exceptions.PersonaNoEncontradaException;
import ar.edu.unlam.pb2.exceptions.faltaPresupuestoException;
import ar.edu.unlam.pb2.exceptions.plantelExcedidoExeption;

public class LigaFutbol {

	private String nombre;
	private List <Equipo> equipos;
	
	public LigaFutbol (String nombre) {
		this.nombre = nombre;
		this.equipos = new ArrayList<Equipo>();
	}
	public Boolean agregarEquipo (Equipo equipo) throws EquipoYaRegistradoEnLaLigaException {
		if(equipos.contains(equipo)) {
			throw new EquipoYaRegistradoEnLaLigaException();
		}
		
		this.equipos.add(equipo);
		return true;
	}
	

	public Boolean agregarPesona (String nombreEquipo,  Persona Persona) throws plantelExcedidoExeption, faltaPresupuestoException, EquipoNoEncontradoException {
		for (Equipo equipo : equipos) {
			if(equipo.getNombre().equals(nombreEquipo)) {
				equipo.agregarPersona(Persona);
				return true;
			}
		}
		
		throw new EquipoNoEncontradoException();
		
	}
	
	public Double calcularCostoDeJugadores(String nombreEquipo) {
		Double costoJugadores = 0.0;
		
		for (Equipo equipo : equipos) {
			if(equipo.getNombre().equals(nombreEquipo)) {
				for (Persona persona : equipo.plantel) {
					 costoJugadores += persona.getCosto();
				}
			}
		}
		return costoJugadores;
		
	}
	
	public Boolean realizarTransferenciaJugador(String nombreEquipoOrigen, String nombreEquipoDestino, Integer numeroDeCamiseta) throws EquipoNoEncontradoException, PersonaNoEncontradaException, plantelExcedidoExeption, faltaPresupuestoException {
		Equipo equipoOrigen = buscarEquipo(nombreEquipoOrigen);
		Equipo equipoDestino = buscarEquipo(nombreEquipoDestino);
		Persona jugadorATransferir = buscarPersonaATransferir(numeroDeCamiseta, equipoOrigen);
		
		equipoDestino.agregarPersona(jugadorATransferir);
		equipoOrigen.eliminarPersona(jugadorATransferir);
		
	
		return true;
		
	}

	private Persona buscarPersonaATransferir(Integer numeroDeCamiseta, Equipo equipoOrigen) throws PersonaNoEncontradaException {
		for (Persona persona : equipoOrigen.plantel) {
			if(persona.getNumeroCamiseta().equals(numeroDeCamiseta)) {
				return persona;
			}
		}
		throw new PersonaNoEncontradaException();
	}
	


	private Equipo buscarEquipo(String nombreEquipo ) throws EquipoNoEncontradoException {
		for (Equipo equipo : equipos) {
			if(equipo.getNombre().equals(nombreEquipo)) {
				return equipo;
			}
		}
		throw new EquipoNoEncontradoException();
	}
	
	
	
	/*Solo integredord
	 * 
	 */
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Equipo> getEquipos() {
		return equipos;
	}
	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}
}
