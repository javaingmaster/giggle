package giggles.giggle.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author zty
 *
 * <p>catagroy</p>
 */
@Table(name = "giggle_catagroy")
public class Catagroy implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long catagroyId;

    @Column(name = "catagroy_name")
    @NotNull
    private String catagroyName;

    public Catagroy() {
    }

    public Catagroy(@NotNull String catagroyName) {
        this.catagroyName = catagroyName;
    }

    public Long getCatagroyId() {
        return catagroyId;
    }

    public void setCatagroyId(Long catagroyId) {
        this.catagroyId = catagroyId;
    }

    public String getCatagroyName() {
        return catagroyName;
    }

    public void setCatagroyName(String catagroyName) {
        this.catagroyName = catagroyName;
    }

    @Override
    public String toString() {
        return "Catagroy{" +
                "catagroyId=" + catagroyId +
                ", catagroyName='" + catagroyName + '\'' +
                '}';
    }
}
