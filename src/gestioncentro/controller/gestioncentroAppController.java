package gestioncentro.controller;

import gestioncentro.view.gestioncentroFrame;

public class gestioncentroAppController {
	
	public gestioncentroFrame appFrame;
	
	public void start() {
		
		appFrame = new gestioncentroFrame(this);
		
	}
	
}
