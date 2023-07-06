package ma.livre.livreexposant.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
@Table(name = "Livre")
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int livreId;
    private String titre;
    private String auteur;
    private String editeur;
    private String date_edition;
    private double prix;
    private String isbn;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "exposant_id")
    private Exposant exposant;

    }
