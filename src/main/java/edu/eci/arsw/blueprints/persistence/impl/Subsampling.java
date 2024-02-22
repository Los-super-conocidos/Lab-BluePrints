package edu.eci.arsw.blueprints.persistence.impl;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BluePrintsFiltred;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Subsampling implements BluePrintsFiltred {
    public Subsampling() {
    }

    @Override
    public Blueprint getFlat(Blueprint flat) {
        List<Point> pointList = flat.getPoints();
        int counter = 1;
        for(Point i: pointList){
            if(counter%2 == 0){
                pointList.remove(i);
            }
            counter++;
        }
        Point[] pnts;
        pnts = pointList.toArray(new Point[0]);
        return new Blueprint(flat.getAuthor(),flat.getName(),pnts);
    }
}
