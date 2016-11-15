package com.chen.repository.IRep;

import org.hibernate.Criteria;

/**
 * Created by chen on 16-11-15.
 */
public interface IRepostitoryPage {
    Long P(Criteria c,Class classs, int page);
}
