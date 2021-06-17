package br.com.zup.vacinacao.model.dto.input;

import br.com.zup.vacinacao.model.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class UsuarioInputDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @Email(message = "Insira um e-mail válido")
    @NotBlank(message = "E-mail é obrigatório")
    private String email;

    @CPF(message = "Insira um CPF válido")
    @NotBlank(message = "CPF é obrigatório")
    private String cpf;

    @NotNull(message = "Data de Nascimento é obrigatório")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    public Usuario convertForEntity() {
        return new Usuario(nome, email, cpf, dataNascimento);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}
