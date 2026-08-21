package com.othavio.agendadortarefas.business.mapper;

import com.othavio.agendadortarefas.business.dto.TarefasDto;
import com.othavio.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TarefaConverter {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "dataEvento", target = "dataEvento")
    @Mapping(source = "dataCriacao", target = "dataCriacao")

    TarefasEntity paraTarefaEntity(TarefasDto dto);

    TarefasDto paraTarefaDto(TarefasEntity entity);

    List<TarefasEntity> paraListaTarefas(List<TarefasDto> dtos);
    List<TarefasDto> paraListaTarefasDto(List<TarefasEntity> entities);
}
