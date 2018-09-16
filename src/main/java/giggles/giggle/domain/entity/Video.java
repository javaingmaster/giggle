package giggles.giggle.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author zty
 *
 * <p>video</p>
 */
@Table(name = "giggle_video")
public class Video extends FileModel {

    @Column(name = "video_like")
    private Integer videoLike;

    @Column(name = "video_collection")
    private Integer videoCollection;

    @Column(name = "video_play")
    private Integer videoPlay;

    private List<Catagroy> catagroys;

    public Video() {
    }

    public Video(String fileName, String filePublisher) {
        this.fileName = fileName;
        this.filePublisher = filePublisher;
    }

    public Video(String fileName, String filePublisher, String fileDescription, Date fileUploadTime) {
        this.fileName = fileName;
        this.fileDescription = fileDescription;
        this.fileUploadTime = fileUploadTime;
        this.filePublisher = filePublisher;
    }

    public Integer getVideoLike() {
        return videoLike;
    }

    public void setVideoLike(Integer videoLike) {
        this.videoLike = videoLike;
    }

    public Integer getVideoCollection() {
        return videoCollection;
    }

    public void setVideoCollection(Integer videoCollection) {
        this.videoCollection = videoCollection;
    }

    public Integer getVideoPlay() {
        return videoPlay;
    }

    public void setVideoPlay(Integer videoPlay) {
        this.videoPlay = videoPlay;
    }

    public List<Catagroy> getCatagroys() {
        return catagroys;
    }

    public void setCatagroys(List<Catagroy> catagroys) {
        this.catagroys = catagroys;
    }
}
