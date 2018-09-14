package giggles.giggle.app.service;

import java.util.List;

import giggles.giggle.domain.entity.Comment;

/**
 * @author zty
 *
 * <p>评论业务层</p>
 */
public interface CommentService {
    /**
     * <p>存入一条评论</p>
     *
     * @param comment
     * @return
     */
    public Comment create(Comment comment);

    /**
     * <p>查询子评论</p>
     *
     * @param commentId
     * @return
     */
    public List<Comment> listChildrenComments(Integer commentId);

    /**
     * <p>删除评论</p>
     *
     * @param commentId
     * @return
     */
    public int deleteComments(Integer commentId);
}
