import java.util.Scanner;


        class InvalidRegistrationException extends Exception {
            public InvalidRegistrationException(String message) {
                super(message);
            }
        }

        public class ExamRegistration {

            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                System.out.println("===== EXAM REGISTRATION SYSTEM =====");
                System.out.println();

                try {
                    System.out.print("Enter Student ID: ");
                    String studentId = scanner.nextLine().trim();

                    if (studentId.isEmpty()) {
                        throw new InvalidRegistrationException(
                                "Student ID cannot be empty."
                        );
                    }

                    System.out.print("Enter Student Name: ");
                    String studentName = scanner.nextLine().trim();

                    if (studentName.isEmpty()) {
                        throw new InvalidRegistrationException(
                                "Student name cannot be empty."
                        );
                    }

                    System.out.print("Enter Age: ");
                    int age = Integer.parseInt(scanner.nextLine().trim());

                    if (age < 18) {
                        throw new InvalidRegistrationException(
                                "Age must be at least 18."
                        );
                    }

                    System.out.print("Enter Exam Mark: ");
                    double examMark =
                            Double.parseDouble(scanner.nextLine().trim());

                    if (examMark < 0 || examMark > 100) {
                        throw new InvalidRegistrationException(
                                "Examination mark must be between 0 and 100."
                        );
                    }

                    System.out.print("Enter Number of Subjects: ");
                    int numberOfSubjects =
                            Integer.parseInt(scanner.nextLine().trim());

                    if (numberOfSubjects < 1) {
                        throw new InvalidRegistrationException(
                                "Minimum allowed subjects is 1."
                        );
                    }

                    if (numberOfSubjects > 5) {
                        throw new InvalidRegistrationException(
                                "Maximum allowed subjects is 5."
                        );
                    }

                    System.out.println();
                    System.out.println("Registration Successful!");
                    System.out.println("Student: " + studentName);
                    System.out.println(
                            "Registered Subjects: " + numberOfSubjects
                    );

                } catch (InvalidRegistrationException e) {
                    System.out.println();
                    System.out.println("Registration Failed!");
                    System.out.println("Error: " + e.getMessage());

                } catch (NumberFormatException e) {
                    System.out.println();
                    System.out.println("Registration Failed!");
                    System.out.println(
                            "Error: Please enter a valid number for age, mark, and subjects."
                    );

                } catch (Exception e) {
                    System.out.println();
                    System.out.println("Registration Failed!");
                    System.out.println(
                            "Error: An unexpected problem occurred."
                    );

                } finally {
                    System.out.println();
                    System.out.println("Registration attempt completed.");
                    scanner.close();
                }
            }

            public static void validateRegistration(
                    String studentId,
                    int age,
                    double examMark,
                    int numberOfSubjects)
                    throws InvalidRegistrationException {

                if (studentId == null || studentId.trim().isEmpty()) {
                    throw new InvalidRegistrationException(
                            "Student ID cannot be empty."
                    );
                }

                if (age < 18) {
                    throw new InvalidRegistrationException(
                            "Age must be at least 18."
                    );
                }

                if (examMark < 0 || examMark > 100) {
                    throw new InvalidRegistrationException(
                            "Examination mark must be between 0 and 100."
                    );
                }

                if (numberOfSubjects < 1 || numberOfSubjects > 5) {
                    throw new InvalidRegistrationException(
                            "Number of subjects must be between 1 and 5."
                    );
                }
            }
        }

        
