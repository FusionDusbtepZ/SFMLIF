package org.happynow.utils;

import java.util.ArrayList;

public abstract class Game {
	
	private Display display;
	private ArrayList<Entity> entities;
	private boolean isRunning = true;
	
	public Game(Display display) {
		this.display = display;
		this.entities = new ArrayList();
		this.display.setRenderOrder(this.entities);
	}
	
	public abstract void secondLoop();
	public abstract void frameLoop();
	
	public void start() {
		
		int initialTime = this.display.getRuntime();
		int finalTime = initialTime;
		
		while(this.isRunning()) {
			
			// Tell if a second has passed then run the second loop iteration
			if(finalTime-initialTime == 1) {
				this.secondLoop();
				initialTime = this.display.getRuntime();
			}
			
			finalTime = this.display.getRuntime();
			
			// Run frame loop iteration
			this.frameLoop();
			
			// Render so everything gets drawn to the screen and time is updated
			this.display.renderAll();
		}
		
	}
	
	public Display getDisplay() {
		return display;
	}

	public void setDisplay(Display display) {
		this.display = display;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}

	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}
	
	
	
}