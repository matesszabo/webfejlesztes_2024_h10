package hu.unideb.inf.webshop.service.dto;

import jakarta.persistence.Column;

import java.util.Objects;

//DTO - Data Transfer Object
//POJO - Plain old java object
public class RuhaDto {

    private long id;
    private String nev;
    private String meret;
    private String szin;
    private String tipus;

    public RuhaDto() {
    }

    public RuhaDto(long id, String nev, String meret, String szin, String tipus) {
        this.id = id;
        this.nev = nev;
        this.meret = meret;
        this.szin = szin;
        this.tipus = tipus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getMeret() {
        return meret;
    }

    public void setMeret(String meret) {
        this.meret = meret;
    }

    public String getSzin() {
        return szin;
    }

    public void setSzin(String szin) {
        this.szin = szin;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RuhaDto ruhaDto = (RuhaDto) o;
        return id == ruhaDto.id && Objects.equals(nev, ruhaDto.nev) && Objects.equals(meret, ruhaDto.meret) && Objects.equals(szin, ruhaDto.szin) && Objects.equals(tipus, ruhaDto.tipus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nev, meret, szin, tipus);
    }
}
