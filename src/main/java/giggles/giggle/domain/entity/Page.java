package giggles.giggle.domain.entity;

import javax.validation.constraints.Min;

/**
 * @author zty
 *
 * <p>page</p>
 */
public class Page {

    @Min(0)
    private int pageNum;
    @Min(0)
    private int pageSize;
    private String sort;

    public Page() {
    }

    public Page(int pageNum, int pageSize, String sort) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.sort = sort;
    }

    public Page(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
