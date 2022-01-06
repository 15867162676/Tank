package RuanKao.rk202105.t6;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TF014268
 * @description 树干节点
 * @since 2021/9/10 0010 9:09
 */
public class Menu extends MenuComponent{
    private List<MenuComponent> elementList;

    public Menu(String name) {
        this.name = name;
        this.elementList = new ArrayList<>();
    }

    @Override
    public boolean addMenuElement(MenuComponent element) {
        return elementList.add(element);
    }

    @Override
    public boolean removeMenuElement(MenuComponent element) {
        return elementList.remove(element);
    }

    @Override
    public List<MenuComponent> getElement() {
        return elementList;
    }
}
