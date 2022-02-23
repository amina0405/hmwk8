package com.company;

public class Boss {
    public Boss(int health, int damage, String name) {
        super(health, damage, name);
    }

    public void hit(Hero[] heroes) {
        if (this.getHealth() > 0) {
            for (int i = 0; i < heroes.length; i++) {
                if (heroes[i].getHealth() > 0) {
                    if (heroes[i] instanceof Berserk) {
                        ((Berserk) heroes[i]).setSaved_damage(this.getDamage() / 2);
                        heroes[i].setHealth(heroes[i].getHealth()
                                - this.getDamage() / 2);
                    } else {
                        heroes[i].setHealth(heroes[i].getHealth()
                                - this.getDamage());
                    }
                }
            }
        }
    }
}

