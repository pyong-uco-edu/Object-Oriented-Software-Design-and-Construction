package model.observerPattern;

import java.util.ArrayList;

import model.Bomb;
import model.Bullet;
import model.EnemyComposite;
import model.GameElement;
import model.Shooter;
import view.GameBoard;

public class BombObserver implements BombObserverInterface {
    private GameBoard gameBoard;
    private ArrayList<GameElement> bombs;
    private Shooter shooter;

    public BombObserver(GameBoard gameBoard, EnemyComposite enemyComposite, Shooter shooter) {
        this.gameBoard = gameBoard;
        this.shooter = shooter;
        this.bombs = enemyComposite.getBombs();
    }

    @Override
    public void bombHitBullet() {
        var removeBullets = new ArrayList<GameElement>();
        var removeBombs = new ArrayList<GameElement>();

        for (var b: bombs) {
            for (var bullet: shooter.getWeapons()) {
                if (b.collideWith(bullet)) {
                    Bomb bomb = (Bomb) b;
                    if (bomb.getBreakable()) {
                        removeBombs.add(b);
                        shooter.getBonusBullets().add(new Bullet(bullet.x + 10, bullet.y));
                        shooter.getBonusBullets().add(new Bullet(bullet.x - 10, bullet.y));
                    } else {
                        removeBullets.add(bullet);
                    }
                }
            }
        }
        bombs.removeAll(removeBombs);
        shooter.getWeapons().removeAll(removeBullets);
        removeBombs.clear();
        removeBullets.clear();

        for (var b: bombs) {
            for (var bullet: shooter.getBonusBullets()) {
                if (b.collideWith(bullet)) {
                    Bomb bomb = (Bomb) b;
                    if (bomb.getBreakable()) {
                        removeBombs.add(b);
                        shooter.getBonusBullets().add(new Bullet(bullet.x + 10, bullet.y));
                        shooter.getBonusBullets().add(new Bullet(bullet.x - 10, bullet.y));
                    } else {
                        removeBullets.add(bullet);
                    }
                }
            }
        }
        bombs.removeAll(removeBombs);
        shooter.getBonusBullets().removeAll(removeBullets);
        removeBombs.clear();
        removeBullets.clear();
    }

    @Override
    public void bombHitShooter() {
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

    @Override
    public void bombLeftScene() {
        var remove = new ArrayList<GameElement>();
        for (var b: bombs) if (b.y >= GameBoard.HEIGHT) remove.add(b);
        bombs.removeAll(remove);
    }
    
}
