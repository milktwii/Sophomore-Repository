import java.util.*;

public class PrelimExam {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        MyMath addition = new MyMath();

        System.out.println("The System will perform basic addition.");
        System.out.println("Please choose a method.");
        System.out.println("A - Add Two Numbers \nB - Add Three Numbers \nC - Add Four Numbers");
        String input = scan.nextLine();

        switch (input) {
            case "A":
            case "a":
                System.out.println("=======================================");
                System.out.println("Enter the Value of the first number:");
                int Afirst = scan.nextInt();

                System.out.println("=======================================");
                System.out.println("Enter the Value of the second number:");
                int Asecond = scan.nextInt();
                System.out.println("The sum of the two numbers is: " + addition.add(Afirst, Asecond));
                System.out.println("=======================================");
                break;

            case "B":
            case "b":
                System.out.println("=======================================");
                System.out.println("Enter the Value of the first number:");
                int Bfirst = scan.nextInt();

                System.out.println("=======================================");
                System.out.println("Enter the Value of the second number:");
                int Bsecond = scan.nextInt();

                System.out.println("=======================================");
                System.out.println("Enter the Value of the third number:");
                int Bthird = scan.nextInt();
                System.out.println("The sum of all three numbers is: " + addition.add(Bfirst, Bsecond, Bthird));
                System.out.println("=======================================");
                break;

            case "C":
            case "c":
                System.out.println("=======================================");
                System.out.println("Enter the Value of the first number:");
                int Cfirst = scan.nextInt();

                System.out.println("=======================================");
                System.out.println("Enter the Value of the second number:");
                int Csecond = scan.nextInt();

                System.out.println("=======================================");
                System.out.println("Enter the Value of the third number:");
                int Cthird = scan.nextInt();

                System.out.println("=======================================");
                System.out.println("Enter the Value of the fourth number:");
                int Cfourth = scan.nextInt();
                System.out.println("The sum of all four numbers is: " + addition.add(Cfirst, Csecond, Cthird, Cfourth));
                System.out.println("=======================================");
                break;

            default:
                System.out.println("Invalid Choice input. Please try again.");
                main(args);
        }
        scan.close();
    }
}

class MyMath {
    public int add(int first, int second) {

        int sum = first + second;
        System.out.println("=======================================");
        System.out.println("The values of each numbers are:");
        System.out.println("First Number: " + first);
        System.out.println("Second Number: " + second);

        return sum;
    }

    public int add(int first, int second, int third) {

        int sum = first + second + third;
        System.out.println("=======================================");
        System.out.println("The values of each numbers are:");
        System.out.println("First Number: " + first);
        System.out.println("Second Number: " + second);
        System.out.println("Third Number: " + third);

        return sum;
    }

    public int add(int first, int second, int third, int fourth) {

        int sum = first + second + third + fourth;
        System.out.println("=======================================");
        System.out.println("The values of each numbers are:");
        System.out.println("First Number: " + first);
        System.out.println("Second Number: " + second);
        System.out.println("Third Number: " + third);
        System.out.println("Fourth Number: " + fourth);

        return sum;
    }
}