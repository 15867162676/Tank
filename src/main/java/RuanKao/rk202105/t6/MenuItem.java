package RuanKao.rk202105.t6;

import java.util.List;

/**
 * @author TF014268
 * @description 叶子节点
 * @since 2021/9/10 0010 9:07
 */
public class MenuItem extends MenuComponent{
    public MenuItem(String name){
        this.name = name;
    }

    @Override
    public boolean addMenuElement(MenuComponent element) {
        return false;
    }

    @Override
    public boolean removeMenuElement(MenuComponent element) {
        return false;
    }

    @Override
    public List<MenuComponent> getElement() {
        return null;
    }
}
