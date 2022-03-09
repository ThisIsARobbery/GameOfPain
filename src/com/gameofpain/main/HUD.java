package com.gameofpain.main;

import java.awt.*;

public class HUD {

    public static int HEALTH = 100;
    private int greenIntensity = 255;

    private int score = 0;
    private int level = 1;

    public void tick() {
        HEALTH = Game.clamp(HEALTH, 0, 100);
        greenIntensity = Game.clamp(greenIntensity, 0, 255);

        greenIntensity = HEALTH * 2;

        score++;
    }

    public void render(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(15, 15, 200, 16);
        g.setColor(new Color(75, greenIntensity, 0));
        g.fillRect(15, 15, 2 * HUD.HEALTH, 16);
        g.setColor(Color.GRAY);
        g.drawRect(15, 15, 200, 16);

        g.drawString("Score: " + score, 15, 46);
        g.drawString("Level: " + level, 15, 60);
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
