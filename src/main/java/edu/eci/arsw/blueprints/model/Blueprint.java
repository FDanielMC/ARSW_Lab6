/*
 * Clase que representa un blueprint (plano o diseño) con su autor, nombre y una lista de puntos.
 */
package edu.eci.arsw.blueprints.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Blueprint {

    private String author = null; // El autor del blueprint
    private List<Point> points = null; // Lista de puntos del blueprint
    private String name = null; // El nombre del blueprint

    /**
     * Constructor que inicializa un blueprint con su autor, nombre y una lista de puntos.
     * @param author El autor del blueprint.
     * @param name El nombre del blueprint.
     * @param pnts La lista de puntos del blueprint.
     */
    public Blueprint(String author, String name, Point[] pnts) {
        this.author = author;
        this.name = name;
        points = new ArrayList<>(Arrays.asList(pnts));
    }

    /**
     * Constructor que inicializa un blueprint con su autor y nombre.
     * @param author El autor del blueprint.
     * @param name El nombre del blueprint.
     */
    public Blueprint(String author, String name) {
        this.author = author;
        this.name = name;
        points = new ArrayList<>();
    }

    /**
     * Constructor de copia que inicializa un blueprint a partir de otro blueprint dado.
     * @param blueprint El blueprint a copiar.
     */
    public Blueprint(Blueprint blueprint) {
        this.name = blueprint.getName();
        this.author = blueprint.getAuthor();
        this.points = new ArrayList<>(blueprint.getPoints());
    }

    /**
     * Constructor por defecto.
     */
    public Blueprint() {
    }

    /**
     * Método que devuelve el nombre del blueprint.
     * @return El nombre del blueprint.
     */
    public String getName() {
        return name;
    }

    /**
     * Método que devuelve el autor del blueprint.
     * @return El autor del blueprint.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Método que devuelve la lista de puntos del blueprint.
     * @return La lista de puntos del blueprint.
     */
    public List<Point> getPoints() {
        return points;
    }

    /**
     * Método que establece la lista de puntos del blueprint.
     * @param points La lista de puntos del blueprint.
     */
    public void setPoints(List<Point> points) {
        this.points = points;
    }

    /**
     * Método que añade un punto a la lista de puntos del blueprint.
     * @param p El punto a añadir.
     */
    public void addPoint(Point p) {
        this.points.add(p);
    }

    /**
     * Método que elimina un punto de la lista de puntos del blueprint.
     * @param p El punto a eliminar.
     */
    public void removePoint(Point p) {
        this.points.remove(p);
    }

    /**
     * Método que devuelve una representación en cadena del blueprint.
     * @return Una cadena que representa el blueprint.
     */
    @Override
    public String toString() {
        StringBuilder value = new StringBuilder("Blueprint{" + "author=" + author + ", name=" + name + ", points=(");
        for (int i = 0; i < points.size() - 1; i++) value.append(points.get(i)).append(",");
        if (points.size() > 0) value.append(points.get(points.size() - 1));
        return value.append(")}").toString();
    }

    /**
     * Método que genera el código hash del blueprint.
     * @return El código hash del blueprint.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    /**
     * Método que comprueba si un objeto es igual a este blueprint.
     * @param obj El objeto a comparar.
     * @return true si los objetos son iguales, false de lo contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Blueprint other = (Blueprint) obj;
        if (!Objects.equals(this.author, other.author)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.points.size() != other.points.size()) {
            return false;
        }
        for (int i = 0; i < this.points.size(); i++) {
            if (!this.points.get(i).equals(other.points.get(i))) {
                return false;
            }
        }

        return true;
    }
}
