package hu.unideb.inf.webshop.data.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "rendeles")
public class RendelesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "datum")
    private Date datum;
    @Column(name = "fizetve")
    private Boolean fizetve;
    @Column(name = "allapot")
    private String allapot;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ruharendelesek",
            joinColumns = {@JoinColumn(name = "rendeles_id")} ,
            inverseJoinColumns = {@JoinColumn(name = "ruha_id")}
    )
    private List<RuhaEntity> ruhaEntities;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "felhasznalo_azon", referencedColumnName = "id")
    private Felhasznalo felhasznalo;

    public RendelesEntity() {
    }

    public RendelesEntity(long id, Date datum, Boolean fizetve, String allapot) {
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
        RendelesEntity that = (RendelesEntity) o;
        return id == that.id && Objects.equals(datum, that.datum) && Objects.equals(fizetve, that.fizetve) && Objects.equals(allapot, that.allapot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, datum, fizetve, allapot);
    }
}
