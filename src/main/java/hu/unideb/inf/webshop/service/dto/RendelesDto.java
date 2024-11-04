package hu.unideb.inf.webshop.service.dto;

import jakarta.persistence.Column;

import java.util.Date;
import java.util.Objects;

public class RendelesDto {

    private long id;
    private Date datum;
    private Boolean fizetve;
    private String allapot;

    public RendelesDto() {
    }

    public RendelesDto(long id, Date datum, Boolean fizetve, String allapot) {
        this.id = id;
        this.datum = datum;
        this.fizetve = fizetve;
        this.allapot = allapot;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Boolean getFizetve() {
        return fizetve;
    }

    public void setFizetve(Boolean fizetve) {
        this.fizetve = fizetve;
    }

    public String getAllapot() {
        return allapot;
    }

    public void setAllapot(String allapot) {
        this.allapot = allapot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RendelesDto that = (RendelesDto) o;
        return id == that.id && Objects.equals(datum, that.datum) && Objects.equals(fizetve, that.fizetve) && Objects.equals(allapot, that.allapot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, datum, fizetve, allapot);
    }
}
