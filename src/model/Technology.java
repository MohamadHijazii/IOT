package model;

import java.util.ArrayList;

public class Technology {

    String name;
    Det range;
    String[] topology;
    Det batteryLife;
    boolean security;
    Det simplicity;
    Det cost;
    Det latency;
    String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    private String topos;
    public int accuracy;

    public int getAccuracy() {
        return accuracy;
    }


    public void setAccuracy(int a){
        this.accuracy = a;
    }
    public String getTopos() {
        return topos;
    }

    public void setTopos() {
        topos  = arrayString();
    }

    private static String sep = "---";

    public Technology(String name, Det range, String[] topology, Det batteryLife, boolean security, Det simplicity, Det cost, Det latency) {
        this.name = name;
        this.range = range;
        this.topology = topology;
        this.batteryLife = batteryLife;
        this.security = security;
        this.simplicity = simplicity;
        this.cost = cost;
        this.latency = latency;
        setTopos();
        DB db = DB.instance();
        db.addTech(this);
    }


    protected Technology(Det range, String[] topology, Det batteryLife, boolean security, Det simplicity, Det cost, Det latency) {
        name = "search";
        this.range = range;
        this.topology = topology;
        this.batteryLife = batteryLife;
        this.security = security;
        this.simplicity = simplicity;
        this.cost = cost;
        this.latency = latency;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Det getRange() {
        return range;
    }

    public void setRange(Det range) {
        this.range = range;
    }

    public String[] getTopology() {
        return topology;
    }

    public void setTopology(String[] topology) {
        this.topology = topology;
    }

    public Det getBatteryLife() {
        return batteryLife;
    }

    public void setBatteryLife(Det batteryLife) {
        this.batteryLife = batteryLife;
    }

    public boolean isSecurity() {
        return security;
    }

    public void setSecurity(boolean security) {
        this.security = security;
    }

    public Det getSimplicity() {
        return simplicity;
    }

    public void setSimplicity(Det simplicity) {
        this.simplicity = simplicity;
    }

    public Det getCost() {
        return cost;
    }

    public void setCost(Det cost) {
        this.cost = cost;
    }

    public Det getLatency() {
        return latency;
    }

    public void setLatency(Det latency) {
        this.latency = latency;
    }


    public void setAccuracy(Technology t){
        int perc = 100/6;
        if(t.range != null && this.range.value!= t.range.value) accuracy -= perc;
        if(t.batteryLife!= null && this.batteryLife.value != t.batteryLife.value) accuracy -= perc;
        if(this.security != t.security) accuracy -= perc;
        if(t.simplicity != null && this.simplicity.value != t.simplicity.value) accuracy -= perc;
        if(t.cost!= null && this.cost.value != t.cost.value) accuracy -= perc;
        if(t.latency!=null && this.latency.value != t.latency.value) accuracy -= perc;
    }

    public boolean acceptV2(Technology t){
        boolean ret = true;
        ret &= t.range.accepted(this.range);
        ret &= t.batteryLife.accepted(this.batteryLife);
        ret &= t.simplicity.accepted(this.simplicity);
        ret &= t.cost.accepted(this.cost);
        ret &= t.latency.accepted(this.latency);
        ret &= (t.security || (!t.security&&!this.security));
        ret &= (contain(t.topology,this.topology[0]) || this.topology[0] == null);
        return ret;
    }

    private boolean contain(String []t,String s){
        for (int i = 0; i < t.length; i++) {
            if(t[i].equals(s))
                return true;
        }
        return false;
    }


    @Override
    public String toString() {
        return "Technology{" +
                "name='" + name + '\'' +
                ", range='" + range + '\'' +
                ", topology='" + topos + '\'' +
                ", batteryLife='" + batteryLife + '\'' +
                ", security=" + security +'\''+
                ", simplicity='" + simplicity + '\'' +
                ", cost=" + cost + '\''+
                ", latency='" + latency + '\'' +
                '}';
    }


    public String toDBFormat() {

        final StringBuffer sb = new StringBuffer("");
        sb.append(name).append(sep);
        sb.append(range).append(sep);
        sb.append(arrayString()).append(sep);
        sb.append(batteryLife).append(sep);
        sb.append(security).append(sep);
        sb.append(simplicity).append(sep);
        sb.append(cost).append(sep);
        sb.append(latency).append(sep);
        sb.append(image);
        sb.append('\n');
        return sb.toString();
    }

    private String arrayString(){
        String ret = "";
        for (int i=0;i<topology.length;i++){
            ret+=topology[i];
            if(i != topology.length-1)
                ret+=",";
        }
        return ret;
    }

    private String[] toStringArray(String s){
        return s.split(",");
    }

    public Technology(String string){
        String []s = string.split(sep);
        setName(s[0]);
        setRange(new Det(s[1]));
        setTopology(toStringArray(s[2]));
        setBatteryLife(new Det(s[3]));
        setSecurity(s[4].equals("true"));
        setSimplicity(new Det(s[5]));
        setCost(new Det(s[6]));
        setLatency(new Det(s[7]));
        setImage(s[8]);
        setTopos();

    }

}
