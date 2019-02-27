package com.result;

/**
 * 分页信息
 *
 * @author XD.Wang
 * @date 2018/9/23.
 */
public class PageInfo {

    private static final long serialVersionUID = -1213662953102038221L;

    private int curPage;
    private long items;
    private long totalPage;
    private int itemsPerPage;

    public PageInfo() {
    }

    public int getCurPage() {
        return this.curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public long getItems() {
        return this.items;
    }

    public void setItems(long items) {
        this.items = items;
    }

    public long getTotalPage() {
        return this.totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public int getItemsPerPage() {
        return this.itemsPerPage;
    }

    public void setItemsPerPage(int itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }
}
