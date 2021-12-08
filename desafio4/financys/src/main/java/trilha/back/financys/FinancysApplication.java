package trilha.back.financys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import trilha.back.financys.model.Categoria;
import trilha.back.financys.model.Lancamento;
import trilha.back.financys.repository.CategoriaRepository;
import trilha.back.financys.repository.LancamentoRepository;

import java.util.Arrays;

@SpringBootApplication
public class FinancysApplication implements CommandLineRunner {
	@Autowired
	private CategoriaRepository categoriaRepository = null;
	@Autowired
	private LancamentoRepository lancamentoRepository = null;

	public static void main(String[] args) {
		SpringApplication.run(FinancysApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria categoria1 = new Categoria("Férias","Recebimento das férias");
		Categoria categoria2 = new Categoria("Salário","Recebimento de Salário");
		categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));
		System.out.println(categoriaRepository.findAll());

		System.out.println("############################################################");

		Lancamento lancamento1 = new Lancamento("Férias", "Recebimento das férias",
				"revenue","6000,00","31/12/2021",true, categoria1);
		Lancamento lancamento2 = new Lancamento("Salário", "Recebimento de Salário",
				"revenue","5000,00","20/01/2022",false, categoria2);
		lancamentoRepository.saveAll(Arrays.asList(lancamento1,lancamento2));
		System.out.println(lancamentoRepository.findAll());
	}
}
