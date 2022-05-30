package com.company;

public class Purchasing implements StockObserver{
protected ReceivingStock receivingStock ;

public Purchasing (ReceivingStock receivingStock)
        {
        if(receivingStock == null)
        throw new NullPointerException();

        this.receivingStock = receivingStock ;
        }


public void buy (Part part , int count ) {

        if(part == null)
        throw new NullPointerException();

        if(count < 1)
        throw new IllegalArgumentException();

        receivingStock.insert(part, count);
        }

public ReceivingStock getStock() {
        return this.receivingStock ;
        }

@Override
public void onPartCountChanged(Part part, int count) {

        // System.out.println("onpartcount changed");

        if(count < receivingStock.getMinStock())
        {
        int toInsert = receivingStock.getMaxStock() - receivingStock.getCount(part);

        buy(part,toInsert);
        }
}
        }
