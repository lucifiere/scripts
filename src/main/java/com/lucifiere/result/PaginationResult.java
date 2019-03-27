package com.lucifiere.result;

import java.util.List;

/**
 * 调用结果-分页列表
 *
 * @author XD.Wang
 * @date 2018/9/23.
 */
public class PaginationResult<T> extends ListResult<T> {

    private static final long serialVersionUID = 1616486553016454395L;

    private PageInfo pageInfo;

    public PaginationResult() {
    }

    public PageInfo getPageInfo() {
        return this.pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public static <S> PaginationResult<S> newSucRes(List<S> data, PageInfo pageInfo) {
        PaginationResult<S> result = new PaginationResult<>();
        result.setDataList(data);
        result.setPageInfo(pageInfo);
        return result;
    }

}
