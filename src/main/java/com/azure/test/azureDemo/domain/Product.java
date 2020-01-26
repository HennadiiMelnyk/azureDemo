package com.azure.test.azureDemo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "products")
public class Product extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private String price;

    @Column(name = "color")
    private String color;

    @Column(name = "description")
    private String description;

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Product that = (Product) o;
        return name.equals(that.name) &&
                price.equals(that.price) &&
                color.equals(that.color) &&
                description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, price, color, description);
    }
}
