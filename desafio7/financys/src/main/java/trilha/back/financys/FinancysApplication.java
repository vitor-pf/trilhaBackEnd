package trilha.back.financys;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FinancysApplication {
	public static void main(String[] args) {
		SpringApplication.run(FinancysApplication.class, args);
	}
	/*
	@Autowired
	private CategoriaRepository categoriaRepository = null;
	@Autowired
	private LancamentoRepository lancamentoRepository = null;
	@Override
	public void run(String... args) throws Exception {
		CategoriaEntity categoriaEntity1 = new CategoriaEntity("Férias","Recebimento das férias");
		CategoriaEntity categoriaEntity2 = new CategoriaEntity("Salário","Recebimento de Salário");
		categoriaRepository.saveAll(Arrays.asList(categoriaEntity1, categoriaEntity2));
		//System.out.println(categoriaRepository.findAll());
		System.out.println("############################################################");
		LancamentoEntity lancamentoEntity1 = new LancamentoEntity("Férias", "Recebimento das férias",
				"REVENUE", 6000.0,"31/12/2021",true, categoriaEntity1);

		LancamentoEntity lancamentoEntity2 = new LancamentoEntity("Salário", "Recebimento de Salário",
				"REVENUE",5000.0,"20/01/2022",false, categoriaEntity2);
		LancamentoEntity lancamentoEntity3 = new LancamentoEntity("Salário", "Recebimento de Salário",
				"PRE_REV",555.0,"01/01/2022",false, categoriaEntity2);
		lancamentoRepository.saveAll(Arrays.asList(lancamentoEntity1, lancamentoEntity2, lancamentoEntity3));
		//System.out.println(lancamentoRepository.findAll());
	}


	 */


	@Bean
	public ModelMapper mapper(){
		return new ModelMapper();
	}

}
