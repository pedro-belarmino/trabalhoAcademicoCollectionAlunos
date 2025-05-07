package org.example;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Produto implements Comparable {

    @EqualsAndHashCode.Include
    private Integer id;

    private String produto;

    private BigDecimal preco;

    @Override
    public int compareTo(Object o) {
        if (o instanceof Produto) {
            Produto outroProduto = (Produto) o;
            return id.compareTo(outroProduto.id);
        }
        throw new IllegalStateException("o nao e Produto");
    }
}
