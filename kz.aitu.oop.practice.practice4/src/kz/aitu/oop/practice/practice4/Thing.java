package kz.aitu.oop.practice.practice4;

public class Thing {
    private String name;
    public Thing(String name){
        this.name = name;
    }
    @Override
    public String toString(){
        return name;
    }
}
