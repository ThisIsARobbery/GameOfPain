package com.gameofpain.main;

import java.util.Random;

public class Spawner {
    private Handler handler;
    private HUD hud;
    private Random random;

    private int scoreKeep = 0;
    private int scoreKeepIncome = 1;

    public Spawner(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
        this.random = new Random();
    }

    public void tick() {
        scoreKeep += 1;

        if (scoreKeep >= 500) {
            scoreKeep = 0;
            hud.setLevel(hud.getLevel() + 1);
            if (hud.getLevel() == 2) {
                spawnEnemies(ID.BasicEnemy, 1);
            }
            if (hud.getLevel() == 3) {
                spawnEnemies(ID.BasicEnemy, 2);
            }
            if (hud.getLevel() == 4) {
                wipeEnemies(ID.BasicEnemy);
                spawnEnemies(ID.FastEnemy, 4);
            }
            if (hud.getLevel() == 5) {
                spawnEnemies(ID.BasicEnemy, 2);
            }
        }
        if (HUD.HEALTH == 0) {
            handler.stopAllObjects();
        }
    }

    public void spawnEnemies(ID enemyId, int number) {
        for (int i = 0; i < number; i++) {
            if (enemyId == ID.BasicEnemy)
                handler.addObject(new BasicEnemy(random.nextInt(Game.WIDTH - 50), random.nextInt(Game.HEIGHT - 50), enemyId, handler));
            if (enemyId == ID.FastEnemy)
                handler.addObject(new FastEnemy(random.nextInt(Game.WIDTH - 50), random.nextInt(Game.HEIGHT - 50), enemyId, handler));
        }
    }

    public void spawnPlayer() {
        handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));
    }

    public void wipeEnemies(ID enemyId) {
        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject object = handler.objects.get(i);
            if (object.getId() == enemyId) {
                handler.removeObject(object);
            }
        }
    }
}
