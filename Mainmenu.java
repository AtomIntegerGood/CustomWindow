import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Mainmenu {
    static Bounds bounds=new Bounds();
    static JFrame noWindowsFrame=new NoWindowsFrame();
    static JPanel titleJpanel=new TitleJpanel();
    static JPanel BodyJpanel=new BodyJPanel();
    public static void main(String[] args) {
        noWindowsFrame.add(titleJpanel);
        noWindowsFrame.add(BodyJpanel);
        noWindowsFrame.setBounds(bounds.x,bounds.y,bounds.w,bounds.h);
    }
}
/**
 * 无边窗口模式
 */
class NoWindowsFrame extends JFrame{
    NoWindowsFrame(){
        setUndecorated(true);
        setVisible(true);
        setLayout(new FlowLayout(2,0,0));
    }
}
/**
 *分辨率相关
 */
class Bounds{
    Dimension Screen=Toolkit.getDefaultToolkit().getScreenSize();
    int Sx= (int) Screen.getWidth();
    int Sy= (int) Screen.getHeight();
    int w=1280;
    int h=720;
    int x=Sx/2-w/2;
    int y=Sy/2-h/2;
}

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
    }
}
/**
 * 关闭按钮
 */
class ColseButton extends JButton{
    ImageIcon Close1=new ImageIcon("icon/Close1.png");
    Color a1=new Color(138,0,50);
    Color a2=new Color(220,20,60);
    ColseButton(){
        setBorder(new EmptyBorder(0,0,0,0));
        setIcon(Close1);
        setBackground(a1);
        setPreferredSize(new Dimension(Close1.getIconWidth(),Close1.getIconHeight()));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(a2);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(a1);
            }
        });
    }
}

/**
 * 选项按钮
 */
class OptionButton extends JButton{
    ImageIcon Option1=new ImageIcon("icon/Option1.png");
    Color a1=new Color(200,200,200);
    Color a2=new Color(255,153,60);
    OptionButton(){
        setBorder(new EmptyBorder(0,0,0,0));
        setIcon(Option1);
        setBackground(a1);
        setPreferredSize(new Dimension(Option1.getIconWidth(),Option1.getIconHeight()));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(a2);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(a1);
            }
        });
    }
}


/**
 * 身体窗口
 */
class BodyJPanel extends JPanel{
    Bounds b=new Bounds();
    TitleJpanel titleJpanel=new TitleJpanel();
    BodyJPanel(){
        setPreferredSize(new Dimension(b.w,b.h-titleJpanel.getHeight()));
        setBackground(new Color(200,200,200));
    }
}
/**
 * 日期JPanel
 */
class DateUp extends JLabel{
    ColseButton c=new ColseButton();
    DateUp(){
        setBackground(new Color(75,75,75));
        setPreferredSize(new Dimension(100,c.Close1.getIconHeight()+5));
        Calendar c = Calendar.getInstance();
        DateFormat d=new SimpleDateFormat("HH:mm:ss");
        String s=d.format(c.getTime());
        setText(s);
    }
}
/**
注：自己带img文件，代码不完善button长按会出现被选中凹陷状态 其次日期未加入线程持续更新 option 按钮功能未添加
后续添加首次登陆设置选项和注册选项和config本地文件
*/
