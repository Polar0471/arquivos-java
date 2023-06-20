package entities;

public class Product {
    private String name;
    private Double value;
    private int quantity;

    public Product() {
    }

    public Product(String name, Double value, int quantity) {
        this.name = name;
        this.value = value;
        this.quantity = quantity;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return this.value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double totalValue() {
        return this.quantity * this.value;
    }

    @Override 
    public String toString() {
        return this.name + ", " + this.value + ", " + this.quantity + ", " + totalValue(); 
    }

}
