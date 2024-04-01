package validation;

import domain.Tema;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TemaValidatorTest {

    @Test
    public void addAssignment(){
        Validator<Tema> validator = new TemaValidator();

        Tema t1 = new Tema("", "descr1", 5, 2);
        Tema t2 = new Tema("2", "", 5, 2);
        Tema t3 = new Tema("3", "descr3", 0, 2);
        Tema t4 = new Tema("3", "descr3", 5, 0);
        Tema t5 = new Tema("3", "descr3", 5, 4);

        assertThrows(ValidationException.class, () -> {validator.validate(t1);});
        assertThrows(ValidationException.class, () -> {validator.validate(t2);});
        assertThrows(ValidationException.class, () -> {validator.validate(t3);});
        assertThrows(ValidationException.class, () -> {validator.validate(t4);});
        assertDoesNotThrow(()->{validator.validate(t5);});
    }

}