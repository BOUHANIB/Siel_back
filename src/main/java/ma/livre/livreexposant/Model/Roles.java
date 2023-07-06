package ma.livre.livreexposant.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Roles {
    @Id
    @Column(name = "Role_Id",nullable = false)
    private int roleId;

    @Column(name = "Role_Name",nullable = false)
    private String roleName;
/*
    @ManyToMany(mappedBy = "role")
    Set<User> user=new HashSet<>();

 */
}
