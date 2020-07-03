package org.fasttrackit.domain;

public class RecreationActivity{

   private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RecreationActivity{" +
                "name='" + name + '\'' +
                '}';
    }
}
