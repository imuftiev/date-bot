package com.project.princeps.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InfoDTO {

    @NotNull
    private Long id;
    private String username;

}
