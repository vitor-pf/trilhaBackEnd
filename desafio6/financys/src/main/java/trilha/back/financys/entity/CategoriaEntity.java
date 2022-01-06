package trilha.back.financys.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "categoria")
public class CategoriaEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nameCategoria")
    @NotBlank(message = "O nome é obrigatório!")
    @Size(min = 3,max = 15,message = "O nome deve conter entre 3 a 15 caracteres!")
    private String nameCategoria;

    @Column(name = "descriptionCategoria")
    @NotBlank(message = "A descrição é obrigatório!")
    @Size(min = 15,max = 50,message = "A descrição deve conter entre 15 a 50 caracteres!")
    private String descriptionCategoria;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<LancamentoEntity> lancamentoEntity;

}