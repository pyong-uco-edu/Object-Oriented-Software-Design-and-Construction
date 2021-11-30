package model.observerPattern;

import java.util.ArrayList;

import model.EnemyComposite;
import model.GameElement;
import model.Shooter;
import view.GameBoard;

public class ShooterObserver implements ShooterObserverInterface {
    private GameBoard gameBoard;
    private ArrayList<GameElement> bombs;
    private Shooter shooter;

    public ShooterObserver(GameBoard gameBoard, EnemyComposite enemyComposite, Shooter shooter) {
        this.gameBoard = gameBoard;
        this.bombs = enemyComposite.getBombs();
        this.shooter = shooter;
    }

    @Override
    public void shooterHitBomb() {
        var removeBody = new ArrayList<GameElement>();
        var removeBombs = new ArrayList<GameElement>();
        for (var b: bombs) {
            for (var body: shooter.getComponents()) {
                if (b.collideWith(body)) {
                    removeBombs.add(b);
                    removeBody.add(body);
                }
            }
        }
        shooter.getComponents().removeAll(removeBody);
        bombs.removeAll(removeBombs);
        if (shooter.getComponents().size() == 0) {
            gameBoard.showGameOver();
        }
    }
    
}
