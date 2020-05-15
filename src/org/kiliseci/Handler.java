package org.kiliseci;

import org.kiliseci.gameObject.GameObject;

import java.awt.*;
import java.util.LinkedList;

public class Handler {

    public LinkedList<GameObject> gameObjects = new LinkedList<>();

    public void tick(){
        for(GameObject object : gameObjects){
            object.tick();
        }
    }

    public void render(Graphics graphics){
        for(GameObject object : gameObjects){
            object.render(graphics);
        }
    }

    public void addObject(GameObject gameObject){
        gameObjects.add(gameObject);
    }

    public void removeObject(GameObject gameObject){
        gameObjects.remove(gameObject);
    }
}
