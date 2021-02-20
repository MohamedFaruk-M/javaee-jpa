package com.nisfa.config;

import java.util.logging.Logger;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author NisfaYasam
 */
public class Producers {

    @Produces
    @PersistenceContext(unitName = "hrms")
    EntityManager entityManager;

    @Produces
    public Logger getLoggers(InjectionPoint injectionPoint) {

        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }

}
