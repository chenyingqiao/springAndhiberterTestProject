package com.chen.repository.IRep;

import java.util.List;

/**
 * Created by chen on 16-11-18.
 */
public interface IBookTypeRepositrory<T> extends IBaseRepostitory<T>  {
    List getAllBookType();
}
