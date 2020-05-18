package Lesson_1.HW.Competition;

public class Robot implements Competitor{

    private String name;

    private int maxRunDistance;
    private int maxJumpHeight;

    private boolean onDistance;

    public Robot(String name, int maxRunDistance, int maxJumpHeight) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.onDistance = true;
    }

    @Override
    public void jump(int height) {
        if (height <= maxJumpHeight) {
            System.out.println("Робот " + name + " перепрыгнул стену высотой " + height + " м");
        } else {
            System.out.println("Робот " + name + " не смог перепрыгнуть стену высотой "
                    + height + " м");
            onDistance = false;
        }
    }

    @Override
    public void run(int distance) {
        if (distance <= maxRunDistance) {
            System.out.println("Робот " + name + " пробежал " + distance + " м");
        } else {
            System.out.println("Робот " + name + " не смог пробежать " + distance + " м");
            onDistance = false;
        }
    }

    @Override
    public boolean isOnDistance() {
        return onDistance;
    }

    @Override
    public void info() {
        System.out.println("Робот " + name +
                (onDistance ? " на дистанции" : " выбыл из соревнований"));

    }


}
