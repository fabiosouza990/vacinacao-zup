package br.com.zup.vacinacao.service;

import br.com.zup.vacinacao.model.Usuario;
import br.com.zup.vacinacao.repository.UsuarioRepository;
import br.com.zup.vacinacao.service.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Page<Usuario> findAll(Pageable pageable) {
        return this.usuarioRepository.findAll(pageable);
    }

    public void salvarUsuario(Usuario usuario) {
        this.usuarioRepository.save(usuario);
    }

    public Usuario findByEmail(String email) {
        Optional<Usuario> usuario = this.usuarioRepository.findByEmail(email);
        return usuario.orElseThrow(() -> new BadRequestException("Não foi possível encontrar o usuário pelo e-mail ou CPF"));
    }


}
