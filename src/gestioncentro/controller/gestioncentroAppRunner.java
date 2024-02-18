package gestioncentro.controller;

	/**
	 * Objeto runner para el MVC de gestioncentro
	 * @author diego
	 */

public class gestioncentroAppRunner {
	
	/**
	 * Metodo de inicio (starter) para este programa
	 * @param args sin usar ya que esta aplicacion usa una GUI
	 */

	public static void main(String[] args) {
		
	gestioncentroAppController centroApp = new gestioncentroAppController();
	centroApp.start();

	}

}
