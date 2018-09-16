package giggles.giggle.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author zty
 *
 * <p>history</p>
 */
@Table(name = "giggle_history")
public class History implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long historyId;

    @Column(name = "user_id")
    @NotNull
    private Long userId;

    @Column(name = "video_id")
    @NotNull
    private Long videoId;

    @Column(name = "watch_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date watchTime;

    @Column(name = "is_collection")
    private Integer isCollection;

    public History() {
    }

    public History(@NotNull Long userId, @NotNull Long videoId) {
        this.userId = userId;
        this.videoId = videoId;
    }

    public Long getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Long historyId) {
        this.historyId = historyId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getVideoId() {
        return videoId;
    }

    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }

    public Date getWatchTime() {
        return watchTime;
    }

    public void setWatchTime(Date watchTime) {
        this.watchTime = watchTime;
    }

    public Integer getIsCollection() {
        return isCollection;
    }

    public void setIsCollection(Integer isCollection) {
        this.isCollection = isCollection;
    }

    @Override
    public String toString() {
        return "History{" +
                "historyId=" + historyId +
                ", userId=" + userId +
                ", videoId=" + videoId +
                '}';
    }
}
