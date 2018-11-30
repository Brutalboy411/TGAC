package me.terror.tgac.util;

import java.util.HashMap;

public class YMap {

    private static final HashMap<Integer, YMap> MAP = new HashMap<>();

    static {
        YMap normal = new YMap();
        normal.set(0, 0.42D);
        normal.set(1, 0.3332D);
        normal.set(2, 0.248136D);
        normal.set(3, 0.164773D);
        normal.set(4, 0.083078D);
        normal.set(0, 0.42D);
        MAP.put(Integer.valueOf(0), normal);

        YMap one = new YMap();
        one.set(0, 0.52D);
        one.set(1, 0.4312D);
        one.set(2, 0.344176D);
        one.set(3, 0.258892D);
        one.set(4, 0.175315D);
        one.set(5, 0.093408D);
        one.set(6, 0.01314D);
        MAP.put(Integer.valueOf(1), one);

        YMap two = new YMap();
        two.set(0, 0.62D);
        two.set(1, 0.5292D);
        two.set(2, 0.440216D);
        two.set(3, 0.353012D);
        two.set(4, 0.267551D);
        two.set(5, 0.1838D);
        two.set(6, 0.101724D);
        two.set(7, 0.02129D);
        MAP.put(Integer.valueOf(2), two);
    }
    public static YMap get(int modifier){
        return (YMap)MAP.get(Integer.valueOf(modifier));
    }
    private HashMap<Integer, Double> speedMap = new HashMap();
    private void set(int speed, double value){
        this.speedMap.put(Integer.valueOf(speed), Double.valueOf(value));
    }
    public boolean contains(double value){
        return this.speedMap.containsValue(Double.valueOf(value));
    }
    public boolean hasSpeed(int speed){
        return this.speedMap.containsKey(Integer.valueOf(speed));
    }
    public Double getSpeed(int speed){
        return (Double)this.speedMap.get(Integer.valueOf(speed));
    }
    public int size(){
        return this.speedMap.size();
    }
    //CLASA TERMINATA!!!
}
