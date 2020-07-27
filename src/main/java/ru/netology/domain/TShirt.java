package ru.netology.domain;

import java.util.Objects;

public class TShirt extends Product {
    private int size;
    private String name;
    private String color;

    public TShirt() {
    }

    public TShirt(int id, String name, int price, int size, String color) {
        super(id, name, price);
        this.size = size;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TShirt tShirt = (TShirt) o;
        return size == tShirt.size &&
                Objects.equals(color, tShirt.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), size, color);
    }
}
