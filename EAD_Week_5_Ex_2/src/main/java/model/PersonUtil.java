package model;

import java.util.ArrayList;
import java.util.List;

public class PersonUtil {

	public List<Person> getPessoas(String pessoas) {
		List<Person> lista = new ArrayList<>();
		if (pessoas.length() > 0) {
			String[] linhas = pessoas.split("\n");
			for (String linha : linhas) {
				System.out.println("entrou no for");
				String[] dados = linha.split("\\s*;\\s*");
				if (dados.length == 3) {
					String nome = dados[0];
					String cpf = dados[1];
					String email = dados[2];
					Person p = new Person(nome, cpf, email);
					lista.add(p);
				}
			}
		}
		return lista;
	}

	public static <T> List<T> castList(List input, Class<T> value) {

		List<T> output = new ArrayList<>();

		if(input == null)
			return output;
		for(Object val : input.toArray()) {
			if((val == null) || value.isAssignableFrom(val.getClass())) {
				T t = value.cast(val);
				output.add(t);
			} else {
				throw new AssertionError(
						"Cannot cast to List"
				);
			}
		}
		return output;
	}

}
