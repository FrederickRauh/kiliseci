package org.kiliseci.gameObject;

import org.kiliseci.structur.ID;

import java.awt.*;

public interface GameObjectInterface {

    float getX();
    void setX(float x);
    float getY();
    float getXVelocity();
    void setXVelocity(float x);
    float getYVelocity();
    void setYVelocity(float y);

    void tick();

    void render(Graphics graphics);
}
