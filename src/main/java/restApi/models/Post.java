package restApi.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "posts", schema = "restapi")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "merchant_id", foreignKey = @ForeignKey(name = "merchant_id_fk"))
    private Merchant merchant;
}
