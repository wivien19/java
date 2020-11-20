package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int water = 400;
        int milk = 540;
        int beans = 120;
        int cups = 9;
        int money = 550;
        int a = 0;
        /*int a =  water / 200;
        int b = milk / 50;
        int c = beans / 15;
        int min=0;
        if (a <= b && a <= c) min = a;
        else if (b <= a && b <= c) min = b;
        else if (c <= a && c <= b)min = c;
        if (min < cups) System.out.println("No, I can make only "+ min +"cup(s) of coffee");
        else if (min > cups) {
            int szam = min-cups;
            System.out.println("Yes, I can make that amount of coffee (and even "+ szam +" more than that)");
        }
        else System.out.println("Yes, I can make that amount of coffee");
     /*   if (a < b && a < c && a > cups) System.out.println("Yes, I can make that amount of coffee (and even "+ a +" more than that)");
        else if (b < a && b < c) System.out.println();
        else if (c < a && c < b) System.out.println();*/
       /*System.out.println("The coffe machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println("$" + money + " of money");*/


        String type = "";
        while (!type.equals("exit")) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            type = sc.nextLine();
            System.out.println();
            switch (type) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                    String coffeeType = sc.nextLine();
                    //sc.nextLine();
                    if (!coffeeType.equals("back")){
                        int coffeNum = Integer.parseInt(coffeeType);
                    switch (coffeNum) {
                        case 1:
                            if (water >= 250 && beans >= 16 && cups >= 1) {
                                water -= 250;
                                beans -= 16;
                                money += 4;
                                cups -= 1;
                                System.out.println("I have enough resources, making you a coffee!");
                            } else {
                                if (water < 250) {
                                    System.out.println("Sorry, not enough water!");
                                }
                                if (beans < 16) {
                                    System.out.println("Sorry, not enough beans!");
                                }
                                if (milk < 0) {
                                    System.out.println("Sorry, not enough milk!");
                                }
                                if (cups < 1) {
                                    System.out.println("Sorry, not enough cups!");
                                }
                            }
                            System.out.println();
                            break;
                        case 2:
                            if (water >= 350 && beans >= 20 && cups >= 1 && milk >= 75) {
                                water -= 350;
                                milk -= 75;
                                beans -= 20;
                                money += 7;
                                cups -= 1;
                                System.out.println("I have enough resources, making you a coffee!");
                            } else {
                                if (water < 350) {
                                    System.out.println("Sorry, not enough water!");
                                }
                                if (beans < 20) {
                                    System.out.println("Sorry, not enough beans!");
                                }
                                if (milk < 75) {
                                    System.out.println("Sorry, not enough milk!");
                                }
                                if (cups < 1) {
                                    System.out.println("Sorry, not enough cups!");
                                }
                                System.out.println();
                            }
                            break;
                        case 3:
                            if (water >= 200 && beans >= 12 && cups >= 1 && milk >= 100) {
                                water -= 200;
                                milk -= 100;
                                beans -= 12;
                                money += 6;
                                cups -= 1;
                                System.out.println("I have enough resources, making you a coffee!");
                            } else {
                                if (water < 200) {
                                    System.out.println("Sorry, not enough water!");
                                }
                                if (beans < 12) {
                                    System.out.println("Sorry, not enough beans!");
                                }
                                if (milk < 100) {
                                    System.out.println("Sorry, not enough milk!");
                                }
                                if (cups < 1) {
                                    System.out.println("Sorry, not enough cups!");
                                }
                                System.out.println();
                            }
                            break;
                        default:
                            break;
                    }
                    }
                    break;
                case "fill":
                    System.out.println("Write how many ml of water do you want to add:");
                    a = sc.nextInt();
                    water += a;
                    sc.nextLine();
                    System.out.println("Write how many ml of milk do you want to add:");
                    a = sc.nextInt();
                    milk += a;
                    sc.nextLine();
                    System.out.println("Write how many grams of coffee beans do you want to add:");
                    a = sc.nextInt();
                    beans += a;
                    sc.nextLine();
                    System.out.println("Write how many disposable cups of coffee do you want to add:");
                    a = sc.nextInt();
                    cups += a;
                    sc.nextLine();
                    System.out.println();
                    break;
                case "take":
                    System.out.println("I gave you $" + money);
                    System.out.println();
                    money = 0;
                    break;
                case "remaining":
                    System.out.println("The coffe machine has:");
                    System.out.println(water + " of water");
                    System.out.println(milk + " of milk");
                    System.out.println(beans + " of coffee beans");
                    System.out.println(cups + " of disposable cups");
                    System.out.println("$" + money + " of money");
                    System.out.println();
                    break;
                case "exit":
                    break;
            }
        }
    }
}
