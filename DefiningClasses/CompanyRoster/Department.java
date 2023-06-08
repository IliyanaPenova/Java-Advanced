package DefiningClasses.CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
  public Department(String name){
        this.name=name;
        employees=new ArrayList<>();
  }
  public double calculateAverageSalary(){
        return this.employees.stream().mapToDouble(e->e.getSalary()).average().orElse(0);
    }
    private String name;
    private List<Employee> employees;
}
