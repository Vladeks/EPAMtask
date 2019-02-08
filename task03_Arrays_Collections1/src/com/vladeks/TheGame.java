package com.vladeks;

import java.util.Random;

public class TheGame {
    /*
    * D. Герой комп'ютерної гри, що володіє силою в 25 балів, знаходиться в круглому залі,
    * з якого ведуть 10 закритих дверей. За кожними дверима героя чекає або магічний артефакт,
    * що дарує силу від 10 до 80 балів, або монстр, який має силу від 5 до 100 балів,
     * з яким герою потрібно битися. Битву виграє персонаж, що володіє найбільшою силою; якщо сили рівні, перемагає герой.
      1. Організувати введення інформації про те, що знаходиться за дверима, або заповнити її, використовуючи генератор випадкових чисел.
      2. Вивести цю саму інформацію на екран в зрозумілому табличному вигляді.
      3. Порахувати, за скількома дверима героя чекає смерть. Рекурсивно.
      4. Вивести номери дверей в тому порядку, в якому слід їх відкривати герою, щоб залишитися в живих, якщо таке можливо.
    * */

    private int heroScore = 25;
    private int deathDoorCount;

    private Random random = new Random(System.currentTimeMillis());
    private final int DOORS_COUNT = 10;

    private void hall() {
        int[] doors = new int[10];


    }

    private int[] initDoors() {
        int[] doors = new int[DOORS_COUNT];
        for (int i = 0; i < DOORS_COUNT; i++) {
            if(isMonster()) {
                doors[i] = getMonsterPower();
            } else {
                doors[i] = getPower();
            }
        }
        return doors;
    }

    private boolean isMonster() {
        boolean[] isMonster = {true, false};
        int position = 0;
        int randomNumber = random.nextInt(101);
        if(randomNumber > 40) {
            position = 1;
        }

        return isMonster[position];
    }

    private int getMonsterPower() {
        return -1 * (5 + random.nextInt(96));
    }

    private int getPower() {
        return 10 + random.nextInt(70 + 1);
    }

    public void printDoors(int[] doors) {
        for (int i = 0; i < doors.length; i++) {
            System.out.println(formatDoors(i, doors[i]));
        }
    }

    private String formatDoors(int i, int power) {
        String behindDoor;
        if (power < 0) {
            behindDoor = "monster";
            power*= -1;
        } else {
            behindDoor = "power";
        }
        return String.format("Door %2d with %7s: %3d behind", i+1, behindDoor, power);
    }

    public void calculateDeathDoor(int[] doors, int currentHeroPower, int door) {
        if(door < doors.length ){
            if(doors[door] < 0  & currentHeroPower < Math.abs(doors[door])) {
                System.out.println("You dead in " + formatDoors(door, doors[door]));
                deathDoorCount++;
            } else {
                System.out.println("Door " + door + " open");
            }
            door++;
            calculateDeathDoor(doors, currentHeroPower,door);
        }
    }

    public void printDeathDoorCount(int[] doors) {
        calculateDeathDoor(doors, heroScore, 0);
        System.out.println("deathDoorCount " + deathDoorCount);
    }

    public static void main(String[] args) {
        TheGame game = new TheGame();
        int [] doors = game.initDoors();
        game.printDoors(doors);
        game.printDeathDoorCount(doors);
        System.out.println();
    }

}
