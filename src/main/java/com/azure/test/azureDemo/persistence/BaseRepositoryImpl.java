package com.azure.test.azureDemo.persistence;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.io.Serializable;

public class BaseRepositoryImpl<T, I extends Serializable> extends SimpleJpaRepository<T, I> implements BaseRepository<T, I> {

    /**
     * Base repository implementation constructor
     *
     * @param entityInformation the entity to manage
     * @param entityManager     the entity manager
     */
    public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
    }

    /**
     * Base repository implementation constructor
     *
     * @param domainClass the entity class to manage
     * @param em          the entity manager
     */
    public BaseRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
    }
}
