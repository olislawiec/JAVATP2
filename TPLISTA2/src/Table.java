import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.*;


public class Table extends Frame implements ActionListener, ChangeListener{
	private static final long serialVersionUID = 1L;
    
    WindowAdapter close = new WindowAdapter()
    {
    public void windowClosing(WindowEvent e) 
        {
        System.exit(0);
        }
    };
    public Label QuantPlayers,QuantCards;
    public TextField Players,Cards;
    public TextArea Wynik;
    public Button Start;
    Deck dk = new Deck();
    public Label text;
	Table()
	{	 
	
    dk.shuffle();
    
    setSize(400,150);
    setTitle("Dane");
    setLayout(new GridLayout(3,2));
    QuantPlayers = new Label("Podaj iloœæ graczy");
    QuantCards= new Label("Podaj iloœæ kart");
    Players=new TextField("");
    Cards=new TextField("");
    Start=new Button("Start");
    Start.addActionListener(this);
    add(QuantPlayers);
    add(Players);
    add(QuantCards);
    
    add(Cards);
    add(Start);
    addWindowListener(close);
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try
        {
                if(e.getSource()==Start)
                {
                	int IloscG=Integer.parseInt(Players.getText());
                	int IloscC=Integer.parseInt(Cards.getText());
                	if(IloscG*IloscC>54)
                	{
                		JOptionPane.showMessageDialog(new JFrame(), "Za duze liczby", "Error",
                		        JOptionPane.ERROR_MESSAGE);
                		}
                	else
                	{
                		setVisible(false);
                		setSize(300,300);
                		remove(Start);
                		remove(Cards);
                		remove(QuantCards);
                		remove(Players);
                		remove(QuantPlayers);
                		Wynik=new TextArea();
                		add(Wynik);
                		Wynik.setSize(300,300);
                		for(int i=0;i<IloscG;i++)
                		{
                			Wynik.setText(Wynik.getText()+"Gracz"+(i+1)+": ");
                		
                			for(int j=0;j<IloscC;j++)
                			{
                				Card card=dk.takeCard();
                				Wynik.setText(Wynik.getText()+card.getRank()+"-"+card.getSuit()+" ");
                				
                			}
                			Wynik.setText(Wynik.getText()+""+'\n');
                			
                		}
                		
                		setVisible(true);
                	}
                }
                
        }
		catch(NumberFormatException ex)
        {
                System.out.println("Bledne dane!");
        }
        
		
	}
	
	public static void main(String []args)
	{
		Table table=new Table();
		table.setVisible(true);
	}
}
