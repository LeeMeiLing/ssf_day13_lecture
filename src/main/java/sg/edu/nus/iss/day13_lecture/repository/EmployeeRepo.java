package sg.edu.nus.iss.day13_lecture.repository;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Repository;
import sg.edu.nus.iss.day13_lecture.model.Employee;

@Repository
public class EmployeeRepo {

    final String dirPath = "C:/ssfData";
    final String fileName = "employee.txt";
    
    private List<Employee> employees;

    public EmployeeRepo() throws ParseException{
        if(employees == null){
            employees = new ArrayList<Employee>();
        }

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse("1980-10-15");
        Employee emp = new Employee("Derrick", "Tan", "derrick@gmail.com", "91234567", 7500, date, "10 Ghim Moh", 272210);
        employees.add(emp);

        // Employee emp = new Employee("Derrick", "Tan", "derrick@gmail.com", "91234567", 7500, new Date(1980-10-15), "10 Ghim Moh", 272210);

        date = df.parse("1979-02-18");
        emp = new Employee("Dennis", "Chew", "dennis@gmail.com", "81234567", 8500, date, "28 Ghim Moh", 272228);
        employees.add(emp);

    }

    public List<Employee> findAll(){
        return employees;
    }

    public Boolean save(Employee employee) throws IOException{
        
        Boolean result = employees.add(employee);

        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File(dirPath + "/" + fileName), true)))
        {
            pw.println(employee.toString());
            pw.flush();
        }

        return result;
    }

    public Boolean delete(Employee employee){
        
        // Employee e = employees.stream().filter(emp -> emp.getEmail().equalsIgnoreCase(employee.getEmail())).findFirst().get();

        Boolean result = false;

        int employeeIndex = employees.indexOf(employee);
        if (employeeIndex >= 0){
            employees.remove(employeeIndex);
            result = true;
        }
        
        return result;
    }

    public Employee findByEmailId (String email){

        Employee emp = employees.stream().filter(e -> e.getEmail().equals(email)).findFirst().get();
        return emp;
    }

    public Boolean updateEmployee (Employee em) {

        Employee emp = employees.stream().filter(e -> e.getEmail().equals(em.getEmail())).findFirst().get();

        Integer idx = 0;

        if(emp != null){

            idx = employees.indexOf(emp);

            if (idx >= 0 ) {
                employees.remove(emp);
                employees.add(idx,em);
                return true;
            }
        }

        return false;
        
    }

}
