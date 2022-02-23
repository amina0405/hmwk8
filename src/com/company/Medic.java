package com.company;

public class Medic {
    private int healPoints;

    public Medic(int health, int damage, int healPoints, String name) {
        super(health, damage, name, SuperAbility.HEAL);
        this.healPoints = healPoints;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (this.getHealth() > 0) {
            for (int i = 0; i < heroes.length; i++) {
                if (heroes[i].getHealth() > 0 && this != heroes[i]) {
                    heroes[i].setHealth(heroes[i].getHealth() + this.healPoints);
                }
            }
        }
    }

    public int getHealPoints() {
        return healPoints;
    }
}
}
