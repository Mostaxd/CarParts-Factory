package com.company;

public class ReceivingStock extends Stock {
    private final int minStock;
    private final int maxStock;

    public ReceivingStock(int minStock, int maxStock) {
        if (minStock < 1) {
            throw new IllegalArgumentException("Min Stock must be a positive value");
        }
        if (maxStock <= minStock) {
            throw new IllegalArgumentException("Max Stock's value must be larger than Min Stock");
        }
        this.maxStock = maxStock;
        this.minStock = minStock;
    }



    public int getMinStock() {
        return this.minStock;
    }

    public int getMaxStock() {
        return this.maxStock;
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
        if (amount + this.parts.get(part) > this.maxStock) {
            System.out.println("parts were not added: not enough stock capacity");
            return false;
        } else
            System.out.println("received stock: " + amount + " " + part.getName());
        super.insert(part, amount);
        return true;
    }

    public boolean remove(Part part, int amount) {
        if (amount < 1) {
            throw new IllegalArgumentException();
        }
        if (part == null) {
            throw new NullPointerException();
        }
        if (!this.parts.containsKey(part)) {
            return false;
        }
        if (this.parts.get(part) - amount < 0) {
            return false;
        } else
            super.remove(part, amount);
        return true;

    }
}