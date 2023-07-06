package ma.livre.livreexposant.Service;

import ma.livre.livreexposant.Exception.ResourceNotFoundException;
import ma.livre.livreexposant.Model.Exposant;
import ma.livre.livreexposant.Model.Livre;
import ma.livre.livreexposant.Repository.ExposantRepository;
import ma.livre.livreexposant.Repository.LivreRepository;
import ma.livre.livreexposant.payload.Dto.ExposantDto;
import ma.livre.livreexposant.payload.Dto.LivreDto;
import ma.livre.livreexposant.payload.Dto.LivreRequest;
import ma.livre.livreexposant.payload.LivreResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivreService {
    @Autowired
    private LivreRepository livreRepo;

    @Autowired
    private ExposantRepository expRepo;

    @Autowired
    private ModelMapper mapper;

    //livre/create
    public LivreDto createLivre(LivreRequest livreRequest, int catid) {
        //Fech Exposant where we want to add Livre
        Exposant exp = this.expRepo.findById(catid).orElseThrow(() ->
                new ResourceNotFoundException(+catid + " This Exposant id not found Exposant"));

        //LivreDto to Livre
        Livre livre = toEntity(livreRequest);
        livre.setExposant(exp);
        Livre save = this.livreRepo.save(livre);
        //Livre to LivreDto
        LivreDto dto = toDto(save);
        return dto;
    }

    //view Livres
    public List<LivreDto> viewAll() {

        List<Livre> findAll = this.livreRepo.findAll();
        List<LivreDto> livreDto = findAll.stream().map(l -> this.toDto(l)).collect(Collectors.toList());

        //LivreDto to Livre
        //List<Livre> findAll = livreRepo.findAll();

        //Livre to LivreDto
        //List<LivreDto> findAllDto = findAll.stream().map(livre -> this.toDto(livre)).collect(Collectors.toList());
        return livreDto;
    }

    //view LivreById
    public LivreDto viewLivreById(int lid) {
        Livre findById = livreRepo.findById(lid).orElseThrow(() ->
                new ResourceNotFoundException(+lid + " from this livre id livre not found"));
        LivreDto dto = this.toDto(findById);
        return dto;
    }

    //delete livre
    public void deleteLivre(int lid) {
        Livre byId = livreRepo.findById(lid).orElseThrow(() ->
                new ResourceNotFoundException(+lid + " from this livre id livre not found"));
        livreRepo.delete(byId);
    }

    //update livre
    public LivreDto updateLivre(int lid, LivreDto newl) {
        Livre oldl = livreRepo.findById(lid).orElseThrow(() ->
                new ResourceNotFoundException(+lid + "livre Not found"));
        oldl.setTitre(newl.getTitre());
        oldl.setAuteur(newl.getAuteur());
        oldl.setEditeur(newl.getEditeur());
        oldl.setDate_edition(newl.getDate_edition());
        oldl.setPrix(newl.getPrix());
        oldl.setIsbn(newl.getIsbn());

        if (newl.getExposant() != null) {
            Exposant exposant = expRepo.findById(newl.getExposant().getExposantId())
                    .orElseThrow(() -> new ResourceNotFoundException("Exposant not found"));
            oldl.setExposant(exposant);
        }

        Livre save = livreRepo.save(oldl);
        LivreDto dto = toDto(save);
        return dto;
    }

    //Find livre by Exposant
    public List<LivreDto> findLivreByExposant(int expId) {
        Exposant Exp = this.expRepo.findById(expId)
                .orElseThrow(() -> new ResourceNotFoundException("This id Exposant not found"));
        List<Livre> findByExposant = this.livreRepo.findByExposant(Exp);
        List<LivreDto> collect = findByExposant.stream().map(livre -> toDto(livre)).collect(Collectors.toList());
        return collect;
    }

    //LivreDto to Livre
    public Livre toEntity(LivreRequest livreRequest) {
/*
        Livre l = new Livre();
        l.setLivreId(lDto.getLivreId());
        l.setTitre(lDto.getTitre());
        l.setAuteur(lDto.getAuteur());
        l.setEditeur(lDto.getEditeur());
        l.setDate_edition(lDto.getDate_edition());
        l.setPrix(lDto.getPrix());
        l.setIsbn(lDto.getIsbn());
*/
        return this.mapper.map(livreRequest, Livre.class);
    }

    //Livre to LivreDto
    public LivreDto toDto(Livre livre) {
        LivreDto lDto = new LivreDto();
        lDto.setLivreId(livre.getLivreId());
        lDto.setTitre(livre.getTitre());
        lDto.setAuteur(livre.getAuteur());
        lDto.setEditeur(livre.getEditeur());
        lDto.setDate_edition(livre.getDate_edition());
        lDto.setPrix(livre.getPrix());
        lDto.setIsbn(livre.getIsbn());

        //Change Exposant to ExposantDao
        ExposantDto expDto = new ExposantDto();
        expDto.setExposantId(livre.getExposant().getExposantId());
        expDto.setNom(livre.getExposant().getNom());
        expDto.setPays(livre.getExposant().getPays());
        expDto.setE_mail(livre.getExposant().getE_mail());
        expDto.setTelephone(livre.getExposant().getTelephone());
        expDto.setSite_Web(livre.getExposant().getSite_Web());
        expDto.setAdresse(livre.getExposant().getAdresse());
        expDto.setResponsable_Salle(livre.getExposant().getResponsable_Salle());
        expDto.setResponsable(livre.getExposant().getResponsable());
        expDto.setSpecialite(livre.getExposant().getSpecialite());
        expDto.setLocalisation(livre.getExposant().getLocalisation());

        //Then Set Exposant Dto in Livre Dto
        lDto.setExposant(expDto);
        return lDto;
    }

}
