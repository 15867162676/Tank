package RuanKao.rk202105.t6;

import java.util.List;

/**
 * @author TF014268
 * @description 菜单抽象类
 * @since 2021/9/10 0010 9:02
 */
public abstract class MenuComponent {
    protected String name;

    //打印名称
    public void printName(){
        System.out.println(name);
    }

    //添加  子操作
    public abstract boolean addMenuElement(MenuComponent element);
    //删除  子操作
    public abstract boolean removeMenuElement(MenuComponent element);
    //查询子
    public abstract List<MenuComponent> getElement();
}
