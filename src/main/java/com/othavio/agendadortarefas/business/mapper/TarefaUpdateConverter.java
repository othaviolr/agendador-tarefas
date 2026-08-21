package com.othavio.agendadortarefas.business.mapper;

import com.othavio.agendadortarefas.business.dto.TarefasDto;
import com.othavio.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TarefaUpdateConverter {

    void updateTarefas(TarefasDto dto, @MappingTarget TarefasEntity entity);
}
