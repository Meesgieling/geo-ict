package nl.hu.geoict.rest;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class DistanceCalc {
	public double distance;

	@XmlAttribute
	public String unit = "km";
	public double lat1;
	public double lon1;
	public double lat2;
	public double lon2;

	public void calcDistance(double lat1, double lon1, double lat2, double lon2) {
		this.lat1 = lat1;
		this.lon1 = lon1;
		this.lat2 = lat2;
		this.lon2 = lon2;
		double p = Math.PI / 180;
		double a = 0.5 - Math.cos((lat2 - lat1) * p) / 2 + Math.cos(lat1 * p)
				* Math.cos(lat2 * p) * (1 - Math.cos((lon2 - lon1) * p)) / 2;
		distance = 12742 * Math.asin(Math.sqrt(a));
	}
}
