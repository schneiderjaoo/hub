package com.room.hub.service;

import com.room.hub.bean.Salas;
import com.room.hub.dao.SalasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class SalasService {

    @Autowired
    private SalasRepository salasRepository;

    public Salas criarSala(String nomeSala, String descricaoSala, double valorSala, Integer qtdeComporta, String cidade, String estado, String endereco, MultipartFile imagem) throws IOException {
        Salas sala = new Salas();
        sala.setNomeSala(nomeSala);
        sala.setDescricaoSala(descricaoSala);
        sala.setValorSala(valorSala);
        sala.setQtdeComporta(qtdeComporta);
        sala.setCidade(cidade);
        sala.setEstado(estado);
        sala.setEndereco(endereco);
        
        if (imagem != null && !imagem.isEmpty()) {
            sala.setImagem(imagem.getBytes()); // Converte MultipartFile para byte[]
        }
        
        sala.setEstrela(5); // Toda sala é criada com 5 estrelas por padrão
        return salasRepository.save(sala);
    }
}
