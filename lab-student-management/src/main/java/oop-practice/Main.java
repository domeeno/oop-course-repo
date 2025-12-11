import java.util.*;
import java.text.SimpleDateFormat;

// Enumeration for Study Fields
enum StudyField {
    MECHANICAL_ENGINEERING,
    SOFTWARE_ENGINEERING,
    FOOD_TECHNOLOGY,
    URBANISM_ARCHITECTURE,
    VETERINARY_MEDICINE
}

// Student class
class Student {
    private String firstName;
    private String lastName;
    private String email;
    private Date enrollmentDate;
    private Date dateOfBirth;
    private boolean graduated;

    public Student(String firstName, String lastName, String email, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.enrollmentDate = new Date();
        this.graduated = false;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public Date getEnrollmentDate() { return enrollmentDate; }
    public Date getDateOfBirth() { return dateOfBirth; }
    public boolean isGraduated() { return graduated; }

    public void setGraduated(boolean graduated) { this.graduated = graduated; }

    // Added setter for loading saved data
    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    @Override
    public String toString() {
        var sdf = new SimpleDateFormat("dd/MM/yyyy");
        return firstName + " " + lastName + " (" + email + ") - Enrolled: " +
                sdf.format(enrollmentDate) + (graduated ? " [GRADUATED]" : " [ENROLLED]");
    }
}

// Faculty class
class Faculty {
    private String name;
    private String abbreviation;
    private List<Student> students;
    private StudyField studyField;

    public Faculty(String name, String abbreviation, StudyField studyField) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.studyField = studyField;
        this.students = new ArrayList<>();
    }

    public String getName() { return name; }
    public String getAbbreviation() { return abbreviation; }
    public StudyField getStudyField() { return studyField; }
    public List<Student> getStudents() { return students; }

    public void addStudent(Student student) {
        students.add(student);
    }

    public boolean hasStudent(String email) {
        for (var s : students) {
            if (s.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }

    public Student findStudentByEmail(String email) {
        for (var s : students) {
            if (s.getEmail().equalsIgnoreCase(email)) {
                return s;
            }
        }
        return null;
    }

    public List<Student> getEnrolledStudents() {
        List<Student> enrolled = new ArrayList<>();
        for (var s : students) {
            if (!s.isGraduated()) {
                enrolled.add(s);
            }
        }
        return enrolled;
    }

    public List<Student> getGraduates() {
        List<Student> graduates = new ArrayList<>();
        for (var s : students) {
            if (s.isGraduated()) {
                graduates.add(s);
            }
        }
        return graduates;
    }

    @Override
    public String toString() {
        return name + " (" + abbreviation + ") - Field: " + studyField +
                " - Students: " + students.size();
    }
}

public class Main {
    private static List<Faculty> faculties = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) {
        System.out.println("Welcome to the student management system.");

        // Load saved data on startup
        faculties = FileManager.loadData();

        mainLoop();

        // Save data before exiting
        FileManager.saveData(faculties);
    }

    private static void mainLoop() {
        while (true) {
            System.out.println("\nWhat do you want to do?");
            System.out.println("g - general operations");
            System.out.println("f - faculty operations");
            System.out.println("s - students operations");
            System.out.println("q - quit program");
            System.out.println("\nyour input>");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "g":
                    generalOperations();
                    break;
                case "f":
                    facultyOperations();
                    break;
                case "s":
                    studentOperations();
                    break;
                case "q":
                    System.out.println("Saving data...");
                    FileManager.saveData(faculties);
                    System.out.println("Bye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void generalOperations() {
        while (true) {
            System.out.println("\nGeneral Operations");
            System.out.println("What do you want to do?");
            System.out.println("\nnf/<faculty name>/<faculty abbreviation>/<field> - create faculty");
            System.out.println("ss/<student email> - search student and show faculty");
            System.out.println("df - display faculties");
            System.out.println("df/<field> - display all faculties of a field");
            System.out.println("save - manually save data");
            System.out.println("backup - create backup of data");
            System.out.println("\nb - Back");
            System.out.println("q - quit program");
            System.out.println("\nyour input>");

            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equalsIgnoreCase("q")) {
                System.out.println("Saving data...");
                FileManager.saveData(faculties);
                System.out.println("Bye!");
                System.exit(0);
            }
            else if (input.startsWith("nf/")) {
                createFaculty(input);
            }
            else if (input.startsWith("ss/")) {
                searchStudent(input);
            }
            else if (input.equalsIgnoreCase("df")) {
                displayFaculties();
            }
            else if (input.startsWith("df/")) {
                displayFacultiesByField(input);
            }
            else if (input.equalsIgnoreCase("save")) {
                FileManager.saveData(faculties);
            }
            else if (input.equalsIgnoreCase("backup")) {
                FileManager.backupData();
            }
            else if (input.equalsIgnoreCase("b")) {
                return;
            }
            else {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }

    private static void createFaculty(String input) {
        var parts = input.split("/");
        if  (parts.length != 4) {
            System.out.println("Invalid input. Please try again.");
            return;
        }

        var name = parts[1];
        var abbreviation = parts[2];
        var fieldStr = parts[3].toUpperCase();

        try {
            StudyField field = StudyField.valueOf(fieldStr);
            var faculty = new Faculty(name, abbreviation, field);
            faculties.add(faculty);
            System.out.println("Faculty created successfully: " + faculty);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid study field. Available fields: " + Arrays.toString(StudyField.values()));
        }
    }

    private static void searchStudent(String input) {
        var parts = input.split("/");
        if (parts.length != 2) {
            System.out.println("Invalid input. Please try again.");
            return;
        }

        var email = parts[1];

        for (var faculty : faculties) {
            if (faculty.hasStudent(email)) {
                Student student = faculty.findStudentByEmail(email);
                System.out.println("Student found in faculty: " + faculty.getName());
                System.out.println("Student details: " + student);
                return;
            }
        }

        System.out.println("Student not found in any faculty.");
    }

    private static void displayFaculties() {
        if (faculties.isEmpty()) {
            System.out.println("No faculties found.");
            return;
        }

        System.out.println("\nUniversity Faculties:");
        for (Faculty faculty : faculties) {
            System.out.println("- " + faculty);
        }
    }

    private static void displayFacultiesByField(String input) {
        var parts = input.split("/");
        if (parts.length != 2) {
            System.out.println("Invalid format. Use: df/<field>");
            return;
        }

        var fieldStr = parts[1].toUpperCase();

        try {
            var field = StudyField.valueOf(fieldStr);
            boolean found = false;

            System.out.println("\nFaculties in field " + field + ":");
            for (Faculty faculty : faculties) {
                if (faculty.getStudyField() == field) {
                    System.out.println("- " + faculty);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No faculties found in this field.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid study field. Available fields: " + Arrays.toString(StudyField.values()));
        }
    }

    private static void facultyOperations() {
        while (true) {
            System.out.println("\nFaculty Operations");
            System.out.println("What do you want to do?");
            System.out.println("\nns/<faculty abbreviation>/<first name>/<last name>/<email>/<day>/<month>/<year> - create student");
            System.out.println("gs/<email> - (g)raduate (s)tudent");
            System.out.println("ds/<faculty abbreviation> - (d)isplay enrolled (s)tudents");
            System.out.println("dg/<faculty abbreviation> - (d)isplay (g)raduated students");
            System.out.println("bf/<faculty abbreviation>/<email> - check if student (b)elongs to (f)aculty");
            System.out.println("\nb - Back");
            System.out.println("q - Quit Program");
            System.out.print("\nyour input> ");

            var input = scanner.nextLine().trim().toLowerCase();

            if (input.equalsIgnoreCase("b")) {
                return;
            } else if (input.equalsIgnoreCase("q")) {
                System.out.println("Saving data...");
                FileManager.saveData(faculties);
                System.out.println("Goodbye!");
                System.exit(0);
            } else if (input.startsWith("ns/")) {
                createStudent(input);
            } else if (input.startsWith("gs/")) {
                graduateStudent(input);
            } else if (input.startsWith("ds/")) {
                displayEnrolledStudents(input);
            } else if (input.startsWith("dg/")) {
                displayGraduates(input);
            } else if (input.startsWith("bf/")) {
                checkStudentBelongsToFaculty(input);
            } else {
                System.out.println("Invalid command.");
            }
        }
    }

    private static void createStudent(String input) {
        String[] parts = input.split("/");
        if (parts.length != 8) {
            System.out.println("Invalid format. Use: ns/<faculty abbr>/<first>/<last>/<email>/<day>/<month>/<year>");
            return;
        }

        var facultyAbbr = parts[1];
        var firstName = parts[2];
        var lastName = parts[3];
        var email = parts[4];

        Faculty faculty = findFacultyByAbbreviation(facultyAbbr);
        if (faculty == null) {
            System.out.println("Faculty not found.");
            return;
        }

        try {
            var day = Integer.parseInt(parts[5]);
            var month = Integer.parseInt(parts[6]) - 1; // Calendar months are 0-based
            var year = Integer.parseInt(parts[7]);

            var cal = Calendar.getInstance();
            cal.set(year, month, day);
            var birthDate = cal.getTime();

            Student student = new Student(firstName, lastName, email, birthDate);
            faculty.addStudent(student);
            System.out.println("Student created and assigned to " + faculty.getName());
            System.out.println("Student: " + student);
        } catch (NumberFormatException e) {
            System.out.println("Invalid date format.");
        }
    }

    private static void displayEnrolledStudents(String input) {
        String[] parts = input.split("/");
        if (parts.length != 2) {
            System.out.println("Invalid format. Use: ds/<faculty abbreviation>");
            return;
        }

        var abbreviation = parts[1];
        var faculty = findFacultyByAbbreviation(abbreviation);

        if (faculty == null) {
            System.out.println("Faculty not found.");
            return;
        }

        List<Student> enrolled = faculty.getEnrolledStudents();
        if (enrolled.isEmpty()) {
            System.out.println("No enrolled students in " + faculty.getName());
            return;
        }

        System.out.println("\nEnrolled students in " + faculty.getName() + ":");
        for (Student student : enrolled) {
            System.out.println("- " + student);
        }
    }

    private static void displayGraduates(String input) {
        String[] parts = input.split("/");
        if (parts.length != 2) {
            System.out.println("Invalid format. Use: dg/<faculty abbreviation>");
            return;
        }

        var abbreviation = parts[1];
        Faculty faculty = findFacultyByAbbreviation(abbreviation);

        if (faculty == null) {
            System.out.println("Faculty not found.");
            return;
        }

        List<Student> graduates = faculty.getGraduates();
        if (graduates.isEmpty()) {
            System.out.println("No graduates in " + faculty.getName());
            return;
        }

        System.out.println("\nGraduates from " + faculty.getName() + ":");
        for (Student student : graduates) {
            System.out.println("- " + student);
        }
    }

    private static void checkStudentBelongsToFaculty(String input) {
        String[] parts = input.split("/");
        if (parts.length != 3) {
            System.out.println("Invalid format. Use: bf/<faculty abbreviation>/<email>");
            return;
        }

        var abbreviation = parts[1];
        var email = parts[2];

        var faculty = findFacultyByAbbreviation(abbreviation);

        if (faculty == null) {
            System.out.println("Faculty not found.");
            return;
        }

        if (faculty.hasStudent(email)) {
            var student = faculty.findStudentByEmail(email);
            System.out.println("Yes, student belongs to " + faculty.getName());
            System.out.println("Student: " + student);
        } else {
            System.out.println("No, student does not belong to " + faculty.getName());
        }
    }

    private static void graduateStudent(String input) {
        var parts = input.split("/");
        if (parts.length != 2) {
            System.out.println("Invalid format. Use: gs/<email>");
            return;
        }

        var email = parts[1];

        for (Faculty faculty : faculties) {
            var student = faculty.findStudentByEmail(email);
            if (student != null) {
                if (student.isGraduated()) {
                    System.out.println("Student is already graduated.");
                } else {
                    student.setGraduated(true);
                    System.out.println("Student graduated successfully: " + student);
                }
                return;
            }
        }

        System.out.println("Student not found.");
    }

    private static Faculty findFacultyByAbbreviation(String abbreviation) {
        for (var faculty : faculties) {
            if (faculty.getAbbreviation().equalsIgnoreCase(abbreviation)) {
                return faculty;
            }
        }
        return null;
    }

    private static void studentOperations() {
        System.out.println("\nStudent operations (not implemented yet)");
        System.out.println("Press Enter to go back...");
        scanner.nextLine();
    }
}

