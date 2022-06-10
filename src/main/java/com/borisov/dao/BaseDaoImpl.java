package com.borisov.dao;

import com.borisov.entity.BaseEntity;
import com.borisov.entity.Employee;
import lombok.Getter;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

@Getter
public abstract class BaseDaoImpl<T extends Serializable, E extends BaseEntity<T>> implements BaseDao<Long, Employee> {

    @Autowired
    private SessionFactory sessionFactory;
}
