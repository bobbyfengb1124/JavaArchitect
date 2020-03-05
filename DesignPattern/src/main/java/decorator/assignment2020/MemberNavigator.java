package decorator.assignment2020;

import java.util.List;

public class MemberNavigator extends NavigatorDecorator {
    public MemberNavigator(Navigator navigator) {
        super(navigator);
    }

    @Override
    protected List<String> getMenuItems() {
        List<String> menuItems;
        menuItems = super.getMenuItems();
        menuItems.add("作业");
        menuItems.add("题库");
        menuItems.add("成长墙");
        return menuItems;
    }
}
