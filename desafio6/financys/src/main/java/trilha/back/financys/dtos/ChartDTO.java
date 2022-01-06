package trilha.back.financys.dtos;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChartDTO {
    private String name;
    private Double total;


}
