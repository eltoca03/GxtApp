package com.mycompany.gxtapp;

/**
 * Created by David on 6/30/15.
 */
public class FieldObj{


    //fields
    int station;
    String name;
    int offset;
    boolean dir;

    FieldObj(){
    }


    FieldObj(int sta, String str, int os, boolean d){
        station = sta;
        name = str;
        offset = os;
        dir = d;
    }

    public int getStation(){
        return station;
    }

    public String getName(){
        return name;
    }

    public int getOffset(){
        return offset;
    }

    public boolean getDirection(){
        return dir;
    }

    public void setStation(int i){
        station = i;
    }

    public void setOffset(int i){
        offset = i;
    }

    public void setDirection(boolean d){
        dir = d;
    }

    public void setName(String str){
        name = str;
    }

    public String toString(){
        String str;
        str ="fix this";

        return str;
    }


}
