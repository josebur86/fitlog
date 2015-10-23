package com.josebur.fitlog.domain;

public class Set {
    private final int setNumber;

    public Set(int setNumber) {
        this.setNumber = setNumber;
    }

    public int getSetNumber() {
        return setNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Set set = (Set) o;

        return setNumber == set.setNumber;

    }

    @Override
    public int hashCode() {
        return setNumber;
    }
}
