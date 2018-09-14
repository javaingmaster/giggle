package giggles.giggle.app.service.impl;

import java.util.List;

import giggles.giggle.app.service.CommentService;
import giggles.giggle.domain.entity.Comment;
import giggles.giggle.domain.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zty
 *
 * <p>评论业务实现</p>
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment create(Comment comment) {
        return commentRepository.save(comment);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Comment> listChildrenComments(Integer commentId) {
        return commentRepository.getChildrenComments(commentId);
    }

    @Override
    public int deleteComments(Integer commentId) {
        return commentRepository.delete(commentId);
    }
}
