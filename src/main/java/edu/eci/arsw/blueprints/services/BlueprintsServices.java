/*
 * Servicio que proporciona operaciones relacionadas con blueprints.
 * Este servicio gestiona la persistencia y manipulación de blueprints, incluida la aplicación de filtros.
 */
package edu.eci.arsw.blueprints.services;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.persistence.BlueprintsPersistence;
import edu.eci.arsw.blueprints.persistence.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public class BlueprintsServices {

    // Persistencia de blueprints
    @Autowired
    BlueprintsPersistence bpp;
    // Filtro aplicado a los blueprints
    @Autowired
    Filter filter;

    /**
     * Agrega un nuevo blueprint al sistema.
     * @param bp El nuevo blueprint a agregar.
     * @throws BlueprintPersistenceException Si ocurre un error durante la persistencia del blueprint.
     */
    public void addNewBlueprint(Blueprint bp) throws BlueprintPersistenceException {
        bpp.saveBlueprint(bp);
    }

    /**
     * Actualiza un blueprint existente.
     * @param author El autor del blueprint a actualizar.
     * @param bpname El nombre del blueprint a actualizar.
     * @param blueprintUpdated El blueprint actualizado.
     * @throws BlueprintNotFoundException Si el blueprint no se encuentra en el sistema.
     */
    public void updateBlueprint(String author, String bpname, Blueprint blueprintUpdated) throws BlueprintNotFoundException {
        bpp.updateBlueprint(author, bpname, blueprintUpdated);
    }

    /**
     * Obtiene todos los blueprints del sistema aplicando filtros.
     * @return Un conjunto de blueprints filtrados.
     */
    public Set<Blueprint> getAllBlueprints() {
        return filter.filterBlueprints(bpp.getAllBlueprints());
    }

    /**
     * Obtiene un blueprint específico aplicando filtros.
     * @param author El autor del blueprint.
     * @param name El nombre del blueprint.
     * @return El blueprint filtrado.
     * @throws BlueprintNotFoundException Si el blueprint no se encuentra en el sistema.
     */
    public Blueprint getBlueprint(String author, String name) throws BlueprintNotFoundException {
        return filter.filterBlueprint(bpp.getBlueprint(author, name));
    }

    /**
     * Obtiene todos los blueprints de un autor específico aplicando filtros.
     * @param author El autor de los blueprints.
     * @return Un conjunto de blueprints filtrados por autor.
     * @throws BlueprintNotFoundException Si no se encuentran blueprints del autor especificado.
     */
    public Set<Blueprint> getBlueprintsByAuthor(String author) throws BlueprintNotFoundException {
        return filter.filterBlueprints(bpp.getBlueprintByAuthor(author));
    }
}
