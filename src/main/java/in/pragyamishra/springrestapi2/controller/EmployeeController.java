package in.pragyamishra.springrestapi2.controller;

import in.pragyamishra.springrestapi2.model.Employee;

import in.pragyamishra.springrestapi2.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController //@Controller + @ResponseBody

public class EmployeeController {
    //localhost:8080/api/v1/employees

    @Autowired
    private EmployeeService eService;
 //   @Value("${app.name}")
 //   private String appName;
 //   @Value("${app.version}")
 //private String appVersion;
   // @GetMapping("/version")
   // public String getAppDetails(){
     //   return appName+ "-" + appVersion;
  //  }
    //localhost:8080/employees - URI
    //@RequestMapping(value ="/employees", method = RequestMethod.GET)
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees(@RequestParam Integer pageNumber, @RequestParam Integer pageSize){
        return new ResponseEntity<List<Employee>>(eService.getEmployees(pageNumber, pageSize), HttpStatus.OK);
    }

    //localhost:8080/employees/898
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id){
        return new ResponseEntity<>(eService.getSingleEmployee(id), HttpStatus.OK);

    }
    @PostMapping("/employees")
    public ResponseEntity<List<Employee>> saveEmployee(@Valid @RequestBody Employee employee){
        return new ResponseEntity(eService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employee){
        employee.setId(id);
        return new ResponseEntity<Employee>(eService.updateEmployee(employee),HttpStatus.OK);
    }

    //localhost:8080/employees?id=34
    @DeleteMapping("/employees")
    public ResponseEntity<HttpStatus>deleteEmployee(@RequestParam Long id){
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/employees/filterByName")
    public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam String name){
        return new ResponseEntity<List<Employee>>(eService.getEmployeesByName(name), HttpStatus.OK);
    }
    @GetMapping("/employees/filterByNameAndLocation")
    public ResponseEntity<List<Employee>> getEmployeesByNameAndLocation(@RequestParam String name, @RequestParam String location){
        return new ResponseEntity<List<Employee>>(eService.getEmployeesByNameAndLocation(name, location), HttpStatus.OK);
    }

    @GetMapping("/employees/filterByKeyword")
    public ResponseEntity<List<Employee>> getEmployeesByKeyword(@RequestParam String name){
        return new ResponseEntity<List<Employee>>(eService.getEmployeesByKeyword(name), HttpStatus.OK);
    }

   // @GetMapping("/employees/{name}/{location}")
   // public ResponseEntity<List<Employee>> getEmployeesByNameOrLocation(@PathVariable String name, @PathVariable String location){
      //  return new ResponseEntity<List<Employee>>(eService.getEmployeesByNameOrLocation(name,location), HttpStatus.OK);
   // }

    // @GetMapping("/employees/delete/{name}")
    // public ResponseEntity<List<String>> deleteEmployeeByName(@PathVariable String name){
    //  return new ResponseEntity<List<String>>(eService.deleteEmployeesByName(name) + "Number of records deleted", HttpStatus.OK);
    // }
}
