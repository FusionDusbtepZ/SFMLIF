package org.happynow.utils;

import org.jsfml.graphics.Drawable;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.system.Vector2f;

public class Entity {
	
	float mass; // Used in force calculations
	int time; // Same as universal time;
	RectangleShape hitbox; // Used in collision and all renders
	Vector2f velocity; // Velocity must be zero for fixed position
	Physics physics; // All physical mechanics for that object
	
	public Entity(float mass, RectangleShape hitbox) {
		this.mass = mass;
		this.hitbox = hitbox;
		this.velocity = new Vector2f(0, 0);
		this.physics = new Physics(this);
	}
	
	// Fundamental movements
	public void moveObject(float x, float y) {
		this.hitbox.setPosition(x, y);
	}
	
	// Fundamental movements
	public void moveObjectByIncrement(float x, float y) {
		this.hitbox.setPosition(this.hitbox.getPosition().x+x, this.hitbox.getPosition().y+y);
	}

	public float getMass() {
		return mass;
	}

	public void setMass(float mass) {
		if(mass > 0) this.mass = mass;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public RectangleShape getHitbox() {
		return hitbox;
	}

	public void setHitbox(RectangleShape hitbox) {
		this.hitbox = hitbox;
	}

	public Vector2f getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector2f velocity) {
		this.velocity = velocity;
	}

	public Physics getPhysics() {
		return physics;
	}

	public void setPhysics(Physics physics) {
		this.physics = physics;
	}
	
}
