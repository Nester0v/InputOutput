import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        try {
            new Main().run();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void run() throws FileNotFoundException {
        HelloWorldTxt();
        RandomNumbersTxt();
        ReadMax();
    }

    private void HelloWorldTxt() throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(
                new FileOutputStream("HelloWorld.txt"))) {
            writer.println("Hello World!!!");
        }

    }

    private void RandomNumbersTxt() throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(
                new FileOutputStream("RandomNumbers.txt"))) {

            final int min = (-500);
            final int max = (650);

            for (int i = 0; i < 1000; ++i) {
                int a = (int) ((Math.random() * max) + min);
                writer.print(a + " ");
            }
        }
    }

    private void ReadMax() throws FileNotFoundException {
        Collection<Integer> values = new ArrayList<Integer>();
        try(Scanner sc = new Scanner(
                new FileInputStream("RandomNumbers.txt"), StandardCharsets.UTF_8.name())) {
            while (sc.hasNextInt()){
                values.add(sc.nextInt());
            }

        }

    }

}
