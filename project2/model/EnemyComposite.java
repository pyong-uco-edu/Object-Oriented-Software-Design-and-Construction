package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

import view.GameBoard;

public class EnemyComposite extends GameElement {
    public static final int NROWS = 2, NCOLS = 10, ENEMY_SIZE = 20, UNIT_MOVE = 5;

    private ArrayList<ArrayList<GameElement>> rows;
    private ArrayList<GameElement> bombs;
    private boolean movingToRight = true;
    private Random random = new Random();
    private GameBoard canvas;

    public EnemyComposite(GameBoard canvas) {
        rows = new ArrayList<>();
        bombs = new ArrayList<>();

        for (int r = 0; r < NROWS; r++) {
            var oneRow = new ArrayList<GameElement>();
            rows.add(oneRow);
            for (int c = 0; c < NCOLS; c++) {
                oneRow.add(new Enemy(c * ENEMY_SIZE * 2, r * ENEMY_SIZE * 2, ENEMY_SIZE, Color.yellow, true));
            }
        }

        this.canvas = canvas;
    }

    public ArrayList<ArrayList<GameElement>> getRows() {
        return rows;
    }

    public ArrayList<GameElement> getBombs() {
        return bombs;
    }

    @Override
    public void render(Graphics2D g2) {
        for (var r: rows) for (var e: r) e.render(g2);
        for (var b: bombs) b.render(g2);
    }

    @Override
    public void animate() {
        int dx = UNIT_MOVE;
        boolean hitSides = false;
        if (movingToRight) {
            if (rightEnd() >= GameBoard.WIDTH) {
                dx = -dx;
                movingToRight = false;
                hitSides = true;
            }
        } else {
            dx = -dx;
            if (leftEnd() <= 0) {
                dx = -dx;
                movingToRight = true;
                hitSides = true;
            }
        }

        boolean enemyReachEnd = false;
        int enemyCount = 0;
        for (var row: rows) {
            for (var e: row) {
                enemyCount++;
                e.x += dx;
                if (hitSides) e.y += ENEMY_SIZE;
                if (e.y == 380) {
                    enemyReachEnd = true;
                    break;
                }
            }
            if (enemyReachEnd) break;
        }

        if (enemyReachEnd) { 
            canvas.showGameOver();
            return;
        }

        if (enemyCount == 0) {
            canvas.showGameWon();
        }

        for (var b: bombs) b.animate();
    }
    
    private int rightEnd() {
        int xEnd = -100;
        for (var row: rows) {
            if (row.size() == 0) continue;
            int x = row.get(row.size() - 1).x + ENEMY_SIZE;
            if (x > xEnd) xEnd = x;
        }
        return xEnd;
    }

    private int leftEnd() {
        int xEnd = 9000;
        for (var row: rows) {
            if (row.size() == 0) continue;
            int x = row.get(0).x;
            if (x < xEnd) xEnd = x;
        }
        return xEnd;
    }

    public void dropBombs() {
        for (var row: rows) {
            for (var e: row) {
                if (random.nextFloat() < 0.1F) {
                    if (random.nextFloat() < 0.1F) bombs.add(new Bomb(e.x, e.y, Color.blue));
                    else bombs.add(new Bomb(e.x, e.y));
                }
            }
        }
    }

    public void removeBombsOutOfBound() {
        var remove = new ArrayList<GameElement>();
        for (var b: bombs) if (b.y >= GameBoard.HEIGHT) remove.add(b);
        bombs.removeAll(remove);
    }

    public void processCollision(Shooter shooter) {
        var removeBullets = new ArrayList<GameElement>();
        for (var row: rows) {
            var removeEnemies = new ArrayList<GameElement>();
            for (var enemy: row) {
                for (var bullet: shooter.getWeapons()) {
                    if (enemy.collideWith(bullet)) {
                        removeBullets.add(bullet);
                        removeEnemies.add(enemy);
                        int score = canvas.getScore();
                        canvas.setScore(score + 10);
                    }
                }
            }
            row.removeAll(removeEnemies);
        }
        shooter.getWeapons().removeAll(removeBullets);

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
        for (var row: rows) {
            var removeEnemies = new ArrayList<GameElement>();
            for (var enemy: row) {
                for (var bonusBullet: shooter.getBonusBullets()) {
                    if (enemy.collideWith(bonusBullet)) {
                        removeBullets.add(bonusBullet);
                        removeEnemies.add(enemy);
                        int score = canvas.getScore();
                        canvas.setScore(score + 10);
                    }
                }
            }
            row.removeAll(removeEnemies);
        }
        shooter.getBonusBullets().removeAll(removeBullets);

        removeBombs.clear();
        var removeBody = new ArrayList<GameElement>();
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
            canvas.showGameOver();
        }
    }
}
