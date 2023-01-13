package ex1;
import java.util.Vector;

class Database {  // Data elements 
    private Vector<Employee> employees; // Stores the employees
    
    public Database() { 
        employees = new Vector<>(); 
    } 
    public boolean addEmployee(Employee employee) { 
    // Code to add employee
        for(Employee employee_to_check : employees){
            if(employee_to_check.equals(employee)){return false;}
        }
        employees.add(employee);
        return true;
    } 
    public void deleteEmployee(long emp_num) {
    // Code to delete employee
        for(Employee employee_to_check : employees){
            if(employee_to_check.getEmpNum() == emp_num){employees.remove(employee_to_check); break;}
        }

    } 
    public Employee[] getAllEmployees() { 
    // Code to retrieve collection
        Employee[] employee_list = new Employee[this.employees.size()];

        for(int i = 0; i < employee_list.length; i++){employee_list[i] = employees.get(i);}
        return employee_list;
    }
} 