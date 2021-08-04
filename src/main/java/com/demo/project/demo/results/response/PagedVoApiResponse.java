package com.demo.project.demo.results.response;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(callSuper = true)
public class PagedVoApiResponse<T> extends PageVoCollectionResponse<T> {
    private final PageVO pageVO;

    public PagedVoApiResponse(T data, PageVO pageVO) {
        super(data);
        this.pageVO = pageVO;
    }
}
