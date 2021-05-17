package br.com.ame.domains.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;
import org.springframework.format.annotation.DateTimeFormat;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document
public class Films {

     @NotBlank
      @Id
      private String title;
      private Integer episode_id;
      private String opening_crawl;

      private  String director;
      private String producer;
      private Set<String> planets;

}
