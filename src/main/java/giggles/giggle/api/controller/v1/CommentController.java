package giggles.giggle.api.controller.v1;

import javax.validation.Valid;

import giggles.giggle.app.service.CommentService;
import giggles.giggle.domain.entity.Comment;
import giggles.giggle.infra.util.exception.ConBindingResultException;
import giggles.giggle.infra.util.exception.ConMissRequestParamException;
import giggles.giggle.infra.util.interfaces.Permission;
import giggles.giggle.infra.util.result.Results;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * @author zty
 *
 * <p>comments controller</p>
 */
@RestController
@RequestMapping("/v1/comments")
@CrossOrigin
@Api("controller for comments api")
public class CommentController {
    private static final Logger logger = Logger.getLogger(CommentController.class);

    @Autowired
    private CommentService commentService;

    @PostMapping
    @ApiOperation("insert a comment")
    @Permission(level = 2)
    public Object create(@Valid @RequestBody Comment comment, BindingResult bindingResult) {
        logger.info("create a comment");
        if (bindingResult.hasErrors()) {
            throw new ConBindingResultException("create request data is illegal when insert a comment " + bindingResult.getFieldError().getDefaultMessage());
        }
        return Results.created(commentService.create(comment));
    }

    /**
     * <p>get children comments</p>
     *
     * @param commentId
     * @return
     */
    @GetMapping("/{commentId}")
    @ApiOperation("list children comments")
    @Permission(level = 2)
    public Object listChildren(@PathVariable(value = "commentId", required = true) Integer commentId) {
        logger.info("list children comments");
        if (commentId == null) {
            throw new ConMissRequestParamException("need a commentId when executing listChildren");
        }
        return Results.success(commentService.listChildrenComments(commentId));
    }

    @DeleteMapping("/{commentId}")
    @ApiOperation("delete children conmments")
    @Permission
    public Object deleteComments(@PathVariable(value = "commentId", required = true) Integer commentId) {
        logger.info("delete comments");
        if (commentId == null) {
            throw new ConMissRequestParamException("need a commentId when executing deleteComments");
        }
        return Results.success(commentService.deleteComments(commentId));
    }
}
