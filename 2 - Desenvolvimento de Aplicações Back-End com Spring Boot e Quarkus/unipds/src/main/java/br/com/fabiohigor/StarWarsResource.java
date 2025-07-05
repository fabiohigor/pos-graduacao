package br.com.fabiohigor;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("starwars")
@Produces(MediaType.APPLICATION_JSON)
public class StarWarsResource {

    @RestClient
    StarWarsService starWarsService;

    @GET
    @Path("starships")
    public String getStarships() {
        return starWarsService.getStarships();
    }

    @GET
    @Path("films")
    public String getFilms() {
        return starWarsService.getFilms();
    }

    @GET
    @Path("people")
    public String getPeople() {
        return starWarsService.getPeople();
    }

    @GET
    @Path("planets")
    public String getPlanets() {
        return starWarsService.getPlanets();
    }

    @GET
    @Path("species")
    public String getSpecies() {
        return starWarsService.getSpecies();
    }

    @GET
    @Path("vehicles")
    public String getVehicles() {
        return starWarsService.getVehicles();
    }
}
