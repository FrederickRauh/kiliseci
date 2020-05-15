package org.kiliseci;

import org.kiliseci.gui.game.Window;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.logging.Logger;

public class Game extends Canvas implements Runnable {

    public static int WIDTH = 800, HEIGHT = 650;
    public static String TITLE = "Kiliseci";

    private Thread thread;
    private boolean isRunning = false;

    private Handler handler;

    public Game() {
        new Window(WIDTH, HEIGHT, TITLE, this);
        init();
    }

    private void init(){
        handler = new Handler();
    }

    private synchronized void start() {
        if (isRunning) return;

        thread = new Thread(this);
        thread.start();
        isRunning = true;
    }

    private synchronized void stop() throws InterruptedException {
        if (!isRunning) {
            return;
        }
        thread.join();
        isRunning = false;
    }

    @Override
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfFPS = 120.0;
        double ns = 1000000000 / amountOfFPS;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (isRunning) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            render();
            frames++;
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                frames = 0;
            }
        }
        try {
            stop();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    private void tick() {

    }

    private void render() {
        BufferStrategy bufferStrategy = this.getBufferStrategy();
        if (bufferStrategy == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics graphics = bufferStrategy.getDrawGraphics();

        bufferStrategy.show();
        graphics.dispose();

    }


    public static void main(String[] args) {
        new Game();
    }
}
