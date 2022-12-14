package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Address;
import entities.Department;
import entities.Employee;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Nome do departamento: ");
		String nomeDep = sc.nextLine();
		System.out.print("Dia do pagamento: ");
		int payDay = sc.nextInt();
		System.out.print("Email: ");
		sc.nextLine();
		String email = sc.nextLine();
		System.out.print("Telefone: ");
		String telefone = sc.nextLine();

		Department dept = new Department(nomeDep, payDay, new Address(email, telefone));

		System.out.print("Quantos funcion?rios tem o departamento? ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			sc.nextLine();
			System.out.println("Dados do funcion?rio " + i + ":");
			System.out.print("Nome: ");
			String name = sc.nextLine();
			System.out.print("Sal?rio: ");
			double salary = sc.nextDouble();

			Employee e = new Employee(name, salary);
			dept.addEmployee(e);
		}

		System.out.println();
		showReport(dept);
		sc.close();
	}

	private static void showReport(Department dept) {
		StringBuilder sb = new StringBuilder();
		sb.append("FOLHA DE PAGAMENTO:\n");
		sb.append("Departamento " + dept.getName() + " = R$ " + String.format("%.2f", dept.payroll()) + "\n");
		sb.append("Pagamento realizado no dia " + dept.getPayDay() + "\n");
		sb.append("Funcion?rios:\n");
		for (int i = 0; i < dept.getEmployees().size(); i++) {
			sb.append(dept.getEmployees().get(i).getName() + "\n");
		}
		sb.append("Para d?vidas favor entrar em contato: " + dept.getAddress().getEmail());
		System.out.println(sb);
	}
}