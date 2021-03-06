package nl.hu.geoict.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/distance")
public class GeoService {
    
    @GET
    @Path("/{lat1}/{long1}/{lat2}/{long2}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response something(@PathParam("lat1") double lat1, @PathParam("long1") double long1, @PathParam("lat2") double lat2, @PathParam("long2") double long2) {
    	DistanceCalc dc = new DistanceCalc();
    	dc.calcDistance(lat1, long1, lat2, long2);
        return Response.status(200).entity(dc).build();
    }
}