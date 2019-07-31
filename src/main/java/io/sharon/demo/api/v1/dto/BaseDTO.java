package io.sharon.demo.api.v1.dto;

import lombok.*;

import java.io.Serializable;


@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BaseDTO implements Serializable {

 public Long id;
}
