package ma.livre.livreexposant.payload.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.livre.livreexposant.payload.Dto.ExposantDto;

@Data
@AllArgsConstructor @NoArgsConstructor
public class LivreDto {
    private int LivreId;
    private String titre;
    private String auteur;
    private String editeur;
    private String date_edition;
    private double prix;
    private String isbn;
    private ExposantDto exposant;
}
