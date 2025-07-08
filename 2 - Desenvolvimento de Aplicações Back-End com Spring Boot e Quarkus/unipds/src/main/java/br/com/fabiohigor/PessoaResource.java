package br.com.fabiohigor;

import io.micrometer.core.annotation.Counted;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("pessoa")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaResource {

    @GET
    @Counted(value = "counted.getPessoa")
    public List<Pessoa> getPessoa() {
     return Pessoa.listAll();
    }

    @POST
    @Transactional
    public Pessoa createPessoa(Pessoa pessoa) {
        pessoa.id = null;
        pessoa.persist();
        return pessoa;
    }

    @PUT
    @Transactional
    public Pessoa updatePessoa(Pessoa pessoa) {
        Pessoa existingPessoa = Pessoa.findById(pessoa.id);
        if (existingPessoa == null) {
            throw new NotFoundException("Pessoa not found with id: " + pessoa.id);
        }
        existingPessoa.nome = pessoa.nome;
        existingPessoa.anoNascimento = pessoa.anoNascimento;
        existingPessoa.persist();
        return existingPessoa;
    }

    @DELETE
    @Transactional
    public void deletePessoa(@QueryParam("id") Long id) {
        Pessoa pessoa = Pessoa.findById(id);
        if (pessoa == null) {
            throw new NotFoundException("Pessoa not found with id: " + id);
        }
        pessoa.delete();
    }

    @GET
    @Path("findByAnoNascimento")
    public List<Pessoa> findByAnoNascimento(@QueryParam("anoNascimento") int anoNascimento) {
        return Pessoa.findByAnoNascimento(anoNascimento);
    }
}
