package registerapp.repository;

import registerapp.domain.entities.Employee;

import java.math.BigDecimal;

public interface EmployeeRepository extends GenericRepository <Employee,String> {

    BigDecimal findTotalSalary();

    Double findAVRSalary();
}
