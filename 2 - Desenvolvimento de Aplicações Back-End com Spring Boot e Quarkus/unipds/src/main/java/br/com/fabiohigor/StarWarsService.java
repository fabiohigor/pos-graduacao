package br.com.fabiohigor;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "https://swapi.info/api")
public interface StarWarsService {


    public static final String MSG_ERROR = "{\"error\": \"Service is currently unavailable. Please try again later.\"}";

    @GET
    @Path("starships")
    @Produces(MediaType.APPLICATION_JSON)
    @Timeout(value = 3000L)
    @Fallback(fallbackMethod = "getStarshipsFallback")
    @CircuitBreaker(requestVolumeThreshold = 5, failureRatio = 0.5, delay = 1000L, successThreshold = 5)
    String getStarships();

    default String getStarshipsFallback() {
        return MSG_ERROR;
    }

    @GET
    @Path("films")
    @Produces(MediaType.APPLICATION_JSON)
    String getFilms();

    @GET
    @Path("people")
    @Produces(MediaType.APPLICATION_JSON)
    String getPeople();

    @GET
    @Path("planets")
    @Produces(MediaType.APPLICATION_JSON)
    String getPlanets();

    @GET
    @Path("species")
    @Produces(MediaType.APPLICATION_JSON)
    String getSpecies();

    @GET
    @Path("vehicles")
    @Produces(MediaType.APPLICATION_JSON)
    String getVehicles();
}