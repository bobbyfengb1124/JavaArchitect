package decorator.assignment2020;

import java.util.List;

public abstract class NavigatorDecorator extends Navigator {
    private Navigator navigator;

    public NavigatorDecorator(Navigator navigator) {
        this.navigator = navigator;
    }

    @Override
    protected List<String> getMenuItems() {
        return this.navigator.getMenuItems();
    }
}
