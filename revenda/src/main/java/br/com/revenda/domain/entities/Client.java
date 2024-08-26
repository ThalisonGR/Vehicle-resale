package br.com.revenda.domain.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "tb_client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;
    @Column(nullable = false)
    private Boolean ativo;

    @Column(name = "codigo_cliente", nullable = false, unique = true)
    @NotBlank(message = "Código do cliente é obrigatório")
    private String codigoCliente;

    @Column(nullable = false)
    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @Column(nullable = false)
    @NotBlank(message = "Obrigatório")
    private String cpfCpj;
    private LocalDate dataNascimento;
    @Column(name = "rg_ie")
    private String rgIe;
    @Column(length = 1)
    private String sexo;

    @Column(nullable = false)
    @NotBlank(message = "Telefone é obrigatório")
    private String telefone;

    @Email(message = "Email deve ser válido")
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "Endereço é obrigatório")
    private String endereco;

    @Column(nullable = false)
    @NotBlank(message = "Número é obrigatório")
    private String numero;

    private String complemento;

    @Column(nullable = false)
    @NotBlank(message = "Bairro é obrigatório")
    private String bairro;

    @Column(nullable = false)
    @NotBlank(message = "Cidade é obrigatório")
    private String cidade;

    @Column(nullable = false)
    @NotBlank(message = "Estado é obrigatório")
    private String estado;

    @Column(nullable = false)
    @NotBlank(message = "CEP é obrigatório")
    private String cep;

    @Column(name = "limite_credito", precision = 10, scale = 2)
    private BigDecimal limiteCredito;

    @Column(name = "limite_credito", precision = 10, scale = 2)
    private BigDecimal saldoDevedor;

    @Column(name = "forma_pagamento_preferida")
    private String formaPagamentoPreferida;

    @Column(nullable = false)
    @NotBlank(message = "Endereço é obrigatório")
    private String status;
    private String tipoCliente;
    private String observacoes;
    private String responsavelCadastro;

    @Column(name = "ultima_atualizacao", updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime ultimaAtualizacao;

    @Column(name = "data_cadastro", updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataCadastro;

    @PrePersist
    protected void onCreate() {
        this.dataCadastro = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.ultimaAtualizacao = LocalDateTime.now();
    }
}
