package aoo.finance;

public class Product implements Accountable {
    
    private final int id;
    private Manufacturer manufacturer;
    private String name, category, description, partNum;
    private double cost, price;

    private int updatedID;

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public Product setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Product setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getPartNum() {
        return partNum;
    }

    public Product setPartNum(String partNum) {
        this.partNum = partNum;
        return this;
    }

    public double getCost() {
        return cost;
    }

    public Product setCost(double cost) {
        this.cost = cost;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Product setPrice(double price) {
        this.price = price;
        return this;
    }
    
    public double getMarkup() {
        return price - cost;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public Product setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public int getUpdatedID() {
        return updatedID;
    }

    public Product setUpdatedID(int updatedID) {
        this.updatedID = updatedID;
        return this;
    }

    @Override
    public Object[] getTabData() {
        return new Object[]{
                id,
                name,
                category,
                description,
                partNum,
                cost,
                price
        };
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Name: \t").append(name)
                .append("\nID: \t").append(id)
                .append("\nCategory: \t").append(category)
//                .append("\nManufacturer: \t").append(manufacturer)
                .append("\nDescription: \t").append(description)
                .append("\nCost: \t").append(cost)
                .append("\nPrice: \t").append(price)
                .toString();
    }
    
    
    
}
