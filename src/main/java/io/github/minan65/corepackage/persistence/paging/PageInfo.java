package io.github.minan65.corepackage.persistence.paging;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageInfo {
    private int page;
    private int size;
}
