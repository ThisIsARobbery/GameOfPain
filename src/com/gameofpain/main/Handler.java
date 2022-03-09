package com.gameofpain.main;

import java.awt.*;
import java.util.LinkedList;

public class Handler {
    LinkedList<GameObject> objects = new LinkedList<>();

    public void tick() {
        for (int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);
            object.tick();
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);
            object.render(g);
        }
    }

    public void stopAllObjects() {
        for (int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);
            object.stop();
        }
    }

    public void addObject(GameObject object) {
        this.objects.add(object);
    }

    public void removeObject(GameObject object) {
        this.objects.remove(object);
    }
}
