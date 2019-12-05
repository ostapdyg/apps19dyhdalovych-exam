package domain;

import json.*;

import java.util.Arrays;
import java.util.LinkedList;
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
        
        LinkedList<JsonObject> lExams = new LinkedList<JsonObject>();

        for(Tuple<String, Integer> exam: exams){
            JsonObject jExam = new JsonObject();
            jExam.add(new JsonPair("course", new JsonString(exam.key)));
            jExam.add(new JsonPair("mark", new JsonNumber(exam.value)));
            jExam.add(new JsonPair("passed", new JsonBoolean(exam.value>2)));
            lExams.add(jExam);
        }
        res.add(new JsonPair("exams", new JsonArray(lExams.toArray(new Json[0]))));
        return res;
    }
}
