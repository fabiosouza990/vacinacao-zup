package br.com.zup.vacinacao.model.dto.input;

import br.com.zup.vacinacao.model.Usuario;
import br.com.zup.vacinacao.model.Vacinacao;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class VacinacaoInputDTO {

    @NotBlank(message = "Nome da Vacina é obrigatória")
    private String nomeVacina;

    @Email(message = "Insira um e-mail válido")
    @NotBlank(message = "E-mail é obrigatório")
    private String emailUsuario;

    @NotNull(message = "Data de Aplicação da Vacina é obrigatória")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAplicacao;

    public Vacinacao convertForEntityVacina(Usuario usuario) {
        return new Vacinacao(nomeVacina, dataAplicacao, usuario);
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public LocalDate getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(LocalDate dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }

}
