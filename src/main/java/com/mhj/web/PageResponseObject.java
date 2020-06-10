package com.mhj.web;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * @author mahuijian
 * @since 2020-04-01
 */
public class PageResponseObject<T> extends AbstractResponse<T> {
    protected List<T> data;
    protected long totalCount;
    protected long pageSize;
    protected long totalPage;
    protected long currPage = 1L;

    public PageResponseObject() {
    }

    public static <S> PageResponseObject<S> success() {
        PageResponseObject<S> responseObject = new PageResponseObject();
        responseObject.setStatus(HttpStatus.OK.value());
        responseObject.setMessage("success");
        return responseObject;
    }

    public static <S> PageResponseObject<S> success(List<S> payload) {
        PageResponseObject<S> responseObject = new PageResponseObject();
        responseObject.setStatus(HttpStatus.OK.value());
        responseObject.setMessage("success");
        responseObject.setData(payload);
        return responseObject;
    }

    public static <S> PageResponseObject<S> internalError() {
        PageResponseObject<S> responseObject = new PageResponseObject();
        responseObject.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return responseObject;
    }

    public static <S> PageResponseObject<S> unauthorized() {
        PageResponseObject<S> responseObject = new PageResponseObject();
        responseObject.setStatus(HttpStatus.UNAUTHORIZED.value());
        return responseObject;
    }

    public static <S> PageResponseObject<S> unauthorized(String message) {
        PageResponseObject<S> responseObject = new PageResponseObject();
        responseObject.setStatus(HttpStatus.UNAUTHORIZED.value());
        responseObject.setMessage(message);
        return responseObject;
    }

    private static <S> PageResponseObject<S> notFound() {
        PageResponseObject<S> responseObject = new PageResponseObject();
        responseObject.setStatus(HttpStatus.NOT_FOUND.value());
        return responseObject;
    }

    public static <S> PageResponseObject<S> internalError(String message) {
        Preconditions.checkArgument(message != null && !Strings.isNullOrEmpty(message), "message不能为空");
        PageResponseObject<S> responseObject = new PageResponseObject();
        responseObject.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        responseObject.setMessage(message);
        return responseObject;
    }

    public static <S> PageResponseObject<S> badRequest(String message) {
        Preconditions.checkArgument(message != null && !Strings.isNullOrEmpty(message), "message不能为空");
        PageResponseObject<S> responseObject = new PageResponseObject();
        responseObject.setStatus(HttpStatus.BAD_REQUEST.value());
        responseObject.setMessage(message);
        return responseObject;
    }

    public static <S> PageResponseObject<S> fail(int code, String message) {
        Preconditions.checkArgument(code > 0, "code必须大于0,请参考http状态的定义");
        Preconditions.checkArgument(message != null && !Strings.isNullOrEmpty(message), "message不能为空");
        PageResponseObject<S> responseObject = new PageResponseObject();
        responseObject.setStatus(code);
        responseObject.setMessage(message);
        return responseObject;
    }

    public boolean checkOk() {
        return this.status == HttpStatus.OK.value();
    }

    public long getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public long getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalPage() {
        return this.totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public long getCurrPage() {
        return this.currPage;
    }

    public void setCurrPage(long currPage) {
        this.currPage = currPage;
    }

    public List<T> getData() {
        return this.data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String toString() {
        return "PageResponseObject{data=" + this.data + ", totalCount=" + this.totalCount + ", pageSize=" + this.pageSize + ", totalPage=" + this.totalPage + ", currPage=" + this.currPage + ", status=" + this.status + ", message='" + this.message + '\'' + '}';
    }
}
