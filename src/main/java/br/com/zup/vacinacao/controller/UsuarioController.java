package br.com.zup.vacinacao.controller;

import br.com.zup.vacinacao.model.Usuario;
import br.com.zup.vacinacao.model.dto.input.UsuarioInputDTO;
import br.com.zup.vacinacao.model.dto.output.UsuarioOutputDTO;
import br.com.zup.vacinacao.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<Page<Usuario>> listAllPagination(Pageable pageable) {
        return ResponseEntity.ok(this.usuarioService.findAll(pageable));
    }

    @GetMapping("/pesquisar")
    public ResponseEntity<UsuarioOutputDTO> findByEmail(@RequestParam(defaultValue = "") String email) {
        Usuario usuario = this.usuarioService.findByEmail(email);
        return ResponseEntity.ok(new UsuarioOutputDTO(usuario));
    }

    @PostMapping
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<UsuarioOutputDTO> cadastrarUsuario(@Valid @RequestBody UsuarioInputDTO usuarioDTO,
                                                             UriComponentsBuilder uriBuilder) {

        Usuario usuario = usuarioDTO.convertForEntity();

        this.usuarioService.salvarUsuario(usuario);

        URI uri = uriBuilder.path("/api/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(uri).body(new UsuarioOutputDTO(usuario));
    }
}
