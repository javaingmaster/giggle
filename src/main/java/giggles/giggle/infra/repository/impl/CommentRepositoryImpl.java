package giggles.giggle.infra.repository.impl;

import java.util.Date;
import java.util.List;

import giggles.giggle.domain.entity.Comment;
import giggles.giggle.domain.repository.CommentRepository;
import giggles.giggle.infra.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author zty
 *
 * <p>评论持久层实现</p>
 */
@Repository
public class CommentRepositoryImpl implements CommentRepository {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public Comment save(Comment comment) {
        comment.setCommentTime(new Date());
        commentMapper.insert(comment);
        if (comment.getCommentParent() != 0) {
            commentMapper.buildRelationBetweenComments(comment);
        }
        return comment;
    }

    @Override
    public int delete(Integer commentId) {
        int count = 0;

        if (commentId > 0) {
            commentMapper.updateCommentBeforeDeleteComments(commentId);
        }
        while (commentId > 0) {
            commentMapper.deleteComment(commentId);
            Comment comment = commentMapper.getCommentIdByCommentParent(commentId);
            if (comment == null) {
                break;
            }
            commentId = comment.getCommentId();
            count++;
        }
        return count;
    }

    @Override
    public List<Comment> getChildrenComments(Integer commentId) {
        if (commentId > 0) {
            return commentMapper.listChildrenComments(commentId);
        }
        return null;
    }
}
