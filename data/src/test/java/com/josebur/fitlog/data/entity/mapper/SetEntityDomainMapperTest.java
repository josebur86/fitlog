package com.josebur.fitlog.data.entity.mapper;

import com.josebur.fitlog.data.entity.SetEntity;
import com.josebur.fitlog.domain.Set;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class SetEntityDomainMapperTest {
    @Test
    public void toDomainModelReturnsNullIfEntityIsNull() {
        SetEntityDomainMapper mapper = new SetEntityDomainMapper();

        SetEntity entity = null;
        Set set = mapper.toDomainModel(entity);
        assertNull(set);

        List<SetEntity> entities = null;
        List<Set> sets = mapper.toDomainModel(entities);
        assertTrue("sets should be empty", sets.isEmpty());

        entities = new ArrayList<>();
        entities.add(null);
        entities.add(null);
        sets = mapper.toDomainModel(entities);
        assertTrue("sets should be empty", sets.isEmpty());
    }

    @Test
    public void toDomainModelTest() {
        SetEntityDomainMapper mapper = new SetEntityDomainMapper();

        SetEntity entity = new SetEntity(1);
        Set set = mapper.toDomainModel(entity);

        Set expectedSet = new Set(1);
        assertEquals(expectedSet, set);
    }

    @Test
    public void toDomainModelListTest() {
        SetEntityDomainMapper mapper = new SetEntityDomainMapper();

        List<SetEntity> setEntities = new ArrayList<>();
        setEntities.add(new SetEntity(1));
        setEntities.add(new SetEntity(2));

        List<Set> sets = mapper.toDomainModel(setEntities);
        List<Set> expectedSets = new ArrayList<>();
        expectedSets.add(new Set(1));
        expectedSets.add(new Set(2));

        assertEquals(expectedSets, sets);
    }
}
