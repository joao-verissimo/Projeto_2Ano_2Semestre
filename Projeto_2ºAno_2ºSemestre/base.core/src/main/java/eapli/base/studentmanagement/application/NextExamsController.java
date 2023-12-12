package eapli.base.studentmanagement.application;

import eapli.base.exammanagement.domain.Exam;
import eapli.base.studentmanagement.domain.Student;
import org.springframework.data.util.Pair;

import java.util.List;

public class NextExamsController {

    NextExamsService examsSvc = new NextExamsService();


    public Iterable<Exam> nextExams(Student student){
        return examsSvc.nextExams(student);
    }


}
