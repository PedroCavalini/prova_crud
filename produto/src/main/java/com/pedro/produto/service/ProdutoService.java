package com.pedro.produto.service;

import com.pedro.produto.model.Produto;
import com.pedro.produto.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto criarProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarId(Long id){
        return produtoRepository.findById(id);
    }

    public Produto atualizar(Produto produto, Long id) {
        Produto produtoAtualizado = buscarId(id).get();
        produto.setNome(produtoAtualizado.getNome());
        produto.setDescricao(produtoAtualizado.getDescricao());
        produto.setPreco(produtoAtualizado.getPreco());
        produto.setStatus(produtoAtualizado.getStatus());

        return produtoRepository.save(produtoAtualizado);
    }
    public void excluir(Long id){
        produtoRepository.deleteById(id);
    }
}
