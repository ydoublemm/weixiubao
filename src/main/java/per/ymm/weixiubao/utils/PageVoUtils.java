package per.ymm.weixiubao.utils;

import per.ymm.weixiubao.vo.PageVo;

/**
 * @Author: ymm
 * @Date: 2018/6/21 21:42
 * @Description:
 */
public class PageVoUtils {
    public  static void check(PageVo page){
        Integer currentPage = page.getCurrentPage();
        Integer pageSize = page.getPageSize();
        if(currentPage==null || currentPage<=0){
            page.setCurrentPage(1);
        }
        if(pageSize==null || pageSize<=0){
            page.setPageSize(7);
        }
    }
}
