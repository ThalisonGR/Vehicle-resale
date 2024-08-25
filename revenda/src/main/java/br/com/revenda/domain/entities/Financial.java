package br.com.revenda.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.yaml.snakeyaml.events.Event;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "tb_flow_financial")
public class Financial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    
}
