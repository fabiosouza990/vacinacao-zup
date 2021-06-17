package br.com.zup.vacinacao.model.dto.output;

import br.com.zup.vacinacao.model.Vacinacao;

import java.time.LocalDate;

public class VacinacaoOutputDTO {


    private String nomeVacina;
    private LocalDate dataAplicacao;
    private String cpfUsuario;

    public VacinacaoOutputDTO(Vacinacao vacinacao) {
        this.nomeVacina = vacinacao.getNomeVacina();
        this.dataAplicacao = vacinacao.getDataAplicacao();
        this.cpfUsuario = vacinacao.getUsuario().getCpf();
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public LocalDate getDataAplicacao() {
        return dataAplicacao;
    }

    public String getCpfUsuario() { return cpfUsuario; }
}
