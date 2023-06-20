package Hippodrome;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    static Hippodrome game;
    private List<Horse> horses;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public void run() throws InterruptedException {
        for (int i = 1; i <= 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        Horse max_horse = null;
        double max_dist = 0;
        for (Horse horse : horses) {
            if (horse.distance > max_dist) {
                max_dist = horse.distance;
                max_horse = horse;
            }
        }
        return max_horse;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) throws InterruptedException {
        List<Horse> horses = new ArrayList<>();
        horses.add(new Horse("Elisey", 3, 0));
        horses.add(new Horse("Alexandr", 3, 0));
        horses.add(new Horse("Alesha", 3, 0));
        game = new Hippodrome(horses);

        game.run();
        game.printWinner();
    }
}