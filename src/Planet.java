/**
 * Created by cchameyr on 2/15/17.
 */
public enum Planet {
    MERCURY("Mercure", 0.387) , VENUS("Venus", 0.722) , EARTH("Terre", 1) , MARS("Mars", 1.52) ,
    JUPITER("Jupiter", 5.20) , SATURN("Saturne", 9.58) , URANUS("Uranus", 19.2) , NEPTUNE("Neptune", 30.1);

    private String  namefr;
    private double  distance_sun_in_astro_unit;
    public static final double UA_IN_KM = 149597871.0;
    public static final double LIGHT_SPEED_IN_KM_PER_S = 299792.458;


    public double   getDistance_sun_in_astro_unit() {
        return (distance_sun_in_astro_unit);
    }

    public String ToString() {
        return (this.namefr);
    }

    public String getNamefr() {
        return (this.namefr);
    }

    public double distanceInUATo(Planet otherPlanet) {
        double     result;

        result = this.distance_sun_in_astro_unit - otherPlanet.getDistance_sun_in_astro_unit();
        return (result < 0 ? -result : result);
    }

    public double distanceInKMTo(Planet otherPlanet) {
        return (distanceInUATo(otherPlanet) * UA_IN_KM);
    }

    public double travelTimeInSTO(Planet otherPlanet) {
        return (distanceInKMTo(otherPlanet) / LIGHT_SPEED_IN_KM_PER_S);
    }

    public double travelTimeInSTo(Planet otherPlanet, double speedInKmPerS) {
        return (distanceInKMTo(otherPlanet) / speedInKmPerS);
    }

    // constructor
    private Planet(String namefr, double distance_sun_in_astro_unit) {
        this.namefr = namefr;
        this.distance_sun_in_astro_unit = distance_sun_in_astro_unit;
    }
}
