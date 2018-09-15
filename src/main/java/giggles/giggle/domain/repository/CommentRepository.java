package giggles.giggle.domain.repository;

import java.util.List;

import giggles.giggle.domain.entity.Comment;

/**
 * @author zty
 *
 * <p>comment repository</p>
 */
public interface CommentRepository {
    /**
     * <p>save</p>
     *
     * @param comment
     * @return
     */
    public Comment save(Comment comment);

    /**
     * <p>delete</p>
     *
     * @param commentId
     * @return
     */
    public int delete(Integer commentId);

    /**
     * <p>query children comments</p>
     *
     * @param commentId
     * @return
     */
    public List<Comment> getChildrenComments(Integer commentId);
}
