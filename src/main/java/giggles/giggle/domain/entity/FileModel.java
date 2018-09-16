package giggles.giggle.domain.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author zty
 *
 * <p>file model params</p>
 */
public class FileModel extends AuditDomain{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long fileId;

    @Column(name = "file_name")
    @NotNull
    protected String fileName;

    @Column(name = "file_publisher")
    @NotNull
    protected String filePublisher;

    @Column(name = "file_description")
    protected String fileDescription;

    @Column(name = "file_upload_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    protected Date fileUploadTime;

    @Column(name = "file_path")
    protected String filePath;

    @Column(name = "file_check")
    protected Integer fileCheck;

    public FileModel() {
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getFilePublisher() {
        return filePublisher;
    }

    public void setFilePublisher(String filePublisher) {
        this.filePublisher = filePublisher;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileDescription() {
        return fileDescription;
    }

    public void setFileDescription(String fileDescription) {
        this.fileDescription = fileDescription;
    }

    public Date getFileUploadTime() {
        return fileUploadTime;
    }

    public void setFileUploadTime(Date fileUploadTime) {
        this.fileUploadTime = fileUploadTime;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Integer getFileCheck() {
        return fileCheck;
    }

    public void setFileCheck(Integer fileCheck) {
        this.fileCheck = fileCheck;
    }
}
