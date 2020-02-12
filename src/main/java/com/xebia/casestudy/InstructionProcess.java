package com.xebia.casestudy;

public class InstructionProcess {

    private final String NORTH = "N";
    private final String EAST = "E";
    private final String SOUTH = "S";
    private final String WEST = "W";
    private final String RIGHT = "D";
    private final String LEFT = "G";

    public Location turn(Location location, String instruction) {
        switch (location.orientation){
            case NORTH :
                location.setOrientation(instruction.equals(RIGHT)? EAST : WEST);
                break;
            case EAST :
                location.setOrientation(instruction.equals(RIGHT)? SOUTH : NORTH);
                break;
            case SOUTH :
                location.setOrientation(instruction.equals(RIGHT)? WEST : EAST);
                break;
            case WEST :
                location.setOrientation(instruction.equals(RIGHT)? NORTH :SOUTH);
                break;
            default :
                break;
        }
        return location;
    }

    public Location advance (Location location,Lawn  lawn) {
        Location nextLocation = new Location(location.getX(),location.getY(),location.orientation);
        switch (location.orientation) {
            case NORTH:
                nextLocation.setY(location.getY() + 1);
                break;
            case EAST:
                nextLocation.setX(location.getX() + 1);
                break;
            case SOUTH:
                nextLocation.setY(location.getY() - 1);
                break;
            case WEST:
                nextLocation.setX(location.getX() - 1);
                break;
            default:
                break;
        }
         if(isOutOfLawn(lawn, nextLocation))
            return location;
        return nextLocation;
    }

    private boolean isOutOfLawn(Lawn lawn, Location nextLocation) {
        return nextLocation.getX()<0
                || nextLocation.getY()<0
                || nextLocation.getX()>lawn.getMaxLocation().getX()
                || nextLocation.getY()>lawn.getMaxLocation().getY();
    }
}
