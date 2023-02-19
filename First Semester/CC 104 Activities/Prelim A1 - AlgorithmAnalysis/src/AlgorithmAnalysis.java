import java.util.Scanner;

public class AlgorithmAnalysis {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        count_function(0);

        long end = System.currentTimeMillis();
        System.out.println("Counting to the specified number takes " + (end - start) + "ms");
    }

    public static void count_function(long x) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Until what number do you want to count?");
        x = scan.nextLong();

        System.out.println("Counting has started.");
        for (long i = 0; i < x; i++)
            ;
        System.out.println("Counting has ended.");
        scan.close();
    }
}
