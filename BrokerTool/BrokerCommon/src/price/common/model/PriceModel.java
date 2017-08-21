package price.common.model;

import java.io.Serializable;

public class PriceModel implements Serializable{
    private String symbol;
    private float price;
    
    public PriceModel(String symbol, float price){
        this.symbol = symbol;
        this.price = price;
    }
    
    // Methods to return the private values of this object
    public float getPrice() {
        return price;
    }
    
    public String getSymbol() {
        return symbol;
    }
    
    public void setPrice (float newPrice) {
        price = newPrice;
    }
    
    public String toString() {
        return "Stock:  " + symbol + "  " + price;
    }
}