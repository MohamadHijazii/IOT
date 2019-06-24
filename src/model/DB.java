package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class DB {

    private static DB db = null;
    public static ArrayList<Technology> technologies;


    private DB(){

    }

    public static DB instance(){
        if(db == null)
            db = new DB();
        return db;
    }

    public void WriteTech(){

        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("saves/tech"));
            for (Technology t:technologies) {
                out.write(t.toDBFormat());
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeTech(Technology t){
        technologies.remove(t);
    }

    public void ReadTech(){

        technologies = new ArrayList<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader("saves/tech"));
            String s;
            while ((s = in.readLine()) != null){
                technologies.add(new Technology(s));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void addTech(Technology technology){
        if(technologies ==null)
            technologies = new ArrayList<>();
        technologies.add(technology);
    }

    public void readDetails(){
        Details d = Details.get_instance();
        try{
            BufferedReader in = new BufferedReader(new FileReader("saves/details"));
            d.setRange(fromDBFormat(in.readLine()));
            String s = in.readLine();
            d.setTopology(s.split(" "));
            d.setBtteryLife(fromDBFormat(in.readLine()));
            d.setSimplicity(fromDBFormat(in.readLine()));
            d.setCost(fromDBFormat(in.readLine()));
            d.setLatency(fromDBFormat(in.readLine()));
        }catch (Exception e){}
    }

    private String getDBFormat(ArrayList<Det> ld){
        String ret = "-";

        for (Det d : ld) {
            ret += " ";
            ret += d.toString();
        }
        return ret+"\n";
    }

    private ArrayList<Det> fromDBFormat(String line){
        ArrayList<Det> ld = new ArrayList<>();
        String []details = line.split(" ");
        for(int i=1;i<details.length;i++){
            String [] detail = details[i].split(",");
            int val = Integer.parseInt(detail[1]);
            ld.add(new Det(detail[0],val));
        }
        return ld;
    }

    public void writeDetails(){
        Details d = Details.get_instance();
        try{
            BufferedWriter out = new BufferedWriter(new FileWriter("saves/details"));
            out.write(getDBFormat(d.getRange()));
            for (int i=0;i<d.getTopology().length;i++){
                out.write(d.getTopology()[i]);
                out.write(" ");
            }
            out.write("\n");
            out.write(getDBFormat(d.getBtteryLife()));
            out.write(getDBFormat(d.getSimplicity()));
            out.write(getDBFormat(d.getCost()));
            out.write(getDBFormat(d.getLatency()));
            out.close();
        }catch (Exception e){e.printStackTrace();}
    }
}
