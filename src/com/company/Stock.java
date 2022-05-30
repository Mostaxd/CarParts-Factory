package com.company;
import java.util.*;

public class Stock {
    Map<Part, Integer> parts = new HashMap();
    private final List<StockObserver> observers = new ArrayList();

    public Stock() {};

    public int getCount(Part part) {
        if (part == null) {
            throw new NullPointerException();
        }
        if (this.parts.containsKey(part) == false){
            return -1;
        }
            return this.parts.get(part);
    }

    public boolean insert(Part part, int amount) {
        if (part == null) {
            throw new NullPointerException();
        }

        if (amount < 1) {
            throw new IllegalArgumentException();
        }

        if (!this.parts.containsKey(part)) {
            this.parts.put(part, amount);
            return true;
        }
        else {
            int current_quantity = this.parts.get(part) + amount;
            this.parts.put(part, current_quantity);
            System.out.println("Notifications sent: " + amount + " " + part.getName() + " parts are added");
            this.notifyPartCountChanged(part);
            return true;
        }
    }

    public boolean remove(Part part, int amount) {
        if (amount < 1) {
            throw new IllegalArgumentException();
        }
        if (amount != amount) {
            throw new IllegalArgumentException();
        }
        if (part == null) {
            throw new NullPointerException();
        }
        if (!this.parts.containsKey(part)) {
            return false;
        }

            int current_quantity = this.parts.get(part);
            if (current_quantity < amount) {
                return false;
            }

            else
                current_quantity -= amount;
                this.parts.put(part, current_quantity);
                System.out.println("Notification sent: an amount of " + amount+
                        " " + part.getName() + " was removed from stock");
                this.notifyPartCountChanged(part);
                return true;

    }

    public void addObserver(StockObserver observer) {
        if (observer == null) {
            throw new NullPointerException();
        }
        else
            this.observers.add(observer);
    }

    private void notifyPartCountChanged(Part part) {
        Iterator itr = this.observers.iterator();

        while(itr.hasNext()) {
            StockObserver observer = (StockObserver)itr.next();
            System.out.println("Notification sent");
            observer.onPartCountChanged(part, this.parts.get(part));
        }
    }
}
