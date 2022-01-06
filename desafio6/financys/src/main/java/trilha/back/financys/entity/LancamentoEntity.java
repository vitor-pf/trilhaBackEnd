package trilha.back.financys.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
@Getter
@Setter
@Entity
@Table(name = "lancamento")
public class LancamentoEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "O nome é obrigatório!")
    @Size(min = 3,max = 45,message = "O nome deve conter entre 3 a 45 caracteres!")
    private String name;

    @Column(name = "description")
    @NotBlank(message = "A descrição é obrigatória!")
    @Size(min = 3,max = 150,message = "A descrição deve conter entre 3 a 150 caracteres!")
    private String description;

    @Column(name = "type")
    @NotBlank(message = "O tipo é obrigatório!")
    @Size(min = 3,max = 10,message = "O tipo deve conter entre 3 a 10 caracteres!")
    private String type;

    @Column(name = "amount")
    @Min(value = 0L, message = "O valor não pode ser nulo e deve ser maior 0!")
    private Double amount;

    @Column(name = "date")
    @NotBlank(message = "A data é obrigatória!")
    private String date;

    @Column(name = "paid")
    @NotNull(message = "O pagamento é obrigatório!")
    private boolean paid;

    @ManyToOne
    @JoinColumn(name = "category", referencedColumnName = "id")
    private CategoriaEntity category;
}