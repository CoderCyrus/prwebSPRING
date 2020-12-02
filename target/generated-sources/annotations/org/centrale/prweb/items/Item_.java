package org.centrale.prweb.items;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.centrale.prweb.items.Category;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-02T23:31:59")
@StaticMetamodel(Item.class)
public class Item_ { 

    public static volatile SingularAttribute<Item, String> author;
    public static volatile SingularAttribute<Item, Integer> id;
    public static volatile SingularAttribute<Item, String> title;
    public static volatile SingularAttribute<Item, String> body;
    public static volatile SingularAttribute<Item, Category> categoryId;

}