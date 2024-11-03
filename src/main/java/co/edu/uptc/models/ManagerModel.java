package co.edu.uptc.models;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import co.edu.uptc.interfaces.Contract;
import co.edu.uptc.utils.UtilThread;

public class ManagerModel implements Contract.Model {

    private Contract.Presenter presenter;
    private List<Ship> ships;
    private Random random;
    Dimension screenSize;
    private static final double SPEED = 5.0;
    private int SLEEP_TIME_MS = 1000;
    public int numberOfColisions = 0;

    public ManagerModel() {
    }

    @Override
    public void setPresenter(Contract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public List<Ship> createShips() {
        SLEEP_TIME_MS = presenter.getVelocity();
        int numberOfShips = presenter.getNumberOfShips();
        ships = new ArrayList<>();
        //UtilThread.sleep(1000);
        for (int i = 0; i < numberOfShips; i++) {
            ships.add(randomApperance());
        }
        //System.out.println("tamaño inicial" + ships.size());
        moveShipsInRandomAngle();
        return ships;
    }

    public Ship randomApperance() {
        Ship ship = new Ship();
        screenSize = presenter.getScreenSize();
        random = new Random();
        Point randomPoint = new Point();
        randomPoint = new Point(random.nextInt((int) screenSize.getWidth() - 30),
                random.nextInt((int) screenSize.getHeight() - 30));
        ship.setPoint(randomPoint);
        return ship;
    }

    private Point randomAngle(Point origin) {
        random = new Random();
        int newX = random.nextInt((int) screenSize.getWidth()+100);
        int newY = random.nextInt((int) screenSize.getHeight()+100);
        return new Point(newX, newY);
    }
    
    

    private void moveShipsInRandomAngle() {
        for (Ship ship : ships) {
            Point newPoint = randomAngle(ship.getPoint());
            moveInDirection(ship, newPoint);
        }
    }

    private void moveInDirection(Ship ship, Point destination) {
        ship.setThread(new Thread(() -> {
            double[] direction = calculateNormalizedDirection(ship.getPoint(), destination);
            double currentX = ship.getPoint().x;
            double currentY = ship.getPoint().y;
            while (!Thread.currentThread().isInterrupted()) {
                currentX += direction[0] * SPEED;
                currentY += direction[1] * SPEED;
                ship.setPoint(new Point((int) Math.round(currentX), (int) Math.round(currentY)));
                if (calculateDistance(currentX, currentY, destination.x, destination.y) < SPEED) {
                    ship.setPoint(destination);
                    break;
                }
                if (comprovateColisionBounds(ship.getPoint()) == true) {
                    ships.remove(ship);
                    break;
                }
                comprovateColisionShips();
                presenter.changePosition();
                UtilThread.sleep(SLEEP_TIME_MS);
            }
        }));
        presenter.changePosition();
        ship.getThread().start();
    }
    
    private double[] calculateNormalizedDirection(Point start, Point end) {
        double dx = end.x - start.x;
        double dy = end.y - start.y;
        double distance = Math.sqrt(dx * dx + dy * dy);
        return distance > 0 ? new double[]{dx / distance, dy / distance} : new double[]{0, 0};
    }

    private double calculateDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    private Boolean comprovateColisionBounds(Point point) {
        int minX = 0;
        int minY = 0;
        int maxX = (int) screenSize.getWidth()-33;
        int maxY = (int) screenSize.getHeight()-33;
        boolean colision = point.x <= minX || point.x >= maxX || point.y <= minY || point.y >= maxY;
        return colision;
    }

    public synchronized boolean comprovateColisionShips() {
        List<Ship> shipsToRemove = new ArrayList<>();
        for (int i = 0; i < ships.size(); i++) {
            Ship ship = ships.get(i);
            for (int j = i + 1; j < ships.size(); j++) {
                Ship ship2 = ships.get(j);
                if (ship != ship2 && !shipsToRemove.contains(ship) && !shipsToRemove.contains(ship2)) {
                    if (ship.getPoint().distance(ship2.getPoint()) < 30) {
                        shipsToRemove.add(ship);
                        shipsToRemove.add(ship2);
                    }
                }
            }
        }
        ships.removeAll(shipsToRemove);
        return !shipsToRemove.isEmpty();
    }
}
