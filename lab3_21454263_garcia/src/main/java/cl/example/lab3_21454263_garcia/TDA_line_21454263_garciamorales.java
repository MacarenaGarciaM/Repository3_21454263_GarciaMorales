package cl.example.lab3_21454263_garcia;

import java.util.ArrayList;
import java.util.List;

public class TDA_line_21454263_garciamorales {
    int id;
    String name;
    String railType;
    List<TDA_section_21454263_garciamorales> sections;

    public TDA_line_21454263_garciamorales (int id,String name, String railType, List<TDA_section_21454263_garciamorales> section){
        this.id = id;
        this.name = name;
        this.railType = railType;
        this.sections = section;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getRailType() {
        return railType;
    }

    public List<TDA_section_21454263_garciamorales> getSections() {
        return sections;
    }
}
