package com.stephengilbane;

import java.util.HashSet;

public class ElevatorProblem
{
    public static class ElevatorRequest
    {

    }

    public static enum Direction
    {
        UP, DOWN, IDLE
    }

    /**
     * Actions that can happen in any state.
     * 
     * @author stephengilbane
     *
     */
    interface ElevatorState
    {
        public void receiveRequest(ElevatorRequest r);

        public void approachingFloor(int floorNo);

        public void elevatorHasStopped(int floor);

        public void doorHasClosed();

        public void doorHasOpened();

        public void move(Direction dir);
    }

    public static class Elevator
    {
        private ElevatorState Moving;
        private ElevatorState Idle;
        private ElevatorState Stopped;
        private ElevatorState DoorOpened;
        private ElevatorState DoorClosed;

        public Elevator()
        {
            Moving = new MovingState(this);
        }
    }

    public static class MovingState implements ElevatorState
    {
        private Elevator elevator;

        public MovingState(Elevator e)
        {
            elevator = e;
            HashSet<String> m = new HashSet<String>();
            for (String s : m)
            {
                
            }
        }

        public void receiveRequest(ElevatorRequest r)
        {
        };

        public void approachingFloor(int floorNo)
        {
        };

        public void elevatorHasStopped(int floor)
        {
        };

        public void doorHasClosed()
        {
        };

        public void doorHasOpened()
        {
        };

        public void move(Direction dir)
        {
        };
    }
}
