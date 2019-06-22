package model;

public class Det {

    String name;
    int value;

    public Det(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public boolean accepted(Det other){
        if(other == null)
            return true;
        return other.value <= this.value;
    }

    public Det(String s){
        String []sp = s.split(",");
        name = sp[0];
        value = Integer.parseInt(sp[1]);
    }
    @Override
    public String toString(){
        return name+","+value;
    }

}
