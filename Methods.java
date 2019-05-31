package pokemon;

import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Methods {
	static Game origin = new Game("Pokemon lila blassblau-kariert");
		public static void append(String text){
			  StyledDocument doc = (StyledDocument) origin.action.getDocument();
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

		public void hitWith(Attack a){
			  int damage = a.power;
			  origin.curEnemy.curhp -= damage;
			  new java.util.Timer().schedule(
				    	new java.util.TimerTask(){
				    		@Override
				    		public void run() {
				    			origin.enemyDrain.start();
				    			cancel();
				    		}
				    	},
				    	1000
				    );
		  }
}
