package aoo.gui.partials;

/**
 * Created by Juju on 3/30/2016.
 */
public class ProductTab extends TabMenu {

    private static final String[] columnList = {
            "ID",
            "Name",
            "Category",
            "Description",
            "Part No.",
            "Cost",
            "Price"
    };

    public ProductTab() {
        super(columnList);
    }

}
