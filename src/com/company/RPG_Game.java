package com.company;

public class RPG_Game {
    private static int round_number;
    public static Random random = new Random();

    public static void start() {
        Boss boss = new Boss(6000, 50, "boss");
        Warrior warrior = new Warrior(270, 10,"Warrior");
        Medic doc = new Medic(200, 5, 15, "Doc");
        Berserk berserk = new Berserk(280, 15, "Berserk");
        Magic magic = new Magic(260, 20, "Magic");
        Medic assistant = new Medic(250, 10, 5, "Assistant");
        Thor thor = new Thor(270,20,"Thor");
        Golem golem = new Golem(250,25,"Golem");
        Witcher witcher = new Witcher(300,0,"Witcher");
        Hero[] heroes = {warrior, doc, berserk, magic, assistant,thor,golem,witcher};

        printStatistics(boss, heroes);
        while (!isGameFinished(boss, heroes)) {
            round(boss, heroes);
        }
        System.out.println();
    }

    private static void round(Boss boss, Hero[] heroes) {
        round_number++;
        boss.hit(heroes);
        for (int i = 0; i < heroes.length; i++) {
            heroes[i].hit(boss);
            heroes[i].applySuperPower(boss, heroes);
        }
        printStatistics(boss, heroes);
    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println(round_number + " ROUND _________________");
        System.out.println("Boss health: " + boss.getHealth()
                + " [" + boss.getDamage() + "]");
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i] instanceof Medic) {
                System.out.println(heroes[i].getName()
                        + " health: " + heroes[i].getHealth()
                        + " [" + heroes[i].getDamage() + "] +" +
                        ((Medic) heroes[i]).getHealPoints() + "+");
            } else {
                System.out.println(heroes[i].getClass().getSimpleName()
                        + " health: " + heroes[i].getHealth()
                        + " [" + heroes[i].getDamage() + "]");
            }
        }
    }
}
}
