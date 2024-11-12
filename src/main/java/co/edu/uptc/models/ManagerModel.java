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
    private int aparitionTime = 0;
    public int colisions = 0;
    public int winners = 0;
    private Boolean selected = false;

    @Override
    public void setPresenter(Contract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public List<Ship> createShips() {
        aparitionTime = presenter.getAparitionTime();
        int numberOfShips = presenter.getNumberOfShips();
        ships = new ArrayList<>();
        presenter.changePosition();
        Thread thread = new Thread(() -> {
            for (int i = 0; i < numberOfShips; i++) {
                selected = false;
                UtilThread.sleep(aparitionTime);
                winners = 0;
                colisions = 0;
                Ship ship = randomApperance();
                ships.add(ship);
                moveShipsInRandomAngle(ship);
            }
        });
        thread.start();
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
        ship.setVelocity(presenter.getVelocity());
        return ship;
    }

    private Point randomAngle(Point origin) {
        random = new Random();
        double angle = random.nextDouble() * 2 * Math.PI;
        int distance = 860;
        int newX = (int) (origin.x + distance * Math.cos(angle));
        int newY = (int) (origin.y + distance * Math.sin(angle));
        return new Point(newX, newY);
    }

    private void moveShipsInRandomAngle(Ship ship) {
        Point newPoint = randomAngle(ship.getPoint());
        ship.setDestinationPoint(newPoint);
        moveInDirection(ship);
    }

    private void moveInDirection(Ship ship) {
        ship.setThread(new Thread(() -> {
            double[] direction = calculateNormalizedDirection(ship.getPoint(), ship.getDestinationPoint());
            double currentX = ship.getPoint().x;
            double currentY = ship.getPoint().y;
            while (!Thread.currentThread().isInterrupted()) {
                currentX += direction[0] * SPEED;
                currentY += direction[1] * SPEED;
                ship.setPoint(new Point((int) Math.round(currentX), (int) Math.round(currentY)));
                if (calculateDistance(currentX, currentY, ship.getDestinationPoint().x, ship.getDestinationPoint().y) < SPEED) {
                    ship.setPoint(ship.getDestinationPoint());
                    break;
                }
                if (comprovateColisionBounds(ship.getPoint()) == true) {
                    ships.remove(ship);
                    presenter.updateColitions();
                    presenter.changePosition();
                }

                if (selected==true) {
                    break;
                }
                comprovateColisionShips();
                comprovationArrive(ship);
                presenter.changePosition();
                UtilThread.sleep(ship.getVelocity());
            }
        }));
        presenter.changePosition();
        ship.getThread().start();
    }

    private double[] calculateNormalizedDirection(Point start, Point end) {
        double dx = end.x - start.x;
        double dy = end.y - start.y;
        double distance = Math.sqrt(dx * dx + dy * dy);
        return distance > 0 ? new double[] { dx / distance, dy / distance } : new double[] { 0, 0 };
    }

    private double calculateDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    private Boolean comprovateColisionBounds(Point point) {
        int minX = 0;
        int minY = 0;
        int maxX = (int) screenSize.getWidth() - 33;
        int maxY = (int) screenSize.getHeight() - 33;
        boolean colision = point.x <= minX || point.x >= maxX || point.y <= minY || point.y >= maxY;
        presenter.changePosition();
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
                        presenter.updateColitions();
                        shipsToRemove.add(ship);
                        shipsToRemove.add(ship2);
                        presenter.changePosition();
                    }
                }
            }
        }
        ships.removeAll(shipsToRemove);
        return !shipsToRemove.isEmpty();
    }


    @Override
    public int setColitions() {
        return colisions;
    }

    @Override
    public void changeVelocity(Ship ship, int velocity) {
        ship.setVelocity(velocity);
    }

    @Override
    public void updateShipPosition(Ship ship, int x, int y) {
        selected = true;
        ship.setPoint(new Point(x, y));
        if (comprovateColisionBounds(ship.getPoint()) == true) {
            ships.remove(ship);
            presenter.updateColitions();
            setColitions();
            presenter.changePosition();
        }
        comprovateColisionShips();
        comprovationArrive(ship);
        presenter.changePosition();
    }

    @Override
    public void continueMovement(Ship ship, Point point) {
        moveInDirection(ship);
        ship.setDestinationPoint(point);
    }

    private void comprovationArrive(Ship ship) {
        if (ship.getPoint().getX() >= 0 && ship.getPoint().getY() >= 0
                && ship.getPoint().getX() <= 100 && ship.getPoint().getY() <= 100) {
            ships.remove(ship);
            presenter.changePosition();
            winners++;
        }
    }
}