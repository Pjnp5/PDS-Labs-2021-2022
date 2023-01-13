package ex1;

public class MergedDatabase extends Registos{
    Database database;

    public MergedDatabase(Database database) {
        super();

        if (database == null) {
            throw new IllegalArgumentException("Database cannot be null!");
        }
        this.database = database;
    }

    public boolean insere(Employee employee){
        return this.database.addEmployee(employee);
    }

    public void insere(Empregado empregado) {
        super.insere(empregado);
    }


    public void remove(int codigo) {
        database.deleteEmployee(codigo);

        if (super.isEmpregado(codigo)) {
            super.remove(codigo);
        }
    }

    public void printEmployees(){

        for(Employee i : this.database.getAllEmployees()){
            System.out.println("Name: " + i.getName() + ", Number: " + i.getEmpNum());
        } 

        for(Empregado i : super.listaDeEmpregados()){
            System.out.println("Name: " + i.nome() + " " + i.apelido() + ", Number: " + i.codigo());
        } 
    }

}
