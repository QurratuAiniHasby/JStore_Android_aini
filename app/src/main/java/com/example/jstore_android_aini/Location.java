package com.example.jstore_android_aini;

public class Location {
    private String province;
    private String description;
    private String city;

    public Location(String province, String description, String city)
    {
        this.province = province;
        this.description = description;
        this.city = city;
    }

    public String getProvince()
    {
        return province;
    }

    public String getDescription()
    {
        return description;
    }

    public String getCity()
    {
        return city;
    }

    public void setProvince(String province)
    {
        this.province = province;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String toString()
    {
        System.out.println("==========LOCATION==========");
        System.out.println("Provinsi : " + province);
        System.out.println("Kota : " + city);
        System.out.println("Deskripsi : " + description);
        return "";
    }
}
