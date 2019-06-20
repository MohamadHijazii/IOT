package model;

public class Det {

    String name;
    int value;

    public Det(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public boolean accepted(Det other){
        return other.value <= this.value;
    }

    @Override
    public String toString(){
        return name+","+value;
    }

}
