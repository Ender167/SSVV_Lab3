package validation;
import domain.Tema;

public class TemaValidator implements Validator<Tema> {
    public void validate(Tema tema) throws ValidationException { //1
        if (tema.getID() == null || tema.getID().equals("")) { //2
            throw new ValidationException("ID invalid! \n"); //3
        }
        if (tema.getDescriere() == null || tema.getDescriere().equals("")) { //4
            throw new ValidationException("Descriere invalida! \n"); //5
        }
        if (tema.getDeadline() < 1 || tema.getDeadline() > 14 || tema.getDeadline() < tema.getStartline()) { //6
            throw new ValidationException("Deadline invalid! \n"); // 7
        }
        if (tema.getStartline() < 1 || tema.getStartline() > 14 || tema.getStartline() > tema.getDeadline()) { //8
            throw new ValidationException("Data de primire invalida! \n");//9
        }
    }// 10
}

