package org.example;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    private static Scanner s = new Scanner(System.in);
    private static ProdutoDAO dao = new ProdutoMemoryDAO();

    public static void main(String[] args) {
        int opcao = 0;
        while (opcao != 6) {
            System.out.println("\nCadastro de produtos");
            System.out.println("Digite a opção desejada:");
            System.out.println("1 - Inserir");
            System.out.println("2 - Alterar");
            System.out.println("3 - Pesquisar");
            System.out.println("4 - Excluir");
            System.out.println("5 - Listar");
            System.out.println("6 - Sair");
            opcao = s.nextInt();
            switch (opcao) {
                case 1 -> insere();
                case 2 -> altera();
                case 3 -> pesquisa();
                case 4 -> exclui();
                case 5 -> lista();
                case 6 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida");
            }
        }
        s.close();
    }

    private static void insere() {
        System.out.println("Digite o id:");
        Integer id = s.nextInt();

        System.out.println("Digite o produto:");
        String produto = s.next();

        System.out.println("Digite o preco:");
        String preco = s.next();

        Produto p = new Produto(id, produto, new BigDecimal(preco));
        dao.insere(p);
    }

    private static void lista() {
        for (Produto p : dao.lista()) {
            System.out.println("ID: " + p.getId() + ", Produto: " + p.getProduto() + ", Preço: " + p.getPreco());
        }
    }

    private static void pesquisa() {
        System.out.println("Digite o id do produto:");
        Integer id = s.nextInt();
        Produto p = dao.pesquisa(id);
        if (p != null) {
            System.out.println("ID: " + p.getId() + ", Produto: " + p.getProduto() + ", Preço: " + p.getPreco());
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private static void altera() {
        System.out.println("Digite o id do produto a alterar:");
        Integer id = s.nextInt();
        Produto p = dao.pesquisa(id);
        if (p != null) {
            System.out.println("Digite o novo nome do produto:");
            String novoProduto = s.next();

            System.out.println("Digite o novo preço:");
            String novoPreco = s.next();

            Produto atualizado = new Produto(id, novoProduto, new BigDecimal(novoPreco));
            dao.altera(atualizado);
            System.out.println("Produto alterado com sucesso.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private static void exclui() {
        System.out.println("Digite o id do produto a excluir:");
        Integer id = s.nextInt();
        Produto p = dao.pesquisa(id);
        if (p != null) {
            dao.exclui(id);
            System.out.println("Produto excluído com sucesso.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }
}
