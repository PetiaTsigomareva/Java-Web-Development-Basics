package registerapp.service;

import registerapp.domain.models.service.EmployeeServiceModel;
import registerapp.domain.models.views.EmployeeListViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeService {

    boolean saveEmployee(EmployeeServiceModel employeeServiceModel);

    List<EmployeeServiceModel> findAllEmployees();

    boolean removeEmployee(String id);

    String findEmployeesTotalSalary();

    String findEmployeesAVGSalary();
}
