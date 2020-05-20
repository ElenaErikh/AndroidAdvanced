package Lesson_1.HW.Competition;

public class Wall implements Obstacle{
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void go(Competitor competitor) {
        competitor.jump(height);
    }
}
