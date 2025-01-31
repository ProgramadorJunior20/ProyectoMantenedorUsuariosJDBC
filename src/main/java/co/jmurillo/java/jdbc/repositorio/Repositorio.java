package co.jmurillo.java.jdbc.repositorio;

import java.util.List;

public interface Repositorio <T> {
    List<T> listar();
    T porId(int id);
    void crear(T t);
    void actualizar(T t);
    void eliminar(int id);
}
