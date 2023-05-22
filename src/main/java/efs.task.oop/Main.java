package efs.task.oop;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Villager kashya = new Villager("Kashya",30);
        ExtraordinaryVillager akara = new ExtraordinaryVillager("Akara", 40, ExtraordinaryVillager.Skill.SHELTER);
        Villager gheed = new Villager("Gheed",50);
        ExtraordinaryVillager deckardCain = new ExtraordinaryVillager("Deckard Cain", 85, ExtraordinaryVillager.Skill.IDENTIFY);
        Villager warriv = new Villager("Warriv", 35);
        Villager flawia = new Villager("Flawia", 25);

        Object objectAkara = akara;
        Object objectDeckardCain = deckardCain;

        List<Villager> villagerList = new ArrayList<>();


        villagerList.add(kashya);
        villagerList.add(gheed);
        villagerList.add(warriv);
        villagerList.add(flawia);

        kashya.sayHello();
        akara.sayHello();
        gheed.sayHello();
        deckardCain.sayHello();
        warriv.sayHello();
        flawia.sayHello();

        int turn = 0;

        Monster currentMonster = Monsters.getAndariel();
        Villager currentVillager = villagerList.get(0);

        while(villagerList.size() > 0 && Monsters.getMonstersHealth() > 0) {
            System.out.printf("Potwory posiadaja jeszcze %d punkty zycia\n", Monsters.getMonstersHealth());
            System.out.printf("Aktualnie walczacy osadnik to %s\n", currentVillager.getName());

            if (turn % 2 == 0 ) {
                currentVillager.attack(currentMonster);

                if(currentMonster.isDead()&&currentMonster==Monsters.getAndariel()) {
                    currentMonster = Monsters.getBlacksmith();
                }
            }else {
                currentMonster.attack(currentVillager);

                if(currentVillager.isDead()) {
                    villagerList.remove(currentVillager);
                    if(villagerList.size() > 0)
                        currentVillager = villagerList.get(0);
                }
            }

            turn++;
        }

        if(villagerList.size() > 0){
            System.out.println("Obozowisko ocalone!");
        }

        deckardCain = (ExtraordinaryVillager) objectDeckardCain;
        akara = (ExtraordinaryVillager) objectAkara;


    }
}
