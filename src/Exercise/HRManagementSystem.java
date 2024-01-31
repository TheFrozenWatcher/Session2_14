package Exercise.BTTH;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static Exercise.BTTH.Department.getTotalMembers;

public class HRManagementSystem {
    public static List<Department> departments = new ArrayList<>();
    public static List<Employee> employees = new ArrayList<>();

    // Quản trị phòng ban
    public static void displayDepartments() {
        if (departments.size() == 0) {
            System.out.println("Chưa có phòng ban nào!");
            return;
        } else {
            departments.forEach(department -> System.out.println("Department: " + department.getDepartmentName() + ", Id: " + department.getDepartmentId() + ", Total members: " + getTotalMembers(department)));
        }

    }

    public static void addDepartment() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ID:");
        String departmentId = sc.nextLine();
        if (departments.stream().noneMatch(department -> department.getDepartmentId() == departmentId) && departmentId.startsWith("D") && departmentId.length() == 4) {
            System.out.println("Nhập tên:");
            String departmentName = sc.nextLine();
            if (departments.stream().noneMatch(department -> department.getDepartmentName() == departmentName)) {
                Department newDepartment = new Department(departmentId, departmentName);
                departments.add(newDepartment);
                System.out.println("Thêm mới thành công!");
            } else {
                System.out.println("Tên đã tồn tại!!");
            }
        } else {
            System.out.println("Id không hợp lệ!");
        }
    }

    public static void editDepartmentName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập Id phòng cần sửa tên:");
        String departmentId = sc.nextLine();
        if (departments.stream().anyMatch(department -> department.getDepartmentId().equals(departmentId))) {
            System.out.println("Nhập tên mới:");
            String newDepartmentName = sc.nextLine();
            if (departments.stream().noneMatch(department -> department.getDepartmentName().equals(newDepartmentName))) {
                departments.stream()
                        .filter(department -> department.getDepartmentId().equals(departmentId))
                        .findFirst()
                        .ifPresent(department -> department.setDepartmentName(newDepartmentName));
                System.out.println("Cập nhật thành công!");
            } else {
                System.out.println("Tên đã tồn tại vui lòng chọn tên khác!");
                return;
            }
        } else {
            System.out.println("Không có ID này trong danh sách!");
            return;
        }
    }

    public static void displayEmployeesInDepartment() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập Id phòng muốn xem:");
        String departmentId = sc.nextLine();
        if (employees.stream().anyMatch(employee -> employee.getDepartment().getDepartmentId().equals(departmentId))) {
            employees.stream()
                    .filter(employee -> employee.getManager() != null && employee.getManager().getEmployeeId().equals(departmentId))
                    .forEach(employee -> System.out.println("Employee: " + employee.getEmployeeName()));
        } else {
            System.out.println("Không có nhân viên nào có trong phòng mang ID trên");
        }
    }

    public static void deleteDepartment() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập Id phòng muốn xóa:");
        String departmentId = sc.nextLine();
        if (employees.stream().noneMatch(employee -> employee.getManager() != null && employee.getManager().getEmployeeId().equals(departmentId))) {
            departments.removeIf(department -> department.getDepartmentId().equals(departmentId));
        } else {
            System.out.println("Không thể xóa phòng có nhân viên.");
        }
    }

    // Quản trị nhân viên
    public static void displayAllEmployees() {
        employees.forEach(employee -> System.out.println("ID: " + employee.getEmployeeId() + " - Name: " + employee.getEmployeeName()));
    }

    //    Hiển thị thông tin chi tiết của nhân viên
    public static void displayEmployee(Employee employee) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Employee name: " + employee.getEmployeeName()
                + " - Date of Birth: " + employee.getBirthday().format(dateFormatter)
                + " - Gender: " + (employee.isSex() ? "Male" : "Female")
                + " - Manager: " + (employee.getManager() == null ? "None" : employee.getManager().getEmployeeName())
                + " - Salary: " + employee.getSalary()
                + " - Department: " + employee.getDepartment().getDepartmentName());

    }

    //   Tìm thông tin chi tiết nhân viên theo ID
    public static void displayEmployeeDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập Id cần tìm:");
        String employeeId = sc.nextLine();
        if (employees.stream().anyMatch(employee -> employee.getEmployeeId().equals(employeeId))) {
            employees.stream()
                    .filter(employee -> employee.getEmployeeId().equals(employeeId))
                    .findFirst()
                    .ifPresent(employee -> displayEmployee(employee));
        } else {
            System.out.println("Không có nhân viên mang ID này.");
        }

    }

    //    Thêm mới nhân viên
    public static void addEmployee() {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String employeeId = null;
        String finalEmployeeId = employeeId;
        do {
            System.out.println("Nhập Id:");
            employeeId = sc.nextLine();
        } while (!employeeId.startsWith("E") || employeeId.length() != 5 || employees.stream().anyMatch(employee -> employee.getEmployeeId().equals(finalEmployeeId)));
        String employeeName;
        do {
            System.out.println("Nhập tên:");
            employeeName = sc.nextLine();
        } while (employeeName.length() == 0);
        String birthdayToString;
        do {
            System.out.println("Nhập ngày sinh");
            birthdayToString = sc.nextLine();
        } while (birthdayToString.isEmpty());
        LocalDate birthday = LocalDate.parse(birthdayToString, dateFormatter);
        System.out.println("Nhập giới tính");
        boolean sex = Boolean.parseBoolean(sc.nextLine());
        System.out.println("Nhập lương:");
        BigDecimal salary = sc.nextBigDecimal();
        sc.nextLine();
        System.out.println("Danh sách nhân viên hiện tại: ");
        displayAllEmployees();
        System.out.println("Nhập manager ID:");
        String managerID = sc.nextLine();
        Employee manager = employees.stream().filter(employee -> employee.getEmployeeId().equals(managerID)).findFirst().orElse(null);
        System.out.println("Danh sách phòng ban: ");
        displayDepartments();
        Optional<Department> departmentOptional;
        do {
            System.out.println("Nhập tên phòng ban:");
            String departmentName = sc.nextLine();
            departmentOptional = departments.stream()
                    .filter(department -> department.getDepartmentName().equals(departmentName))
                    .findFirst();
        } while (!departmentOptional.isPresent());
        Department employeeDepartment = departmentOptional.get();
        Employee newEmployee = new Employee(employeeId, employeeName, birthday, sex, salary, manager, employeeDepartment);
        employees.add(newEmployee);
        System.out.println("Thêm mới thành công!");
    }

    //  Sửa thông tin nhân viên
    public static void editEmployeeDetails() {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Nhập Id cần sửa thông tin:");
        String employeeId = sc.nextLine();
        if (employees.stream().anyMatch(employee -> employee.getEmployeeId().equals(employeeId))) {
            String employeeName;
            do {
                System.out.println("Nhập tên:");
                employeeName = sc.nextLine();
            } while (employeeName.length() == 0);
            String birthdayToString;
            do {
                System.out.println("Nhập ngày sinh");
                birthdayToString = sc.nextLine();
            } while (birthdayToString.length() == 0);
            LocalDate birthday = LocalDate.parse(birthdayToString, dateFormatter);
            System.out.println("Nhập giới tính");
            boolean sex = sc.nextBoolean();
            System.out.println("Nhập lương:");
            BigDecimal salary = sc.nextBigDecimal();
            System.out.println("Danh sách nhân viên hiện tại: ");
            sc.nextLine();
            displayAllEmployees();
            System.out.println("Nhập manager ID:");
            String managerID = sc.nextLine();
            Employee manager = employees.stream().filter(employee -> employee.getEmployeeId().equals(managerID)).findFirst().orElse(null);
            System.out.println("Danh sách phòng ban: ");
            displayDepartments();
            Optional<Department> departmentOptional;
            do {
                System.out.println("Nhập tên phòng ban:");
                String departmentName = sc.nextLine();
                departmentOptional = departments.stream()
                        .filter(department -> department.getDepartmentName().equals(departmentName))
                        .findFirst();
            } while (!departmentOptional.isPresent());
            Department employeeDepartment = departmentOptional.get();
            String finalEmployeeName = employeeName;
            employees.stream()
                    .filter(employee -> employee.getEmployeeId().equals(employeeId))
                    .findFirst()
                    .ifPresent(employee -> {
                        employee.setEmployeeName(finalEmployeeName);
                        employee.setBirthday(birthday);
                        employee.setSex(sex);
                        employee.setSalary(salary);
                        employee.setManager(manager);
                        employee.setDepartment(employeeDepartment);
                    });
            System.out.println("Cập nhật thành công!");
        } else {
            System.out.println("Không có nhân viên mang ID này.");
            return;
        }
    }

    //    Xóa nhân viên
    public static void deleteEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập Id cần xóa:");
        String employeeId = sc.nextLine();

        if (employees.stream().anyMatch(employee -> employee.getEmployeeId().equals(employeeId))) {
            employees.removeIf(employee -> employee.getEmployeeId().equals(employeeId));
            System.out.println("Xóa thành công!");

        } else {
            System.out.println("Không có nhân viên mang ID này.");
            return;
        }
    }

    // Thống kê
//   Số lượng nhân viên trung bình
    public static void averageEmployeesPerDepartment() {
        if (employees.size() == 0 || departments.size() == 0) {
            System.out.println("Không có số liệu thống kê");
        } else {
            System.out.println("Số lượng nhân viên trung bình là " +
                    departments.stream()
                            .mapToInt(Department::getTotalMembers)
                            .average().orElse(0.0));
        }

    }

    //    Top 5 phòng ban theo số nhân viên
    public static void topDepartmentsByEmployeeCount() {
        List<Department> top5DepartmentsByEmployeeCount = departments.stream().sorted(Comparator.comparingInt(Department::getTotalMembers).reversed())
                .limit(5)
                .collect(Collectors.toList());
        top5DepartmentsByEmployeeCount.forEach(department -> System.out.println(department.getDepartmentName()));
    }

    //    Top 5 quản lý nhiều nhân viên nhất
    public static void managerWithMostEmployees() {
        Map<Employee, Integer> employeeCountMap = new HashMap<>();
        for (Employee employee : employees) {
            if (employee.getManager() != null) {
                employeeCountMap.put(employee.getManager(), employeeCountMap.getOrDefault(employee.getManager(), 0) + 1);
            }
        }
        employeeCountMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .forEach(entry -> {
                    System.out.println("Người quản lý: " + entry.getKey().getEmployeeName() + " - Số nhân viên quản lý: " + entry.getValue());
                });
    }

    //    5 nhân viên cao tuổi nhất
    public static void top5OldestEmployees() {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getBirthday))
                .limit(5)
                .collect(Collectors.toList())
                .forEach(employee -> displayEmployee(employee));
    }

    // 5 nhân viên lương cao nhất
    public static void top5HighestPaidEmployees() {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .limit(5)
                .collect(Collectors.toList())
                .forEach(employee -> displayEmployee(employee));
    }

    public static void employeeManagement() {
        Scanner sc = new Scanner(System.in);
        byte choice;
        do {
            System.out.println("Quản lý nhân viên");
            System.out.println("1. Hiển thị mã và tên nhân viên");
            System.out.println("2. Xem chi tiết thông tin nhân viên theo mã nhân viên (toàn bộ thông tin)");
            System.out.println("3.Thêm mới nhân viên");
            System.out.println("4. Chỉnh sửa thông tin nhân viên");
            System.out.println("5. Xóa nhân viên");
            System.out.println("6. Thống kê số lượng nhân viên trung bình của mỗi phòng");
            System.out.println("7.Tìm ra 5 phòng có số lượng nhân viên đông nhất");
            System.out.println("8.Tìm ra người quản lý nhiều  nhân viên nhất");
            System.out.println("9.Tìm ra 5 nhân viên có tuổi cao nhất công ty");
            System.out.println("10.Tìm ra 5 nhân viên hưởng lương cao nhất");
            System.out.println("11. Quay lại menu chính");
            System.out.println("Nhập lựa chọn:");
            choice = sc.nextByte();
            switch (choice) {
                case 1:
                    System.out.println("1. Hiển thị mã và tên nhân viên");
                    displayAllEmployees();
                    break;
                case 2:
                    System.out.println("2. Xem chi tiết thông tin nhân viên theo mã nhân viên (toàn bộ thông tin)");
                    displayEmployeeDetails();
                    break;
                case 3:
                    System.out.println("3.Thêm mới nhân viên");
                    addEmployee();
                    break;
                case 4:
                    System.out.println("4. Chỉnh sửa thông tin nhân viên");
                    editEmployeeDetails();
                    break;
                case 5:
                    System.out.println("5. Xóa nhân viên");
                    deleteEmployee();
                    break;
                case 6:
                    System.out.println("6. Thống kê số lượng nhân viên trung bình của mỗi phòng");
                    averageEmployeesPerDepartment();
                    break;
                case 7:
                    System.out.println("7.Tìm ra 5 phòng có số lượng nhân viên đông nhất");
                    topDepartmentsByEmployeeCount();
                    break;
                case 8:
                    System.out.println("8.Tìm ra người quản lý nhiều  nhân viên nhất");
                    managerWithMostEmployees();
                    break;
                case 9:
                    System.out.println("9.Tìm ra 5 nhân viên có tuổi cao nhất công ty");
                    top5OldestEmployees();
                    break;
                case 10:
                    System.out.println("10.Tìm ra 5 nhân viên hưởng lương cao nhất");
                    top5HighestPaidEmployees();
                    break;
                case 11:
                    return;
                default:
                    System.out.println("Nhập sai lệnh!");
                    break;
            }

        } while (choice != 11);
    }

    public static void departmentManagement() {
        Scanner sc = new Scanner(System.in);
        byte choice;
        do {
            System.out.println("Quản lý phòng ban");
            System.out.println("1. Hiển thị danh sách phòng ban");
            System.out.println("2. Thêm mới phòng ban");
            System.out.println("3. Chỉnh sửa tên phòng ban");
            System.out.println("4. Hiển thị danh sách nhân viên theo mã phòng");
            System.out.println("5. Xóa phòng ban");
            System.out.println("6. Quay lại menu chính");
            System.out.println("Nhập lựa chọn:");
            choice = sc.nextByte();
            switch (choice) {
                case 1:
                    System.out.println("1. Hiển thị danh sách phòng ban");
                    displayDepartments();
                    break;
                case 2:
                    System.out.println("2. Thêm mới phòng ban");
                    addDepartment();
                    break;
                case 3:
                    System.out.println("3. Chỉnh sửa tên phòng ban");
                    editDepartmentName();
                    break;
                case 4:
                    System.out.println("4. Hiển thị danh sách nhân viên theo mã phòng");
                    displayEmployeesInDepartment();
                    break;
                case 5:
                    System.out.println("5. Xóa phòng ban");
                    deleteDepartment();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Nhập sai lệnh!");
                    break;
            }
        } while (choice != 6);
    }
}
