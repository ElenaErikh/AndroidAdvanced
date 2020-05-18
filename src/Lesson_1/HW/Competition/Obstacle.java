package Lesson_1.HW.Competition;

import Lesson_1.HW.Competition.Competitor;

@FunctionalInterface
public interface Obstacle {
    void go(Competitor competitor);
}
