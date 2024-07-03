package ru.volgaitcamp;

import robocode.*;
import robocode.Robot;

import java.awt.*;
import java.util.Random;

public class DummyBot extends Robot {

    boolean movingForward;

    public void run() {
        setBodyColor(Color.PINK);
        setGunColor(Color.BLUE);
        setRadarColor(Color.CYAN);
        setBulletColor(Color.ORANGE);
        setScanColor(Color.YELLOW);

        while (true) {
            ahead(100);
            movingForward = true;
            turnRight(new Random().nextDouble(36) * 10);
        }
    }

    public void onHitWall(HitWallEvent e) {
        reverseDirection();
    }

    public void reverseDirection() {
        if (movingForward) {
            back(50);
            movingForward = false;
        } else {
            ahead(50);
            movingForward = true;
        }
    }

    public void onScannedRobot(ScannedRobotEvent e) {
        fire(10);
    }

    public void onHitRobot(HitRobotEvent e) {
        if (e.isMyFault()) {
            reverseDirection();
        }
    }
}
