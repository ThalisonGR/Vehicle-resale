package br.com.revenda.domain.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_code", nullable = false, unique = true)
    @NotBlank(message = "Código do colaborador é obrigatório")
    private String employeeCode;

    @Column(nullable = false)
    @NotBlank(message = "Nome é obrigatório")
    private String name;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "CPF é obrigatório")
    @Size(min = 11, max = 11, message = "O CPF deve ter 11 dígitos")
    private String cpf;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "position", nullable = false)
    @NotBlank(message = "Cargo é obrigatório")
    private String position;

    @Column(name = "hire_date", nullable = false)
    private LocalDate hireDate;

    @Column(nullable = false)
    private Boolean active;

    @Email(message = "Email deve ser válido")
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "Telefone é obrigatório")
    private String phone;

    @Column(name = "address")
    @NotBlank(message = "Endereço é obrigatório")
    private String address;

    @NotBlank(message = "Número casa é obrigatório")
    @Column(name = "number")
    private String number;

    @Column(name = "complement")
    private String complement;

    @Column(name = "city", nullable = false)
    @NotBlank(message = "Cidade é obrigatória")
    private String city;

    @Column(name = "state", nullable = false)
    @NotBlank(message = "Estado é obrigatório")
    private String state;

    @Column(name = "postal_code", nullable = false)
    @NotBlank(message = "CEP é obrigatório")
    private String postalCode;

    @Column(name = "salary", precision = 10, scale = 2)
    private BigDecimal salary;

    @ManyToOne
    @JoinColumn(name = "employee_type_id", nullable = false)
    private EmployeeType employeeType;

    @Column(name = "created_at", updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
