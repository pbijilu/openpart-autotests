package models;

import java.text.MessageFormat;

public class Trade {
    private double price;
    private int tradeItemsQuantity;

    public Trade(double price, int tradeItemsQuantity) {
        this.price = price;
        this.tradeItemsQuantity = tradeItemsQuantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTradeItemsQuantity() {
        return tradeItemsQuantity;
    }

    public void setTradeItemsQuantity(int tradeItemsQuantity) {
        this.tradeItemsQuantity = tradeItemsQuantity;
    }

    @Override
    public String toString() {
        return MessageFormat.format("Закупка с ценой {0} и количеством позиций {1}", price, tradeItemsQuantity);
    }
}
