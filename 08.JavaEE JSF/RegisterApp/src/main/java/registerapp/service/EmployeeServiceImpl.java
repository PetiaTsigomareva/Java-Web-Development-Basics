package registerapp.service;

import org.modelmapper.ModelMapper;
import registerapp.domain.entities.Employee;
import registerapp.domain.models.service.EmployeeServiceModel;
import registerapp.repository.EmployeeRepository;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    @Inject
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean saveEmployee(EmployeeServiceModel employeeServiceModel) {
        boolean result = false;
        try {
            this.employeeRepository.save(this.modelMapper.map(employeeServiceModel, Employee.class));
            result = true;
        } catch (Exception e) {
            result = false;

        }

        return result;
    }

    @Override
    public List<EmployeeServiceModel> findAllEmployees() {

        return this.employeeRepository.findAll().stream().map(e -> this.modelMapper.map(e, EmployeeServiceModel.class)).collect(Collectors.toList());
    }

    @Override
    public boolean removeEmployee(String id) {
        boolean result = false;
        try {
            this.employeeRepository.remove(id);
            result = true;
        } catch (Exception e) {
            result = false;

        }

        return result;
    }

    @Override
    public String findEmployeesTotalSalary() {
        BigDecimal totalSalary = null;
        try {
            totalSalary = this.employeeRepository.findTotalSalary();
            if (totalSalary == null) {
                totalSalary = BigDecimal.valueOf(0.00);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return totalSalary.toString();

    }

    @Override
    public String findEmployeesAVGSalary() {
        Double avgSalary = null;
        try {
            avgSalary = this.employeeRepository.findAVRSalary();
            if (avgSalary == null) {
                avgSalary = 0.00;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return avgSalary.toString();


    }
}
