package Exercise.BTTH;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Department {
    private String departmentId;
    private String departmentName;
    private int totalMembers;

    public Department(){}
    public Department(String departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public static int getTotalMembers(Department department) {
        return HRManagementSystem.employees.stream().filter(employee->employee.getDepartment().equals(department)).collect(Collectors.toList()).size();
    }


}
