package ma.livre.livreexposant.payload;

import lombok.Data;
import ma.livre.livreexposant.payload.Dto.LivreDto;

import java.util.List;

@Data
public class LivreResponse {

    private List<LivreDto> content;
    private int pageNumber;
    private int pageSize;
    private int totalPages;
    private boolean lastPage;
}
