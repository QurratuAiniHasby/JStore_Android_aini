package com.example.jstore_android_aini;

public class Item {
    private int id;
    private String name;
    private int price;
    private String category;
    private String status;
    private Supplier supplier;

    public Item(int id, String name, int price, String category, String status, Supplier supplier)
    {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.supplier = supplier;
        this.status = status;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public int getPrice()
    {
        return price;
    }

    public String getCategory()
    {
        return category;
    }

    public String getStatus()
    {
        return status;
    }

    public Supplier getSupplier()
    {
        return supplier;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public void setSupplier(Supplier supplier)
    {
        this.supplier = supplier;
    }

    public String toString()
    {
        return "===============ITEM==============="
                + "\nID       : " + getId()
                + "\nName     : " + getName()
                + "\nCategory : " + getCategory()
                + "\nStatus   : " + getStatus()
                + "\nSupplier : " + supplier.getName() + "\n";
    }

}
