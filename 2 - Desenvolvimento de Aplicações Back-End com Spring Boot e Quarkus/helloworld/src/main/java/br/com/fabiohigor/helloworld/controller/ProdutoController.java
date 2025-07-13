package br.com.fabiohigor.helloworld.controller;

import br.com.fabiohigor.helloworld.dto.ProdutoDTO;
import br.com.fabiohigor.helloworld.mapper.ProdutoMapper;
import br.com.fabiohigor.helloworld.model.Produto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
public class ProdutoController {

    private ArrayList<Produto> produtos;

    public ProdutoController() {
        this.produtos = new ArrayList<>() {{
            add(new Produto(1, "Produto 1", 100.00));
            add(new Produto(2, "Produto 2", 200.00));
            add(new Produto(3, "Produto 3", 300.00));
            add(new Produto(4, "Produto 4", 400.00));
        }};
    }

    @GetMapping("/produtos")
    public ResponseEntity<List<Produto>> produtos() {
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/produtos/{id}")
    public ResponseEntity<Produto> produto(@PathVariable int id) {
        Produto p = produtos.stream()
                .filter(produto -> produto.getId() == id)
                .findFirst()
                .orElse(null);

        if (p != null) {
            return ResponseEntity.ok(p);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/produtos/sort")
    public ResponseEntity<List<Produto>> produtosSort(@RequestParam(name = "order", required = false) String order) {
        List<Produto> produtosOrdenados = new ArrayList<>(produtos);
        if (order == null) {
            return ResponseEntity.ok(produtosOrdenados);
        } else if (order.equalsIgnoreCase("desc")) {
            produtosOrdenados.sort(Comparator.comparing(Produto::getPreco).reversed());
            return ResponseEntity.ok(produtosOrdenados);
        } else if (order.equalsIgnoreCase("asc")) {
            produtosOrdenados.sort(Comparator.comparing(Produto::getPreco));
            return ResponseEntity.ok(produtosOrdenados);
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/produto")
    public ResponseEntity<Produto> createProduto(@RequestBody @Valid ProdutoDTO produtoDTO) {
        Produto produto = ProdutoMapper.INSTANCE.toEntity(produtoDTO);

        int novoId = produtos.stream()
                .mapToInt(Produto::getId)
                .max()
                .orElse(0) + 1;
        produto.setId(novoId);
        this.produtos.add(produto);

        return ResponseEntity.created(URI.create("/produto/" + novoId)).body(produto);
    }

    @PutMapping("/produto/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable int id,@RequestBody @Valid ProdutoDTO produtoDTO) {
        Produto produto = ProdutoMapper.INSTANCE.toEntity(produtoDTO);

        Produto produtoExistente = produtos.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);

        if (produtoExistente != null) {
            produtoExistente.setNome(produto.getNome());
            produtoExistente.setPreco(produto.getPreco());
            return ResponseEntity.ok(produto);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/produto/{id}")
    public ResponseEntity<String> deleteProduto(@PathVariable int id) {
        boolean removed = produtos.removeIf(produto -> produto.getId() == id);// Remove o produto com o ID especificado

        return removed
                ? ResponseEntity.ok("Produto removido com sucesso.")
                : ResponseEntity.notFound().build(); // Retorna 404 se o produto não for encontrado
    }


}

