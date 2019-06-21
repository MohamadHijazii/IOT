package model;

public class Technology {

    String name;
    Det range;
    Det topology;
    Det batteryLife;
    boolean security;
    Det simplicity;
    Det cost;
    Det latency;
    private static String sep = "---";

    public Technology(String name, Det range, Det topology, Det batteryLife, boolean security, Det simplicity, Det cost, Det latency) {
        this.name = name;
        this.range = range;
        this.topology = topology;
        this.batteryLife = batteryLife;
        this.security = security;
        this.simplicity = simplicity;
        this.cost = cost;
        this.latency = latency;
        DB db = DB.instance();
        db.addTech(this);
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

    public Det getTopology() {
        return topology;
    }

    public void setTopology(Det topology) {
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



    @Override
    public String toString() {
        return "Technology{" +
                "name='" + name + '\'' +
                ", range='" + range + '\'' +
                ", topology='" + topology + '\'' +
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
        sb.append(topology).append(sep);
        sb.append(batteryLife).append(sep);
        sb.append(security).append(sep);
        sb.append(simplicity).append(sep);
        sb.append(cost).append(sep);
        sb.append(latency);
        sb.append('\n');
        return sb.toString();
    }

    public Technology(String string){
        String []s = string.split(sep);
        setName(s[0]);
        setRange(new Det(s[1]));
        setTopology(new Det(s[2]));
        setBatteryLife(new Det(s[3]));
        setSecurity(s[4].equals("true"));
        setSimplicity(new Det(s[5]));
        setCost(new Det(s[6]));
        setLatency(new Det(s[7]));

    }

}
