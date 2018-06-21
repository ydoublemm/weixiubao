package per.ymm.weixiubao.vo;

/**
 * @Author: ymm
 * @Date: 2018/6/21 13:20
 * @Description:
 */
public class PageVo {
    private Integer currentPage;//当前页
    private Integer pageSize;//每页大小
    private Integer totalCount;//总记录数
    private Integer totalPage;//总页数

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(final Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(final Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(final Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(final Integer totalPage) {
        this.totalPage = totalPage;
    }
}
