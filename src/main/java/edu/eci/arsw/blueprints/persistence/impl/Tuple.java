/*
 * Clase que representa una tupla genérica de dos elementos.
 * Esta clase es utilizada para almacenar pares de objetos de diferentes tipos.
 */
package edu.eci.arsw.blueprints.persistence.impl;

import java.util.Objects;

public class Tuple<T1, T2> {

    // Primer elemento de la tupla
    T1 o1;
    // Segundo elemento de la tupla
    T2 o2;

    /**
     * Constructor de la clase Tuple.
     * @param o1 Primer elemento de la tupla.
     * @param o2 Segundo elemento de la tupla.
     */
    public Tuple(T1 o1, T2 o2) {
        super();
        this.o1 = o1;
        this.o2 = o2;
    }

    /**
     * Obtiene el primer elemento de la tupla.
     * @return El primer elemento de la tupla.
     */
    public T1 getElem1() {
        return o1;
    }

    /**
     * Obtiene el segundo elemento de la tupla.
     * @return El segundo elemento de la tupla.
     */
    public T2 getElem2() {
        return o2;
    }

    /**
     * Calcula el código hash de la tupla.
     * @return El código hash de la tupla.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.o1);
        hash = 17 * hash + Objects.hashCode(this.o2);
        return hash;
    }

    /**
     * Compara la tupla actual con otro objeto para verificar si son iguales.
     * @param obj El objeto con el que se compara la tupla.
     * @return true si la tupla es igual al objeto dado, false en caso contrario.
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
        final Tuple<?, ?> other = (Tuple<?, ?>) obj;
        if (!Objects.equals(this.o1, other.o1)) {
            return false;
        }
        return Objects.equals(this.o2, other.o2);
    }
}
