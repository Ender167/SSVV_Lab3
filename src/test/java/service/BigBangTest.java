package service;

import domain.Nota;
import domain.Student;
import domain.Tema;
import org.junit.Test;
import repository.NotaXMLRepository;
import repository.StudentXMLRepository;
import repository.TemaXMLRepository;
import validation.*;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BigBangTest {
    @Test
    public void addStudent() {

        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();
        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);
        String n = "nume";
        String id = "1";

        assert service.saveStudent(id, n, 111) == 0;
        assert service.saveStudent(id, n, 110) == 1;
        assert service.saveStudent(id, n, 200) == 0;
        assert service.saveStudent(id, n, 937) == 0;
        assert service.saveStudent(id, n, 938) == 1;

    }
    @Test
    public void addAssignment(){
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();
        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);

        Tema t1 = new Tema("", "descr1", 5, 2);
        Tema t2 = new Tema("2", "", 5, 2);
        Tema t3 = new Tema("3", "descr3", 0, 2);
        Tema t4 = new Tema("3", "descr3", 5, 0);
        Tema t5 = new Tema("3", "descr3", 5, 4);

        assert service.saveTema(t1.getID(), t1.getDescriere(), t1.getDeadline(), t1.getStartline()) == 1;
        assert service.saveTema(t5.getID(), t5.getDescriere(), t5.getDeadline(), t5.getStartline()) == 0;
    }

    @Test
    public void addGrade(){
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();
        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);

        Tema t5 = new Tema("36", "descr3", 5, 3);

        String n = "nume";
        String id = "1";

        service.saveStudent(id, n, 111);
        service.saveTema(t5.getID(), t5.getDescriere(), t5.getDeadline(), t5.getStartline());

        assert service.saveNota(id, t5.getID(), 8, 5, "Good") == 0;
    }

    @Test
    public void addAssignmentStudent(){
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();
        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);

        Tema t5 = new Tema("36", "descr3", 5, 3);

        String n = "nume";
        String id = "1";

        assert service.saveStudent(id, n, 111) == 0;
        assert service.saveTema(t5.getID(), t5.getDescriere(), t5.getDeadline(), t5.getStartline()) == 0;
    }
}
