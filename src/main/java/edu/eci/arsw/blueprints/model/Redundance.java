package edu.eci.arsw.blueprints.model;

import edu.eci.arsw.blueprints.persistence.BluePrintsFiltred;

import java.util.List;

public class Redundance implements BluePrintsFiltred {
    public Redundance() {
    }

    @Override
    public List<Point> getFlat(Blueprint flat) {
        List<Point> listFiltr = flat.getPoints();
        int count = 0;
        while(count < listFiltr.size() -1){
            int index = count +1;
            if(listFiltr.get(count).getX() == listFiltr.get(index).getX() && listFiltr.get(count).getY() == listFiltr.get(index).getY()){
                listFiltr.remove(count);
            }else{
                count++;
            }
        }
        return listFiltr;
    }
}
