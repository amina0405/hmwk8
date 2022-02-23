package com.company;

public class Hero {
    implements HavingSuperAbility {
        private SuperAbility ability;

    public Hero(int health, int damage,String name, SuperAbility ability) {
            super(health, damage, name);
            this.ability = ability;
        }

        public SuperAbility getAbility() {
            return ability;
        }

        public void setAbility(SuperAbility ability) {
            this.ability = ability;
        }

        public void hit(Boss boss) {
            if (this.getHealth() > 0 && boss.getHealth() > 0) {
                boss.setHealth(boss.getHealth() - this.getDamage());
            }
        }
    }
}
