package com.stdio.hue.yoga.data.mappers;

import com.stdio.hue.yoga.data.models.Collection;
import com.stdio.hue.yoga.network.GetCollectionQuery;

/**
 * Created by TranHuuPhuc on 11/7/18.
 */
public class CollectionMapper extends Mapper<GetCollectionQuery.Collection, Collection> {
    @Override
    public Collection transform(GetCollectionQuery.Collection entity) {
        Collection collection = null;
        if (entity != null) {
            collection = new Collection();
            collection.setId(entity.id());
            collection.setName(entity.name());
            collection.setCreatedAt(entity.created_at());
            collection.setUpdatedAt(entity.updated_at());
            collection.setImage(entity.image());
            collection.setDescription(entity.description());
            collection.setCategoryId(entity.category_id());
        }
        return collection;
    }
}
