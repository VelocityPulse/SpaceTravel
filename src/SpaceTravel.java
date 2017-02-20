import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;


/**
 * Created by cchameyr on 2/15/17.
 */
public class SpaceTravel {

    private static final double ROCKET_SPEED_IN_KM_PER_S = 4.0;
    private static Planet[]     planet_list = Planet.values();
    private static Planet       p1 = null;
    private static Planet       p2 = null;

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

    private static void departureSelect(Scanner scan) {
		System.out.println("What is your departure planet?");
		p1 = choosePlanet(scan);
		System.out.println("Departure planet set to: " + p1.getNamefr());
		System.out.println("What is your arrival planet?");
		p2 = choosePlanet(scan);
		System.out.println("Arrival planet set to: " + p2.getNamefr());
		System.out.print("Distance between " + p1.getNamefr() + " and " + p2.getNamefr() + " is : ");
		System.out.printf("%.4f UA.\n", p1.distanceInUATo(p2));
		System.out.printf("It is equivalent to %.1f million of Km!\n", p1.distanceInKMTo(p2) / 1_000_000);
		System.out.printf("At the speed of the light, you will need %.1f minutes.\n", p1.travelTimeInSTO(p2) / 60);
		System.out.printf("But with our current technology it's more %.1f month!\n", p1.travelTimeInSTo(p2, ROCKET_SPEED_IN_KM_PER_S));
	}

	private static Date chooseDate(Scanner scan) {
        Calendar    departure = Calendar.getInstance();

        while (true) {
            System.out.print("Year: ");
            if (scan.hasNext(Pattern.compile("[0-9]{1,4}"))) {
                departure.set(Calendar.YEAR, scan.nextInt() - 1900);
                scan.nextLine();
                break;
            }
            else
                scan.nextLine();
        }
        while (true) {
            System.out.print("Month: ");
            if (scan.hasNext(Pattern.compile("[0-9]{1,2}"))) {
                departure.set(Calendar.MONTH, scan.nextInt());
                scan.nextLine();
                break;
            }
            else
                scan.nextLine();
        }
        while (true) {
            System.out.print("Day: ");
            if (scan.hasNext(Pattern.compile("[0-9]{1,2}"))) {
                departure.set(Calendar.DAY_OF_MONTH, scan.nextInt());
                scan.nextLine();
                break;
            }
            else
                scan.nextLine();
        }
        while (true) {
            System.out.print("Hour: ");
            if (scan.hasNext(Pattern.compile("[0-9]{1,2}]"))) {
                departure.set(Calendar.HOUR, scan.nextInt());
                scan.nextLine();
                break;
            }
            else
                scan.nextLine();
        }
        while (true) {
            System.out.print("Minute: ");
            if (scan.hasNext(Pattern.compile("[0-9]{1,2}]"))) {
                departure.set(Calendar.MINUTE, scan.nextInt());
                scan.nextLine();
                break;
            }
            else
                scan.nextLine();
        }
        while (true) {
            System.out.print("Second: ");
            if (scan.hasNext(Pattern.compile("[0-9]{1,2}"))) {
                departure.set(Calendar.SECOND, scan.nextInt());
                scan.nextLine();
                break;
            }
            else
                scan.nextLine();
        }
        return (departure.getTime());
    }

	private static void calculateArrivalTime(Scanner scan) {
        SimpleDateFormat    dateFormatter = new SimpleDateFormat("d MMMM y H:mm:s");

        chooseDate(scan);

    }

    public static void spaceTravel () {

        Scanner     scan = new Scanner(System.in);
        String      choice;
        boolean     quit = false;

        System.out.println("Welcome");
        while (!quit) {
            choice = scan.nextLine().trim();
            if (choice.length() > 0) {

                switch (choice.charAt(0)) {
                    case 'q' :
                        quit = true;
                        break;

                    case 'h' :
                        System.out.println("usage :\nq: quit the program\nl: list the planets\n" +
                                "d : Choose your departure planet\nt: calculate arrival time\nh: print help");
                        break;

                    case 'l' :
                        listPlanetWithUA();
                        break;

                    case 'd' :
						departureSelect(scan);
                        break;

                    case 't' :
                        if (p1 != null && p2 != null) {
                            calculateArrivalTime(scan);
                            break;
                        }
                        System.out.println("Please select departure with 'd'");
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
