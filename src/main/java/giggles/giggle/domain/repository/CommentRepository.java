package giggles.giggle.domain.repository;

import java.util.List;

import giggles.giggle.domain.entity.Comment;

/**
 * @author zty
 *
 * <p>评论类</p>
 */
public interface CommentRepository {
    /**
     * <p>存入评论</p>
     *
     * @param comment
     * @return
     */
    public Comment save(Comment comment);

    /**
     * <p>删除评论</p>
     *
     * @param commentId
     * @return
     */
    public int delete(Integer commentId);

    /**
     * <p>递归查询子评论</p>
     *
     * @param commentId
     * @return
     */
    public List<Comment> getChildrenComments(Integer commentId);
}
