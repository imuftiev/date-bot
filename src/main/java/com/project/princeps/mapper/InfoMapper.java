package com.project.princeps.mapper;

import com.project.princeps.dto.InfoDTO;
import com.project.princeps.entity.Info;
import org.springframework.stereotype.Component;

@Component
public class InfoMapper {

    public InfoDTO toDto(Info info) {
        return InfoDTO.builder()
                .id(info.getId())
                .username(info.getUsername())
                .build();
    }

    public Info toEntity(InfoDTO infoDTO) {
        return Info.builder()
                .id(infoDTO.getId())
                .username(infoDTO.getUsername())
                .build();
    }

}
