package hu.unideb.inf.webshop.data.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "ruha")
public class RuhaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "nev", nullable = false)
    private String nev;
    @Column(name = "meret", nullable = false, length = 10)
    private String meret;
    @Column(name = "szin")
    private String szin;
    @Column(name = "tipus")
    private String tipus;

    public RuhaEntity() {
    }

    public RuhaEntity(long id, String nev, String meret, String szin, String tipus) {
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
        RuhaEntity that = (RuhaEntity) o;
        return id == that.id && Objects.equals(nev, that.nev) && Objects.equals(meret, that.meret) && Objects.equals(szin, that.szin) && Objects.equals(tipus, that.tipus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nev, meret, szin, tipus);
    }
}
