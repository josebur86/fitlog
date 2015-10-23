package com.josebur.fitlog.data.entity;

import java.util.List;

/**
 * Workout Session entity that is used at the data layer.
 */
public class SessionEntity {
    private final int id;
    private final int userId;
    private final int workoutId;
    private final int exerciseId;
    private final int repGoal;
    private final List<SetEntity> sets;

    /**
     * Constructs a session for a workout.
     * @param id the id of this session
     * @param userId the id of the user for this session
     * @param workoutId the id of the workout for this session
     * @param exerciseId the id of the exercise for this session
     * @param repGoal the exercise repetitions goal for this session
     * @param sets the {@link SetEntity} list for this session
     */
    public SessionEntity(int id, int userId, int workoutId, int exerciseId, int repGoal, List<SetEntity> sets) {
        this.id = id;
        this.userId = userId;
        this.workoutId = workoutId;
        this.exerciseId = exerciseId;
        this.repGoal = repGoal;
        this.sets = sets;
    }

    /**
     * Returns the id for this session.
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the user id for this session.
     * @return the user id
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Returns the workout id for this session.
     * @return the workout id
     */
    public int getWorkoutId() {
        return workoutId;
    }

    /**
     * Returns the exercise id for this session.
     * @return the exercise id
     */
    public int getExerciseId() {
        return exerciseId;
    }

    /**
     * Returns the exercise repetition goal for this session.
     * @return the rep goal
     */
    public int getRepGoal() {
        return repGoal;
    }

    /**
     * Returns the sets for this session.
     * @return the sets
     */
    public List<SetEntity> getSets() {
        return sets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SessionEntity that = (SessionEntity) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (workoutId != that.workoutId) return false;
        if (exerciseId != that.exerciseId) return false;
        if (repGoal != that.repGoal) return false;
        return sets.equals(that.sets);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId;
        result = 31 * result + workoutId;
        result = 31 * result + exerciseId;
        result = 31 * result + repGoal;
        result = 31 * result + sets.hashCode();
        return result;
    }
}
