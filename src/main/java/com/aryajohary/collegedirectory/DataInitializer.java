package com.aryajohary.collegedirectory;


import com.aryajohary.collegedirectory.repos.DepartmentRepository;
import com.aryajohary.collegedirectory.schemas.*;
import com.aryajohary.collegedirectory.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private StudentProfileService studentProfileService;

    @Autowired
    private FacultyProfileService facultyProfileService;

    @Autowired
    private AdministratorProfileService administratorProfileService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private EnrollmentService enrollmentService;
    @Autowired
    private DepartmentRepository departmentRepository;

    @Bean
    public CommandLineRunner commandLineRunner() {
        return runner ->
        {
            createCollegeRecords();
        };
    }

    // Method to create and return the list of departments
    private List<Department> createDepartments() {
        Department csDepartment = new Department("Computer Science", "Department of Computer Science");
        Department mathDepartment = new Department("Mathematics", "Department of Mathematics");
        Department physicsDepartment = new Department("Physics", "Department of Physics");
        Department chemistryDepartment = new Department("Chemistry", "Department of Chemistry");

        return List.of(csDepartment, mathDepartment, physicsDepartment, chemistryDepartment);
    }

    // Method to create and return the list of student profiles
    private List<StudentProfile> createStudentProfiles(List<Department> departments) {
        Department csDepartment = departments.get(0);
        Department mathDepartment = departments.get(1);
        Department physicsDepartment = departments.get(2);
        Department chemistryDepartment = departments.get(3);

        StudentProfile studentProfile1 = new StudentProfile(
                "asmith",
                "password456",
                Role.STUDENT,
                "Alice Smith",
                "asmith@example.com",
                "234-567-8901",
                "https://example.com/photos/asmith.jpg",
                "Sophomore",
                mathDepartment
        );

        StudentProfile studentProfile2 = new StudentProfile(
                "bjohnson",
                "password789",
                Role.STUDENT,
                "Bob Johnson",
                "bjohnson@example.com",
                "345-678-9012",
                "https://example.com/photos/bjohnson.jpg",
                "Freshman",
                csDepartment
        );

        StudentProfile studentProfile3 = new StudentProfile(
                "cclark",
                "password303",
                Role.STUDENT,
                "Charlie Clark",
                "cclark@example.com",
                "789-012-3456",
                "https://example.com/photos/cclark.jpg",
                "Junior",
                chemistryDepartment
        );

        StudentProfile studentProfile4 = new StudentProfile(
                "dperry",
                "password404",
                Role.STUDENT,
                "Dana Perry",
                "dperry@example.com",
                "890-123-4567",
                "https://example.com/photos/dperry.jpg",
                "Senior",
                physicsDepartment
        );

        return List.of(studentProfile1, studentProfile2, studentProfile3, studentProfile4);
    }

    // Method to create and return the list of faculty profiles
    private List<FacultyProfile> createFacultyProfiles(List<Department> departments) {
        Department csDepartment = departments.get(0);
        Department chemistryDepartment = departments.get(3);
        Department mathDepartment = departments.get(1);

        FacultyProfile facultyProfile1 = new FacultyProfile(
                "jdoe",
                "password123",
                Role.FACULTY_MEMBER,
                "John Doe",
                "jdoe@example.com",
                "123-456-7890",
                "https://example.com/photos/jdoe.jpg",
                chemistryDepartment,
                "9 AM - 5 PM"
        );

        FacultyProfile facultyProfile2 = new FacultyProfile(
                "mbrown",
                "password101",
                Role.FACULTY_MEMBER,
                "Mary Brown",
                "mbrown@example.com",
                "567-890-1234",
                "https://example.com/photos/mbrown.jpg",
                csDepartment,
                "10 AM - 4 PM"
        );

        FacultyProfile facultyProfile3 = new FacultyProfile(
                "rwhite",
                "password202",
                Role.FACULTY_MEMBER,
                "Richard White",
                "rwhite@example.com",
                "678-901-2345",
                "https://example.com/photos/rwhite.jpg",
                mathDepartment,
                "11 AM - 3 PM"
        );

        return List.of(facultyProfile1, facultyProfile2, facultyProfile3);
    }

    // Method to create and return the list of administrator profiles
    private List<AdministratorProfile> createAdministratorProfiles(List<Department> departments) {
        Department csDepartment = departments.get(0);
        Department physicsDepartment = departments.get(2);
        Department chemistryDepartment = departments.get(3);

        AdministratorProfile adminProfile = new AdministratorProfile(
                "adminuser",
                "adminpass",
                Role.ADMINISTRATOR,
                "Admin User",
                "adminuser@example.com",
                "456-789-0123",
                "https://example.com/photos/adminuser.jpg",
                csDepartment
        );

        AdministratorProfile adminProfile2 = new AdministratorProfile(
                "admin2",
                "adminpass2",
                Role.ADMINISTRATOR,
                "Admin Two",
                "admin2@example.com",
                "567-890-1234",
                "https://example.com/photos/admin2.jpg",
                physicsDepartment
        );

        AdministratorProfile adminProfile3 = new AdministratorProfile(
                "admin3",
                "adminpass3",
                Role.ADMINISTRATOR,
                "Admin Three",
                "admin3@example.com",
                "678-901-2345",
                "https://example.com/photos/admin3.jpg",
                chemistryDepartment
        );

        return List.of(adminProfile, adminProfile2, adminProfile3);
    }

    // Method to create and return the list of courses
    private List<Course> createCourses(List<FacultyProfile> facultyProfiles, List<Department> departments) {
        Department csDepartment = departments.get(0);
        Department mathDepartment = departments.get(1);
        Department chemistryDepartment = departments.get(3);
        Department physicsDepartment = departments.get(2);

        FacultyProfile facultyProfile1 = facultyProfiles.get(1);
        FacultyProfile facultyProfile2 = facultyProfiles.get(0);
        FacultyProfile facultyProfile3 = facultyProfiles.get(2);

        Course course1 = new Course(
                "Introduction to Programming",
                "Basics of programming using Python",
                csDepartment,
                facultyProfile1
        );

        Course course2 = new Course(
                "Linear Algebra",
                "Study of linear algebra concepts",
                mathDepartment,
                facultyProfile3
        );

        Course course3 = new Course(
                "Organic Chemistry",
                "Study of organic compounds and reactions",
                chemistryDepartment,
                facultyProfile2
        );

        Course course4 = new Course(
                "Thermodynamics",
                "Study of energy and heat transfer",
                physicsDepartment,
                facultyProfile3
        );

        return List.of(course1, course2, course3, course4);
    }

    // Method to create and return the list of enrollments
    private List<Enrollment> createEnrollments(List<StudentProfile> students, List<Course> courses) {
        Enrollment enrollment1 = new Enrollment(students.get(0), courses.get(1)); // Alice takes Linear Algebra
        Enrollment enrollment2 = new Enrollment(students.get(1), courses.get(0)); // Bob takes Programming
        Enrollment enrollment3 = new Enrollment(students.get(2), courses.get(2)); // Charlie takes Organic Chemistry
        Enrollment enrollment4 = new Enrollment(students.get(3), courses.get(3)); // Dana takes Thermodynamics

        return List.of(enrollment1, enrollment2, enrollment3, enrollment4);
    }

    // Main method to organize the creation process
    public void createCollegeRecords() {
        List<Department> departmentList = createDepartments();
        List<StudentProfile> studentProfiles = createStudentProfiles(departmentList);
        List<FacultyProfile> facultyProfiles = createFacultyProfiles(departmentList);
        List<AdministratorProfile> administratorProfiles = createAdministratorProfiles(departmentList);
        List<Course> courseList = createCourses(facultyProfiles, departmentList);
        List<Enrollment> enrollmentList = createEnrollments(studentProfiles, courseList);

        departmentService.saveAll(departmentList);
        studentProfileService.saveAll(studentProfiles);
        facultyProfileService.saveAll(facultyProfiles);
        administratorProfileService.saveAll(administratorProfiles);
        courseService.saveAll(courseList);
        enrollmentService.saveAll(enrollmentList);

    }


}
