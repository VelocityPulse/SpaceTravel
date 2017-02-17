import java.util.Scanner;

/**
 * Created by cchameyr on 2/15/17.
 */
public class SpaceTravel {

    public static final double  ROCKET_SPEED_IN_KM_PER_S = 4.0;

    private static Planet[]     planet_list = Planet.values();

    private static Planet choosePlanet(Scanner scan) {

    }

    public static void spaceTravel () {

        Scanner     scan = new Scanner(System.in);
        String      choice;
        boolean     quit = false;

        System.out.println("Welcome");
        while (!quit) {
            choice = (scan.nextLine()).trim();
            if (choice.length() > 0) {

                switch (choice.charAt(0)) {
                    case 'q' :
                        quit = true;
                        break;

                    case 'h' :
                        System.out.println("usage :\nq: quit the program\nl: list the planets\nh: print help");
                        break;

                    case 'l' :
                        for (int i = 0 ; i < planet_list.length ; i++) {
                            System.out.print(planet_list[i].getNamefr() + " (" + planet_list[i].getDistance_sun_in_astro_unit() + "), ");
                        }
                        System.out.print('\n');
                        break;

                    default :
                        System.out.println(choice.charAt(0) + " command not found [use 'h' for help]");
                        break;
                }
            }
        }
        System.out.print("Bye");
    }
}
