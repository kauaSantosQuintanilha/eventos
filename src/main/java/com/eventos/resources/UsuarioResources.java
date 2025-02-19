package com.eventos.resources;

import com.eventos.dto.UsuarioDTO;
import com.eventos.models.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioResources {

    @RequestMapping("/")
    public String getUsuario() {
        return "testar retorno dos usuarios";
    }

    @PostMapping("/")
    public ResponseEntity<UsuarioDTO>  criarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(usuarioDTO);
    }
}

