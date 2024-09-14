package com.aryajohary.collegedirectory;


import com.aryajohary.collegedirectory.schemas.*;
import com.aryajohary.collegedirectory.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

/***
 * I have used this file to initialize some data in sql for
 * testing purposes. Here i use the respective services to
 * push a list of data items into the sql table
 * ***/



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


    @Bean
    public CommandLineRunner commandLineRunner() {
        return runner -> createCollegeRecords();
    }

    // create and return the list of departments
    private List<Department> createDepartments() {
        Department csDepartment = new Department("Computer Science", "Department of Computer Science");
        Department mathDepartment = new Department("Mathematics", "Department of Mathematics");
        Department physicsDepartment = new Department("Physics", "Department of Physics");
        Department chemistryDepartment = new Department("Chemistry", "Department of Chemistry");

        return List.of(csDepartment, mathDepartment, physicsDepartment, chemistryDepartment);
    }

    // create and return the list of student profiles
    private List<StudentProfile> createStudentProfiles(List<Department> departments) {
        Department csDepartment = departments.get(0);
        Department mathDepartment = departments.get(1);
        Department physicsDepartment = departments.get(2);
        Department chemistryDepartment = departments.get(3);

        StudentProfile studentProfile1 = new StudentProfile(
                "arya_student1",
                "password456",
                Role.STUDENT,
                "Arya Student 1",
                "arya@student1.com",
                "234-567-8901",
                "https://example.com/photos/arya_student1.jpg",
                "2",
                mathDepartment
        );

        StudentProfile studentProfile2 = new StudentProfile(
                "arya_student2",
                "password789",
                Role.STUDENT,
                "Arya Student 2",
                "arya@student2.com",
                "345-678-9012",
                "https://example.com/photos/arya_student2.jpg",
                "1",
                csDepartment
        );

        StudentProfile studentProfile3 = new StudentProfile(
                "arya_student3",
                "password303",
                Role.STUDENT,
                "Arya Student 3",
                "arya@student3.com",
                "789-012-3456",
                "https://example.com/photos/arya_student3.jpg",
                "3",
                chemistryDepartment
        );

        StudentProfile studentProfile4 = new StudentProfile(
                "arya_student4",
                "password404",
                Role.STUDENT,
                "Arya Student 4",
                "arya@student4.com",
                "890-123-4567",
                "https://example.com/photos/arya_student4.jpg",
                "4",
                physicsDepartment
        );

        return List.of(studentProfile1, studentProfile2, studentProfile3, studentProfile4);
    }


    // create and return the list of faculty profiles
    private List<FacultyProfile> createFacultyProfiles(List<Department> departments) {
        Department csDepartment = departments.get(0);
        Department chemistryDepartment = departments.get(3);
        Department mathDepartment = departments.get(1);

        FacultyProfile facultyProfile1 = new FacultyProfile(
                "arya_faculty1",
                "password123",
                Role.FACULTY_MEMBER,
                "Arya Faculty 1",
                "arya@faculty1.com",
                "123-456-7890",
                "https://example.com/photos/arya_faculty1.jpg",
                chemistryDepartment,
                "9 AM - 5 PM"
        );

        FacultyProfile facultyProfile2 = new FacultyProfile(
                "arya_faculty2",
                "password101",
                Role.FACULTY_MEMBER,
                "Arya Faculty 2",
                "arya@faculty2.com",
                "567-890-1234",
                "https://example.com/photos/arya_faculty2.jpg",
                csDepartment,
                "10 AM - 4 PM"
        );

        FacultyProfile facultyProfile3 = new FacultyProfile(
                "arya_faculty3",
                "password202",
                Role.FACULTY_MEMBER,
                "Arya Faculty 3",
                "arya@faculty3.com",
                "678-901-2345",
                "https://example.com/photos/arya_faculty3.jpg",
                mathDepartment,
                "11 AM - 3 PM"
        );

        return List.of(facultyProfile1, facultyProfile2, facultyProfile3);
    }


    // create and return the list of administrator profiles
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

    // create and return the list of courses
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

    // create and return the list of enrollments
    private List<Enrollment> createEnrollments(List<StudentProfile> students, List<Course> courses) {
        Enrollment enrollment1 = new Enrollment(students.get(0), courses.get(1));
        Enrollment enrollment2 = new Enrollment(students.get(1), courses.get(0));
        Enrollment enrollment3 = new Enrollment(students.get(2), courses.get(2));
        Enrollment enrollment4 = new Enrollment(students.get(3), courses.get(3));

        return List.of(enrollment1, enrollment2, enrollment3, enrollment4);
    }

    // main method to organize the creation process
    public void createCollegeRecords() {

        // below i created lists for data to be inserted in sql database

        List<Department> departmentList = createDepartments();
        List<StudentProfile> studentProfiles = createStudentProfiles(departmentList);
        List<FacultyProfile> facultyProfiles = createFacultyProfiles(departmentList);
        List<AdministratorProfile> administratorProfiles = createAdministratorProfiles(departmentList);
        List<Course> courseList = createCourses(facultyProfiles, departmentList);
        List<Enrollment> enrollmentList = createEnrollments(studentProfiles, courseList);

        // now using the services to actually insert the data

        departmentService.saveAll(departmentList);
        studentProfileService.saveAll(studentProfiles);
        facultyProfileService.saveAll(facultyProfiles);
        administratorProfileService.saveAll(administratorProfiles);
        courseService.saveAll(courseList);
        enrollmentService.saveAll(enrollmentList);

    }


}
