/*
 * Clase de excepción que indica que no se ha encontrado un blueprint.
 */
package edu.eci.arsw.blueprints.persistence;

public class BlueprintNotFoundException extends Exception {

    // Mensajes de error predefinidos
    public static final String AUTHOR_NOT_FOUND = "The given author doesn't exist.";
    public static final String BLUEPRINT_NOT_FOUND = "No such blueprint.";

    /**
     * Constructor que crea una instancia de BlueprintNotFoundException con un mensaje específico.
     * @param message El mensaje de la excepción.
     */
    public BlueprintNotFoundException(String message) {
        super(message);
    }
}
