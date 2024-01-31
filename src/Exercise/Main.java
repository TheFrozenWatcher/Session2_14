package Exercise.BTTH;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

import static Exercise.BTTH.HRManagementSystem.departments;
import static Exercise.BTTH.HRManagementSystem.employees;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//       Ví dụ kiểm tra
        departments.add(new Department("D001", "HR"));
        departments.add(new Department("D002", "Finance"));
        departments.add(new Department("D003", "IT"));
        departments.add(new Department("D004", "Marketing"));
        departments.add(new Department("D005", "Operations"));
        departments.add(new Department("D006", "Sales"));
        departments.add(new Department("D007", "Research and Development"));
        departments.add(new Department("D008", "Customer Support"));
        departments.add(new Department("D009", "Legal"));
        departments.add(new Department("D010", "Quality Assurance"));

        Employee employee1 = new Employee("E001", "John Doe", LocalDate.of(1990, 5, 15), true, new BigDecimal("50000"), null, departments.get(0));
        Employee employee2 = new Employee("E002", "Jane Smith", LocalDate.of(1985, 8, 22), false, new BigDecimal("60000"), null, departments.get(1));
        Employee employee3 = new Employee("E003", "Bob Williams", LocalDate.of(1995, 2, 10), true, new BigDecimal("55000"), employee1, departments.get(0));
        Employee employee4 = new Employee("E004", "Alice Johnson", LocalDate.of(1988, 11, 3), false, new BigDecimal("70000"), null, departments.get(2));
        Employee employee5 = new Employee("E005", "Michael Brown", LocalDate.of(1992, 7, 18), true, new BigDecimal("80000"), employee2, departments.get(1));
        Employee employee6 = new Employee("E006", "Emily Davis", LocalDate.of(1986, 4, 27), false, new BigDecimal("60000"), null, departments.get(3));
        Employee employee7 = new Employee("E007", "Christopher Lee", LocalDate.of(1993, 9, 8), true, new BigDecimal("75000"), employee4, departments.get(2));
        Employee employee8 = new Employee("E008", "Sophia Wilson", LocalDate.of(1989, 12, 14), false, new BigDecimal("90000"), employee5, departments.get(1));
        Employee employee9 = new Employee("E009", "Daniel Anderson", LocalDate.of(1991, 6, 5), true, new BigDecimal("65000"), employee1, departments.get(0));
        Employee employee10 = new Employee("E010", "Olivia Moore", LocalDate.of(1987, 3, 12), false, new BigDecimal("70000"), employee3, departments.get(0));

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);
        employees.add(employee6);
        employees.add(employee7);
        employees.add(employee8);
        employees.add(employee9);
        employees.add(employee10);

        Employee employee11 = new Employee("E011", "Liam Turner", LocalDate.of(1992, 10, 8), true, new BigDecimal("65000"), employees.get(0), departments.get(3));
        Employee employee12 = new Employee("E012", "Ava Brown", LocalDate.of(1987, 6, 15), false, new BigDecimal("70000"), employees.get(4), departments.get(3));
        Employee employee13 = new Employee("E013", "Logan Harris", LocalDate.of(1995, 3, 23), true, new BigDecimal("60000"), employees.get(2), departments.get(1));
        Employee employee14 = new Employee("E014", "Ella Clark", LocalDate.of(1989, 12, 1), false, new BigDecimal("75000"), null, departments.get(5));
        Employee employee15 = new Employee("E015", "Mason Adams", LocalDate.of(1993, 7, 5), true, new BigDecimal("80000"), employees.get(1), departments.get(2));

        employees.add(employee11);
        employees.add(employee12);
        employees.add(employee13);
        employees.add(employee14);
        employees.add(employee15);

        byte choice;
        do {
            System.out.println("MENU");
            System.out.println("1. Quản lý phòng ban");
            System.out.println("2. Quản lý nhân viên");
            System.out.println("3. Thoát chương trình");
            System.out.println("Nhập lựa chọn:");
            choice = sc.nextByte();
            switch (choice) {
                case 1:
                    HRManagementSystem.departmentManagement();
                    break;
                case 2:
                    HRManagementSystem.employeeManagement();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;
            }

        } while (choice != 3);
    }

}
