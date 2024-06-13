package com.core.models.dto;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor
public class ErrorDto {
    private String timestamp;
    private int status;
    private String error;
    private String path;
    private Object message;

}
