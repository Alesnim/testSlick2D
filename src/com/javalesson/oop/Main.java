package com.javalesson.oop;

import org.newdawn.slick.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main extends BasicGame {
    private Image back;
    private Platform platform;
    private final Path RESOURCE = Paths.get("./resource/");
    private Ball ball;
    private ArrayList<GameObject> gameObjects;

    public Main(String title) {
        super(title);

    }


    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        gameObjects = new ArrayList<>();
        try {
            back = new Image(String.valueOf(RESOURCE.resolve("forest_back.png"))).getScaledCopy(640, 480);
            Image bl = new Image(String.valueOf(RESOURCE.resolve("orb.png")));
            Image pl = new Image(String.valueOf(RESOURCE.resolve("platform.png")));
            pl = pl.getScaledCopy(2.4f);
            pl.rotate(90f);

            platform = new Platform(10, 20, pl.getWidth(), pl.getHeight(), pl);
            ball = new Ball(200, 200, bl.getWidth(), bl.getHeight(), bl);
            gameObjects.add(platform);
        } catch (SlickException e) {
            e.printStackTrace();
        }

        gameContainer.setTargetFrameRate(60);
        gameContainer.setAlwaysRender(true);
        gameContainer.setVSync(true);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        var inp = gameContainer.getInput();
        if (inp.isKeyPressed(Input.KEY_S)) {
            platform.move(gameContainer, delta, 1);
        }
        if (inp.isKeyPressed(Input.KEY_W)) {
            platform.move(gameContainer, delta, -1);
        }
        if (!ball.isCollision(ball.getX(), ball.getY(), gameObjects)) {
            ball.move(gameContainer, (int) (delta * 0.4f));
        }


    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) {

        graphics.drawImage(back, 0, 0);
        graphics.drawString("eeeeee", 40, 180);
        ball.draw(graphics);
        platform.draw(graphics);

    }


    public static void main(String[] args) throws SlickException {
        AppGameContainer container = new AppGameContainer(new Main("State Base"));
        container.setDisplayMode(640, 480, false);
        container.start();
    }
}


class Platform extends GameObject {
    public Platform(int x, int y, int width, int height, Image sprite) {
        super(x, y, width, height, sprite);
    }

    public void move(GameContainer gameContainer, int speed, int direction) {
        if (y >= 0 && y <= gameContainer.getHeight()) {
            y += speed * direction;
        }
    }
}


class Ball extends GameObject {
    int directionX = -1;
    int directionY = -1;


    public Ball(int x, int y, int width, int height, Image sprite) {
        super(x, y, width, height, sprite);

    }

    public void move(GameContainer gameContainer, int speed) {
        if (x <= 0) {
            directionX = 1;
        }
        if (x >= gameContainer.getWidth() - getWidth()) {
            directionX = -1;
        }
        if (y <= 0) {
            directionY = 1;
        }
        if (y >= gameContainer.getHeight() - getHeight()) {
            directionY = -1;
        }
        x += speed * directionX;
        y += speed * directionY;
    }


    private int getCenterX() {
        return (x + width) / 2;
    }

    private int getCenterY() {
        return (y + height) / 2;
    }

    @Override
    public void wallCollision(GameObject object) {
        int minY = object.getY();
        int maxY = object.getY() + object.getHeight();
        int center = (maxY - minY) / 2;
        if (getCenterY() > center) {
            directionX = 1;
            directionY = 1;
        } else if (getCenterY() < center) {
            directionY = -1;
            directionX = 1;
        } else {
            directionX = 1;
            directionY = 1;
        }

    }
}