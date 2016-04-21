package aoo.tester;

/**
 * Created by Juju on 4/20/2016.
 */
public class EmployeeTester extends DataTester {

    public boolean testName(String name) {
        return (!isEmpty(name) && name.length() < 50);
    }

    public boolean testDepartment(String deptartment) {
        return (!isEmpty(deptartment) && deptartment.length() < 50);
    }

    public boolean testPosition(String position) {
        return (!isEmpty(position) && position.length() < 25);
    }

    public boolean testYear(String text) {
        return (!isEmpty(text) && isInt(text) && text.length() == 4 && !text.startsWith("19"));
    }

    public boolean testMonth(String text) {
        if (!isEmpty(text) && isInt(text)) {
            int month = Integer.parseInt(text);
            return (month > 0 && month <= 12);
        }
        return false;
    }

    public boolean testDay(String text) {
        if (!isEmpty(text) && isInt(text) ) {
            int day = Integer.parseInt(text);
            return (day > 0 && day < 32);
        }
        return false;
    }

    public boolean testCommissionRate(String text) {
        if(!isEmpty(text) && isDouble(text)) {
            double rate = Double.parseDouble(text);
            return (rate > 0 && rate < 1000);
        }
        return false;
    }

    public boolean testGrossSales(String text) {
        if(!isEmpty(text) && isDouble(text)) {
            double sales = Double.parseDouble(text);
            return (sales > 0 && sales < 100000000); // max in database is dec(10,2)
        }
        return false;
    }
}
