package org.happynow;

import org.happynow.utils.Display;
import org.happynow.utils.Game;

public class TestGame extends Game {

	public TestGame(Display display) {
		super(display);
		
	}

	@Override
	public void secondLoop() {
		this.getEntities().get(0).getPhysics().addForce(200, 45, -1);
		this.getEntities().get(0).getPhysics().handleMovement();
	}

	@Override
	public void frameLoop() {
		// TODO Auto-generated method stub
		
	}

	
	
}
