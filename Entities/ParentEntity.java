package ObjectOrientedProgramming.OOPDemo.Entities;

import java.util.UUID;

public class ParentEntity {
    private UUID id;
    private String name;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void displayByName(String name){
        this.name=name;
    }

    @Override
    public String toString() {
        return "ParentEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
