package aoo.gui.partials;

/**
 * Created by Juju on 3/25/2016.
 */
public class EmployeeTab extends TabMenu {

    private static final String[] columnList = {
            "ID",
            "Name",
            "Department",
            "Position",
            "Date Hired"
    };

    public EmployeeTab() {
        super(columnList);
    }

}
