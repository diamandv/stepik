import java.math.*;
import java.util.Arrays;

public class module2 {
    public static void main(String[] args) {
        Robot robot = new Robot(0, 0, Direction.DOWN);
        moveRobot(robot, -10, 20);
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public static class Robot {
        int x;
        int y;
        Direction dir;

        public Robot(int x, int y, Direction dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        public Direction getDirection() {
            return dir;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void turnLeft() {
            if (dir == Direction.UP) {
                dir = Direction.LEFT;
            } else if (dir == Direction.DOWN) {
                dir = Direction.RIGHT;
            } else if (dir == Direction.LEFT) {
                dir = Direction.DOWN;
            } else if (dir == Direction.RIGHT) {
                dir = Direction.UP;
            }
        }

        public void turnRight() {
            if (dir == Direction.UP) {
                dir = Direction.RIGHT;
            } else if (dir == Direction.DOWN) {
                dir = Direction.LEFT;
            } else if (dir == Direction.LEFT) {
                dir = Direction.UP;
            } else if (dir == Direction.RIGHT) {
                dir = Direction.DOWN;
            }
        }

        public void stepForward() {
            if (dir == Direction.UP) {
                y++;
            }
            if (dir == Direction.DOWN) {
                y--;
            }
            if (dir == Direction.LEFT) {
                x--;
            }
            if (dir == Direction.RIGHT) {
                x++;
            }
        }
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        System.out.println(robot.getX());
        int positionX = robot.getX();
        if (positionX < toX) {
            while (robot.getX() != toX)
                if (robot.getDirection() == Direction.RIGHT) {
                    robot.stepForward();
                } else {
                    robot.turnRight();
                }
        } else {
            if (positionX > toX) {
                while (robot.getX() != toX)
                    if (robot.getDirection() == Direction.LEFT) {
                        robot.stepForward();
                    } else {
                        robot.turnRight();
                    }
            }
        }
        System.out.println(robot.getX());

        System.out.println(robot.getY());
        int positionY = robot.getY();
        if (positionY < toY) {
            while (robot.getY() != toY)
                if (robot.getDirection() == Direction.UP) {
                    robot.stepForward();
                } else {
                    robot.turnRight();
                }
        } else {
            if (positionY > toY) {
                while (robot.getY() != toY)
                    if (robot.getDirection() == Direction.DOWN) {
                        robot.stepForward();
                    } else {
                        robot.turnRight();
                    }
            }
        }
        System.out.println(robot.getY());
    }
}