package com.company;

public class Witcher {
    public Witcher (int health, int damage, String name){
        super(health,damage,name,SuperAbility.REVIVS);
    }
    public void applySuperPower(Boss boss, Hero[] heroes) {
        boolean reviveToHero = RPG_Game.random.nextBoolean();
        if (this.getHealth() > 0 && reviveToHero == true ){
            for (int i = 0; i < heroes.length ; i++) {
                if (heroes[i].getHealth() <= 0){
                    heroes[i].setHealth(this.getHealth() + heroes[i].getHealth());
                    this.setHealth(0);
                }
            }
        }
    }
}
