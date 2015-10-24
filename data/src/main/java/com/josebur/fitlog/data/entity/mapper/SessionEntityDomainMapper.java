package com.josebur.fitlog.data.entity.mapper;

import com.josebur.fitlog.data.entity.SessionEntity;
import com.josebur.fitlog.data.entity.SetEntity;
import com.josebur.fitlog.domain.Session;
import com.josebur.fitlog.domain.Set;

import java.util.ArrayList;
import java.util.List;

public class SessionEntityDomainMapper {
    private final SetEntityDomainMapper setMapper;

    public SessionEntityDomainMapper(SetEntityDomainMapper setMapper) {
        this.setMapper = setMapper;
    }

    public Session toDomainModel(SessionEntity sessionEntity) {
        if (sessionEntity == null) return null;

        List<Set> sets = setMapper.toDomainModel(sessionEntity.getSets());
        return new Session("Squat", sessionEntity.getRepGoal(), sets);
    }

    public SessionEntity toEntity(Session session) {
        if (session == null) return null;

        List<SetEntity> setEntities = new ArrayList<>();
        for (Set set : session.getSets()) {
            setEntities.add(new SetEntity(set.getSetNumber()));
        }
        return new SessionEntity(999, 1, 1, 1, session.getRepGoal(), setEntities);
    }
}
