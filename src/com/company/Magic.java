package com.company;

public class Magic {
    public Magic(int health, int damage, String name) {

        super(health, damage, name, SuperAbility.BOOST);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length ; i++) {
            if (heroes[i].getHealth() > 0 && this.getHealth() > 0 && heroes[i] != heroes[7] ){
                heroes[i].setDamage(heroes[i].getDamage() + 3);
            }
        }
    }
}

