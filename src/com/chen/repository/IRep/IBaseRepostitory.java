package com.chen.repository.IRep;


import com.sun.istack.internal.Nullable;

import java.io.Serializable;

/**
 * Created by chen on 16-11-12.
 */
public interface IBaseRepostitory<T> {
    void save(T entiy);
    void save(T[] entiy);
    void delete(T entiy);
    void delete(T[] entiy);
    void update(T entiy);
    void update(T[] entiy);
    T getOne(Class<T> tClass, @Nullable Serializable primaryKey);
}
