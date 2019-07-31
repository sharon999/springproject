package io.sharon.demo.api.v1.dto;

import lombok.*;

import java.io.Serializable;


@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UIMessage implements Serializable {

    private String field;

    private String code;

    private String message;
}
