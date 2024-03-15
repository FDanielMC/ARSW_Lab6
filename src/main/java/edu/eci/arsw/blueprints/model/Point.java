/*
 * Clase que representa un punto en un plano cartesiano bidimensional.
 */
package edu.eci.arsw.blueprints.model;

import java.util.Objects;

public class Point {

    private int x; // Coordenada x del punto
    private int y; // Coordenada y del punto

    /**
     * Constructor que inicializa un punto con coordenadas x e y.
     * @param x La coordenada x del punto.
     * @param y La coordenada y del punto.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Método que devuelve la coordenada x del punto.
     * @return La coordenada x del punto.
     */
    public int getX() {
        return x;
    }

    /**
     * Método que establece la coordenada x del punto.
     * @param x La coordenada x del punto.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Método que devuelve la coordenada y del punto.
     * @return La coordenada y del punto.
     */
    public int getY() {
        return y;
    }

    /**
     * Método que establece la coordenada y del punto.
     * @param y La coordenada y del punto.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Método que comprueba si un objeto es igual a este punto.
     * @param obj El objeto a comparar.
     * @return true si los objetos son iguales, false de lo contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        final Point other = (Point) obj;
        if (!Objects.equals(this.getX(), other.getX())) return false;
        return Objects.equals(this.getY(), other.getY());
    }

    /**
     * Método que genera el código hash del punto.
     * @return El código hash del punto.
     */
    @Override
    public int hashCode() {
        return Integer.parseInt(x + Integer.toString(y));
    }

    /**
     * Método que devuelve una representación en cadena del punto.
     * @return Una cadena que representa el punto.
     */
    @Override
    public String toString() {
        return x + "-" + y;
    }
}
