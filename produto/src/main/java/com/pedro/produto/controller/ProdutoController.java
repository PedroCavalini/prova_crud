package com.pedro.produto.controller;

import com.pedro.produto.model.Produto;
import com.pedro.produto.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> criar(@RequestBody Produto produto){
        Produto produtoCriado = produtoService.criarProduto(produto);
        return ResponseEntity.ok(produtoCriado);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listar(){
        List<Produto> produtos = produtoService.listarProdutos();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Produto>> buscarId(@PathVariable Long id){
        Optional<Produto> produto = produtoService.buscarId(id);
        return ResponseEntity.ok(produto);
    }

    @PutMapping
    public  ResponseEntity<Produto> atualizar(@PathVariable Long id, @RequestBody Produto produtoAtualizado){
        Produto produto = produtoService.atualizar(produtoAtualizado, id);
        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        return ResponseEntity.ok().build();
    }
}
