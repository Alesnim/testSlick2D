package com.javalesson.oop;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;

import java.util.ArrayList;
import java.util.Random;

public class Main extends BasicGame {
    private ArrayList<Circle> circles;
    private int timePassed = 0;

    public Main(String title) {
        super(title);
        circles = new ArrayList<Circle>();
    }


    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        circles.add(new Circle(gameContainer.getInput().getMouseX(),
                gameContainer.getInput().getMouseY(), 10));


    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        timePassed += delta;
        if (timePassed > 500) {
            timePassed = 0;
            circles.add(new Circle(300, 0, 10));

        }
        for (Circle circle : circles) {

            circle.setCenterX(circle.getCenterX() + (delta * 0.1f));
            circle.setCenterY(circle.getCenterY() + (delta * 0.1f));
        }
        for (int i = 0; i < circles.size(); i++) {
            Circle circ = circles.get(i);
            if (circ.getCenterX() > gameContainer.getWidth()
            || circ.getCenterY() > gameContainer.getHeight()) {
                circles.remove(i);
                System.out.println(circles.size());
            }
        }


    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        Random random = new Random(System.nanoTime());

        Color[] colors = {Color.cyan, Color.darkGray, Color.orange, Color.yellow};
        for (Circle circle : circles) {
            graphics.setColor(colors[random.nextInt(colors.length)]);
            graphics.fill(circle);

        }

    }


    public static void main(String[] args) throws SlickException {
        AppGameContainer container = new AppGameContainer(new Main("State Base"));
        container.setDisplayMode(640, 480, false);
        container.start();
    }
}
