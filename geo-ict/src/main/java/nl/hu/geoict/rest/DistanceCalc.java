package nl.hu.geoict.rest;

public class DistanceCalc {

    public static void main(String[] args) {
        System.out.println("test1: " + distance(52.1748705, 4.9743146, 52.0618651, 8.4672746));
        System.out.println("test2: " + distance(-52.1748705, 4.9743146, 52.0618651, 8.4672746));
    }

    public static double distance(double lat1, double lon1, double lat2, double lon2) {
    double p = Math.PI / 180;
    double a = 0.5 - Math.cos((lat2 - lat1) * p) / 2 + Math.cos(lat1 * p) * Math.cos(lat2 * p) * (1 - Math.cos((lon2 - lon1) * p)) / 2;
    return 12742 * Math.asin(Math.sqrt(a));
    }
}
