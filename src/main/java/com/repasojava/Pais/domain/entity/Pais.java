package com.repasojava.Pais.domain.entity;
import java.text.*;
public class Pais {
    private Long id;
    private String name;

    
    public Pais() {
    }
    
    
    public Pais(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        String data = MessageFormat.format("Id :{0}\nName :{1}",this.id,this.name);
        return data;
    }

    
}
