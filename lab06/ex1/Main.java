package ex1;

public class Main {
    public static void main(String[] args) {
        
        Database database = new Database();
        MergedDatabase Staff = new MergedDatabase(database);


        // criar empregados da Sweets   
        Employee se1 = new Employee("Kelinha", 76, 8765.87);
        Employee se2 = new Employee("Mankings", 12, 345.54);
        Employee se3 = new Employee("Tigas", 98, 235.00);

        // adicionar empregados da Sweets 
        Staff.insere(se1);
        Staff.insere(se2);
        Staff.insere(se3);

        // criar empregados do Petiscos
        Empregado pe1 = new Empregado("Nico", "Lau", 1, 134.00);
        Empregado pe2 = new Empregado("Asdrú", "Bal", 6, 765.53); 
        
        // adicionar empregados do Petiscos
        Staff.insere(pe1);
        Staff.insere(pe2);

        //New Company
        System.out.println("Current Staff:");
        Staff.printEmployees();

        Staff.remove(76);
        Staff.remove(1);
        System.out.println("\nNew current Staff without Nico and Kelinha because they were fired:");
        Staff.printEmployees();

        System.out.println("\nIs there a worker with code 0 in the company? " + Staff.isEmpregado(0) );
        System.out.println("Is Asdrú a worker in the company? " + Staff.isEmpregado(pe2.codigo()));

        Empregado pe3 = new Empregado("Empre", "Gado", 694, 1111111.11);
        Staff.insere(pe3);
        System.out.println("\n" + pe3.nome() + " has joined the company with " + pe3.salario() + " sallary!");
        

    }
}
