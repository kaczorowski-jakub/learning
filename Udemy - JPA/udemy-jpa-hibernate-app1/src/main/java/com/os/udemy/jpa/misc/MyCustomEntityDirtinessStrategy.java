package com.os.udemy.jpa.misc;

import org.hibernate.CustomEntityDirtinessStrategy;
import org.hibernate.Session;
import org.hibernate.persister.entity.EntityPersister;

public class MyCustomEntityDirtinessStrategy implements CustomEntityDirtinessStrategy {
    @Override
    public boolean canDirtyCheck(Object o, EntityPersister entityPersister, Session session) {
        return false;
    }

    @Override
    public boolean isDirty(Object o, EntityPersister entityPersister, Session session) {
        return false;
    }

    @Override
    public void resetDirty(Object o, EntityPersister entityPersister, Session session) {

    }

    @Override
    public void findDirty(Object o, EntityPersister entityPersister, Session session, DirtyCheckContext dirtyCheckContext) {

    }
}
