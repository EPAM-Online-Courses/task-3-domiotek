package efs.task.oop;

public class ExtraordinaryVillager extends Villager {
    public enum Skill {
        IDENTIFY("I will identify items for you at no charge."),
        SHELTER("I can offer you poor shelter.");

        private final String description;
        Skill(String s) {
            description = s;
        }

        public String getDescription() {
            return description;
        }
    }

    Skill skill;

    public ExtraordinaryVillager(String name, int age, Skill skill) {
        super(name, age);
        this.skill = skill;
    }

    @Override
    public void sayHello() {
        System.out.printf("Greetings traveler... I'm %s and I'm %d years old. %s\n", this.name, this.age, this.skill.getDescription());
    }

    @Override
    public void attack(Fighter victim) {
        victim.takeHit(0);
    }

    @Override
    public void takeHit(int damage) {
        this.health = 0;
    }
}
