package com.josebur.fitlog.data.entity.mapper;

import com.josebur.fitlog.data.entity.SessionEntity;
import com.josebur.fitlog.data.entity.builders.SessionEntityBuilder;
import com.josebur.fitlog.domain.Session;
import com.josebur.fitlog.domain.Set;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SessionEntityDomainMapperTest {
    private SessionEntityDomainMapper mapper;

    @Before
    public void setup() {
        mapper = new SessionEntityDomainMapper(new SetEntityDomainMapper());
    }

    @Test
    public void toDomainModelReturnsNullIfEntityIsNull() {
        Session session = mapper.toDomainModel(null);

        assertNull(session);
    }

    @Test
    public void toDomainModelTest() {
        SessionEntity entity = new SessionEntityBuilder().withSquatSession().build();

        Session session = mapper.toDomainModel(entity);

        List<Set> sets = new ArrayList<>();
        sets.add(new Set(1));
        sets.add(new Set(2));
        sets.add(new Set(3));
        sets.add(new Set(4));
        sets.add(new Set(5));
        Session expectedSession = new Session("Squat", 5, sets);
        assertEquals(expectedSession, session);
    }

    @Test
    public void toEntityReturnsNullIfSessionIsNull() {
        Session session = null;
        //noinspection ConstantConditions
        SessionEntity entity = mapper.toEntity(session);

        assertNull(entity);
    }

    @Test
    public void toEntityTest() {
        List<Set> sets = new ArrayList<>();
        sets.add(new Set(1));
        sets.add(new Set(2));
        sets.add(new Set(3));
        sets.add(new Set(4));
        sets.add(new Set(5));
        Session session = new Session("Squat", 5, sets);
        SessionEntity entity = mapper.toEntity(session);

        SessionEntity expectedEntity = new SessionEntityBuilder().withSquatSession().build();
        assertEquals(expectedEntity, entity);
    }
}
