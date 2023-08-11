
public class Vendor extends User {

    private int opticalZoom;
    private List<DayMenu> dayMenus;

    public Vendor(String assetTag, String description, int opticalZoom) {
        super(assetTag, description);
        this.opticalZoom = opticalZoom;
        this.dayMenus = new ArrayList<>();
    }

    public int getOpticalZoom() {
        return opticalZoom;
    }

    public void addMenuForDay(String day, DayMenu menu) {
        dayMenus.add(new DayMenu(day, menu));
    }

    public void updateMenuForDay(String day, DayMenu newMenu) {
        for (DayMenu menu : dayMenus) {
            if (menu.getDay().equals(day)) {
                menu.setMenu(newMenu);
                break;
            }
        }
    }

    public void deleteMenuForDay(String day) {
        dayMenus.removeIf(menu -> menu.getDay().equals(day));
    }

    public DayMenu getMenuForDay(String day) {
        for (DayMenu menu : dayMenus) {
            if (menu.getDay().equals(day)) {
                return menu;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String output = "Vendor Information:\n";
        output += "Asset Tag: " + getAssetTag() + "\n";
        output += "Description: " + getDescription() + "\n";
        output += "Optical Zoom: " + opticalZoom + "\n";
        output += "Day Menus:\n";
        for (DayMenu menu : dayMenus) {
            output += menu.toString() + "\n";
        }
        return output;
    }

    public static class DayMenu {
        private String day;
        private Menu menu;

        public DayMenu(String day, Menu menu) {
            this.day = day;
            this.menu = menu;
        }

        public String getDay() {
            return day;
        }

        public void setMenu(Menu menu) {
            this.menu = menu;
        }

        public Menu getMenu() {
            return menu;
        }

        @Override
        public String toString() {
            return day + ":\n" + menu.toString();
        }
    }

    public static class Menu {
        private List<String> items;

        public Menu() {
            this.items = new ArrayList<>();
        }

        public void addItem(String item) {
            items.add(item);
        }

        public void updateItem(int index, String newItem) {
            if (index >= 0 && index < items.size()) {
                items.set(index, newItem);
            }
        }

        public void deleteItem(int index) {
            if (index >= 0 && index < items.size()) {
                items.remove(index);
            }
        }

        @Override
        public String toString() {
            StringBuilder menuOutput = new StringBuilder();
            for (int i = 0; i < items.size(); i++) {
                menuOutput.append(i + 1).append(": ").append(items.get(i)).append("\n");
            }
            return menuOutput.toString();
        }
    }
}
