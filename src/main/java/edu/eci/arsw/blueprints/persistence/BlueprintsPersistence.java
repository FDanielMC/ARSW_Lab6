/*
 * Interfaz que define los métodos para la persistencia de blueprints.
 */
package edu.eci.arsw.blueprints.persistence;

import edu.eci.arsw.blueprints.model.Blueprint;
import java.util.Set;

public interface BlueprintsPersistence {

    /**
     * Guarda un blueprint en el sistema de persistencia.
     * @param bp El blueprint a guardar.
     * @throws BlueprintPersistenceException Si ocurre un error durante la persistencia.
     */
    void saveBlueprint(Blueprint bp) throws BlueprintPersistenceException;

    /**
     * Obtiene un blueprint específico por autor y nombre.
     * @param author El autor del blueprint.
     * @param bprintname El nombre del blueprint.
     * @return El blueprint encontrado.
     * @throws BlueprintNotFoundException Si el blueprint no se encuentra en el sistema de persistencia.
     */
    Blueprint getBlueprint(String author, String bprintname) throws BlueprintNotFoundException;

    /**
     * Obtiene todos los blueprints de un autor específico.
     * @param author El autor de los blueprints.
     * @return Un conjunto de blueprints del autor.
     * @throws BlueprintNotFoundException Si el autor no tiene blueprints en el sistema de persistencia.
     */
    Set<Blueprint> getBlueprintByAuthor(String author) throws BlueprintNotFoundException;

    /**
     * Obtiene todos los blueprints almacenados en el sistema de persistencia.
     * @return Un conjunto de todos los blueprints almacenados.
     */
    Set<Blueprint> getAllBlueprints();

    /**
     * Actualiza un blueprint existente en el sistema de persistencia.
     * @param author El autor del blueprint.
     * @param bpname El nombre del blueprint a actualizar.
     * @param bpUpdate El blueprint con la información actualizada.
     * @throws BlueprintNotFoundException Si el blueprint a actualizar no se encuentra en el sistema de persistencia.
     */
    void updateBlueprint(String author, String bpname, Blueprint bpUpdate) throws BlueprintNotFoundException;

}
