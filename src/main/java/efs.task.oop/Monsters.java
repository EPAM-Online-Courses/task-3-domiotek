package efs.task.oop;

public class Monsters {
    static final public Monster andariel = new Monster(10, 70) {
        @Override
        public void attack(Fighter victim) {
            victim.takeHit(this.getDamage());
        }

        @Override
        public void takeHit(int damage) {
            this.health -= damage;
            monstersHealth -= damage;
        }
    };

    static final public Monster blacksmith = new Monster(100,25) {
        @Override
        public void attack(Fighter victim) {
            victim.takeHit(this.getDamage());
        }

        @Override
        public void takeHit(int damage) {
            this.health -= 5+damage;
            monstersHealth -= 5+damage;
        }
    };

    static int monstersHealth = 110;

    public static int getMonstersHealth() {
        return monstersHealth;
    }

    public static Monster getAndariel() {
        return Monsters.andariel;
    }

    public static Monster getBlacksmith() {
        return Monsters.blacksmith;
    }
}
