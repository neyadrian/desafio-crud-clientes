import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "tb_client") // Boa prática para distinguir a tabela na base de dados
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;[cite: 2]

    @NotBlank(message = "O nome não pode ser vazio")[cite: 3]
    private String name;[cite: 2]

    private String cpf;[cite: 2]

    private Double income;[cite: 2]

    @PastOrPresent(message = "A data de nascimento não pode ser no futuro")[cite: 3]
    @Column(name = "birth_date")
    private LocalDate birthDate;[cite: 2]

    private Integer children;[cite: 2]
}