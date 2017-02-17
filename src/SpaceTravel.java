import java.util.Scanner;

/**
 * Created by cchameyr on 2/15/17.
 */
public class SpaceTravel {

    public static final double  ROCKET_SPEED_IN_KM_PER_S = 4.0;
    private static Planet[]     planet_list = Planet.values();

    private static void listPlanetWithUA() {
        for (int i = 0 ; i < planet_list.length ; i++) {
            System.out.print(planet_list[i].getNamefr() + " (" + planet_list[i].getDistance_sun_in_astro_unit() + "), ");
        }
        System.out.print('\n');
    }

    private static void listPlanet() {
        for (int i = 0 ; i < planet_list.length ; i++) {
            System.out.print(planet_list[i].getNamefr() + ", ");
        }
        System.out.print('\n');
    }


    private static Planet choosePlanet(Scanner scan) {
        listPlanet();
        while (true) {
            final String choice = scan.next();
            for (int i = 0 ; i < planet_list.length ; i++) {
                if (planet_list[i].getNamefr().toLowerCase().startsWith(choice.toLowerCase())) {
                    return (planet_list[i]);
                }
            }
            System.out.printf("Sorry, [%s] isn't a valid planet\n", choice);
        }
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
                        System.out.println("usage :\nq: quit the program\nl: list the planets\nd : Choose your departure planet\nh: print help");
                        break;

                    case 'l' :
                        listPlanetWithUA();
                        break;

                    case 'd' :
                        System.out.println("What is your departure planet?");
                        Planet p1 = choosePlanet(scan);
                        System.out.println("Departure planet set to: " + p1.getNamefr());
                        System.out.println("What is your arrival planet?");
                        Planet p2 = choosePlanet(scan);
                        System.out.println("Arrival planet set to: " + p2.getNamefr());
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
