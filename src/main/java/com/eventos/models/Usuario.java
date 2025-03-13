package com.eventos.models;

import com.eventos.dto.UsuarioDTO;
import com.eventos.enums.Perfil;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(unique = true)
    private String email;
    private String senha;
    @Column(unique = true)
    private String cpf;
    @Column(name = "data_nascimento")
    private Date dataNascimento;

    @Enumerated(EnumType.STRING)
    private List<Perfil> perfis;

    @Column(name = "verificado")
    private Boolean  Verificado;

    public Usuario() {}
    public Usuario(String nome, String email, String senha, String cpf, Date dataNascimento, List<Perfil> perfis, Boolean isVerificado) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.perfis = perfis;
        this.Verificado = Verificado;
    }
    public  Usuario(UsuarioDTO usuarioDTO) {
        this.id = usuarioDTO.getId();
        this.nome = usuarioDTO.getNome();
        this.email = usuarioDTO.getEmail();
        this.senha = usuarioDTO.getSenha();
        this.cpf = usuarioDTO.getCpf();
        this.dataNascimento = usuarioDTO.getDataNascimento();
        this.perfis = usuarioDTO.getPerfis();
        this.Verificado = usuarioDTO.getVerificado();
    }

    public Long getId() {
        return id;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Perfil>getPerfis() {
        return perfis;
    }

    public void setPerfis(List<Perfil> perfis) {
        this.perfis = perfis;
    }

    public Boolean getVerificado() {
        return Verificado;
    }

    public void setVerificado(Boolean verificado) {
        Verificado = verificado;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
