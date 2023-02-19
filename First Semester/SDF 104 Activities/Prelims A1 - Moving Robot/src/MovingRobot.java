import java.util.Scanner;

public class MovingRobot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Robot robot = new Robot();

        System.out.println("What do you want the robot to do?");
        System.out.println("1 - Move Forward \n2 - Move a Set Number of Steps");
        int input = scan.nextInt();

        switch (input) {
            case 1:
                robot.travel();
                break;

            case 2:
                robot.travel(0);
                break;

            default:
                System.out.println("The robot is waiting for it to move again.");
                main(args);
        }
        scan.close();
    }
}

class Robot {
    public void travel() {
        facing("");
        System.out.println("The robot has moved forward one step.");
    }

    public void travel(int in) {
        Scanner scan = new Scanner(System.in);

        System.out.println("How many steps do you want the robot to take?");
        int steps = scan.nextInt();
        facing("");

        for (int a = 1; a <= steps; a++) {
            System.out.println("The robot has moved forward.");
        }
        System.out.println("The robot has stopped moving because of an obstacle.");
        System.out.println("The robot took a total of " + steps + " steps.");

        scan.close();
    }

    String facing(String direction) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Which direction would you like the robot to face? (WASD)");
        direction = scan.nextLine();

        switch (direction) {
            case "w":
            case "W":
                System.out.println("The robot changed its direction to move NORTH.");
                break;

            case "a":
            case "A":
                System.out.println("The robot changed its direction to move EAST.");
                break;

            case "s":
            case "S":
                System.out.println("The robot changed its direction to move SOUTH.");
                break;

            case "d":
            case "D":
                System.out.println("The robot changed its direction to move WEST.");
                break;

            default:
                System.out.println("The robot did not understand and remained facing the same direction.");
                facing(direction);
        }
        scan.close();
        return direction;
    }
}
