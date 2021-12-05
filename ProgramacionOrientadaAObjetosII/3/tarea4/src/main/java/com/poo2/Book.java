package com.poo2;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Book {
    private SimpleIntegerProperty id;
    private SimpleStringProperty name;
    private SimpleStringProperty autor;
    private SimpleStringProperty descripcion;
    private SimpleStringProperty genero;
    private SimpleIntegerProperty edition;

    public Book(Integer id,
                String name,
                String autor,
                String descripcion,
                String genero,
                Integer edition) {

        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.autor = new SimpleStringProperty(autor);
        this.descripcion = new SimpleStringProperty(descripcion);
        this.genero = new SimpleStringProperty(genero);
        this.edition = new SimpleIntegerProperty(edition);
    }

    public Integer getId() {
        return id.get();
    }
    public void setId(Integer id) {
        this.id.set(id);
    }
    public String getName() {
        return name.get();
    }
    public void setName(String name) {
        this.name.set(name);
    }
    public String getAutor() {
        return autor.get();
    }
    public void setAutor(String autor) {
        this.autor.set(autor);
    }
    public String getDescripcion() {
        return descripcion.get();
    }
    public void setDescripcion(String descripcion) {
        this.descripcion.set(descripcion);
    }
    public String getGenero() {
        return genero.get();
    }
    public void setGenero(String genero) {
        this.genero.set(genero);
    }
    public Integer getEdition() {
        return edition.get();
    }
    public void setEdition(Integer edition) {
        this.edition.set(edition);
    }
}
