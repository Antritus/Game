package com.gmail.antcoreservices.games.laura.map.location;


public enum Direction {
	NORTH,
	NORTH_EAST,
	NORTH_WEST,
	SOUTH,
	SOUTH_EAST,
	SOUTH_WEST,
	EAST,
	WEST,
	ALL,
	ALL_NORTH,
	ALL_SOUTH,
	ALL_EAST,
	ALL_WEST;

	public static Direction[] getAll(Direction direction) {
		Direction[] directions = new Direction[7];
		if (direction == ALL) {
			directions[0] = NORTH;
			directions[1] = NORTH_WEST;
			directions[2] = NORTH_EAST;
			directions[3] = SOUTH;
			directions[4] = SOUTH_WEST;
			directions[5] = SOUTH_EAST;
			directions[6] = WEST;
			directions[7] = EAST;
		}
		if (direction == ALL_EAST) {
			directions[0] = NORTH_EAST;
			directions[1] = SOUTH_EAST;
			directions[2] = EAST;
		}
		if (direction == ALL_WEST) {
			directions[0] = NORTH_WEST;
			directions[1] = SOUTH_WEST;
			directions[2] = WEST;
		}
		if (direction == ALL_NORTH) {
			directions[0] = NORTH;
			directions[1] = NORTH_WEST;
			directions[2] = NORTH_EAST;
		}
		if (direction == ALL_SOUTH) {
			directions[0] = SOUTH;
			directions[1] = SOUTH_WEST;
			directions[2] = SOUTH_EAST;
		}
		return directions;
	}

	public static Direction getDirection(double angle) {
		while (angle < 0) {
			angle = 360 - angle;
		}
		while (angle > 360.01) {
			angle = angle - 360;
		}
		if (angle >= 337.5 || angle <= 22.5) {
			return NORTH;
		}
		if (angle > 22.5 && angle <= 67.5) {
			return NORTH_EAST;
		}
		if (angle > 67.5 && angle <= 112.5) {
			return EAST;
		}
		if (angle > 112.5 && angle <= 157.5) {
			return SOUTH_EAST;
		}
		if (angle > 157.5 && angle <= 202.5) {
			return SOUTH;
		}
		if (angle > 202.5 && angle <= 247.5) {
			return SOUTH_WEST;
		}
		if (angle > 247.5 && angle <= 292.5) {
			return WEST;
		}
		if (angle > 292.5 && angle <= 337.4) {
			return NORTH_WEST;
		}
		return null;
	}
}