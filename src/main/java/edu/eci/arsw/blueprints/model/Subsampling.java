package edu.eci.arsw.blueprints.model;

import edu.eci.arsw.blueprints.persistence.BluePrintsFiltred;

import java.util.List;

public class Subsampling implements BluePrintsFiltred {
    public Subsampling() {
    }

    /**
     * @return
     */
    @Override
    public List<Point> getFlat(Blueprint flat) {
        List<Point> pointList = flat.getPoints();
        int counter = 1;
        for(Point i: pointList){
            if(counter%2 == 0){
                pointList.remove(i);
            }
            counter++;
        }
        return pointList;
    }
}
