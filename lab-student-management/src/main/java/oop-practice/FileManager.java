import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

class FileManager {
    private static final String DATA_FILE = "lab-student-management/src/main/java/oop-practice/university_data.txt";
    private static final String DELIMITER = "|";
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static boolean saveData(List<Faculty> faculties) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_FILE))) {
            // Write header
            writer.write("# University Management System Data File\n");
            writer.write("# Format: FACULTY|name|abbreviation|studyField\n");
            writer.write("# Format: STUDENT|firstName|lastName|email|enrollmentDate|dateOfBirth|graduated\n");
            writer.write("# ============================================\n");

            for (Faculty faculty : faculties) {
                // write faculty line
                writer.write("FACULTY" + DELIMITER);
                writer.write(faculty.getName() + DELIMITER);
                writer.write(faculty.getAbbreviation() + DELIMITER);
                writer.write(faculty.getStudyField().name());
                writer.write("\n");

                // write all students for this faculty
                for (Student student : faculty.getStudents()) {
                    writer.write("STUDENT" + DELIMITER);
                    writer.write(student.getFirstName() + DELIMITER);
                    writer.write(student.getLastName() + DELIMITER);
                    writer.write(student.getEmail() + DELIMITER);
                    writer.write(sdf.format(student.getEnrollmentDate()) + DELIMITER);
                    writer.write(sdf.format(student.getDateOfBirth()) + DELIMITER);
                    writer.write(student.isGraduated() ? "true" : "false");
                    writer.write("\n");
                }
            }

            System.out.println("Data saved successfully to " + DATA_FILE);
            return true;

        } catch (IOException e) {
            System.err.println("Error saving data: " + e.getMessage());
            return false;
        }
    }

    public static List<Faculty> loadData() {
        List<Faculty> faculties = new ArrayList<>();
        File file = new File(DATA_FILE);

        // if file doesn't exist, return empty list
        if (!file.exists()) {
            System.out.println("No saved data found. Starting fresh.");
            return faculties;
        }

        Faculty currentFaculty = null;
        int facultyCount = 0;
        int studentCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE))) {
            String line;

            while ((line = reader.readLine()) != null) {
                // skip comments and empty lines
                if (line.trim().isEmpty() || line.startsWith("#")) {
                    continue;
                }

                String[] parts = line.split("\\" + DELIMITER);

                if (parts[0].equals("FACULTY")) {
                    // parse faculty: FACULTY|name|abbreviation|studyField
                    if (parts.length >= 4) {
                        String name = parts[1];
                        String abbreviation = parts[2];
                        StudyField studyField = StudyField.valueOf(parts[3]);

                        currentFaculty = new Faculty(name, abbreviation, studyField);
                        faculties.add(currentFaculty);
                        facultyCount++;
                    }
                } else if (parts[0].equals("STUDENT")) {
                    // parse student: STUDENT|firstName|lastName|email|enrollmentDate|dateOfBirth|graduated
                    if (parts.length >= 7 && currentFaculty != null) {
                        String firstName = parts[1];
                        String lastName = parts[2];
                        String email = parts[3];
                        Date enrollmentDate = sdf.parse(parts[4]);
                        Date dateOfBirth = sdf.parse(parts[5]);
                        boolean graduated = Boolean.parseBoolean(parts[6]);

                        // create student with custom enrollment date
                        Student student = new Student(firstName, lastName, email, dateOfBirth);
                        // use reflection or add a setter to restore enrollment date
                        student.setEnrollmentDate(enrollmentDate);
                        student.setGraduated(graduated);

                        currentFaculty.addStudent(student);
                        studentCount++;
                    }
                }
            }

            System.out.println("Data loaded successfully:");
            System.out.println("- " + facultyCount + " faculties");
            System.out.println("- " + studentCount + " students");

        } catch (IOException e) {
            System.err.println("Error loading data: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error parsing data: " + e.getMessage());
        }

        return faculties;
    }

    public static boolean backupData() {
        File source = new File(DATA_FILE);
        if (!source.exists()) {
            return false;
        }

        String backupName = "university_data_backup_" +
                new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".txt";
        File backup = new File(backupName);

        try (FileInputStream in = new FileInputStream(source);
             FileOutputStream out = new FileOutputStream(backup)) {

            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }

            System.out.println("Backup created: " + backupName);
            return true;

        } catch (IOException e) {
            System.err.println("Error creating backup: " + e.getMessage());
            return false;
        }
    }

    public static boolean dataExists() {
        return new File(DATA_FILE).exists();
    }

    public static boolean deleteData() {
        File file = new File(DATA_FILE);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }
}