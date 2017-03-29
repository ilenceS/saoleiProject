import javafx.scene.input.MouseButton;
import javafx.scene.layout.Border;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by nietz on 17-3-28.
 */
public class VisibleChess extends JFrame{
    private JButton jb1=new JButton("=_=");
    private JButton [][]chessClicked=new JButton[9][9];
    int [][]MouseButton3Help=new  int[9][9];
    int winHelp=0;
    final Color colorBefore=jb1.getBackground();
    public VisibleChess(){
        chessboard game=new chessboard();
        setLayout(new BorderLayout());
        JPanel jp1=new JPanel();
        jp1.setPreferredSize(new Dimension(40,30));
        jp1.add(jb1);
        add(jp1,BorderLayout.NORTH);
        JPanel cjp=new JPanel();
        //Font f=new Font("粗体",Font.PLAIN,8    );
        cjp.setPreferredSize(new Dimension(180,180));
        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++){
                MouseButton3Help[i][j]=0;
                chessClicked[i][j]=new JButton();
                chessClicked[i][j].setPreferredSize(new Dimension(20,20));
                cjp.add(chessClicked[i][j]);
                int x=i,y=j;
                chessClicked[i][j].addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (e.getButton() == MouseEvent.BUTTON1) {
                            chessClicked[x][y].setMargin(new Insets(0,0,0,0));
                            if(game.chess[x][y]!=9) {
                                chessClicked[x][y].setText(String.valueOf(game.chess[x][y]));
                                winHelp++;
                            }
                            else{
                                jb1.setText("you lose");
                                for(int a=0;a<9;a++){
                                    for(int b=0;b<9;b++){
                                        if(game.chess[a][b]==9){
                                            chessClicked[a][b].setMargin(new Insets(0,0,0,0));
                                            chessClicked[a][b].setText("x");
                                            chessClicked[a][b].setBackground(Color.RED);
                                        }
                                    }
                                }
                            }
                        }
                        else if(e.getButton()==MouseEvent.BUTTON3){
                            if(MouseButton3Help[x][y]==0){
                                chessClicked[x][y].setBackground(Color.GRAY);
                                MouseButton3Help[x][y]=1;
                            }
                            else if(MouseButton3Help[x][y]==1){
                                chessClicked[x][y].setBackground(colorBefore);
                                MouseButton3Help[x][y]=0;
                            }
                        }
                        if(winHelp==72){
                            jb1.setText("you win!");
                        }

                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }
                });
            }

        add(cjp,BorderLayout.CENTER);
    }
    public static void main(String args[]){
        SwingConsole.run(new VisibleChess(),240,260);
    }
}