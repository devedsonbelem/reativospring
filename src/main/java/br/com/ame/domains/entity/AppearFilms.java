package br.com.ame.domains.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document
public class AppearFilms {
    @NotBlank
    @Id
    private String name;
    private Integer count;
    private List<Films> films;
}
