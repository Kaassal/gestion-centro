package gestioncentro.view;

import javax.swing.JPanel;

import gestioncentro.controller.gestioncentroAppController;

public class gestioncentroPanel extends JPanel {

	private gestioncentroAppController baseController;
	
	public gestioncentroPanel(gestioncentroAppController baseController) {
		
		this.baseController = baseController;
	}
		
}
