/*
 * Clase que implementa un filtro de redundancia para blueprints.
 * Esta clase extiende la clase abstracta Filter y proporciona la lógica para filtrar un blueprint eliminando puntos.
 */
package edu.eci.arsw.blueprints.persistence.impl;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.Filter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RedudancyFilter extends Filter {
    @Override
    public Blueprint filterBlueprint(Blueprint blueprint) {
        List<Point> points = new ArrayList<>(blueprint.getPoints());
        Blueprint newBlueprint = new Blueprint(blueprint);
        for (int i = 0; i < points.size() - 1; i++) {
            if (points.get(i).equals(points.get(i + 1))) {
                newBlueprint.removePoint(points.get(i));
            }
        }
        return newBlueprint;
    }
}

