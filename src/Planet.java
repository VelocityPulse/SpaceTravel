/**
 * Created by cchameyr on 2/15/17.
 */
public enum Planet {
    MERCURY("Mercure", 0.387) , VENUS("Venus", 0.722) , EARTH("Terre", 1) , MARS("Mars", 1.52) ,
    JUPITER("Jupiter", 5.20) , SATURN("Saturne", 9.58) , URANUS("Uranus", 19.2) , NEPTUNE("Neptune", 30.1);

    private String  namefr;
    private double  distance_sun_in_astro_unit;

    public double   getDistance_sun_in_astro_unit() {
        return (distance_sun_in_astro_unit);
    }

    public String ToString() {
        return (this.namefr);
    }

    public String getNamefr() {
        return (this.namefr);
    }

    private Planet(String namefr, double distance_sun_in_astro_unit) {
        this.namefr = namefr;
        this.distance_sun_in_astro_unit = distance_sun_in_astro_unit;
    }

}
