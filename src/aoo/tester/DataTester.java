package aoo.tester;

/**
 * Created by Juju on 4/20/2016.
 */
abstract class DataTester {

    public boolean isEmpty(String s) {
        return s.trim().isEmpty();
    }

    public boolean isInt(String s) {
        try {
            Integer.parseInt(s);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

}
