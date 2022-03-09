package com.gameofpain.main;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject {
    private static final int PLAYER_WIDTH = 32;
    private static final int PLAYER_HEIGHT = 32;

    Random r = new Random();

    Handler handler;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, PLAYER_WIDTH, PLAYER_HEIGHT);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        x = Game.clamp(x, 0 , Game.WIDTH - 30);
        y = Game.clamp(y, 0, Game.HEIGHT - 60);

        handler.addObject(new Trail(x, y, ID.Trail, Color.YELLOW, PLAYER_WIDTH, PLAYER_HEIGHT, 0.03f, handler));

        collision();
    }

    public void collision() {
        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject object = handler.objects.get(i);
            if (object.getId() == ID.BasicEnemy || object.getId() == ID.FastEnemy) {
                if (getBounds().intersects(object.getBounds())) {
                    // collision
                    HUD.HEALTH -= 2;
                }
            }
        }
    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g.setColor(Color.YELLOW);
        g2d.fill(getBounds());
    }
}
