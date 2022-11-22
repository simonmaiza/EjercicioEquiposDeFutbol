package ar.edu.unlam.pb2.test;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.junit.Test;

import ar.edu.unlam.pb2.clases.Arquero;
import ar.edu.unlam.pb2.clases.Equipo;
import ar.edu.unlam.pb2.clases.Jugador;
import ar.edu.unlam.pb2.clases.LigaFutbol;
import ar.edu.unlam.pb2.clases.Persona;
import ar.edu.unlam.pb2.exceptions.EquipoNoEncontradoException;
import ar.edu.unlam.pb2.exceptions.EquipoYaRegistradoEnLaLigaException;
import ar.edu.unlam.pb2.exceptions.PersonaNoEncontradaException;
import ar.edu.unlam.pb2.exceptions.faltaPresupuestoException;
import ar.edu.unlam.pb2.exceptions.plantelExcedidoExeption;

public class TestFutbol {

	@Test
	public void testQuePermiteAgregarUnJugadorAUnEquipo() throws plantelExcedidoExeption, faltaPresupuestoException, EquipoYaRegistradoEnLaLigaException, EquipoNoEncontradoException {
		Persona jugador1 = new Jugador("Messi" , 10 , 1000.0, 5);
		Persona arquero1 = new Arquero("Dibu" , 1 , 1000.0 , 5);
		Equipo equipo1 = new Equipo ("Seleccion Argentina" , 50000.0);
		LigaFutbol liga = new LigaFutbol("LFP");	
		
		liga.agregarEquipo(equipo1);
		
		liga.agregarPesona("Seleccion Argentina", jugador1);
		liga.agregarPesona("Seleccion Argentina",  arquero1);
		
		Integer valorEspereado = 2;
		Integer valorObtenido = equipo1.obtenerCantidadDeJugadoresEnElPlantel();
		
		assertEquals(valorEspereado, valorObtenido);
		
	}
	

	@Test(expected = faltaPresupuestoException.class)
	public void testQueNoPermiteAgregarUnJugadorAUnEquipoPorFaltaDePresupuesto() throws faltaPresupuestoException, plantelExcedidoExeption, EquipoYaRegistradoEnLaLigaException, EquipoNoEncontradoException {

		Persona jugador1 = new Jugador("Messi" , 10 , 10000.0, 5);
		Persona arquero1 = new Arquero("Dibu" , 1 , 5000.0 , 5);
		Equipo equipo1 = new Equipo ("Seleccion Argentina" , 5000.0);
		LigaFutbol liga = new LigaFutbol("LFP");
	
		liga.agregarEquipo(equipo1);
		
		liga.agregarPesona("Seleccion Argentina", jugador1);
		liga.agregarPesona("Seleccion Argentina",  arquero1);
	}
	
	@Test
	public void testQueEncuentraUnJugadorEnUnEquipo() throws plantelExcedidoExeption, faltaPresupuestoException, PersonaNoEncontradaException, EquipoYaRegistradoEnLaLigaException, EquipoNoEncontradoException {

		Persona jugador1 = new Jugador("Messi" , 10 , 100.0, 5);
		Persona arquero1 = new Arquero("Dibu" , 1 , 50.0 , 5);
		Equipo equipo1 = new Equipo ("Seleccion Argentina" , 5000.0);
		LigaFutbol liga = new LigaFutbol("LFP");
		
		liga.agregarEquipo(equipo1);
		
		liga.agregarPesona("Seleccion Argentina", jugador1);
		liga.agregarPesona("Seleccion Argentina",  arquero1);
		
		equipo1.buscarPersona(10);
		
		Persona valorEsperado = jugador1;
		Persona valorObtenido = equipo1.buscarPersona(10);
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test(expected = PersonaNoEncontradaException.class)
	public void testQueEliminaUnJugadorEnUnEquipo() throws plantelExcedidoExeption, faltaPresupuestoException, PersonaNoEncontradaException, EquipoYaRegistradoEnLaLigaException, EquipoNoEncontradoException {

		Persona jugador1 = new Jugador("Messi" , 10 , 100.0, 5);
		Persona arquero1 = new Arquero("Dibu" , 1 , 50.0 , 5);
		Equipo equipo1 = new Equipo ("Seleccion Argentina" , 5000.0);
		LigaFutbol liga = new LigaFutbol("LFP");
		
		liga.agregarEquipo(equipo1);
		
		liga.agregarPesona("Seleccion Argentina", jugador1);
		liga.agregarPesona("Seleccion Argentina",  arquero1);
		
		equipo1.eliminarPersona(jugador1);
		
		Persona valorEsperado = jugador1;
		Persona valorObtenido = equipo1.buscarPersona(10);
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void testQueCalculaLosCostosDelosJugadores() throws EquipoYaRegistradoEnLaLigaException, plantelExcedidoExeption, faltaPresupuestoException, EquipoNoEncontradoException {

		Persona jugador1 = new Jugador("Messi" , 10 , 100.0, 5);
		Persona arquero1 = new Arquero("Dibu" , 1 , 50.0 , 5);
		Equipo equipo1 = new Equipo ("Seleccion Argentina" , 5000.0);
		LigaFutbol liga = new LigaFutbol("LFP");
		
		liga.agregarEquipo(equipo1);
		
		liga.agregarPesona("Seleccion Argentina", jugador1);
		liga.agregarPesona("Seleccion Argentina",  arquero1);
		
	
		Double valorEsperado = 150.0;
		Double valorObtenido = liga.calcularCostoDeJugadores("Seleccion Argentina");
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void testQuePermiteRealizarUnaTransaferenciaDeUnEquipoAOtro() throws EquipoYaRegistradoEnLaLigaException, plantelExcedidoExeption, faltaPresupuestoException, EquipoNoEncontradoException, PersonaNoEncontradaException {

		Persona jugador1 = new Jugador("Messi" , 10 , 1000.0, 5);
		Persona arquero1 = new Arquero("Dibu" , 1 , 500.00 , 5);
		Persona jugador2 = new Jugador("Neymar" , 10 , 1000.0 , 4 );
		Equipo equipo1 = new Equipo ("Seleccion Argentina" , 5000.0);
		Equipo equipo2 = new Equipo ("Seleccion Brasil" , 10000.0);
		LigaFutbol liga = new LigaFutbol("LFP");
		
		liga.agregarEquipo(equipo1);
		liga.agregarEquipo(equipo2);
		
		liga.agregarPesona("Seleccion Argentina", jugador1);
		liga.agregarPesona("Seleccion Argentina",  arquero1);
		
		liga.agregarPesona("Seleccion Brasil", jugador2);
		
		liga.realizarTransferenciaJugador("Seleccion Argentina", "Seleccion Brasil", 10);
		
		Integer valorEsperado = 2;
		Integer valorObtenido = equipo2.obtenerCantidadDeJugadoresEnElPlantel();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void verificaELOrdenDelEquipoPorNumeroDeCamiseta() throws EquipoYaRegistradoEnLaLigaException, plantelExcedidoExeption, faltaPresupuestoException, EquipoNoEncontradoException {

		Persona jugador1 = new Jugador("Messi" , 10 , 100.0, 5);
		Persona arquero1 = new Arquero("Dibu" , 1 , 50.0 , 5);
		Equipo equipo1 = new Equipo ("Seleccion Argentina" , 5000.0);
		LigaFutbol liga = new LigaFutbol("LFP");
		
		liga.agregarEquipo(equipo1);
		
		liga.agregarPesona("Seleccion Argentina", jugador1);
		liga.agregarPesona("Seleccion Argentina",  arquero1);
		
		Set<Persona> plantelOrdenado = equipo1.obtenerPlantelPorNumeroDeCamiseta();
		
		for (Persona persona : plantelOrdenado) {
			System.out.println(persona.getNombre() + persona.getNumeroCamiseta());
		}
		
	}
}
