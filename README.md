# Kinect Mini-Games : Football Goal

## The Game (or Mini-Game)

### Getting Started

Welcome to Football Goal Kinect Mini-Game. This mini-game is coded in Java and use OpenNI, and PrimeSense Driver for Kinect v1 (Xbox 360 Kinect).

### Requirements

- A Kinect v1 (Xbox 360 Kinect)
- SensorKinect Driver (If you don't have it installed see Installation section below.)
- OpenNI (If you don't have it installed see Installation section below.)
- NITE (If you don't have it installed see Installation section below.)
- Java Runtime (JRE) v8

### Installation

#### Windows

See [OPEN_NI_INSTALL_WIN.md](./OPEN_NI_INSTALL_WIN.md)

### Gameplay

You are a goal in a football team, your objective is to stop the ball with your whole body, fot his you will need to move in front of your Kinect.

## For Developpers

### Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `test`: the folder to maintain unit and functionnal tests

When you compile there is a `bin` directory created.

And Create a `lib` directory in which you add dependecies (see below).

### Commands Files

- `compile` for compiling, place dependencies in a folder call `lib` before.
- `run` for running the mini-game, place the dependencies in a folder call `lib` before.

### Dependencies

- OpenNI (filename: org.OpenNI.jar)
- NITE PrimeSense (filename: com.primesense.NITE.jar)
- JUnit v4.13.1 (For Unit Tests Only) (filename: junit-4.13.1.jar)

## Special Thanks

to :

- Andrew Davison author of Killer Game Programming in Java and many other programming books.
- My Friends and Familly for helping in test, and supporting everyday