package br.com.zup.vacinacao.controller;

import br.com.zup.vacinacao.model.Usuario;
import br.com.zup.vacinacao.model.Vacinacao;
import br.com.zup.vacinacao.model.dto.input.VacinacaoInputDTO;
import br.com.zup.vacinacao.model.dto.output.VacinacaoOutputDTO;
import br.com.zup.vacinacao.service.UsuarioService;
import br.com.zup.vacinacao.service.VacinacaoService;
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
@RequestMapping("/api/vacinas")
public class VacinacaoController {

    @Autowired
    private VacinacaoService vacinacaoService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<Page<Vacinacao>> listAllPagination(Pageable pageable) {
        return ResponseEntity.ok(this.vacinacaoService.findAll(pageable));
    }

    @PostMapping
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<VacinacaoOutputDTO> cadastrarVacina
            (@Valid @RequestBody VacinacaoInputDTO vacinacaoInputDTO,
             UriComponentsBuilder uriBuilder) {

        Usuario usuario = this.usuarioService.findByEmail(vacinacaoInputDTO.getEmailUsuario());

        Vacinacao vacinacao = vacinacaoInputDTO.
                convertForEntityVacina(usuario);

        this.vacinacaoService.cadastrarVacina(vacinacao);

        URI uri = uriBuilder.path("/api/vacinas/{id}").
                buildAndExpand(vacinacao.getId()).toUri();

        return ResponseEntity.created(uri).body(new VacinacaoOutputDTO(vacinacao));

    }
}









