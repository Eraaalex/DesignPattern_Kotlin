package org.hse.software.construction.model.employee;

public class EmployeeFactory {

    public static Employee createEmployee(String name, String role) {
        switch (role.trim().toLowerCase()) {
            case "developer":
                return new Developer(name);
            case "manager":
                return new Manager(name);

            default:
                throw new IllegalArgumentException("Unknown role: " + role);
        }
    }
}
