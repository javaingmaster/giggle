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
public class Video extends AuditDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer videoId;

    @Column(name = "video_name")
    @NotNull
    private String videoName;

    @Column(name = "video_description")
    private String videoDescription;

    @Column(name = "video_upload_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date videoUploadTime;

    @Column(name = "video_path")
    private String videoPath;

    @Column(name = "video_check")
    private Integer videoCheck;

    @Column(name = "video_like")
    private Integer videoLike;

    @Column(name = "video_collection")
    private Integer videoCollection;

    @Column(name = "video_play")
    private Integer videoPlay;

    private List<Catagroy> catagroys;

    public Video() {
    }

    public Video(@NotNull String videoName) {
        this.videoName = videoName;
    }

    public Video(@NotNull String videoName, String videoDescription, Date videoUploadTime) {
        this.videoName = videoName;
        this.videoDescription = videoDescription;
        this.videoUploadTime = videoUploadTime;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getVideoDescription() {
        return videoDescription;
    }

    public List<Catagroy> getCatagroys() {
        return catagroys;
    }

    public void setCatagroys(List<Catagroy> catagroys) {
        this.catagroys = catagroys;
    }

    public void setVideoDescription(String videoDescription) {
        this.videoDescription = videoDescription;
    }

    public Date getVideoUploadTime() {
        return videoUploadTime;
    }

    public void setVideoUploadTime(Date videoUploadTime) {
        this.videoUploadTime = videoUploadTime;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public Integer getVideoCheck() {
        return videoCheck;
    }

    public void setVideoCheck(Integer videoCheck) {
        this.videoCheck = videoCheck;
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

    @Override
    public String toString() {
        return "Video{" +
                "videoId=" + videoId +
                ", videoName='" + videoName + '\'' +
                ", videoUploadTime=" + videoUploadTime +
                '}';
    }
}
