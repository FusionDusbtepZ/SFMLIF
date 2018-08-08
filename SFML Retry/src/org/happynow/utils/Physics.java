package org.happynow.utils;

import org.jsfml.system.Vector2f;


public class Physics {
	
	Entity entity;
	
	public Physics(Entity entity) {
		this.entity = entity;
	}
	
	// Lazy movement, carries out all current movement commands
	public void handleMovement() {
		this.entity.moveObjectByIncrement(this.entity.velocity.x, this.entity.velocity.y);
	}
	
	public int addForce(int scaler, float direction, int duration) {
		
		direction = (float) Math.toRadians(direction);
		
		float initialX = this.entity.velocity.x;
		float initialY = this.entity.velocity.y;
		
		float addedX = 0;
		float addedY = 0;
		
		float acceleration = scaler/entity.mass;
		
		// Vector component dissection
		
		if(direction > 360) {
			return 0;
		} else if(89 >= direction && direction >= 0) { // First Quadrant Vectors
			// cos(angle)=a/h
			addedX = (float) (Math.cos(direction) * (double) acceleration);
			
			// sin(angle)=o/h
			addedY = (float) (-1 * Math.sin(direction) * (double) acceleration);
			
		} else if(179 >= direction && direction >= 90) { // Second Quadrant Vectors
			
			// cos(angle)=a/h
			addedX = (float) (-1 * Math.cos(direction - 90) * (double) acceleration);
			
			// sin(angle)=o/h
			addedY = (float) (Math.sin(direction - 90) * (double) acceleration);
			
		} else if(269 >= direction && direction >= 180) { // Third Quadrant Vectors
			
			// cos(angle)=a/h
			addedX = (float) (-1 * Math.cos(direction - 180) * (double) acceleration);
			
			// sin(angle)=o/h
			addedY = (float) (-1 * Math.sin(direction - 180) * (double) acceleration);
			
		} else if(359 >= direction && direction >= 270) { // Fourth Quadrant Vectors
			
			// cos(angle)=a/h
			addedX = (float) (-1 * Math.cos(direction - 270) * (double) acceleration);
			
			// sin(angle)=o/h
			addedY = (float) (-1 * Math.sin(direction - 270) * (double) acceleration);
		}
		
		
		this.entity.velocity = new Vector2f(initialX+addedX, initialY+addedY);
		
		
		if(duration == -1) {
			return duration;
		} else {
			return duration - 1;
		}
	}
	
}
