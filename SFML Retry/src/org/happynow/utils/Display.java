package org.happynow.utils;

import java.util.ArrayList;
import org.happynow.utils.Entity;
import org.jsfml.graphics.Drawable;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.VideoMode;

public class Display {
	
	RenderWindow renderWindow;
	ArrayList renderOrder;
	int frameRateLimit = 0;
	int frameInteration = 0;
	int runtime = 0; // Runtime starts at first frame
	
	public Display(String windowName, int x, int y) {
		this.renderWindow = new RenderWindow(new VideoMode(x, y), windowName);
		this.setFrameRateLimit(60);
		this.renderOrder = new ArrayList<Entity>();
	}
	
	
	// Main render function for all entities that appear on screen
	public void renderAll() {
		for(Object obj: this.renderOrder) {
			Entity entity = (Entity) obj;
			entity.setTime(this.runtime);
			this.renderWindow.draw(entity.hitbox);
		}
		
		this.renderWindow.display();
		this.renderWindow.clear();
		
		// Used in time calculation
		if(this.frameInteration < this.frameRateLimit) {
			
			this.frameInteration++;
		
		} else {
			
			this.frameInteration = 0;
			this.runtime++;
			
		}
	}

	public RenderWindow getRenderWindow() {
		return renderWindow;
	}

	public void setRenderWindow(RenderWindow renderWindow) {
		this.renderWindow = renderWindow;
	}

	public ArrayList getRenderOrder() {
		return renderOrder;
	}

	public void setRenderOrder(ArrayList renderOrder) {
		this.renderOrder = renderOrder;
	}

	public int getFrameInteration() {
		return frameInteration;
	}

	public void setFrameInteration(int frameInteration) {
		this.frameInteration = frameInteration;
	}
	
	public void setFrameRateLimit(int frameRate) {
		this.frameRateLimit = frameRate;
		this.renderWindow.setFramerateLimit(frameRate);
	}
	
	public int getFrameRateLimit() {
		return this.frameRateLimit;
	}


	public int getRuntime() {
		return runtime;
	}


	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}
	
	
}