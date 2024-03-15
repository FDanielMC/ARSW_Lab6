/*
 * Clase que implementa un filtro de submuestreo para blueprints.
 * Esta clase extiende la clase abstracta Filter y proporciona la lógica para filtrar un blueprint eliminando puntos.
 */
package edu.eci.arsw.blueprints.persistence.impl;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.Filter;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


public class SubsamplingFilter extends Filter {

    /**
     * Método que filtra un blueprint aplicando submuestreo.
     * Elimina puntos del blueprint para reducir la cantidad de información.
     * @param blueprint El blueprint a filtrar.
     * @return El blueprint filtrado después de aplicar submuestreo.
     */
    @Override
    public Blueprint filterBlueprint(Blueprint blueprint) {
        // Crear una copia de la lista de puntos del blueprint
        List<Point> points = new ArrayList<>(blueprint.getPoints());
        // Crear un nuevo blueprint basado en el blueprint original
        Blueprint newBlueprint = new Blueprint(blueprint);
        // Determinar si el número de puntos es par o impar
        int odd = points.size() % 2 == 0 ? 0 : 1;
        // Eliminar puntos del blueprint de manera alternada, comenzando desde el primer punto
        for (int i = 0; i < points.size() - odd; i += 2) {
            newBlueprint.removePoint(points.get(i));
        }
        return newBlueprint;
    }
}
