package org.kiliseci.gameObject;

import org.kiliseci.structur.ID;

import java.awt.*;

public class GameObject implements GameObjectInterface {

    protected float x, y;
    protected float xVelocity = 0, yVelocity = 0;
    protected ID id;

    public GameObject(float x, float y, ID id){
        this.x = x;
        this.y = y;
        this.id = id;
    }

    @Override
    public float getX() {
        return this.x;
    }

    @Override
    public void setX(float x) {
            this.x = x;
    }

    @Override
    public float getY() {
        return this.y;
    }

    @Override
    public float getXVelocity() {
        return this.xVelocity;
    }

    @Override
    public void setXVelocity(float x) {
        this.xVelocity = x;
    }

    @Override
    public float getYVelocity() {
        return this.yVelocity;
    }

    @Override
    public void setYVelocity(float y) {
        this.yVelocity = y;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics graphics) {

    }


}
