package com.chen.repository.IRep;

import org.hibernate.Criteria;
import org.hibernate.criterion.SimpleExpression;

/**
 * Created by chen on 16-11-15.
 */
public interface IRepostitoryPage {
    void P(Criteria c, Class classs, int page, SimpleExpression[] simpleExpressions);
}
