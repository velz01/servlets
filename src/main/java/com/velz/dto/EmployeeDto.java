package com.velz.dto;

import lombok.*;

import java.util.Objects;

@AllArgsConstructor
@Value //@Getter  @EqualsAndHashCode @ToString private final
@Builder
public class EmployeeDto {

    Integer id;
    String name;

}
