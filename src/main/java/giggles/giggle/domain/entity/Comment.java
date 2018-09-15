package giggles.giggle.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author zty
 *
 * <p>comment</p>
 */
@Table(name = "giggle_comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;

    @NotNull
    @Column(name = "user_id")
    private Integer userId;

    @NotNull
    @Column(name = "video_id")
    private Integer videoId;

    @NotNull
    @Column(name = "comment_content")
    private String commentContent;

    @Column(name = "comment_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date commentTime;

    @Column(name = "comment_parent")
    private Integer commentParent;

    @Column(name = "comment_child")
    private Integer commentChild;

    private List<Comment> childrenComments;

    public Comment() {
    }

    public Comment(@NotNull Integer userId, @NotNull Integer videoId, @NotNull String commentContent, @NotNull Date commentTime) {
        this.userId = userId;
        this.videoId = videoId;
        this.commentContent = commentContent;
        this.commentTime = commentTime;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public Integer getCommentParent() {
        return commentParent;
    }

    public void setCommentParent(Integer commentParent) {
        this.commentParent = commentParent;
    }

    public Integer getCommentChild() {
        return commentChild;
    }

    public void setCommentChild(Integer commentChild) {
        this.commentChild = commentChild;
    }

    public List<Comment> getChildrenComments() {
        return childrenComments;
    }

    public void setChildrenComments(List<Comment> childrenComments) {
        this.childrenComments = childrenComments;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", userId=" + userId +
                ", videoId=" + videoId +
                ", commentContent='" + commentContent + '\'' +
                '}';
    }
}
