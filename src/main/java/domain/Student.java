package domain;

import json.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class Student extends BasicStudent {

    private Tuple<String, Integer>[] exams;
    public Student(String name, String surname, Integer year, Tuple<String, Integer>... exams) {
        super(name, surname, year);
        this.exams = exams;

    }
    @Override
    public JsonObject toJsonObject() {
        JsonObject res = super.toJsonObject();
        
        JsonObject jExam = new JsonObject();
        for(Tuple<String, Integer> exam: exams){
            jExams.add(new JsonPair(exam.key,new JsonNumber(exam.value)));
        }
        res.add(new JsonPair("exams", jExams));
        return res;
    }
}
