package Lesson_1.HW.Competition;

public class RunningTrack implements Obstacle {
    private int distance;

    public RunningTrack(int length) {
        this.distance = length;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public void go(Competitor competitor) {
        competitor.run(distance);
    }
}
