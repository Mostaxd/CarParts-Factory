package com.company;
// Car-Parts Example
public class Main {

    public static void main(String[] args) {

        ReceivingStock receivingStock = new ReceivingStock(50, 100);

        Purchasing purchasing = new Purchasing(receivingStock);

        Factory factory = new Factory(purchasing, receivingStock);

        // Create Part bumper
        Part bumper = factory.createPart(PartType.SINGLE_PART, "1", "Bumper");

        //buy 500 bumpers
        factory.getPurchasing().buy(bumper, 50);

        //check received inventory


        factory.getReceivingStock().insert(bumper, 50);
        factory.getReceivingStock().remove(bumper, 5);



    }
}