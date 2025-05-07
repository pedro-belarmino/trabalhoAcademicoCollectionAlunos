package org.example;

import java.util.*;

public class ProdutoMemoryDAO implements ProdutoDAO {
    private Collection<Produto> produtos = new TreeSet<>();

    @Override
    public void insere(Produto produto) {
        produtos.add(produto);
    }

    @Override
    public Collection<Produto> lista() {
        return produtos;
    }

    @Override
    public Produto pesquisa(Integer id) {
        for (Produto p : produtos) {
            if (p.getId().equals(id)) return p;
        }
        return null;
    }

    @Override
    public void altera(Produto produto) {
        exclui(produto.getId());
        insere(produto);
    }

    @Override
    public void exclui(Integer id) {
        produtos.removeIf(p -> p.getId().equals(id));
    }
}
