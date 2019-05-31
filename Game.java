package pokemon;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.swing.JLayeredPane;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.plaf.ColorUIResource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import pokemon.Pkmn;
import pokemon.Attack;

public class Game extends JFrame{
 //Pkmn
 static Pkmn glutexo = new Pkmn(true,"Glutexo", "Feuer", null,19,10,10);
 static Pkmn mantax = new Pkmn(true,"Mantax","Wasser","Flug",19,10,10); //374
 static Pkmn voltenso = new Pkmn(true,"Voltenso","Elektro",null,24,10,10);//344
 static Pkmn galagladi = new Pkmn(true,"Galagladi","Psycho","Kampf",31,10,10);//340
 static Pkmn caesurio = new Pkmn(true,"Caesurio","Unlicht","Stahl",33,10,10);//334
 static Pkmn viscogon = new Pkmn(true,"Viscogon","Drache",null,47,10,10);//384

 static Pkmn weberak = new Pkmn(false,"Weberak","Kaefer","Gift",1,284,284);
 static Pkmn nasgnet = new Pkmn(false,"Nasgnet","Gestein",null,1,264,264);
 static Pkmn shnebedeck = new Pkmn(false,"Shnebedeck","Pflanze","Eis",1,324,324);
 static java.util.List<Object> enemy = new ArrayList<>();
 static java.util.List<Object> koFriend = new ArrayList<>();
 static java.util.List<Object> koFiend = new ArrayList<>();

 
 static Pkmn PkmnNo1 = glutexo;
 static Pkmn PkmnNo2 = mantax;
 static Pkmn PkmnNo3 = voltenso;
 static Pkmn PkmnNo4 = galagladi;
 static Pkmn PkmnNo5 = caesurio;
 static Pkmn PkmnNo6 = viscogon;
 static Pkmn curPkmnobj = glutexo;
 static Pkmn prevPkmn;
 static Pkmn curEnemy;
 static Attack curAt;
 public Pkmn reObj;


 static boolean ePresence = false;
 static boolean inDrain = false;
 static boolean ko = false;

 static int killCount = 0;
 static int curlvl = 1;
 static int highscore = 0;

  static ActionListener a1;
  static ActionListener a2;
  static ActionListener a3;
  static Timer hitDrain;
  static Timer enemyDrain;
  static Timer delay;
  static JButton fight = new JButton("Kampf");
  static JButton beutel = new JButton("Beutel");
  static JButton Pkmn = new JButton("Pkmn");
  private JButton potion = new JButton("Trank");
  private JButton hyperHeal = new JButton("Hyperheiler");
  private JButton ball = new JButton("Pok�ball");
  private JButton back = new JButton("<<");
  private JButton back2 = new JButton("<<");
  static JLabel currentPkmn = new JLabel();
  static JButton attack1 = new JButton();
  static JButton attack2 = new JButton();
  static JButton attack3 = new JButton();
  static JButton attack4 = new JButton();
  static JProgressBar slotbar1 = new JProgressBar();
  static JProgressBar slotbar2 = new JProgressBar();
  static JProgressBar slotbar3 = new JProgressBar();
  static JProgressBar slotbar4 = new JProgressBar();
  static JProgressBar slotbar5 = new JProgressBar();
  static JProgressBar slotbar6 = new JProgressBar();
  JLabel shpl1 = new JLabel();
  JLabel shpl2 = new JLabel();
  JLabel shpl3 = new JLabel();
  JLabel shpl4 = new JLabel();
  JLabel shpl5 = new JLabel();
  JLabel shpl6 = new JLabel();
  JButton pkslot1 = new JButton();
  JButton pkslot2 = new JButton();
  JButton pkslot3 = new JButton();
  JButton pkslot4 = new JButton();
  JButton pkslot5 = new JButton();
  JButton pkslot6 = new JButton();
  static JProgressBar hpBar = new JProgressBar();
  static JProgressBar enemyBar = new JProgressBar();
  static JTextPane action = new JTextPane();
  public JScrollPane scrollPane = new JScrollPane(action);
  public JButton freeSlot;
  private final JButton back3 = new JButton("<<");
  JLabel defeatText = new JLabel();
  JLabel score = new JLabel();
  JButton retry = new JButton("Retry");
  JButton btnNewButton = new JButton("-");
  // Ende Attribute


  public Game(String title) {
    // Frame-Initialisierung
    super(title);
    getContentPane().setBackground(Color.BLACK);
    getContentPane().setLayout(null);




    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 500;
    int frameHeight = 500;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(false);
    JLayeredPane lp = getLayeredPane();

    // Pkmn movesets
  //Glutexo moveset;
    glutexo.seta1(new Attack(true,glutexo.name,"Flammenwurf","Feuer",90));
    glutexo.seta2(new Attack(true,glutexo.name,"Eisenschweif", "Stahl",55));
    glutexo.seta3(new Attack(true,glutexo.name,"Glut","Feuer",40));
    glutexo.seta4(new Attack(true,glutexo.name,"Schlitzer","Normal",40));

    //Mantax moveset
     mantax.seta1(new Attack(true,mantax.name,"Blubbstrahl","Wasser",65));
     mantax.seta2(new Attack(true,mantax.name,"Fl�gelschlag","Flug",60));
     mantax.seta3(new Attack(true,mantax.name,"Kopfnuss","Normal",70));
     mantax.seta4(new Attack(true,mantax.name,"Aquawelle","Wasser",60));

   //Voltenso moveset
     voltenso.seta1(new Attack(true,voltenso.name,"Ruckzuckhieb","Normal",40));
     voltenso.seta2(new Attack(true,voltenso.name,"Funkensprung","Elektro",65));
     voltenso.seta3(new Attack(true,voltenso.name,"Donnerzahn","Elektro",65));
     voltenso.seta4(new Attack(true,voltenso.name,"Biss","Unlicht",60));

   //Galagladi moveset
     galagladi.seta1(new Attack(true,galagladi.name,"Nahkampf","Kampf",120));
     galagladi.seta2(new Attack(true,galagladi.name,"Zornklinge","K�fer",40));
     galagladi.seta3(new Attack(true,galagladi.name,"Aero-Ass","Flug",60));
     galagladi.seta4(new Attack(true,galagladi.name,"Psychoklinge","Psycho",70));

   //Caesurio moveset
     caesurio.seta1(new Attack(true,caesurio.name,"Gewissheit","Unlicht",60));
     caesurio.seta2(new Attack(true,caesurio.name,"Zornklinge","K�fer",40));
     caesurio.seta3(new Attack(true,caesurio.name,"Schlitzer","Normal",70));
     caesurio.seta4(new Attack(true,caesurio.name,"Eisensch�del","Stahl",80));

   //Viscogon moveset
     viscogon.seta1(new Attack(true,viscogon.name,"Nassschweif","Wasser",90));
     viscogon.seta2(new Attack(true,viscogon.name,"Bodyslam","Normal",85));
     viscogon.seta3(new Attack(true,viscogon.name,"Blattgei�el","Pflanze",120));
     viscogon.seta4(new Attack(true,viscogon.name,"Drachenpuls","Drache",85));

   //Weberak moveset
     weberak.seta1(new Attack(false,weberak.name,"Schattenstoss","Geist",40));
     weberak.seta2(new Attack(false,weberak.name,"Tiefschlag","Unlicht",70));
     weberak.seta3(new Attack(false,weberak.name,"Plage","K�fer",20));
     weberak.seta4(new Attack(false,weberak.name,"Giftstachel","Gift",15));

     //Nasgnet moveset
     nasgnet.seta1(new Attack(false,nasgnet.name,"Tackle","Normal",40));
     nasgnet.seta2(new Attack(false,nasgnet.name,"Steinwurf","Gestein",50));
     nasgnet.seta3(new Attack(false,nasgnet.name,"Funkensprung","Elektro",65));
     nasgnet.seta4(new Attack(false,nasgnet.name,"Steinhagel","Gestein",75));

     //Shnebedeck
     shnebedeck.seta1(new Attack(false,shnebedeck.name,"Pulverschnee","Eis",40));
     shnebedeck.seta2(new Attack(false,shnebedeck.name,"Rasierblatt","Pflanze",40));
     shnebedeck.seta3(new Attack(false,shnebedeck.name,"Eissturm","Eis",55));
     shnebedeck.seta4(new Attack(false,shnebedeck.name,"Eisspliter","Eis",40));

     //enemy array
    enemy.add(weberak);
    enemy.add(nasgnet);
    enemy.add(shnebedeck);

    getLayeredPane().setLayout(null);


   //Font
    try{
    	GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    	ge.registerFont(Font.createFont(Font.TRUETYPE_FONT,new File("8-BIT WONDER")));
    }
    catch(IOException|FontFormatException e){}

    Font standard = new Font("8-BIT WONDER",Font.PLAIN,12);

    // Slot Components
    //y +80
    //x+232

    //left

    slotbar1.setBounds(110, 200, 101, 9);
    getLayeredPane().add(slotbar1,new Integer(2));
    slotbar1.setVisible(false);


    slotbar3.setBounds(110,280,101,9);
    getLayeredPane().add(slotbar3);
    slotbar3.setVisible(false);


    slotbar5.setBounds(110, 360, 101, 9);
    getLayeredPane().add(slotbar5);
    slotbar5.setVisible(false);


    shpl1.setFont(new Font("Tahoma", Font.PLAIN, 10));
    shpl1.setBounds(67, 197, 46, 12);
    getLayeredPane().add(shpl1, new Integer(2));
    shpl1.setVisible(false);


    shpl3.setFont(new Font("Tahoma", Font.PLAIN, 10));
    shpl3.setBounds(67, 277, 46, 12);
    getLayeredPane().add(shpl3);
    shpl3.setVisible(false);


    shpl5.setFont(new Font("Tahoma", Font.PLAIN, 10));
    shpl5.setBounds(67, 357, 46, 12);
    getLayeredPane().add(shpl5);
    shpl5.setVisible(false);

    //right
    slotbar2.setBounds(342, 200, 101, 9);
    getLayeredPane().add(slotbar2);
    slotbar2.setVisible(false);

    slotbar4.setBounds(342,280,101,9);
    getLayeredPane().add(slotbar4);
    slotbar4.setVisible(false);

    slotbar6.setBounds(342, 360, 101, 9);
    getLayeredPane().add(slotbar6);
    slotbar6.setVisible(false);

    shpl2.setFont(new Font("Tahoma", Font.PLAIN, 10));
    shpl2.setBounds(299, 197, 46, 12);
    getLayeredPane().add(shpl2);
    shpl2.setVisible(false);

    shpl4.setFont(new Font("Tahoma", Font.PLAIN, 10));
    shpl4.setBounds(299, 277, 46, 12);
    getLayeredPane().add(shpl4);
    shpl4.setVisible(false);

    shpl6.setFont(new Font("Tahoma", Font.PLAIN, 10));
    shpl6.setBounds(299, 357, 46, 12);
    getLayeredPane().add(shpl6);
    shpl6.setVisible(false);

    //slots
    pkslot1.setBounds(60, 150, 160, 63);
    getLayeredPane().add(pkslot1,new Integer(1));
    pkslot1.setVisible(false);

    pkslot2.setBounds(292, 150, 160, 63);
    pkslot2.setText(null);
    pkslot2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt) {
            pkslot2_ActionPerformed(evt);
          }
        });
    getLayeredPane().add(pkslot2);
    pkslot2.setVisible(false);

    pkslot3.setBounds(60, 230, 160, 63);
    pkslot3.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt) {
            pkslot3_ActionPerformed(evt);
          }
        });
    getLayeredPane().add(pkslot3);
    pkslot3.setText(null);
    pkslot3.setVisible(false);


    pkslot4.setBounds(292, 230, 160, 63);
    pkslot4.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt) {
            pkslot4_ActionPerformed(evt);
          }
        });
    getLayeredPane().add(pkslot4);
    pkslot4.setText(null);
    pkslot4.setVisible(false);


    pkslot5.setBounds(60, 310, 160, 63);
    pkslot5.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt) {
            pkslot5_ActionPerformed(evt);
          }
        });
    getLayeredPane().add(pkslot5);
    pkslot5.setText(null);
    pkslot5.setVisible(false);


    pkslot6.setBounds(292, 310, 160, 63);
    pkslot6.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt) {
            pkslot6_ActionPerformed(evt);
          }
        });
    getLayeredPane().add(pkslot6);
    pkslot6.setText(null);
    pkslot6.setVisible(false);


    btnNewButton.setBounds(10, 377, 50, 23);
    lp.add(btnNewButton);
    btnNewButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          btnNewButtons_ActionPerformed(evt);
        }
      });

    beutel.setBounds(60, 261, 125, 70);
    beutel.setBackground(Color.YELLOW);
    beutel.setMargin(new Insets(2, 2, 2, 2));
    beutel.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        beutel_ActionPerformed(evt);
      }
    });

    fight.setBounds(158, 166, 190, 97);
    fight.setBackground(Color.RED);
    fight.setMargin(new Insets(2, 2, 2, 2));
    fight.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        fight_ActionPerformed(evt);
      }
    });
    getLayeredPane().add(fight);
    getLayeredPane().add(beutel);

    Pkmn.setBounds(327, 261, 125, 70);
    Pkmn.setBackground(Color.GREEN);
    Pkmn.setMargin(new Insets(2, 2, 2, 2));
    Pkmn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Pkmn_ActionPerformed(evt);
      }
    });
    lp.add(Pkmn);

    potion.setBounds(195, 151, 111, 38);
    potion.setMargin(new Insets(2, 2, 2, 2));
    potion.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        potion_ActionPerformed(evt);
      }
    });
    lp.add(potion);
    potion.setVisible(false);

    hyperHeal.setBounds(193, 211, 111, 41);
    hyperHeal.setMargin(new Insets(2, 2, 2, 2));
    hyperHeal.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        hyperHeal_ActionPerformed(evt);
      }
    });
    lp.add(hyperHeal);
    hyperHeal.setVisible(false);

    ball.setBounds(193, 276, 111, 41);
    ball.setMargin(new Insets(2, 2, 2, 2));
    ball.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        ball_ActionPerformed(evt);
      }
    });
    lp.add(ball);
    ball.setVisible(false);

    back.setBounds(193, 347, 111, 41);
    back.setMargin(new Insets(2, 2, 2, 2));
    back.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        back_ActionPerformed(evt);
      }
    });
    lp.add(back);
    back.setVisible(false);
    currentPkmn.setFont(new Font("Tahoma", Font.PLAIN, 20));

    currentPkmn.setBounds(10, 423, 175, 37);
    currentPkmn.setForeground(Color.WHITE);
    lp.add(currentPkmn);

    hpBar.setBounds(212, 431, 272, 23);
    hpBar.setStringPainted(true);
    lp.add(hpBar);

    attack1.setBounds(10, 156, 183, 63);

    attack1.setMargin(new Insets(2, 2, 2, 2));
    attack1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        attack1_ActionPerformed(evt);
      }
    });
    lp.add(attack1);
    attack1.setVisible(false);

    attack2.setBounds(301, 156, 183, 63);

    attack2.setMargin(new Insets(2, 2, 2, 2));
    attack2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        attack2_ActionPerformed(evt);
      }
    });
    lp.add(attack2);
    attack2.setVisible(false);

    attack3.setBounds(10, 267, 183, 64);

    attack3.setMargin(new Insets(2, 2, 2, 2));
    attack3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        attack3_ActionPerformed(evt);
      }
    });
    lp.add(attack3);
    attack3.setVisible(false);

    attack4.setBounds(301, 267, 183, 64);

    attack4.setMargin(new Insets(2, 2, 2, 2));
    attack4.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        attack4_ActionPerformed(evt);
      }
    });
    lp.add(attack4);
    attack4.setVisible(false);

    enemyBar.setBounds(60, 120, 392, 23);
    lp.add(enemyBar);

    back2.setBounds(195, 226, 101, 38);
    back2.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent evt) {
        back2_ActionPerformed(evt);
      }
    });
    lp.add(back2);
    back2.setVisible(false);

    back3.setBounds(212, 388, 89, 23);
    back3.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt) {
            back3_ActionPerformed(evt);
          }
        });
    getLayeredPane().add(back3);
    back3.setVisible(false);

    scrollPane.setBounds(10, 11, 474, 100);
    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
    action.setEditable(false);
    action.setContentType("text/html");
    DefaultCaret caret = (DefaultCaret)action.getCaret();
    caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
    lp.add(scrollPane);

    defeatText.setBounds(63, 66, 368, 36);
    lp.add(defeatText);
    defeatText.setVisible(false);
    defeatText.setFont(standard);
    score.setForeground(Color.white);

    score.setBounds(63, 194, 368, 46);
    lp.add(score);
    score.setVisible(false);
    score.setFont(standard);
    score.setForeground(Color.white);


    retry.setBounds(173, 375, 148, 57);
    retry.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt) {
            retry_ActionPerformed(evt);
          }
        });
    lp.add(retry);
    retry.setVisible(false);

    //action for hitDrain
    a1 = new ActionListener(){
    	public void actionPerformed(ActionEvent evt){
    		if(hpBar.getValue() > curPkmnobj.curhp){
    		 inDrain = true;
   			 hpBar.setValue(hpBar.getValue() - 1);
   			 hpBar.setString(hpBar.getValue() + "/" + curPkmnobj.hp);
   			 update();
    		}
    		else{
    		 inDrain = false;
   			 hitDrain.stop();
   			new java.util.Timer().schedule(
   			    	new java.util.TimerTask(){
   			    		@Override
   			    		public void run() {
   			    			if(curPkmnobj.curhp == 0){
   			    				append("\n\n *" + curPkmnobj.name + " wurde besiegt");
   			    				defeat(true);
   			    				cancel();
   			    			}
   			    			else{
   			    				append("\n\n *" + curPkmnobj.name + " wurde von " + curAt.atname + " getroffen");
   			    				playerInput(true);
   	   			    			cancel();
   			    			}

   			    		}
   			    	},
   			    	1000
   			    );
    		}
   	 	};
   	};

   	//action for enemyDrain
   	a2 = new ActionListener(){
    	public void actionPerformed(ActionEvent evt){
    		if(enemyBar.getValue() > curEnemy.curhp){
    		 inDrain =true;
   			 enemyBar.setValue(enemyBar.getValue() - 1);
   			 update();
    		}
    		else{
    		 inDrain = false;
   			 enemyDrain.stop();
   			new java.util.Timer().schedule(
   			    	new java.util.TimerTask(){
   			    		@Override
   			    		public void run() {
   			    			if(curEnemy.curhp == 0){
   			    				append("\n\n *" + curEnemy.name + " wurde besiegt");
   			    				defeat(false);
   			    				cancel();
   			    			}
   			    			else{
	   			    			append("\n\n *" + curEnemy.name + " wurde von " + curAt.atname + " getroffen");
	   			    			counterAttack();
	   			    			cancel();
   			    			}
   			    		}
   			    	},
   			    	1000
   			    );
    		 }
   	 	};
   	};


    // Ende Komponenten

    setVisible(true);
  }

  // Anfang Methoden

  public static void playerInput(boolean b){
	  fight.setEnabled(b);
	  beutel.setEnabled(b);
	  Pkmn.setEnabled(b);
  }

  public static void limitHp(){
	  if(curPkmnobj.curhp < 0){
		  curPkmnobj.curhp = 0;
	  }
	  if(curPkmnobj.curhp > curPkmnobj.hp){
		  curPkmnobj.curhp = curPkmnobj.hp;
	  }

	  if(curEnemy.curhp < 0){
		  curEnemy.curhp = 0;
	  }
	  if(curEnemy.curhp > curEnemy.hp){
		  curEnemy.curhp = curEnemy.hp;
	  }
  }

  public static void delayAppend(String s){
	  new java.util.Timer().schedule(
		    	new java.util.TimerTask(){
		    		@Override
		    		public void run() {
		    			append(s);
		    			cancel();
		    		}
		    	},
		    	1000
		    );
  }

  public void hitWith(Attack a,boolean friend){
	  int damage = a.power;
	  if(friend){
		  curEnemy.curhp -= damage;
	  }
	  else{
		  curPkmnobj.curhp -= damage;
	  }
	  new java.util.Timer().schedule(
		    	new java.util.TimerTask(){
		    		@Override
		    		public void run() {
		    			if(friend){
		    				enemyDrain.start();
		    			}
		    			else{
		    				hitDrain.start();
		    			}
		    			cancel();
		    		}
		    	},
		    	1000
		    );
  }

  public void counterAttack(){
	  Random rand = new Random();
	  int r = rand.nextInt(4)+1;
	  switch(r){
	  	case 1:
	  		curAt = curEnemy.a1;
		break;

	  	case 2:
	  		curAt = curEnemy.a2;
	  	break;

	  	case 3:
	  		curAt = curEnemy.a3;
	  	break;

	  	case 4:
	  		curAt = curEnemy.a4;
	  	break;
	  }
	  new java.util.Timer().schedule(
		    	new java.util.TimerTask() {
		    		@Override
		    		public void run() {
		    			append("\n\n *" + curEnemy.name + " setzt " + curAt.atname + " ein ");
		    			hitWith(curAt,false);
		    			cancel();
		    		}
		    	},
		    	2000
		    );
  }

  public void GameOver(){
	  new java.util.Timer().schedule(
		    	new java.util.TimerTask() {
		    		@Override
		    		public void run() {
		    			hidebtn(fight,beutel,Pkmn);
		    			hideBars(hpBar,enemyBar);
		    			hideLabels(currentPkmn);
		    			action.setVisible(false);
		    			scrollPane.setVisible(false);
		    			defeatText.setText("Defeat at Level " + curlvl);
		    			if(highscore != 0){
		    				score.setText("<html><center>Your Score:  " + koFiend.size() + "\n\nHighscore:  " + highscore + "</center></html>");
		    			}
		    			else{
		    				score.setText("<html><center>Your Score:  " + koFiend.size() + "</center></html>");
		    			}
		    			showLabels(defeatText,score);
		    			showbtn(retry);
		    			if(koFiend.size() > highscore){
		    				highscore = koFiend.size();
		    			}
		    		}
		    	},
		    	2000
		    );
  }

  public void defeat(boolean friend){
	  new java.util.Timer().schedule(
		    	new java.util.TimerTask() {
		    		@Override
		    		public void run() {
		    			if(friend){
		    				 ko = true;
		    				 koFriend.add(curPkmnobj);
		    				 if(koFriend.size() > 5){
		    					 append("\n\n*Trainer besitzt keine Pokemon mehr\n\n*Game Over");
		    					 GameOver();
		    				 }
		    				 else{
		    					 showSelection();
		    				 }

		    			  }
		    			else{
		    				koFiend.add(curEnemy);
		    				enemy.remove(curEnemy);
		    				append("\n\n*Noch " + enemy.size() + " bis zum naechsten Level");
		    				new java.util.Timer().schedule(
		    				    	new java.util.TimerTask() {
		    				    		@Override
		    				    		public void run() {
		    				    			try{
		    				    				curEnemy = spawn(enemy);
		    				    			}
		    				    			catch(BadLocationException bl){}
		    				    			update();
		    				    		}
		    				    	},
		    				    	2000
		    				    );
		    			}
		    		}
		    	},
		    	2000
		    );

  }

  public static void setBarColor(JProgressBar bar){
	  if(bar.getValue() < (bar.getMaximum()/2)){
		  if(bar.getValue() < (bar.getMaximum()/5)){
			  bar.setForeground(Color.RED);
		  }
		  else{
			  bar.setForeground(Color.YELLOW);
		  }
	  }
	  else{
		  bar.setForeground(Color.GREEN);
	  }
  }

  public static void update(){
	  limitHp();
	  currentPkmn.setText(">>> "+ curPkmnobj.name);
	  hpBar.setMaximum(curPkmnobj.hp);
	  hpBar.setMinimum(0);
	  if(!inDrain){
		  hpBar.setString(curPkmnobj.curhp + "/" + curPkmnobj.hp);
		  hpBar.setValue(curPkmnobj.curhp);
	  }
	  setBarColor(hpBar);
	  if(ePresence){
		  enemyBar.setMaximum(curEnemy.hp);
		  enemyBar.setMinimum(0);
		  if(!inDrain){
			  enemyBar.setValue(curEnemy.curhp);
		  }
		  setBarColor(enemyBar);
	  }
	  attack1.setText(curPkmnobj.a1.atname);
	  attack2.setText(curPkmnobj.a2.atname);
	  attack3.setText(curPkmnobj.a3.atname);
	  attack4.setText(curPkmnobj.a4.atname);
  }

  public void hideLabels(JLabel...labels){
	  for (int i=0;i<labels.length;i++){
		  labels[i].setVisible(false);
	  }
  }

  public void hidebtn(JButton...buttons){
	  for (int i=0;i<buttons.length;i++){
		  buttons[i].setVisible(false);
	  }
  }

  public void hideBars(JProgressBar...bars){
	  for (int i=0;i<bars.length;i++){
		  bars[i].setVisible(false);
	  }
  }

  public void showLabels(JLabel...labels){
	  for (int i=0;i<labels.length;i++){
		  labels[i].setVisible(true);
	  }
  }

  public void showbtn(JButton...buttons){
	  for (int i=0;i<buttons.length;i++){
		  buttons[i].setVisible(true);
	  }
  }

  public void showBars(JProgressBar...bars){
	  for (int i=0;i<bars.length;i++){
		  bars[i].setVisible(true);
	  }
  }

  public void assignBars(Pkmn pk,int slotnr,JProgressBar...bars){
	  for (int i= 0;i<bars.length;i++){
		  if (i == slotnr){
			  bars[i].setMinimum(0);
			  bars[i].setMaximum(pk.hp);
			  bars[i].setValue(pk.curhp);
			  setBarColor(bars[i]);
		  }
	  }
  }

  public void assignLabels(Pkmn pk,int slotnr,JLabel...labels){
	  for (int i= 0;i<labels.length;i++){
		  if (i == slotnr){
			  labels[i].setText(pk.curhp + "/" + pk.hp);
		  }
	  }
  }

  public boolean checkforUse(Pkmn pk){
	  if(pk.name == curPkmnobj.name){
		  return true;
	  }
	  else{
		  return false;
	  }
  }

  public String retrieveName(String og, JButton slot){
	  og = slot.getText();
	  String [] split1 = og.split("<center>");
	  String[] split2 = split1[1].split(" \\(");
	  if(split2[0].equals(split1[1])){
		  split2 = split1[1].split("<br /");
	  }

	  return split2[0];
  }

  public void setInSlot(Pkmn pk,JButton...slots){
	  boolean alreadyInSlot = false;
	  for(int i = 0;i<slots.length;i++){
		  for (int u = 0;u<slots.length;u++){
			  if(slots[u].getText() != null){
				  if(retrieveName(slots[u].getText(),slots[u]).equals(pk.name)){
					  alreadyInSlot = true;
					  break;
				  }
			  }
		  }
		  if(alreadyInSlot){
			  break;
		  }
		  if(slots[i].getText() == null || retrieveName(slots[i].getText(),slots[i]).equals(curPkmnobj.name)){
			  freeSlot = slots[i];
			  String stat;
			  if(pk.curhp == 0){
				  stat = " (K.O) ";
			  }
			  else{
				  stat = "";
			  }
			  if(pk.elem2 == null){
				  freeSlot.setText("<html><center>" + pk.name + stat + "<br />" + pk.elem1 + "</center></html>");
			  }
			  else{
				  freeSlot.setText("<html><center>" + pk.name + stat + "<br />" + pk.elem1 + "/" + pk.elem2 + "</center></html>");
			  }
			  assignBars(pk,i,slotbar2,slotbar3,slotbar4,slotbar5,slotbar6);
			  assignLabels(pk,i,shpl2,shpl3,shpl4,shpl5,shpl6);
			  break;
		  }
	  }
  }

  public void assignFirst(){
	  String stat;
	  if(curPkmnobj.curhp == 0){
		  stat = " (K.O) ";
	  }
	  else{
		  stat = " (im Kampf) ";
	  }
	  if(curPkmnobj.elem2 == null){
	    	pkslot1.setText("<html><center>" + curPkmnobj.name + stat + "<br />" + curPkmnobj.elem1 + "</center></html>");
	    }
	    else{
	    	pkslot1.setText("<html><center>" + curPkmnobj.name + stat + "<br />" + curPkmnobj.elem1 + "/" + curPkmnobj.elem2 + "</center></html>");
	    }

	    slotbar1.setMaximum(curPkmnobj.hp);
	    slotbar1.setMinimum(0);
	    slotbar1.setValue(curPkmnobj.curhp);
	    setBarColor(slotbar1);
	    shpl1.setText(curPkmnobj.curhp + "/" + curPkmnobj.hp);
  }

  public void assign(Pkmn...pk){
	 for (int i = 0;i<pk.length;i++){
		 if(!checkforUse(pk[i])){
			 setInSlot(pk[i],pkslot2,pkslot3,pkslot4,pkslot5,pkslot6);
		 }
	 }
  }

  public Pkmn searchObject(String sname){
	  if(sname.equals(PkmnNo1.name)){
		  reObj = PkmnNo1;
	  }
	  else if(sname.equals(PkmnNo2.name)){
		  reObj = PkmnNo2;
	  }
	  else if(sname.equals(PkmnNo3.name)){
		  reObj = PkmnNo3;
	  }
	  else if(sname.equals(PkmnNo4.name)){
		  reObj = PkmnNo4;
	  }
	  else if(sname.equals(PkmnNo5.name)){
		  reObj = PkmnNo5;
	  }
	  else if(sname.equals(PkmnNo6.name)){
		  reObj = PkmnNo6;
	  }
	  return reObj;
  }

  public void changePkmn(){
	  new java.util.Timer().schedule(
		    	new java.util.TimerTask() {
		    		@Override
		    		public void run() {
		    			append("\n\n*Trainer schickt " + curPkmnobj.name + " in den Kampf");
		    			update();
		    			if(!ko){
		    				counterAttack();
		    			}
		    			else{
		    				ko = false;
		    				playerInput(true);
		    			}
		    			cancel();
		    		}
		    	},
		    	2000
		    );

  }

  public void slotBtn(JButton pkslot){
	  String btnName = retrieveName(pkslot.getText(),pkslot);
	  boolean dead = false;
	  for(int i = 0;i<koFriend.size();i++){
		  Pkmn p = (pokemon.Pkmn) koFriend.get(i);
		  if(p.name.equals(btnName)){
			  dead = true;
		  }
	  }
	  if(!dead){
		  playerInput(false);
		  hidebtn(pkslot1,pkslot2,pkslot3,pkslot4,pkslot5,pkslot6,back3);
		  hideLabels(shpl1,shpl2,shpl3,shpl4,shpl5,shpl6);
		  hideBars(slotbar1,slotbar2,slotbar3,slotbar4,slotbar5,slotbar6);
		  showbtn(fight,beutel,Pkmn);
		  prevPkmn = curPkmnobj;
		  curPkmnobj = searchObject(retrieveName(pkslot.getText(),pkslot));
		  new java.util.Timer().schedule(
			    	new java.util.TimerTask() {
			    		@Override
			    		public void run() {
			    			if(!ko){
			    				append("\n\n *" + prevPkmn.name + " wird zuruek gerufen");
			    			}
			    			changePkmn();
			    			cancel();
			    		}
			    	},
			    	1000
			    );
	  }
  }

  public void showSelection(){
	  hidebtn(fight,beutel,Pkmn);
	  showLabels(shpl1,shpl2,shpl3,shpl4,shpl5,shpl6);
	  showBars(slotbar1,slotbar2,slotbar3,slotbar4,slotbar5,slotbar6);
	  showbtn(pkslot1,pkslot2,pkslot3,pkslot4,pkslot5,pkslot6,back3);
	  assignFirst();
	  assign(PkmnNo1,PkmnNo2,PkmnNo3,PkmnNo4,PkmnNo5,PkmnNo6);
  }

  //Button actions

  public void fight_ActionPerformed(ActionEvent evt) {
	showbtn(attack1,attack2,attack3,attack4,back2);
    hidebtn(fight,beutel,Pkmn);
  } // end of fight_ActionPerformed

  public void beutel_ActionPerformed(ActionEvent evt) {
	showbtn(potion,hyperHeal,ball,back);
	hidebtn(beutel,Pkmn,fight);
  } // end of beutel_ActionPerformed

  public void Pkmn_ActionPerformed(ActionEvent evt) {
    showSelection();

  } // end of Pkmn_ActionPerformed

  public void potion_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einf�gen
  } // end of potion_ActionPerformed

  public void hyperHeal_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einf�gen
  } // end of hyperHeal_ActionPerformed

  public void ball_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einf�gen
  } // end of ball_ActionPerformed

  public void back_ActionPerformed(ActionEvent evt) {
	hidebtn(potion,hyperHeal,ball,back);
	showbtn(beutel,Pkmn,fight);
  } // end of back_ActionPerformed

  public void back2_ActionPerformed(ActionEvent evt){
	  hidebtn(attack1,attack2,attack3,attack4,back2);
	  showbtn(fight,beutel,Pkmn);
  }

  public void back3_ActionPerformed(ActionEvent evt){
	  hidebtn(pkslot1,pkslot2,pkslot3,pkslot4,pkslot5,pkslot6,back3);
	  hideLabels(shpl1,shpl2,shpl3,shpl4,shpl5,shpl6);
	  hideBars(slotbar1,slotbar2,slotbar3,slotbar4,slotbar5,slotbar6);
	  showbtn(fight,beutel,Pkmn);
  }

  public void attack1_ActionPerformed(ActionEvent evt){
	curAt = curPkmnobj.a1;
	playerInput(false);
    hidebtn(attack1,attack2,attack3,attack4,back2);
    showbtn(fight,beutel,Pkmn);
    new java.util.Timer().schedule(
	    	new java.util.TimerTask() {
	    		@Override
	    		public void run() {
	    			append("\n\n *" + curPkmnobj.name + " setzt " + curAt.atname + " ein ");
	    			hitWith(curAt,true);
	    			cancel();
	    		}
	    	},
	    	1000
	    );
  } // end of attack1_ActionPerformed

  public void attack2_ActionPerformed(ActionEvent evt) {
	  curAt = curPkmnobj.a2;
		playerInput(false);
	    hidebtn(attack1,attack2,attack3,attack4,back2);
	    showbtn(fight,beutel,Pkmn);
	    new java.util.Timer().schedule(
		    	new java.util.TimerTask() {
		    		@Override
		    		public void run() {
		    			append("\n\n *" + curPkmnobj.name + " setzt " + curAt.atname + " ein ");
		    			hitWith(curAt,true);
		    			cancel();
		    		}
		    	},
		    	1000
		    );
  } // end of attack2_ActionPerformed

  public void attack3_ActionPerformed(ActionEvent evt) {
	  curAt = curPkmnobj.a3;
		playerInput(false);
	    hidebtn(attack1,attack2,attack3,attack4,back2);
	    showbtn(fight,beutel,Pkmn);
	    new java.util.Timer().schedule(
		    	new java.util.TimerTask() {
		    		@Override
		    		public void run() {
		    			append("\n\n *" + curPkmnobj.name + " setzt " + curAt.atname + " ein ");
		    			hitWith(curAt,true);
		    			cancel();
		    		}
		    	},
		    	1000
		    );
  } // end of attack3_ActionPerformed

  public void attack4_ActionPerformed(ActionEvent evt) {
	  curAt = curPkmnobj.a4;
		playerInput(false);
	    hidebtn(attack1,attack2,attack3,attack4,back2);
	    showbtn(fight,beutel,Pkmn);
	    new java.util.Timer().schedule(
		    	new java.util.TimerTask() {
		    		@Override
		    		public void run() {
		    			append("\n\n *" + curPkmnobj.name + " setzt " + curAt.atname + " ein ");
		    			hitWith(curAt,true);
		    			cancel();
		    		}
		    	},
		    	1000
		    );
  } // end of attack4_ActionPerformed


  public void pkslot2_ActionPerformed(ActionEvent evt){
	  slotBtn(pkslot2);
  }

  public void pkslot3_ActionPerformed(ActionEvent evt){
	  slotBtn(pkslot3);
  }

  public void pkslot4_ActionPerformed(ActionEvent evt){
	  slotBtn(pkslot4);
  }

  public void pkslot5_ActionPerformed(ActionEvent evt){
	  slotBtn(pkslot5);
  }

  public void pkslot6_ActionPerformed(ActionEvent evt){
	  slotBtn(pkslot6);
  }

  public void  btnNewButtons_ActionPerformed(ActionEvent evt){
	  curPkmnobj.curhp -= 100;
	  hitDrain.start();
  }

  public void retry_ActionPerformed(ActionEvent evt){

  }

  //main

  public static void main(String[] args) throws BadLocationException{
    new Game("Pokemon lila blassblau-kariert");
    defineTimers();
    curEnemy = spawn(enemy);
    update();
  }

  public static void append(String text){
	  StyledDocument doc = (StyledDocument) action.getDocument();
	  SimpleAttributeSet center = new SimpleAttributeSet();
	  StyleConstants.setAlignment(center,  StyleConstants.ALIGN_CENTER);
	  StyleConstants.setFontFamily(center,"8BIT WONDER");
	  StyleConstants.setFontSize(center, 12);
	  doc.setParagraphAttributes(0, doc.getLength(), center, false);
	  try{
	  doc.insertString(doc.getLength(), text, null);
	  }
	  catch (BadLocationException bl){}
  }

  public static Pkmn spawn(List<Object> array) throws BadLocationException{
	  int len = array.size();
	  int epk = ThreadLocalRandom.current().nextInt(0,len);
	  Pkmn curEnemy = (pokemon.Pkmn) array.get(epk);
	  append("\n\n*Ein wildes " + curEnemy.name + " erscheint");
	  ePresence = true;
	  playerInput(true);
	  return curEnemy;
  }

  public static void defineTimers(){
	  hitDrain = new Timer(15,a1);
	  enemyDrain = new Timer(15,a2);
  }
} // end of class james
