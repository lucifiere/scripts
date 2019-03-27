package com.lucifiere.result;

import java.util.ArrayList;
import java.util.List;

/**
 * 调用结果-列表
 *
 * @author XD.Wang
 * @date 2018/9/23.
 */
public class ListResult<T> {

    private static final long serialVersionUID = 7860817246881361024L;

    private List<T> dataList = new ArrayList<>();

    public ListResult() {
    }

    public static <S> ListResult<S> newSucRes(List<S> data) {
        ListResult<S> result = new ListResult<>();
        result.setDataList(data);
        return result;
    }

    public List<T> getDataList() {
        return this.dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

}
