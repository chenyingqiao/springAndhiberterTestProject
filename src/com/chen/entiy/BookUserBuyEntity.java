package com.chen.entiy;

import javax.persistence.*;

/**
 * Created by chen on 16-11-11.
 */
@Entity
@Table(name = "book_user_buy", schema = "book_store", catalog = "")
public class BookUserBuyEntity {
    private int id;
    private int buyTime;
    private int buyNumber;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "buy_time")
    public int getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(int buyTime) {
        this.buyTime = buyTime;
    }

    @Basic
    @Column(name = "buy_number")
    public int getBuyNumber() {
        return buyNumber;
    }

    public void setBuyNumber(int buyNumber) {
        this.buyNumber = buyNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookUserBuyEntity that = (BookUserBuyEntity) o;

        if (id != that.id) return false;
        if (buyTime != that.buyTime) return false;
        if (buyNumber != that.buyNumber) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + buyTime;
        result = 31 * result + buyNumber;
        return result;
    }
}
