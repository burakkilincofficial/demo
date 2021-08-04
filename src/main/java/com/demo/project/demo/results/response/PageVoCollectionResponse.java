package com.demo.project.demo.results.response;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(callSuper = true)
public class PageVoCollectionResponse<T> extends BaseResponse {
    private final T data;

    public PageVoCollectionResponse() {
        super("SUCCESS", "");
        this.data = null;
    }

    public PageVoCollectionResponse(T data) {
        super("SUCCESS", "");
        this.data = data;
    }

    public PageVoCollectionResponse(String errorCode, String errorMsg, T data) {
        super(errorCode, errorMsg);
        this.data = data;
    }
}
