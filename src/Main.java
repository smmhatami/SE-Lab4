import Model.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String name = getPackName();
        int weight = getWeight();
        Pack pack = new Pack(name, weight, new InTransit());
        String packStatus = "in-transit";
        while (!packStatus.equals("delivered")) {
            ShippingPlan currentShippingMethod = getShippingMethod();

            double price = currentShippingMethod.calcPrice(pack.getWeight());

            System.out.println("Product weight: " + weight + " kilograms");
            System.out.println("Shipping method: " + currentShippingMethod);
            System.out.println("Price: " + price + " rials");

            String newStatus = getStatus();


            if (!newStatus.equals(packStatus)) {
                System.out.println("Status change: " + newStatus);
            }
            packStatus = newStatus;
        }

        System.out.println("The product has reached its destination.");
    }


    private static int getWeight() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the product weight (kilograms): ");
        return scanner.nextInt();
    }

    private static String getPackName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the product name: ");
        return scanner.next();
    }

    private static ShippingPlan getShippingMethod() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the shipping method (express or standard): ");
        String input = scanner.next();
        if (input.equals("express")) {
            return new ExpressPlan();
        } else if (input.equals("standard")) {
            return new StandardPlan();
        }
        return null;
    }

    private static String getStatus() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the product status (in-transit or delivered): ");
        return scanner.next();
    }
}
