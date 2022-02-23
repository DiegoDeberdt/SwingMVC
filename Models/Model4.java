package Models;

import Models.Enums.Direction;
import Models.Enums.Weather;

public class Model4 extends BaseModel {

    private boolean walkLeft;
    private Direction direction = Direction.LEFT_TO_RIGHT;
    private int walkingSpeed = 2;
    private Weather weather = Weather.SUNNY;

    public Model4(String title) {
        super(title);
    }

    public void setWalkingSpeed(int walkingSpeed) {
        this.walkingSpeed = walkingSpeed;
        notifyModelChangedListeners(this);
    }
    public int getWalkingSpeed() { return this.walkingSpeed; }
    public void setWalkingSpeed(String walkingSpeedName) {

        if (walkingSpeedName == "Slow") this.walkingSpeed = 1;
        else if (walkingSpeedName == "Moderate") this.walkingSpeed = 2;
        else if (walkingSpeedName == "Fast") this.walkingSpeed = 3;
        else throw new RuntimeException();

        notifyModelChangedListeners(this);
    }
    public String getWalkingSpeedName() {
        switch(this.walkingSpeed) {
            case 1:
                return "Slow";
            case 2:
                return "Moderate";
            case 3:
                return "Fast";
            default:
                throw new RuntimeException();
        }
    }

    public Direction getDirection() { return this.direction; }
    public void setDirection(Direction direction) {
        this.direction = direction;
        notifyModelChangedListeners(this);
    }

    public Weather getWeather() { return this.weather; }
    public void setWeather(Weather weather) {
        this.weather = weather;
        notifyModelChangedListeners(this);
    }
}
