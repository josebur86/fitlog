package com.josebur.fitlog.data.entity.mapper;

import com.josebur.fitlog.data.entity.SetEntity;
import com.josebur.fitlog.domain.Set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SetEntityDomainMapper {
    public Set toDomainModel(SetEntity entity) {
        if (entity == null) return null;
        return new Set(entity.getSetNumber());
    }

    public List<Set> toDomainModel(List<SetEntity> setEntities) {
        if (setEntities == null) return Collections.emptyList();

        List<Set> sets = new ArrayList<>();
        for (SetEntity setEntity : setEntities) {
            Set set = toDomainModel(setEntity);
            if (set != null) {
                sets.add(set);
            }
        }

        return sets;
    }
}
