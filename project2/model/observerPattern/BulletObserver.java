package model.observerPattern;

import java.util.ArrayList;

import model.Bomb;
import model.Bullet;
import model.EnemyComposite;
import model.GameElement;
import model.Shooter;
import view.GameBoard;

public class BulletObserver implements BulletObserverInterface {
    private GameBoard gameBoard;
    private ArrayList<GameElement> bombs;
    private ArrayList<ArrayList<GameElement>> rows;
    private Shooter shooter;

    public BulletObserver(GameBoard gameBoard, EnemyComposite enemyComposite, Shooter shooter) {
        this.gameBoard = gameBoard;
        this.bombs = enemyComposite.getBombs();
        this.rows = enemyComposite.getRows();
        this.shooter = shooter;
    }

    @Override
    public void bulletHitBomb() {
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
                        // removeBombs.add(b);
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
                        // removeBombs.add(b);
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
    public void bulletHitEnemy() {
        var removeBullets = new ArrayList<GameElement>();
        for (var row: rows) {
            var removeEnemies = new ArrayList<GameElement>();
            for (var enemy: row) {
                for (var bullet: shooter.getWeapons()) {
                    if (enemy.collideWith(bullet)) {
                        removeBullets.add(bullet);
                        removeEnemies.add(enemy);
                        int score = gameBoard.getScore();
                        gameBoard.setScore(score + 10);
                    }
                }
            }
            row.removeAll(removeEnemies);
        }
        shooter.getWeapons().removeAll(removeBullets);
    }

    @Override
    public void bulletLeftScene() {
        var remove = new ArrayList<GameElement>();
        var weapons = shooter.getWeapons();
        for (var w: weapons) {
            if (w.y < 0) remove.add(w);
        }
        weapons.removeAll(remove);
        shooter.setWeapons(weapons);
    }
    
}
