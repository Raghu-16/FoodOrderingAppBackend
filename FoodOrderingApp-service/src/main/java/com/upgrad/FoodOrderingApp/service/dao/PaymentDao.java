package com.upgrad.FoodOrderingApp.service.dao;

import com.upgrad.FoodOrderingApp.service.entity.PaymentEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Repository
public class PaymentDao {

    @PersistenceContext
    private EntityManager entityManager;

    public PaymentEntity getPaymentByUuid(String uuid) {
        try {
            return this.entityManager.createNamedQuery("paymentByUuid", PaymentEntity.class).setParameter("uuid", uuid)
                    .getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

}