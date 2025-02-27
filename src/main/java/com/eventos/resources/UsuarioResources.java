package com.eventos.resources;

import com.eventos.dto.UsuarioDTO;
import com.eventos.models.Usuario;
import com.eventos.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioResources {

    @Autowired
    private UsuarioServices UsuarioServices;

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> buscarUsuarioPorId(@PathVariable Long id) {
        Usuario usuario = UsuarioServices.buscarUsuarioPorId(id);
        return ResponseEntity.ok(UsuarioServices.converterUsuarioParaUsuarioDTO(usuario));
    }

    @GetMapping("/buscar")
    public ResponseEntity<UsuarioDTO> buscarUsuarioPorEmail(@RequestParam String email) {
        Usuario usuario = UsuarioServices.buscarUsuarioPorEmail(email);
        return ResponseEntity.ok(UsuarioServices.converterUsuarioParaUsuarioDTO(usuario));
    }

    @PostMapping("/")
    public ResponseEntity<UsuarioDTO> criarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        usuarioDTO = UsuarioServices.salvarUsuario(usuarioDTO);
        return ResponseEntity.ok(usuarioDTO);
    }

    @PutMapping()
    public ResponseEntity<UsuarioDTO> atualizarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        usuarioDTO = UsuarioServices.salvarUsuario(usuarioDTO);
        return ResponseEntity.ok(usuarioDTO);
    }

    @DeleteMapping()
    public ResponseEntity<Void> deletarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        UsuarioServices.deletarUsuario(usuarioDTO.getId());
        return ResponseEntity.noContent().build();
    }

}