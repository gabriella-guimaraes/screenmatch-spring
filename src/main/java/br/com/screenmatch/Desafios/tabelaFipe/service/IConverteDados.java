package br.com.screenmatch.Desafios.tabelaFipe.service;

public interface IConverteDados {
    <T> T obterdados(String json, Class<T> classe);
}
