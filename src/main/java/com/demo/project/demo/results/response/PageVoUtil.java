package com.demo.project.demo.results.response;

import org.springframework.data.domain.Page;

public class PageVoUtil {
    public PageVoUtil() {
    }

    public static PageVO getPageVO(Page<?> employee) {
        PageVO pageVO = new PageVO();
        pageVO.setPageNo(employee.getPageable().getPageNumber() + 1);
        pageVO.setPageSize(employee.getPageable().getPageSize());
        pageVO.setTotalPage(employee.getTotalPages());
        pageVO.setTotalRecords((int) employee.getTotalElements());
        return pageVO;
    }
}
