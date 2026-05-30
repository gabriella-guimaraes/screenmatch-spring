package br.com.screenmatch.Desafios.tabelaFipe.service;

import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.type.CollectionType;

import java.util.List;

public class ConverteDados implements IConverteDados{
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T obterdados(String json, Class<T> classe) {
        return objectMapper.readValue(json, classe);
    }

    @Override
    public <T> List<T> obterLista(String json, Class<T> classe) {
        CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(List.class, classe);
        return objectMapper.readValue(json, collectionType);
    }
}
