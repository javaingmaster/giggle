package giggles.giggle.domain.entity;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author zty
 *
 * <p>通用实体字段</p>
 */
public class AuditDomain {

    @Column(name = "last_update")
    protected Date lastUpdate;
    @Column(name = "last_update_by")
    protected String lastUpdateBy;
    @NotNull
    @Column(name = "user_version")
    protected Integer userVersion;

    public AuditDomain() {
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public Integer getUserVersion() {
        return userVersion;
    }

    public void setUserVersion(Integer userVersion) {
        this.userVersion = userVersion;
    }
}
