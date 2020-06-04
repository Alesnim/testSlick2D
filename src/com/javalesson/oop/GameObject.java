package com.javalesson.oop;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import java.awt.*;
import java.awt.geom.Area;
import java.util.ArrayList;

public class GameObject {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected Image sprite;

    protected boolean checkcollision = true;

    public GameObject(int x, int y, int width, int height, Image sprite) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.sprite = sprite;
    }


    public void draw(Graphics gr) {
        gr.drawImage(sprite, x, y);


    }


    public Rectangle getRectangle() {
        return new Rectangle(x, y, width, height);
    }

    public boolean isCollision(int newX, int newY, ArrayList<GameObject> objects) {
        Rectangle rect = new Rectangle(newX, newY, width, height);
        boolean collision = false;
        Area area = new Area();
        for (GameObject object: objects) {
            area.add(new Area(rect));
            area.intersect(new Area(object.getRectangle()));

            if (!area.isEmpty()) {
                // collision = true;
                wallCollision(object);
            }
        }
        return collision;
    }

    public void wallCollision(GameObject object) {
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Image getSprite() {
        return sprite;
    }

    public void setSprite(Image sprite) {
        this.sprite = sprite;
    }
}
