package web.adminlicense.models;


import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "users", schema = "licsrv")
public class User {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name = "user_generator", sequenceName = "users_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "name", nullable = false, length = 255, unique = true)
    private String name;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Transient
    private String confirmPassword;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(schema = "licsrv", name = "user_roles", joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_role"))
    private Set<Role> roles;

    @Column(name = "state", nullable = false, columnDefinition = "character varying (32) DEFAULT \'BLOCKED\'")
    @Enumerated(value = EnumType.STRING)
    private State state;
}
