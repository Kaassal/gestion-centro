package gestioncentro.view;

import javax.swing.JFrame;
import gestioncentro.controller.gestioncentroAppController;

	/**
	 * Objeto (gestioncentro) Frame que hereda de la clase JFrame para uso con una GUI MVC.
	 * @author diego
	 */
public class gestioncentroFrame extends JFrame {
	
	/**
	 * Referencia al (gestioncentro) Panel de la applicacion.
	 */
	private gestioncentroPanel basePanel;
	
	/**
	 * Crear un objeto de la clase gestioncentroPanel que referencia a gestioncentroAppController para ser usado por el objeto gestioncentroFrame 
	 * @param baseController referencia al objeto (gestioncentro) Appcontroller
	 */
	public gestioncentroFrame(gestioncentroAppController baseController) {

		basePanel = new gestioncentroPanel(baseController);
		setupFrame();
	}
	
	/**
	 * Establece el content pane, tamaño y hace el frame visible
	 */
	private void setupFrame() {

		this.setContentPane(basePanel);
		this.setSize(640, 480);
		this.setVisible(true);

	}

}
