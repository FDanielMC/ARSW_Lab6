/*
 * Clase abstracta que define un filtro para blueprints.
 */
package edu.eci.arsw.blueprints.persistence;

import edu.eci.arsw.blueprints.model.Blueprint;
import java.util.HashSet;
import java.util.Set;

public abstract class Filter {

    /**
     * Método abstracto que filtra un blueprint según un criterio específico.
     * @param blueprint El blueprint a filtrar.
     * @return El blueprint filtrado.
     */
    public abstract Blueprint filterBlueprint(Blueprint blueprint);

    /**
     * Método que filtra un conjunto de blueprints según un criterio específico.
     * @param blueprints El conjunto de blueprints a filtrar.
     * @return Un conjunto de blueprints filtrados.
     */
    public Set<Blueprint> filterBlueprints(Set<Blueprint> blueprints) {
        Set<Blueprint> newBlueprints = new HashSet<>();
        blueprints.forEach(blueprint -> newBlueprints.add(filterBlueprint(blueprint)));
        return newBlueprints;
    }
}
