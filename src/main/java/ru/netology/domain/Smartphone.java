package ru.netology.domain;

import java.util.Objects;

public class Smartphone extends Product {
    private String name;
    private String vendor;

    public Smartphone() {
        super();
    }

    public Smartphone(int id, String name, int price, String vendor) {
        super(id, name, price);
        this.name = name;
        this.vendor = vendor;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Smartphone that = (Smartphone) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(vendor, that.vendor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, vendor);
    }

    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        return getVendor().equalsIgnoreCase(search);
    }
}
