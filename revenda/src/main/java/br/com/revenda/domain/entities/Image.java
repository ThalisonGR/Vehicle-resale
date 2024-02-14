package br.com.revenda.domain.entities;

import br.com.revenda.domain.enums.ImagensExtesion;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.java.Log;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "tb_image")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column
    private  String name;

    @Column
    private Long size;

    @Column
    @Enumerated(EnumType.STRING)
    private ImagensExtesion extension;

    @Column
    @CreatedDate
    private LocalDateTime uploadDate;

    @Column
    private String tags;

    @Column
    private byte [] file;

}
