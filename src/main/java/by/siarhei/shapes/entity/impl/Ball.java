package by.siarhei.shapes.entity.impl;

import by.siarhei.shapes.entity.api.Figure;
import by.siarhei.shapes.event.EventType;
import by.siarhei.shapes.observer.ChangesParametersListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static by.siarhei.shapes.event.EventType.CHANGE_COORDINATE;
import static by.siarhei.shapes.event.EventType.CHANGE_RADIUS;

public class Ball implements Figure {
    private long figureId;
    private double radius;
    private Point center;
    private Map<EventType, List<ChangesParametersListener>> listeners;

    public Ball(long figureId, double radius, Point center) {
        this.listeners = new HashMap<>();
        this.figureId = figureId;
        this.radius = radius;
        this.center = center;
        this.listeners.put(CHANGE_RADIUS, new ArrayList<>());
        this.listeners.put(CHANGE_COORDINATE, new ArrayList<>());
    }

    public Ball() {
    }

    public void subscribeListener(EventType eventType, ChangesParametersListener listener) {
        List<ChangesParametersListener> currentListeners = this.listeners.get(eventType);
        currentListeners.add(listener);
    }

    public void unsubscribeListener(EventType eventType, ChangesParametersListener listener) {
        List<ChangesParametersListener> currentListeners = this.listeners.get(eventType);
        currentListeners.remove(listener);
    }

    private void notifyListenersByType(EventType eventType) {
        List<ChangesParametersListener> currentListeners = this.listeners.get(eventType);
        for (ChangesParametersListener listener : currentListeners) {
            listener.update(this);
        }
    }

    public Point getCenterPoint() {
        return center;
    }

    @Override
    public String toString() {
        return String.format("figureId: %s, radius: %s, %s", figureId, radius, center.toString());
    }

    @Override
    public boolean equals(Object ob) {
        if (this == ob) {
            return true;
        }
        if ((ob == null) || getClass() != ob.getClass()) {
            return false;
        }
        Ball ball = (Ball) ob;
        return this.getRadius() == (ball.getRadius())
                && this.getCenterPoint().equals(ball.getCenterPoint());

    }

    @Override
    public int hashCode() {
        int result;
        result = 17;
        result = 31 * result + (int) (figureId ^ (figureId >>> 32));
        result = 31 * result + Double.hashCode(radius);
        result = 31 * result + center.hashCode();
        return result;
    }


    public long getFigureId() {
        return figureId;
    }

    public double getRadius() {
        return radius;
    }

    public void setX(double x) {
        this.center.setX(x);
        if (isListenersSubscribed(CHANGE_COORDINATE)) {
            notifyListenersByType(CHANGE_COORDINATE);
        }
    }

    public void setY(double y) {
        this.center.setY(y);
        if (isListenersSubscribed(CHANGE_COORDINATE)) {
            notifyListenersByType(CHANGE_COORDINATE);
        }
    }

    public void setZ(double z) {
        this.center.setZ(z);
        if (isListenersSubscribed(CHANGE_COORDINATE)) {
            notifyListenersByType(CHANGE_COORDINATE);
        }
    }

    public void setCenter(Point center) {
        this.center = center;
        if (isListenersSubscribed(CHANGE_COORDINATE)) {
            notifyListenersByType(CHANGE_COORDINATE);
        }
    }

    public void setRadius(double radius) {
        this.radius = radius;
        if (isListenersSubscribed(CHANGE_RADIUS)) {
            notifyListenersByType(CHANGE_RADIUS);
        }
    }

    private boolean isListenersSubscribed(EventType eventType) {
        List<ChangesParametersListener> ceurrentListeners = this.listeners.get(eventType);
        return !ceurrentListeners.isEmpty();
    }
}
