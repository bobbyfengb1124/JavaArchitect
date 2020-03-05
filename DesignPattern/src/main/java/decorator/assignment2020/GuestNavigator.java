package decorator.assignment2020;

import java.util.ArrayList;
import java.util.List;

public class GuestNavigator extends Navigator {
    @Override
    protected List<String> getMenuItems() {
        List<String> items = new ArrayList<>();
        items.add("问答");
        items.add("文章");
        items.add("精品课");
        items.add("冒泡");
        items.add("商城");
        return items;
    }
}
