package com.eventos.services;

import com.eventos.dto.CidadeDTO;
import com.eventos.dto.UsuarioDTO;
import com.eventos.models.Cidade;
import com.eventos.models.Usuario;
import com.eventos.repositories.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class CidadeService {
    @Autowired
    private CidadeRepository cidadeRepository;

    public CidadeDTO salvarCidade(CidadeDTO cidadeDTO) {
        Cidade cidade = converterCidadeDTOParaCidade(cidadeDTO);
        cidade = cidadeRepository.save(cidade);
        return converterCidadeParaCidadeDTO(cidade);

    }

    public CidadeDTO converterCidadeParaCidadeDTO(Cidade cidade) {
        CidadeDTO cidadeDTO = new CidadeDTO();
        cidadeDTO.setId(cidade.getId());
        cidadeDTO.setNome(cidade.getNome());
        cidadeDTO.setEstado(cidade.getEstado());
        return cidadeDTO;
    }

    public Cidade converterCidadeDTOParaCidade(CidadeDTO cidadeDTO) {
        Cidade cidade = new Cidade();
        cidade.setId(cidadeDTO.getId());
        cidade.setNome(cidadeDTO.getNome());
        cidade.setEstado(cidadeDTO.getEstado());
        return cidade;
    }

    public Cidade buscarCidadePorId(Long id) {
        return cidadeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Ciade não encontrado"));

    }

    public CidadeDTO atualizarcidade(CidadeDTO cidadeDTO) {
        if (isNull(cidadeDTO.getId())) {
            throw new IllegalArgumentException("id não informado");
        }
        Cidade cidade = cidadeRepository.findById(cidadeDTO.getId())
                .orElseThrow(() ->
                        new IllegalArgumentException("Usuário não encontrado"));
        cidade = converterCidadeDTOParaCidade(cidadeDTO);
        cidade = cidadeRepository.save(cidade);
        return converterCidadeParaCidadeDTO(cidade);
    }
    public  CidadeDTO buscarCiadePorNome (String nome) {
        return converterCidadeParaCidadeDTO(cidadeRepository.findByNome(nome).orElseThrow(() -> new IllegalArgumentException("Ciade não encontrado")));
    }

    public void deletarCidade(Long id) {
        cidadeRepository.deleteById(id);
    }

    public CidadeDTO buscarCidadePorNome(String nome) {
    return converterCidadeParaCidadeDTO(cidadeRepository.findByNome(nome).orElseThrow(() -> new IllegalArgumentException("Ciade não encontrado")));
    }

    public CidadeDTO atualizarCidade(CidadeDTO cidadeDTO) {
        return converterCidadeParaCidadeDTO(cidadeRepository.findById(cidadeDTO.getId())
                .orElseThrow(() ->
                        new IllegalArgumentException("Ciade não encontrado")));
    }
}

