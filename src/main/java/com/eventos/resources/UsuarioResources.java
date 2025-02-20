package com.eventos.resources;

import com.eventos.dto.UsuarioDTO;
import com.eventos.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioResources {

   @Autowired
   private UsuarioServices usuarioServices;
    @RequestMapping("/")
    public String getUsuario() {
        return "testar retorno dos usuarios";
    }

    @PostMapping("/")
    public ResponseEntity<UsuarioDTO>  criarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
       usuarioDTO= usuarioServices.salvarUsuario(usuarioDTO);
        return ResponseEntity.ok(usuarioDTO);
    }
}

