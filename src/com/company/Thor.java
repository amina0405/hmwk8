package com.company;

public class Thor {
    public Thor (int health, int damage, String name) {
        super(health, damage,name, SuperAbility.STUN );
    }
    public void applySuperPower(Boss boss, Hero[] heroes) {
        boolean thorAttack = RPG_Game.random.nextBoolean();
        if (this.getHealth() > 0 && thorAttack == true) {
            boss.setDamage(0);
        }else {
            boss.setDamage(50);
        }
    }
}

