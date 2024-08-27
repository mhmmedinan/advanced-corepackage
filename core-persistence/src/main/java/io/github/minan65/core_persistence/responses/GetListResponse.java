package io.github.minan65.core_persistence.responses;

import java.util.ArrayList;
import java.util.List;

public class GetListResponse<T> {
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
