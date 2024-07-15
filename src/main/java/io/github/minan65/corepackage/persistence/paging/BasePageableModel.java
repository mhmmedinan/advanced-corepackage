package io.github.minan65.corepackage.persistence.paging;

import lombok.Data;

@Data
public class BasePageableModel {
    private int totalPages;
    private long totalElements;
    private boolean hasNext;
    private boolean hasPrevious;
    private int size;
}
