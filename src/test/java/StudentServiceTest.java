import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @Test
    void findById_shouldThrowException_whenIdDoesNotExist() {
        StudentService studentService = new StudentService();
        assertThrows(IdNotFoundException.class, ()-> studentService.getById("2"));
    }
    @Test
    void findById_shouldNotThrowException_whenIdExists() {
        StudentService studentService = new StudentService();
        studentService.addNewStudent(new Student("","John", "math"));
        Student found = studentService.getAllStudents().get(0);
        String id = found.id();
        assertDoesNotThrow(()-> studentService.getById(id));
    }
    @Test
    void findById_shouldReturnCorrectStudent_whenIdExists() throws IdNotFoundException {
        StudentService studentService = new StudentService();
        studentService.addNewStudent(Student.builder().name("Jane").build());
        studentService.addNewStudent(Student.builder().name("Bob").build());
        studentService.addNewStudent(Student.builder().name("John").build());
        Student found = studentService.getAllStudents().get(1);
        System.out.println(studentService.getAllStudents());
        String id = found.id();
        assertEquals(found, studentService.getById(found.id()));
        System.out.println((found) + ", " + id);
    }
}