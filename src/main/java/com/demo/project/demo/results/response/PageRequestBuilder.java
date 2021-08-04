package com.demo.project.demo.results.response;

import com.demo.project.demo.dto.EmployeeQuery;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public class PageRequestBuilder {
    public PageRequestBuilder() {
    }

    public static PageRequest build(EmployeeQuery query) {
        if (query.getSortDirection() == null || query.getSortBy() == null) {
            return PageRequest.of(Math.max(0, query.getPage() - 1), Math.max(0, query.getPageSize()));
        }
        return PageRequest.of(Math.max(0, query.getPage() - 1),
                Math.max(0, query.getPageSize()),
                Sort.Direction.valueOf(query.getSortDirection().toUpperCase()),
                query.getSortBy());
    }
}
