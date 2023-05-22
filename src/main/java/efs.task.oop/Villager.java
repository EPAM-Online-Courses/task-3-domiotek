package efs.task.oop;

public class Villager implements Fighter {

    protected final String name;
    protected final int age;

    protected int health;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getHealth() {
        return health;
    }

    public Villager(String name, int age) {
        this.name = name;
        this.age = age;
        this.health = 100;
    }

    public void sayHello() {
        System.out.printf("Greetings traveler... I'm %s and I'm %d years old\n", this.name, this.age);
    }

    @Override
    public void attack(Fighter victim) {
        victim.takeHit((int)(100- age * 0.5) / 10);
    }

    @Override
    public void takeHit(int damage) {
        this.health -= damage;
    }

    public boolean isDead() {
        return health <=0;
    }
}
