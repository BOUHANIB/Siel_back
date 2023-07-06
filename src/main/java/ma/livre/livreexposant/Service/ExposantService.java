package ma.livre.livreexposant.Service;

import ma.livre.livreexposant.Exception.ResourceNotFoundException;
import ma.livre.livreexposant.Model.Exposant;
import ma.livre.livreexposant.Repository.ExposantRepository;
import ma.livre.livreexposant.payload.Dto.ExposantDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExposantService {
    @Autowired
    private ExposantRepository expRepo;

    @Autowired
    private ModelMapper mapper;

    //exposant/create
    public ExposantDto create(ExposantDto dto) {
        //ExposantDto to Exposant
        Exposant exp = this.mapper.map(dto,Exposant.class);
        Exposant save = this.expRepo.save(exp);
        //Exposant to ExposantDto
        return this.mapper.map(save,ExposantDto.class);
    }

    //view Exposants
    public List<ExposantDto> getAll() {
        List<Exposant> findAll = this.expRepo.findAll();
        List<ExposantDto> allDto = findAll.stream().map(exp -> this.mapper.map(exp,ExposantDto.class)).collect(Collectors.toList());
        return allDto;
    }

    //view ExposantById
    public ExposantDto getbyId(int expoid) {
        Exposant getByid = this.expRepo.findById(expoid).orElseThrow(() ->
                new ResourceNotFoundException(+expoid + " from this exposant id exposant not found"));
        return this.mapper.map(getByid,ExposantDto.class);
    }

    //delete exposant
    public void delete(int expId) {
        Exposant Exp = this.expRepo.findById(expId).orElseThrow(() ->
                new ResourceNotFoundException(+expId + "This Exposant Id Not found"));
        this.expRepo.delete(Exp);
    }

    //update exposant
    public ExposantDto update(ExposantDto newexp,int expid) {
        Exposant oldExp = this.expRepo.findById(expid).orElseThrow(() ->
                new ResourceNotFoundException(+expid + "This Exposant Id Not found"));
        oldExp.setNom(newexp.getNom());
        oldExp.setPays(newexp.getPays());
        oldExp.setE_mail(newexp.getE_mail());
        oldExp.setTelephone(newexp.getTelephone());
        oldExp.setSite_Web(newexp.getSite_Web());
        oldExp.setAdresse(newexp.getAdresse());
        oldExp.setResponsable_Salle(newexp.getResponsable_Salle());
        oldExp.setResponsable(newexp.getResponsable());
        oldExp.setSpecialite(newexp.getSpecialite());
        oldExp.setLocalisation(newexp.getLocalisation());
        Exposant save = this.expRepo.save(oldExp);
        return this.mapper.map(save,ExposantDto.class);
    }

/*
    //ExposantDto to Exposant
    public Exposant toEntity(ExposantDto eDto) {
        Exposant e = new Exposant();
        e.setExposantId(eDto.getExposantId());
        e.setNom(eDto.getNom());
        e.setPays(eDto.getPays());
        e.setE_mail(eDto.getE_mail());
        e.setTelephone(eDto.getTelephone());
        e.setSite_Web(eDto.getSite_Web());
        e.setAdresse(eDto.getAdresse());
        e.setResponsable_Salle(eDto.getResponsable_Salle());
        e.setResponsable(eDto.getResponsable());
        e.setSpecialite(eDto.getSpecialite());
        e.setLocalisation(eDto.getLocalisation());
        return e;
    }

    //Exposant to ExposantDto
    public ExposantDto toDto(Exposant exposant) {
        ExposantDto eDto = new ExposantDto();
        eDto.setExposantId(exposant.getExposantId());
        eDto.setNom(exposant.getNom());
        eDto.setPays(exposant.getPays());
        eDto.setE_mail(exposant.getE_mail());
        eDto.setTelephone(exposant.getTelephone());
        eDto.setSite_Web(exposant.getSite_Web());
        eDto.setAdresse(exposant.getAdresse());
        eDto.setResponsable_Salle(exposant.getResponsable_Salle());
        eDto.setResponsable(exposant.getResponsable());
        eDto.setSpecialite(exposant.getSpecialite());
        eDto.setLocalisation(exposant.getLocalisation());
        return eDto;
    }

 */
}
