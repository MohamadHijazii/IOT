package model;

import java.util.ArrayList;

public class Details {

    private ArrayList<Det> range;
    private ArrayList<Det> topology;
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

    public ArrayList<Det> getTopology() {
        return topology;
    }

    public void setTopology(ArrayList<Det> topology) {
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
        range.add(new Det("test",1));
        range.add(new Det("brain",2));
        topology = new ArrayList<>();
        topology.add(new Det("nigga",5));
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
