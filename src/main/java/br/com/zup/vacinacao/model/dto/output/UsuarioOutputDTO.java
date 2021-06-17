package br.com.zup.vacinacao.model.dto.output;

import br.com.zup.vacinacao.model.Usuario;

import java.time.LocalDate;


public class UsuarioOutputDTO {

    private String nome;
    private String email;
    private String cpf;
    private LocalDate dataNascimento;

    public UsuarioOutputDTO(Usuario usuario) {
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.cpf = usuario.getCpf();
        this.dataNascimento = usuario.getDataNascimento();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
}
