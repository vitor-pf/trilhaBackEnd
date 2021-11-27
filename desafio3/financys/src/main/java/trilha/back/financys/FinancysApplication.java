package trilha.back.financys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinancysApplication {
	public static void main(String[] args) {
		SpringApplication.run(FinancysApplication.class,args);

		Categoria categoria1 = new Categoria(1L,"Férias","Recebimento das férias");
		System.out.println(categoria1.toString());
		Categoria categoria2 = new Categoria(4L,"Salário","Recebimento de Salário");
		System.out.println(categoria2.toString());

		System.out.println("#############################################");

		Lancamento lancamento1 = new Lancamento(2L, "13º", "Adiantamento 13º", "revenue","5000,00","31/12/2021",false,0L);
		System.out.println(lancamento1.toString());
		Lancamento lancamento2 = new Lancamento(3L, "Salário", "Adiantamento Quinzenal", "revenue","4405,49","15/09/2021",true,categoria1.getId());
		System.out.println(lancamento2.toString());
	}
}
