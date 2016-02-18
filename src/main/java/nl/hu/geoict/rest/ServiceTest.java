package nl.hu.geoict.rest;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class ServiceTest {

	private Double lat1, lon1, lat2, lon2;
	private Double expected;
	/* 
	 * Deze delta geeft de precisie bij assertEquals. Floating point fouten 
	 * kunnen hiermee voorkomen worden.
	 */
	private static Double DELTA = 5.0;

	//parameters pass via this constructor
	public ServiceTest(Double lat1, Double lon1, Double lat2, Double lon2, Double expected) {
		this.lat1 = lat1;
		this.lon1 = lon1;
		this.lat2 = lat2;
		this.lon2 = lon2;
		this.expected = expected;
	}

	//Declares parameters here
	@Parameters(name = "{index}: getDistance({0},{1},{2},{3})={4}")
	public static Iterable<Object[]> data1() {
		return Arrays.asList(new Object[][] { 
			{ 51.50344938606154, -0.1229561158615433, 52.37987006843646, 4.842485644105237, 354.0}, 
			{ 37.7927179966777, -122.4554170705756, 55.7535529731822, 37.64350870442227, 9444.0},
			{ 10.0, 178.0, 10.0, -178.0, 438.0 }, 
			{ 90.0, 0.0, -90.0, -0.0, 20020.0 }, 
			{ 89.9, 180.0, 89.9, 0.0, 22.24 }, 
			{ 89.9, 170.0, 89.9, -170.0, 3.862 } 
		});
	}

    @Test
    public void test_add() {
    	DistanceCalc dc = new DistanceCalc();
    	System.out.println("lat/lon: "+lat1 + " " + lon1 + " " + lat2 + " " + lon2 + " expected: "+expected);
    	dc.calcDistance(lat1, lon1, lat2, lon2);
    	System.out.println("distance: " + dc.distance);
        assertEquals(expected, dc.distance, DELTA);

    }
}
