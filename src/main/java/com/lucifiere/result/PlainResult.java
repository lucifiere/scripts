package com.lucifiere.result;

/**
 * 调用结果-简单对象
 *
 * @author XD.Wang
 * @date 2018/9/23.
 */
public class PlainResult<T> extends BaseResult {

    private static final long serialVersionUID = 8190808030433290273L;

    private T data;

    public PlainResult() {
    }

    public static <S> PlainResult<S> newSucRes(S data) {
        PlainResult<S> result = new PlainResult<>();
        result.setData(data);
        return result;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isDataPresent() {
        return this.data != null;
    }

}
