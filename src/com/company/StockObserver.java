package com.company;

public interface StockObserver {
    void onPartCountChanged(Part part, int count);
}