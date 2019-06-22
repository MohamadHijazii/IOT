package model;

import javax.swing.*;
import java.util.ArrayList;

public class Details {

    private ArrayList<Det> range;
    private String[] topology;
    private ArrayList<Det> btteryLife;
    private ArrayList<Det> simplicity;
    private ArrayList<Det> cost;
    private ArrayList<Det> latency;
    private static Details _instance = null;


    public ArrayList<Det> getRange() {
        return range;
    }

    public void setRange(ArrayList<Det> range) {
        this.range = range;
    }

    public String[] getTopology() {
        return topology;
    }

    public void setTopology(String[] topology) {
        this.topology = topology;
    }

    public ArrayList<Det> getBtteryLife() {
        return btteryLife;
    }

    public void setBtteryLife(ArrayList<Det> btteryLife) {
        this.btteryLife = btteryLife;
    }


    public ArrayList<Det> getSimplicity() {
        return simplicity;
    }

    public void setSimplicity(ArrayList<Det> simplicity) {
        this.simplicity = simplicity;
    }

    public ArrayList<Det> getCost() {
        return cost;
    }

    public void setCost(ArrayList<Det> cost) {
        this.cost = cost;
    }

    public ArrayList<Det> getLatency() {
        return latency;
    }

    public void setLatency(ArrayList<Det> latency) {
        this.latency = latency;
    }


    private Details(){
        DB db = DB.instance();
        range = new ArrayList<>();
        topology = new String[]{};
        btteryLife = new ArrayList<>();
        simplicity = new ArrayList<>();
        cost = new ArrayList<>();
        latency = new ArrayList<>();

    }

    public static Details get_instance(){
        if(_instance == null)
            _instance = new Details();
        return _instance;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Details{");
        sb.append("range=").append(range);
        sb.append(", topology=").append(topology);
        sb.append(", btteryLife=").append(btteryLife);
        sb.append(", simplicity=").append(simplicity);
        sb.append(", cost=").append(cost);
        sb.append(", latency=").append(latency);
        sb.append('}');
        return sb.toString();
    }
}
