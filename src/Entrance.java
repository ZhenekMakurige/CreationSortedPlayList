import java.util.Scanner;

public class Entrance {
    public Integer SetIntegerValue(String ValueName) {
        Scanner scanr = new Scanner(System.in);
        System.out.println("Enter the numbers of " + ValueName);
        int i = 0;
        if (scanr.hasNextInt()) {
            i = scanr.nextInt();
         }
        return i;
    }
}
