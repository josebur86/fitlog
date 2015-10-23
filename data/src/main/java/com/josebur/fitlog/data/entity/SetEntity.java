package com.josebur.fitlog.data.entity;

/**
 * Exercise Set entity that is used in the data layer.
 */
public class SetEntity {
    private int setNumber;

    /**
     * Constructs a set for an exercise
     * @param setNumber the number of the set to construct.
     *
     * @throws IllegalArgumentException if the set number is zero or less
     */
    public SetEntity(int setNumber) throws IllegalArgumentException {
        if (setNumber <= 0 )
            throw new IllegalArgumentException("set number cannot be zero or less");

        this.setNumber = setNumber;
    }

    /**
     * Returns the set number for this set. The set number will determine
     * the order of the set in a group of sets.
     * @return the set number
     */
    public int getSetNumber() {
        return setNumber;
    }

    /**
     * Returns the string representation of this set
     * @return string representation
     */
    @Override
    public String toString() {
        return "Set: " + setNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SetEntity setEntity = (SetEntity) o;

        return setNumber == setEntity.setNumber;

    }

    @Override
    public int hashCode() {
        return setNumber;
    }
}
