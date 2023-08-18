package br.com.bernhoeft.gerenciadorprodutos.exception;

public class ProdutoNaoEncontradaException extends EntidadeNaoEncontradaException{

    private static final long serialVersionUID = 1L;

    public ProdutoNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

    public ProdutoNaoEncontradaException(Long categoriaId) {
        this(String.format("Não existe um cadastro de produto com código %d", categoriaId));
    }
}
