package com.company;


public class Factory {
    protected Purchasing purchasing;
    protected ReceivingStock receivingStock;

    public Factory(Purchasing purchasing, ReceivingStock receivingStock) {
        if (purchasing == null || receivingStock == null){
            throw new NullPointerException();
        }

            this.purchasing = purchasing;
            this.receivingStock = receivingStock;
        }


    public Purchasing getPurchasing() {
        return this.purchasing;
    }

    public ReceivingStock getReceivingStock() {
        return this.receivingStock;
    }

    public static Part createPart(PartType partype, String id, String name) {
        if (partype == null) {
            throw new NullPointerException();
        }
        else {
            Part p = null;
            if (PartType.SINGLE_PART.equals(partype)) {
                p = new SinglePart(id, name);
            }
            if (PartType.MANY_PARTS.equals(partype)) {
                p = new ManyParts(id, name);

            }
            return p;
        }
    }
}
