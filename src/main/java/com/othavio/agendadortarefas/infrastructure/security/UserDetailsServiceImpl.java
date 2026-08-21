package com.othavio.agendadortarefas.infrastructure.security;

import com.othavio.agendadortarefas.business.dto.UsuarioDto;
import com.othavio.agendadortarefas.infrastructure.client.UsuarioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl  {

    @Autowired
    private UsuarioClient client;

    public UserDetails carregaDadosUsuario(String email, String token){
        UsuarioDto usuarioDto = client.buscarUsuarioPorEmail(email, token);

        return User.withUsername(usuarioDto.getEmail()).password(usuarioDto.getSenha()).build();
    }
}
