package io.github.minan65.corepackage.application.responses;

import io.github.minan65.corepackage.persistence.paging.BasePageableModel;

import java.util.ArrayList;
import java.util.List;

public class GetListPaginationResponse<T> extends BasePageableModel {
    private List<T> items;

    public List<T> getItems(){
        if(items==null){
            items = new ArrayList<T>();
        }
        return items;
    }

    public void setItems(List<T> items){
        this.items=items;
    }
}
