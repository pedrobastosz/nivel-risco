/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nivelrisco.common;

/**
 *
 * @author pedro
 */
public class EntidadeNaoEncontradaException extends RuntimeException {

    private final String entidade;

    public EntidadeNaoEncontradaException(String entidade) {
        this(formataMensagem(entidade), null);
    }

    public EntidadeNaoEncontradaException(String entidade, Throwable cause) {
        super(formataMensagem(entidade), cause);
        this.entidade = entidade;
    }

    public String getEntidade() {
        return entidade;
    }
    
    private static String formataMensagem(String entidade) {
        return String.format("%s não encontrada", entidade);
    }

}
