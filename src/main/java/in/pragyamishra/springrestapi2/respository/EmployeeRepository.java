package in.pragyamishra.springrestapi2.respository;

import in.pragyamishra.springrestapi2.model.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    List<Employee> findByName(String name);
    List<Employee> findByNameAndLocation(String name, String location);

    // Select * from table where name like "%ram%"
    List<Employee>findByNameContaining(String keyword, Sort sort);
   // @Query("FROM employee WHERE name = :name OR location = :location")
   // List<Employee> getEmployeesByNameAndLocation(String name, String Location);
    //@Transactional
    //@Modifyings
    // @Query("DELETE employee WHERE name = :name OR location = :location")
    // Integer deleteEmployeeByName(String name);

}
