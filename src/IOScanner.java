import java.util.Scanner;
public class IOScanner {

    public static Scanner input;

    public static int inputInt(String message) {
        input = new Scanner(System.in);
        System.out.println(message);
        int a = input.nextInt();
        input.nextLine();

        return a;
    }


    public static String inputString(String message) {
        System.out.println(message);

        return input.nextLine();

    }

    public static void closeScanner(){
        input.close();
    }

}