package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Funcionario;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Funcionario> list = new ArrayList<>();
		
		System.out.print("Quantos funcionários serão registrados? ");
		int n = sc.nextInt();
		
		
		for (int i=0; i<n; i++) {
			
			System.out.println();
			System.out.println("Funcionário #" + (i +1) + ": ");
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			System.out.print("Nome: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salário: ");
			Double salary = sc.nextDouble();
			
			Funcionario fun = new Funcionario(id, name, salary);
			
			list.add(fun);
		}
		
		System.out.println();
		System.out.println("Entre com o id do funcionário que irá receber um incremento salarial: ");
		int idsalary = sc.nextInt();
		
		Integer pos = position(list, idsalary);
		
		if (pos == null) {
			System.out.println("Esse id não foi encontrado.");
		} else {
			System.out.println("Qual será a porcentagem de aumento salarial? ");
			double percent = sc.nextDouble();
			list.get(pos).increaseSalary(percent);
		}
		
		System.out.println();
		System.out.println("Lista de Funcionários: ");
		
		for (Funcionario fun : list) {
			System.out.println(fun);
		}
		
		sc.close();
	}
	
	public static Integer position(List<Funcionario> list, int id) {
		for (int i=0; i <list.size(); i++) {
			if (list.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}

}
