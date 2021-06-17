package br.com.zup.vacinacao.service;

import br.com.zup.vacinacao.model.Vacinacao;
import br.com.zup.vacinacao.repository.VacinacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VacinacaoService {

    @Autowired
    private VacinacaoRepository vacinacaoRepository;

    public void cadastrarVacina(Vacinacao vacinacao) {
        this.vacinacaoRepository.save(vacinacao);
    }

    public Page findAll(Pageable pageable) {
        return this.vacinacaoRepository.findAll(pageable);
    }
}
