package trilha.back.financys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinancysApplication {
	public static void main(String[] args) {
		Categoria categoria = new Categoria(0L,"Novo","Sem descrição");
		System.out.println(categoria.toString());

		Categoria categoria2 = new Categoria();
		categoria2.setId(4L);
		categoria2.setName("Salário");
		categoria2.setDescription("Recebimento de Salário");
		System.out.println(categoria2.toString());

		System.out.println("#############################################");

		Lancamento lancamento = new Lancamento(00L, "Novo", "Sem desc", "revenue","5000,00","01/01/2021",false,0L);
		System.out.println(lancamento.toString());

		Lancamento lancamento2 = new Lancamento();
		lancamento2.setId(3L);
		lancamento2.setName("Salário");
		lancamento2.setDescription("Adiantamento Quinzenal");
		lancamento2.setType("revenue");
		lancamento2.setAmount("4405,49");
		lancamento2.setDate("15/09/2021");
		lancamento2.setPaid(true);
		lancamento2.setCategoryId(categoria.getId());
		System.out.println(lancamento2.toString());
	}
}
