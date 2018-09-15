package giggles.giggle.app.service;

import java.util.List;

import giggles.giggle.domain.entity.Comment;

/**
 * @author zty
 *
 * <p>comments service</p>
 */
public interface CommentService {
    /**
     * <p>save a comment</p>
     *
     * @param comment
     * @return
     */
    public Comment create(Comment comment);

    /**
     * <p>query comment</p>
     *
     * @param commentId
     * @return
     */
    public List<Comment> listChildrenComments(Integer commentId);

    /**
     * <p>delete comment</p>
     *
     * @param commentId
     * @return
     */
    public int deleteComments(Integer commentId);
}
