package giggles.giggle.infra.mapper;

import java.util.List;

import giggles.giggle.domain.entity.Comment;
import giggles.giggle.infra.tkMapper.TkMapper;

/**
 * @author zty
 *
 * <p>评论mapper</p>
 */
public interface CommentMapper extends TkMapper<Comment> {
    /**
     * <p>get comments from a commentId</p>
     *
     * @param commentId
     * @return
     */
    public List<Comment> listChildrenComments(Integer commentId);

    /**
     * <p>set childId of parent</p>
     *
     * @param comment
     * @return
     */
    public int buildRelationBetweenComments(Comment comment);

    /**
     * <p>delete the comment</p>
     *
     * @param commentId
     * @return
     */
    public int deleteComment(Integer commentId);

    /**
     * <p>get commentId through another commentId as the parent of this ,
     * and the function is used with the function above ,
     * this function has a low efficiency,
     * so it will be replaced with a procedure in database</p>
     *
     * @param commentId
     * @return
     */
    public Comment getCommentIdByCommentParent(Integer commentId);

    /**
     * <p>update the comment_child column before a comment is deleted</p>
     *
     * @return
     */
    public int updateCommentBeforeDeleteComments(Integer commentId);
}
