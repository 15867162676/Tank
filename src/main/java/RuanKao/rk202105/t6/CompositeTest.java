package RuanKao.rk202105.t6;

import java.util.List;

/**
 * @author TF014268
 * @description 组合模式测试类
 * @since 2021/9/10 0010 9:12
 */
public class CompositeTest {
    public static void main(String[] args) {
        //树干
        MenuComponent mainMenu = new Menu("Insert");
        MenuComponent subMenu = new Menu("Chart");

        //叶子节点
        MenuComponent element =  new MenuItem("On This Sheet");

        mainMenu.addMenuElement(subMenu);
        subMenu.addMenuElement(element);
        //打印树结构
        printMenus(mainMenu);
    }

    private static void printMenus(MenuComponent ifile){
        ifile.printName();
        List<MenuComponent> children = ifile.getElement();
        if(null==children){
            return;
        }

        //递归打印
        for(MenuComponent element : children){
            printMenus(element);
        }
    }

}
