package br.com.alura.screenmatch.Excecao;

public class ErroDeConversaoException extends RuntimeException{
    private String mensagem;

    public ErroDeConversaoException(String mensagem){
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
