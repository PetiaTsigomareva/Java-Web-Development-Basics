package registerapp.web.managebeans;

import registerapp.domain.models.views.EmployeeAVGSalaryViewModel;
import registerapp.domain.models.views.EmployeeTotalSalaryViewModel;
import registerapp.service.EmployeeService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class EmployeeSalariesBean {

    private EmployeeTotalSalaryViewModel employeeTotalSalaryViewModel;
    private EmployeeAVGSalaryViewModel employeeAVGSalaryViewModel;
    private EmployeeService employeeService;

    public EmployeeSalariesBean() {
        employeeTotalSalaryViewModel = new EmployeeTotalSalaryViewModel();
        employeeAVGSalaryViewModel = new EmployeeAVGSalaryViewModel();

    }

    @Inject
    public EmployeeSalariesBean(EmployeeService employeeService) {
        this();
        this.employeeService = employeeService;
        employeeTotalSalaryViewModel.setTotalSalary(this.employeeService.findEmployeesTotalSalary());
        employeeAVGSalaryViewModel.setAvgSalary(this.employeeService.findEmployeesAVGSalary());

    }

    public EmployeeTotalSalaryViewModel getEmployeeTotalSalaryViewModel() {
        return employeeTotalSalaryViewModel;
    }

    public void setEmployeeTotalSalaryViewModel(EmployeeTotalSalaryViewModel employeeTotalSalaryViewModel) {
        this.employeeTotalSalaryViewModel = employeeTotalSalaryViewModel;
    }

    public EmployeeAVGSalaryViewModel getEmployeeAVGSalaryViewModel() {
        return employeeAVGSalaryViewModel;
    }

    public void setEmployeeAVGSalaryViewModel(EmployeeAVGSalaryViewModel employeeAVGSalaryViewModel) {
        this.employeeAVGSalaryViewModel = employeeAVGSalaryViewModel;
    }
}
