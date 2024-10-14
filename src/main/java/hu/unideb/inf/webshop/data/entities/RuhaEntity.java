package hu.unideb.inf.webshop.data.entities;

import jakarta.persistence.*;

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

}
