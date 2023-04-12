package in.pragyamishra.springrestapi2.service;

import in.pragyamishra.springrestapi2.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees(int pageNumber, int pageSize);
    Employee saveEmployee(Employee employee);

    Employee getSingleEmployee (Long id);

    void deleteEmployee(Long id);

    Employee updateEmployee( Employee employee);

    List<Employee> getEmployeesByName(String name);
  /// select * from table where name="Pragya" and location="India"

    List<Employee> getEmployeesByNameAndLocation(String name, String location);

    List<Employee> getEmployeesByKeyword(String name);

    //List<Employee> getEmployeesByNameOrLocation(String name, String Location);

    //Integer deleteByEmployeeName(String name);
}
