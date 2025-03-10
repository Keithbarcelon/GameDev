package main;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	GamePanel gp;
	public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed;
	
	public KeyHandler(GamePanel gp) {
		this.gp = gp;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int code = e.getKeyCode();
		// Title state
		if (gp.gameState == gp.titleState) {
			
			if(gp.ui.titleScreenState == 0) {
				if (code == KeyEvent.VK_W) { // Navigate up
			        gp.ui.commandNum--;
			        if (gp.ui.commandNum < 0) {
			            gp.ui.commandNum = 2; // Wrap to the last menu option
			        }
			    }

			    if (code == KeyEvent.VK_S) { // Navigate down
			        gp.ui.commandNum++;
			        if (gp.ui.commandNum > 2) {
			            gp.ui.commandNum = 0; // Wrap to the first menu option
			        }
			    }

			    if (code == KeyEvent.VK_ENTER) { // Execute the selected option
			    	if (gp.ui.commandNum == 0) { // "New Game" selected
			    	    gp.setUpGame(); // Ensure game setup
			    	    gp.gameState = gp.playState; // Switch to play state
			    	    gp.playMusic(0); // Start music
			    	}

			        if (gp.ui.commandNum == 1) {
			            // Add functionality for "New Game" later
			        }
			        if (gp.ui.commandNum == 2) {
			            System.exit(0); // Exit the game
			        }
			}
			    
		    
		    }
		}

		//playstate
		else if(gp.gameState == gp.playState) {
			
			if(code == KeyEvent.VK_W ) {
				upPressed = true;
			}
			if(code == KeyEvent.VK_S ) {
				downPressed = true;
			}
			if(code == KeyEvent.VK_A) {
				leftPressed = true;
			}
			if(code == KeyEvent.VK_D) {
				rightPressed = true;
			}
			if(code == KeyEvent.VK_P) {
					gp.gameState = gp.pauseState;		
			}
			if(code == KeyEvent.VK_C) {
				gp.gameState = gp.characterState;
			}
			if(code == KeyEvent.VK_ENTER) {
				enterPressed = true;		
			}
		    if (gp.gameState == gp.gameOverState) {
		        if (code == KeyEvent.VK_ENTER) {
		            // Maybe return to title screen or restart
		            gp.gameState = gp.titleState;
		        }
		        if (code == KeyEvent.VK_ESCAPE) {
		            System.exit(0);
		        }
		    }
		}
		//pausestate
		else if(gp.gameState == gp.pauseState) {
			if(code == KeyEvent.VK_P) {
				gp.gameState = gp.playState;
			}
		}
		
		//dialogue state
		else if(gp.gameState == gp.dialogueState) {
			if(code == KeyEvent.VK_ENTER) {
				gp.gameState = gp.playState;
			}
		}
		
		//character state
		else if(gp.gameState == gp.characterState) {
			if (code == KeyEvent.VK_C) {
				gp.gameState = gp.playState;
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_W ) {
			upPressed = false;
		}
		if(code == KeyEvent.VK_S ) {
			downPressed = false;
		}
		if(code == KeyEvent.VK_A) {
			leftPressed = false;
		}
		if(code == KeyEvent.VK_D) {
			rightPressed = false;
		}
	}

}
