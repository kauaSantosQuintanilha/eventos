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
   private UsuarioServices usuarioServices;
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> buscarUsuarioPorId(@PathVariable Long id) {
        Usuario usuario = usuarioServices.buscarUsuarioPorId(id);
        return  ResponseEntity.ok(usuarioServices.converterUsuarioParaUsuarioDTO(usuario));
    }

    @PostMapping("/")
    public ResponseEntity<UsuarioDTO>  criarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
       usuarioDTO= usuarioServices.salvarUsuario(usuarioDTO);
        return ResponseEntity.ok(usuarioDTO);
    }
}

