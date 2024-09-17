# College Directory Application

## Tasks I Finished

- Set up Spring Boot Hibernate JPA with proper table schema implementation.
- Set up all the relationships among various tables as mentioned in the assignment.
- Secured all the endpoints with Spring Security.
- Ensured that only authorized users can access certain functionalities.
- Role-based access control for advanced security.

## Student Functionalities Implemented

- Fetch and display student profile details.
- Fetch and display faculty advisors' details related to a given student from the database.
- CRUD operations available to only **STUDENT** and **ADMINISTRATOR**.

## Faculty Member Functionalities Implemented

- Fetch and display class list from the database. It will contain a list of all students being taught by that faculty member.
- CRUD operations available to only **FACULTY_MEMBER** and **ADMINISTRATOR**.

## Administrator Functionalities Implemented

- CRUD operations for all the **STUDENT**, **FACULTY_MEMBER**, and **ADMINISTRATOR** roles.

## API Endpoints Available

### For StudentProfile

- `GET     /studentProfiles` – List all students.
- `POST    /studentProfiles` – Create student.
- `PUT     /studentProfiles/{id}` – Update a student using ID.
- `GET     /studentProfiles/{id}` – Get a single student detail.
- `DELETE  /studentProfiles/{id}` – Delete student using ID.
- `GET     /studentProfiles/listFaculty/{id}` – List all faculties teaching that student.

### For FacultyProfile

- `GET     /facultyProfiles` – List all faculties.
- `POST    /facultyProfiles` – Create faculty.
- `PUT     /facultyProfiles/{id}` – Update a faculty using ID.
- `GET     /facultyProfiles/{id}` – Get a single faculty detail.
- `DELETE  /facultyProfiles/{id}` – Delete faculty using ID.
- `GET     /facultyProfiles/listStudents/{id}` – List all students being taught by that faculty.

### For AdministratorProfile

- `GET     /administratorProfiles` – List all admins.
- `POST    /administratorProfiles` – Create admin.
- `PUT     /administratorProfiles/{id}` – Update an admin using ID.
- `GET     /administratorProfiles/{id}` – Get a single admin detail.
- `DELETE  /administratorProfiles/{id}` – Delete admin using ID.
- All endpoints present in **StudentProfile** and **FacultyProfile** are also available to **AdministratorProfile**.


---

