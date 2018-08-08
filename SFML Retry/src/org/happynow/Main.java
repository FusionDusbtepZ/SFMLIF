package org.happynow;

import org.happynow.utils.Display;
import org.happynow.utils.Entity;
import org.happynow.utils.Game;
import org.happynow.utils.Physics;
import org.jsfml.graphics.CircleShape;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Shape;
import org.jsfml.system.Vector2f;
import org.jsfml.window.VideoMode;

public class Main {
	
	public static void main(String args[]) {
		
		Display display = new Display("Game", 800, 600);
		TestGame game = new TestGame(display);
		
		
		RectangleShape shape = new RectangleShape(new Vector2f(200, 200));
		shape.setPosition(0, 0);
		shape.setFillColor(Color.RED);
		
		Entity entity = new Entity((float) 100.00, shape);
		game.getEntities().add(entity);
		
		game.start();
		
	}
	
}
