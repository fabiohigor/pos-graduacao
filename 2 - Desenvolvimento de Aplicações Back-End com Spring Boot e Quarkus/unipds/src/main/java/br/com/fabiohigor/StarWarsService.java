package br.com.fabiohigor;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "https://swapi.info/api")
public interface StarWarsService {

    @GET
    @Path("starships")
    @Produces(MediaType.APPLICATION_JSON)
    String getStarships();

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