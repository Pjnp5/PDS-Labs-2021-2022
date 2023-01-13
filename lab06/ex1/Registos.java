package ex1;
import java.util.ArrayList;
import java.util.List;

class Registos {
    // Data elements
    private ArrayList<Empregado> empregados;

    // Stores the employees
    public Registos() {
        empregados = new ArrayList<>();
    }

    public void insere(Empregado emp) {
        // Code to insert employee
        for(Empregado empregado_para_ver : empregados){
            if(empregado_para_ver.equals(emp)){; break;}
        }
        empregados.add(emp);
    }

    public void remove(int codigo) {
        // Code to remove employee
        for(Empregado empregado_para_ver : empregados){
            if(empregado_para_ver.codigo() == codigo){empregados.remove(empregado_para_ver); break;}
        }
    }

    public boolean isEmpregado(int codigo) {
        // Code to find employee
        for(Empregado empregado_para_ver : empregados){
            if(empregado_para_ver.codigo() == codigo){ return true;}
        }
        return false;
    }

    public List<Empregado> listaDeEmpregados() {
        // Code to retrieve collection
        return empregados;
    }
}