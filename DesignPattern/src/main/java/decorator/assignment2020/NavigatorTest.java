package decorator.assignment2020;

import java.util.List;

public class NavigatorTest {
    public static void main(String[] args) {
        Navigator guestNavigator = new GuestNavigator();
        List<String> items = guestNavigator.getMenuItems();
        displayItems(items);

        Navigator memberNavigator = new MemberNavigator(guestNavigator);
        items = memberNavigator.getMenuItems();
        displayItems(items);
    }

    private static void displayItems(List<String> items) {
        for (String item : items) {
            System.out.print(item + " ");
        }

        System.out.println();
    }
}
