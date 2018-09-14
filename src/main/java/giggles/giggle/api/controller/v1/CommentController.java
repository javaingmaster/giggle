package giggles.giggle.api.controller.v1;

import javax.validation.Valid;

import giggles.giggle.app.service.CommentService;
import giggles.giggle.domain.entity.Comment;
import giggles.giggle.infra.util.exception.C_BindingResultException;
import giggles.giggle.infra.util.exception.C_MissRequestParamException;
import giggles.giggle.infra.util.interfaces.Permission;
import giggles.giggle.infra.util.result.Results;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * @author zty
 *
 * <p>评论控制层</p>
 */
@RestController
@RequestMapping("/v1/comments")
@CrossOrigin
@Api("controller for comments api")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping
    @ApiOperation("insert a comment")
    @Permission(level = 2)
    public Object create(@Valid @RequestBody Comment comment, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new C_BindingResultException("create request data is illegal when insert a comment " + bindingResult.getFieldError().getDefaultMessage());
        }
        return Results.created(commentService.create(comment));
    }

    /**
     * <p>获取子评论</p>
     *
     * @param commentId
     * @return
     */
    @GetMapping("/{commentId}")
    @ApiOperation("list children comments")
    @Permission(level = 2)
    public Object listChildren(@PathVariable(value = "commentId", required = true) Integer commentId) {
        if (commentId == null) {
            throw new C_MissRequestParamException("need a commentId when executing listChildren");
        }
        return Results.success(commentService.listChildrenComments(commentId));
    }

    @DeleteMapping("/{commentId}")
    @ApiOperation("delete children conmments")
    @Permission
    public Object deleteComments(@PathVariable(value = "commentId", required = true) Integer commentId) {
        if (commentId == null) {
            throw new C_MissRequestParamException("need a commentId when executing deleteComments");
        }
        return Results.success(commentService.deleteComments(commentId));
    }
}
