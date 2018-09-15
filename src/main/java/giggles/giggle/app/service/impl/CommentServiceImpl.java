package giggles.giggle.app.service.impl;

import java.util.List;

import giggles.giggle.app.service.CommentService;
import giggles.giggle.domain.entity.Comment;
import giggles.giggle.domain.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * @author zty
 *
 * <p>comment service impl</p>
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class CommentServiceImpl implements CommentService {
    @Autowired
    private DataSourceTransactionManager transactionManager;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment create(Comment comment) {
        return commentRepository.save(comment);
    }

    @Transactional(rollbackFor = RuntimeException.class, readOnly = true)
    @Override
    public List<Comment> listChildrenComments(Integer commentId) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setName("SomeTxName");
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        TransactionStatus status = transactionManager.getTransaction(def);
        try {
            return commentRepository.getChildrenComments(commentId);
        } catch (Exception e) {
            transactionManager.rollback(status);
            throw new RuntimeException("throw exception when listing children");
        }
    }

    @Override
    public int deleteComments(Integer commentId) {
        return commentRepository.delete(commentId);
    }
}
