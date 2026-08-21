package com.othavio.agendadortarefas.business;

import com.othavio.agendadortarefas.business.dto.TarefasDto;
import com.othavio.agendadortarefas.business.mapper.TarefaConverter;
import com.othavio.agendadortarefas.infrastructure.entity.TarefasEntity;
import com.othavio.agendadortarefas.infrastructure.enums.StatusNotificacao;
import com.othavio.agendadortarefas.infrastructure.repository.TarefasRepository;
import com.othavio.agendadortarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TarefaService {

    private final TarefasRepository tarefasRepository;
    private final TarefaConverter tarefaConverter;
    private final JwtUtil jwtUtil;

    public TarefasDto gravarTarefa(String token, TarefasDto dto){
        String email = jwtUtil.extrairEmaildoToken(token.substring(7));
        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNotificacao(StatusNotificacao.PENDENTE);
        dto.setEmailUsuario(email);
        TarefasEntity entity = tarefaConverter.paraTarefaEntity(dto);

        return tarefaConverter.paraTarefaDto(tarefasRepository.save(entity));
    }
}
