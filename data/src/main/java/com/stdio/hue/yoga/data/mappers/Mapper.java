package com.stdio.hue.yoga.data.mappers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 09/07/2017.
 */

public abstract class Mapper<E,M> {
    public abstract M transform(E entity);

    public List<M> transform(List<E> entities){
        List<M> modelList = new ArrayList<>();
        if (entities!=null && !entities.isEmpty()){
            for (E e : entities) {
                modelList.add(transform(e));
            }
        }
        return modelList;
    }
}
