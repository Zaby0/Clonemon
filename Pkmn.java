package pokemon;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Pkmn{
	  Boolean friend;
	  String name;
	  String elem1;
	  String elem2;
	  int lvl;
	  int hp;
	  int curhp;
	  Attack a1;
	  Attack a2;
	  Attack a3;
	  Attack a4;

	  public Pkmn(Boolean friend,String n, String e1, String e2, int lvl, int hp, int curhp){
		  this.friend = friend;
		  name = n;
		  elem1 = e1;
		  elem2 = e2;
		  this.lvl = lvl;
		  this.hp = hp;
		  this.curhp = curhp;
	  }

	  public void seta1(Attack at){
		  a1 = at;
	  }
	  public void seta2(Attack at){
		  a2 = at;
	  }
	  public void seta3(Attack at){
		  a3 = at;
	  }
	  public void seta4(Attack at){
		  a4 = at;
	  }

}
