class Employee {
        protected String employeeId;
        protected String name;
        protected String department;
        protected double basicSalary;

        public Employee(String employeeId, String name,
                        String department, double basicSalary) {
            this.employeeId = employeeId;
            this.name = name;
            this.department = department;
            this.basicSalary = basicSalary;
        }

        public double calculateSalary() {
            return basicSalary;
        }

        public String getCategory() {
            return "Employee";
        }

        public void displayInfo() {
            System.out.println("Employee ID: " + employeeId);
            System.out.println("Name: " + name);
            System.out.println("Category: " + getCategory());
            System.out.printf("Monthly Salary: $%.2f%n", calculateSalary());
        }
    }

    class FullTimeEmployee extends Employee {
        private double allowance;

        public FullTimeEmployee(String id, String name, String department,
                                double basicSalary, double allowance) {
            super(id, name, department, basicSalary);
            this.allowance = allowance;
        }

        @Override
        public double calculateSalary() {
            return basicSalary + allowance;
        }

        @Override
        public String getCategory() {
            return "Full-Time Employee";
        }
    }

    class PartTimeEmployee extends Employee {
        private double hoursWorked;
        private double hourlyRate;

        public PartTimeEmployee(String id, String name, String department,
                                double hoursWorked, double hourlyRate) {
            super(id, name, department, 0);
            this.hoursWorked = hoursWorked;
            this.hourlyRate = hourlyRate;
        }

        @Override
        public double calculateSalary() {
            return hoursWorked * hourlyRate;
        }

        @Override
        public String getCategory() {
            return "Part-Time Employee";
        }
    }

    class Manager extends Employee {
        private double bonus;

        public Manager(String id, String name, String department,
                       double basicSalary, double bonus) {
            super(id, name, department, basicSalary);
            this.bonus = bonus;
        }

        @Override
        public double calculateSalary() {
            return basicSalary + bonus;
        }

        @Override
        public String getCategory() {
            return "Manager";
        }
    }

    public class EmployeeSalaryManagement {
        public static void main(String[] args) {

            Employee[] employees = {
                    new FullTimeEmployee(
                            "EMP001", "Ahmed Ali", "IT", 500, 150
                    ),
                    new PartTimeEmployee(
                            "EMP002", "Fatima Hassan", "Finance", 30, 8
                    ),
                    new Manager(
                            "EMP003", "Mohamed Omar", "Administration", 1000, 200
                    )
            };

            System.out.println("===== EMPLOYEE SALARY REPORT =====");
            System.out.println();

            for (Employee employee : employees) {
                employee.displayInfo();
                System.out.println();
            }
        }
    }
