import pkg21.Hostel;
import pkg21.pkg22.SRA;
import pkg21.pkg22.Student;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Test6_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hostel hostel = new Hostel("XYZ Hostel");
        List<Student> students = new ArrayList<>();
        List<SRA> sras = new ArrayList<>();

        while (true) {
            try {
                System.out.println("Hostel Management System Menu:");
                System.out.println("1. Allocate SRA");
                System.out.println("2. List SRAs in Hostel");
                System.out.println("3. List Students under an SRA");
                System.out.println("4. View Student Details");
                System.out.println("5. Allocate Student to SRA");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine();  

                switch (choice) {
                    case 1:
                        System.out.print("Enter SRA Name: ");
                        String sraName = scanner.nextLine();
                        System.out.print("Enter SRA ID: ");
                        String sraID = scanner.nextLine();
                        SRA sra = new SRA(sraName, sraID);
                        sras.add(sra);
                        System.out.println("SRA Allocated Successfully.");
                        break;

                    case 2:
                        if (sras.isEmpty()) {
                            System.out.println("No SRAs in the hostel.");
                        } else {
                            System.out.println("List of SRAs in the Hostel:");
                            for (SRA s : sras) {
                                System.out.println("Name: " + s.getSraName() + ", ID: " + s.getSraID());
                            }
                        }
                        break;

                    case 3:
                        System.out.print("Enter SRA ID to list students: ");
                        String sraIDToSearch = scanner.nextLine();
                        boolean found = false;
                        for (Student student : students) {
                            if (student.getSraID().equals(sraIDToSearch)) {
                                System.out.println("Student Name: " + student.getStudentName() + ", Roll Number: " + student.getRollNumber());
                                found = true;
                            }
                        }
                        if (!found) {
                            System.out.println("No students found under this SRA.");
                        }
                        break;

                    case 4:
                        System.out.print("Enter Roll Number to view student details: ");
                        String rollNumberToSearch = scanner.nextLine();
                        found = false;
                        for (Student student : students) {
                            if (student.getRollNumber().equals(rollNumberToSearch)) {
                                System.out.println("Student Name: " + student.getStudentName() + ", Roll Number: " + student.getRollNumber());
                                found = true;
                            }
                        }
                        if (!found) {
                            System.out.println("Student not found.");
                        }
                        break;

                    case 5:
                        System.out.print("Enter Student Name: ");
                        String studentName = scanner.nextLine();
                        System.out.print("Enter Student Roll Number: ");
                        String rollNumber = scanner.nextLine();
                        System.out.print("Enter SRA ID to allocate student: ");
                        String sraIDToAllocate = scanner.nextLine();

                        
                        boolean sraExists = false;
                        for (SRA s : sras) {
                            if (s.getSraID().equals(sraIDToAllocate)) {
                                Student student = new Student(studentName, rollNumber, sraIDToAllocate);
                                students.add(student);
                                System.out.println("Student Allocated to SRA Successfully.");
                                sraExists = true;
                                break;
                            }
                        }

                        if (!sraExists) {
                            System.out.println("SRA not found. Student allocation failed.");
                        }
                        break;

                    case 6:
                        System.out.println("Exiting...");
                        scanner.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer choice.");
                scanner.nextLine();  
            }
        }
    }
}
