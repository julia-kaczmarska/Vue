package com.vue.bg.controller.mapper;

import com.vue.bg.controller.dto.SourceDto;
import com.vue.bg.model.Source;

public class SourceMapper {

    public static SourceDto mapToSourceDto(Source source) {
        return SourceDto.builder()
                .name(source.getName())
                .build();
    }
}
