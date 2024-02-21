package edu.eci.arsw.blueprints.ui;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.persistence.impl.Tuple;
import edu.eci.arsw.blueprints.services.BlueprintsServices;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Main {

    public static void main(String args[]) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        BlueprintsServices bps = ac.getBean(BlueprintsServices.class);
        Blueprint blueprint;
        Blueprint blueprintSpecified;
        Point[] points = new Point[3];
        Point point_1 = new Point(3, 2);
        Point point_2 = new Point(7,1);
        Point point_3 = new Point(10,3);
        points[0] = point_1;
        points[1] = point_2;
        points[2] = point_3;

        try{
            blueprint = new Blueprint("Christian","Arsw");
            blueprintSpecified = new Blueprint("Carolina", "Arsw",points);
            createBluePrint(bps, blueprint);
            selectBluePrint(bps,"Christian","Arsw");
            createBluePrint(bps,blueprintSpecified);
            selectAllBlueprints(bps);
            selectSpecifiedBluePrint(bps, "Christian");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static void createBluePrint(BlueprintsServices bps, Blueprint bp)
            throws BlueprintPersistenceException {
        System.out.println("BluePrint " + bp.getName() +" created successfull\n ");
        bps.addNewBlueprint(bp);
    }

    public static void selectBluePrint(BlueprintsServices bps, String author, String name)
            throws BlueprintNotFoundException {
        System.out.println("Selecting blueprint...\n\t " + bps.getBlueprint(author,name) + "\n");
    }

    public static void selectAllBlueprints(BlueprintsServices bps)
            throws BlueprintPersistenceException {
        Map<Tuple<String, String>,Blueprint> blueprintMap = bps.getAllBlueprints();
        System.out.println("Listing all BluePrints... \n");
        blueprintMap.forEach((key, value) -> System.out.println("\t" + value));
    }

    public static void selectSpecifiedBluePrint(BlueprintsServices bps, String author)
            throws BlueprintNotFoundException {
        Set<Blueprint> blueprints = bps.getBlueprintsByAuthor(author);
        System.out.println("\nListing all BluePrints of:" + author);
        blueprints.forEach(blueprint -> System.out.println("\t" + blueprint));
    }

}
