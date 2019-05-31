package pokemon;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class Attack {
	Boolean friend;
	String owner;
	String atname;
	String atelem;
	int power;
	int acc;
	
	public Attack(Boolean friend,String owner,String atname, String atelem, int power){
		this.friend = friend;
		this.owner = owner;
		this.atname = atname;
		this.atelem = atelem;
		this.power = power;
	}
	
	public Attack(){}
}
