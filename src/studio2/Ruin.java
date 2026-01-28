package studio2;

import java.util.Scanner;

public class Ruin {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("How much money will you bring?: ");
        Double StartingAmount = scan.nextDouble();
        System.out.print("What is you winning chance at this game?: ");
        Double WinChance = scan.nextDouble();
        System.out.print("What is your win limit?: ");
        Double winLimit = scan.nextDouble();
        System.out.print("How many days will you go to the casino?: ");
        int TotalSimulations = scan.nextInt();
        int TotalWins = 0;
        int TotalLosses = 0;
        for (int SimulationsRan = 1; SimulationsRan < TotalSimulations + 1; SimulationsRan++) {
            int Plays = 0;
            Double Pot = StartingAmount;
            int WinCount = 0;
            int LossCount = 0;
            while (Pot >= 1 && Pot < winLimit) {
                double probability = Math.random();
                if (probability > WinChance) {
                    Pot--;
                    System.out.println(Pot);
                    LossCount++;
                } else {
                    Pot++;
                    System.out.println(Pot);
                    WinCount++;
                } Plays++;
            }
            System.out.println("Day: " + SimulationsRan);
            System.out.println("Today's Wins: " + WinCount +" Today's Loss Count: " + LossCount);
            System.out.println("Numer of Plays= " + Plays);
            if (WinCount > LossCount) {
                System.out.println("Today was a win!");
                TotalWins++;
            } else if (WinCount < LossCount) {
                System.out.println("Bummer!");
                TotalLosses++;
            }

        }
        double RuinSim = TotalLosses / TotalSimulations;
        double ExpectedRuin = (1 - WinChance) / TotalSimulations ;
        System.out.println(ExpectedRuin);
    }

}
