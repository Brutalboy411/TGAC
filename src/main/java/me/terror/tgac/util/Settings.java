package me.terror.tgac.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Settings {
    public static final double COMBAT_MAX_REACH_SURVIVAL = 3.7D;
    public static final double COMBAT_MAX_REACH_CREATIVE = 5.25D;
    public static final int COMBAT_MAX_CPS = 14;
    public static final int CLEAN_UP_DELAY = 200;
    public static final int MAX_ENTITIES = 6;
    public static final int ROUNDING_PLACES = 6;

    public static double round(double value, int places){
        if (places < 0){
            throw new IllegalArgumentException();
        }
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    public static double round(double value){
        return round(value, 6);
    }

    //CLASA E GATA NU MAI TREBUIE NIMIC SCHIMBAT
}
