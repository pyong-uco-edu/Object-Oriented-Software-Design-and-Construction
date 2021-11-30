package model.observerPattern;

import java.util.ArrayList;

import model.EnemyComposite;
import model.GameElement;
import model.Shooter;
import view.GameBoard;

public class EnemyObserver implements EnemyObserverInterface {
    private GameBoard gameBoard;
    private ArrayList<ArrayList<GameElement>> rows;
    private Shooter shooter;
    // private EnemyComposite enemyComposite;

    public EnemyObserver(GameBoard gameBoard, EnemyComposite enemyComposite, Shooter shooter) {
        this.gameBoard = gameBoard;
        // this.enemyComposite = enemyComposite;
        this.rows = enemyComposite.getRows();
        this.shooter = shooter;
    }

    @Override
    public void enemyHitBullet() {
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
    public void enemyHitShooter() {
        int dx = EnemyComposite.UNIT_MOVE;
        boolean enemyReachEnd = false;
        for (var row: rows) {
            for (var e: row) {
                e.x += dx;
                if (e.y == 380) {
                    enemyReachEnd = true;
                    break;
                }
            }
            if (enemyReachEnd) break;
        }

        if (enemyReachEnd) { 
            gameBoard.showGameOver();
            return;
        }
    }

    @Override
    public void enemyReachSides() {
        int dx = EnemyComposite.UNIT_MOVE;
        boolean hitSides = false;
        for (var row: rows) {
            for (var e: row) {
                e.x += dx;
                if (hitSides) e.y += EnemyComposite.ENEMY_SIZE;
            }
        }
    }
    
}
