package com.chen.entiy;

import javax.persistence.*;

/**
 * Created by chen on 16-11-16.
 */
@Entity
@Table(name = "book_books", schema = "book_store", catalog = "")
public class BookBooksEntity {
    private int id;
    private String name;
    private String face;
    private Float price;
    private int number;
    private int buyNumber;
    private int type;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "face")
    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    @Basic
    @Column(name = "price")
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Basic
    @Column(name = "number")
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Basic
    @Column(name = "buy_number")
    public int getBuyNumber() {
        return buyNumber;
    }

    public void setBuyNumber(int buyNumber) {
        this.buyNumber = buyNumber;
    }

    @Basic
    @Column(name = "type")
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookBooksEntity that = (BookBooksEntity) o;

        if (id != that.id) return false;
        if (price != that.price) return false;
        if (number != that.number) return false;
        if (buyNumber != that.buyNumber) return false;
        if (type != that.type) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (face != null ? !face.equals(that.face) : that.face != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (face != null ? face.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);;
        result = 31 * result + number;
        result = 31 * result + buyNumber;
        result = 31 * result + type;
        return result;
    }
}
