import java.util.Scanner;

/**
 * Created by cchameyr on 2/15/17.
 */
public class SpaceTravel {
    public static void main (String[] args)
    {
        Scanner     scan = new Scanner(System.in);
        String      choice;
        boolean     quit = false;

        while (!quit) {
            choice = (scan.nextLine()).trim();
            if (choice.length() > 0) {

                switch (choice.charAt(0)) {
                    case 'q' :
                        quit = true;
                        break;
                    case 'h' :
                        System.out.println("Print help :");
                        break;
                    default :
                        System.out.println(choice.charAt(0) + " command not found\nUse 'h' for help");
                        break;
                }
            }
        }
        System.out.println("Bye");
    }
}
