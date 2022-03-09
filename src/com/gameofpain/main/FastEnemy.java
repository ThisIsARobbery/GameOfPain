package com.gameofpain.main;

import java.awt.*;

public class FastEnemy extends GameObject {
    private static final int ENEMY_WIDTH = 16;
    private static final int ENEMY_HEIGHT = 16;

    private Handler handler;

    public FastEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velX = 2;
        velY = 9;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, ENEMY_WIDTH, ENEMY_HEIGHT);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        if (y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
        if (x <= 0 || x >= Game.WIDTH - 16) velX *= -1;

        handler.addObject(new Trail(x, y, ID.Trail, Color.CYAN, ENEMY_WIDTH, ENEMY_HEIGHT, 0.03f, handler));
    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g.setColor(Color.CYAN);
        g2d.fill(getBounds());
    }
}
