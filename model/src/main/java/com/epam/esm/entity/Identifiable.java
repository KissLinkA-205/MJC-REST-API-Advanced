package com.epam.esm.entity;

import org.springframework.hateoas.RepresentationModel;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

/**
 * Class {@code Identifiable} represents to identify objects.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
@MappedSuperclass
public abstract class Identifiable extends RepresentationModel<Identifiable> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    Identifiable() {
    }

    Identifiable(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Identifiable that = (Identifiable) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
