package com.train;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        System.out.println("Please enter number of tickets:");
        Scanner scanner = new Scanner(System.in);
        int totalTickets = scanner.nextInt();
        System.out.println("How many round-trip tickets:");
        int roundTripTickets = scanner.nextInt();
        Tickets tickets = new Tickets(totalTickets, roundTripTickets);
        if (tickets.checkOK()) {
            System.out.println("Total tickets: " + tickets.getTotalTickets());
            System.out.println("Round-trip: " + tickets.getRoundTripTickets());
            System.out.println("Total: " + tickets.getTotalPrice());
        }
    }
}

class Tickets {
    private int totalTickets;
    private int roundTripTickets;
    private double discount = 0.9;
    private double priceOfTicket = 1000;
    private double priceOfRoundTicket = 2000 * discount;

    public Tickets(int total, int roundTrip) {
        this.totalTickets = total;
        this.roundTripTickets = roundTrip;
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public int getRoundTripTickets() {
        return roundTripTickets;
    }

    public void setRoundTripTickets(int roundTripTickets) {
        this.roundTripTickets = roundTripTickets;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getPriceOfTicket() {
        return priceOfTicket;
    }

    public void setPriceOfTicket(double priceOfTicket) {
        this.priceOfTicket = priceOfTicket;
    }

    public double getPriceOfRoundTicket() {
        return priceOfRoundTicket;
    }

    public void setPriceOfRoundTicket(double priceOfRoundTicket) {
        this.priceOfRoundTicket = priceOfRoundTicket;
    }

    public double getTotalPrice() {
        return (this.totalTickets - this.roundTripTickets) * priceOfTicket +
                this.roundTripTickets * priceOfRoundTicket;
    }

    public boolean checkOK() {
        if (this.totalTickets < 0) {
            System.out.println("Total tickets cannot be less than zero !!");
            return false;
        }
        if (this.roundTripTickets < 0) {
            System.out.println("Total roundTrip tickets cannot be less than zero !!");
            return false;
        }
        if (this.totalTickets < this.roundTripTickets) {
            System.out.println("RoundTrip tickets cannot be more than Total tickets !!");
            return false;
        }
        return true;
    }


}
