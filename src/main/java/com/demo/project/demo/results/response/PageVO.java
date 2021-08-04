package com.demo.project.demo.results.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.Objects;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PageVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Valid
    @JsonProperty("pageNo")
    private Integer pageNo = null;

    @Valid
    @JsonProperty("pageSize")
    private Integer pageSize = null;

    @Valid
    @JsonProperty("totalRecords")
    private Integer totalRecords = null;

    @Valid
    @JsonProperty("totalPage")
    private Integer totalPage = null;

    public PageVO() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PageVO pageVO = (PageVO) o;
        return Objects.equals(pageNo, pageVO.pageNo) && Objects.equals(pageSize, pageVO.pageSize) && Objects.equals(totalRecords, pageVO.totalRecords) && Objects.equals(totalPage, pageVO.totalPage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pageNo, pageSize, totalRecords, totalPage);
    }

    @Override
    public String toString() {
        return "PageVO{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", totalRecords=" + totalRecords +
                ", totalPage=" + totalPage +
                '}';
    }
}
