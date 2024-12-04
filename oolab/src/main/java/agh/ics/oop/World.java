package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.model.util.ConsoleMapDisplay;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class World {

    public static void main(String[] args) {

        try {
            List<MoveDirection> directions = OptionsParser.parse(args);
            List<Vector2d> positions = List.of(new Vector2d(3, 5), new Vector2d(1, 5));
            List<Simulation> simulations = new ArrayList<>();
            ConsoleMapDisplay display = new ConsoleMapDisplay();

            for(int i = 0; i<1000; i++) {
                GrassField grassField = new GrassField(10);
                GrassField grassField2 = new GrassField(10);

                grassField.addMapChangeObserver(display);
                grassField2.addMapChangeObserver(display);

                Simulation sim1 = new Simulation(positions, directions, grassField);
                Simulation sim2 = new Simulation(positions, directions, grassField2);

                simulations.add(sim1);
                simulations.add(sim2);

            }


            SimulationEngine engine = new SimulationEngine(simulations);
            engine.runAsyncInThreadPool();
            engine.awaitSimulationsEnd();


        }
        catch (IllegalArgumentException e) {
            e.printStackTrace(System.err);
        }

        System.out.println("Sys run ended");
    }
}
