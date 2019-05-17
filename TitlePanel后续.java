import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * 无边窗口标题
 */
class TitleJpanel extends JPanel{
    Bounds size=new Bounds();
    ColseButton b1=new ColseButton();
    OptionButton b2=new OptionButton();
    DateUp d=new DateUp();
    TitleJpanel(){
        setLayout(new FlowLayout(2,2,0));
        setPreferredSize(new Dimension(size.w,b1.Close1.getIconHeight()+5));
        setBackground(new Color(75,75,75));
        add(d);
        add(b2);
        add(b1);
        new Thread(()->d.run(),"timeThread").start();
    }
}
/**
 * 关闭按钮
 */
class ColseButton extends JButton {
    ImageIcon Close1=new ImageIcon("icon/Close1.png");
    Color a1=new Color(138,0,50);
    Color a2=new Color(220,20,60);
    ColseButton(){
        setBorder(new EmptyBorder(0,0,0,0));
        setIcon(Close1);
        setBackground(a1);
        setEnabled(false);
        setPreferredSize(new Dimension(Close1.getIconWidth(),Close1.getIconHeight()));
        addMouseListener(new MouseAdapter() {
            byte i=0;
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getButton()==1) {
                    System.exit(0);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(i==1&&e.getButton()==1) {
                    System.exit(0);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                i=1;
                setBackground(a2);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                i=2;
                setBackground(a1);
            }
        });
    }
}

/**
 * 选项按钮
 */
class OptionButton extends JButton implements Runnable{
    ImageIcon Option1=new ImageIcon("icon/Option1.png");
    Color a1=new Color(200,200,200);
    Color a2=new Color(255,153,60);
    int i=4;
    static byte e1=0;
    Thread a=null;
    OptionButton(){
        setBorder(new EmptyBorder(0,0,0,0));
        setIcon(Option1);
        setBackground(a1);
        setEnabled(false);
        setPreferredSize(new Dimension(Option1.getIconWidth(),Option1.getIconHeight()));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switch (e.getButton()){
                    case 1:break;
                    case 3:if (e1>10){
                        a=new Thread(()->run(),"OptionButton");
                        q=true;
                        a.start();
                        e1=0;
                    }else {
                        q=false;
                    }break;
                    default:break;
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(a2);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                e1++;
                setBackground(a1);
            }
        });
    }
    volatile boolean q=true;
    public void run(){
        ArrayList s=new ArrayList();
        for (i=0;i<=4;i++) s.add(new ImageIcon("icon/Option/"+i+".png"));
        while(q){
            i--;
            if (i==-1){
                i=4;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setIcon((Icon) s.get(i));
        }
        setIcon(Option1);
    }
}
