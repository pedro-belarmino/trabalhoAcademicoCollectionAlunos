package org.example;

import java.util.Collection;

public interface ProdutoDAO {
    void insere(Produto produto);
    Collection<Produto> lista();
    Produto pesquisa(Integer id);
    void altera(Produto produto);
    void exclui(Integer id);
}
