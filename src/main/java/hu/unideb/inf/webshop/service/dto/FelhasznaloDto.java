package hu.unideb.inf.webshop.service.dto;

import hu.unideb.inf.webshop.data.entities.Jogosultsag;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.Date;
import java.util.Objects;

public class FelhasznaloDto {

    private Long id;
    private String nev;
    private Date szuldate;
    private String cim;
    private String nem;
    private String email;
    private String telefon;
    private String jelszo;
    private String jogosultsag;

    public FelhasznaloDto() {
    }

    public FelhasznaloDto(Long id, String nev, Date szuldate, String cim, String nem, String email, String telefon, String jelszo, String jogosultsag) {
        this.id = id;
        this.nev = nev;
        this.szuldate = szuldate;
        this.cim = cim;
        this.nem = nem;
        this.email = email;
        this.telefon = telefon;
        this.jelszo = jelszo;
        this.jogosultsag = jogosultsag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public Date getSzuldate() {
        return szuldate;
    }

    public void setSzuldate(Date szuldate) {
        this.szuldate = szuldate;
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public String getNem() {
        return nem;
    }

    public void setNem(String nem) {
        this.nem = nem;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getJelszo() {
        return jelszo;
    }

    public void setJelszo(String jelszo) {
        this.jelszo = jelszo;
    }

    public String getJogosultsag() {
        return jogosultsag;
    }

    public void setJogosultsag(String jogosultsag) {
        this.jogosultsag = jogosultsag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FelhasznaloDto that = (FelhasznaloDto) o;
        return Objects.equals(id, that.id) && Objects.equals(nev, that.nev) && Objects.equals(szuldate, that.szuldate) && Objects.equals(cim, that.cim) && Objects.equals(nem, that.nem) && Objects.equals(email, that.email) && Objects.equals(telefon, that.telefon) && Objects.equals(jelszo, that.jelszo) && Objects.equals(jogosultsag, that.jogosultsag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nev, szuldate, cim, nem, email, telefon, jelszo, jogosultsag);
    }
}
