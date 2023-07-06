package ma.livre.livreexposant.payload.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class ExposantDto {
    private int ExposantId;
    private String nom;
    private String pays;
    private String e_mail;
    private String telephone;
    private String site_Web;
    private String adresse;
    private String responsable_Salle;
    private String responsable;
    private String specialite;
    private String localisation;
}
