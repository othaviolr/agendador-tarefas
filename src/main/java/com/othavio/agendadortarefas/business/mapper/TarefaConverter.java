package com.othavio.agendadortarefas.business.mapper;

import com.othavio.agendadortarefas.business.dto.TarefasDto;
import com.othavio.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefaConverter {

    TarefasEntity paraTarefaEntity(TarefasDto dto);

    TarefasDto paraTarefaDto(TarefasEntity entity);
}
