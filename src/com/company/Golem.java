package com.company;

public class Golem {
    public Golem(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.TAKE_SOME_DAMAGE);
    }

    public void applySuperPower(Boss boss, Hero[] heroes) {
        int takeDamage = boss.getDamage() / 5;
        for (int i = 0; i < heroes.length; i++) {
            if (this.getHealth() > 0 && heroes[i].getHealth() > 0 && this != heroes[i]) {
                heroes[i].setHealth(heroes[i].getHealth() + boss.getDamage());
                this.setHealth(this.getHealth() - boss.getDamage());
            }
        }
    }
}

