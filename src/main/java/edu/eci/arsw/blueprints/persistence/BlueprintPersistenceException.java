/*
 * Clase de excepción que indica un error en la persistencia de blueprints.
 */
package edu.eci.arsw.blueprints.persistence;

public class BlueprintPersistenceException extends Exception {

    // Mensaje de error predefinido
    public static final String EXISTING_BLUEPRINT = "The given blueprint already exists: ";

    /**
     * Constructor que crea una instancia de BlueprintPersistenceException con un mensaje específico.
     * @param message El mensaje de la excepción.
     */
    public BlueprintPersistenceException(String message) {
        super(message);
    }
}
