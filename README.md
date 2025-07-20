# Dining Philosophers Simulation - Java Multithreading with GUI

This project simulates the classical **Dining Philosophers Problem** using Java threads and a graphical user interface. It demonstrates the use of synchronization mechanisms to manage access to shared resources and prevent deadlock.

## Problem Description

- Five philosophers sit around a circular table.
- A bowl of rice is placed in front of each philosopher.
- One chopstick is placed between each pair of adjacent philosophers.
- To eat, a philosopher must hold **both chopsticks** to their left and right.
- Chopsticks are **shared resources**, which can lead to **deadlock** if not handled properly.

Each philosopher operates in a continuous loop:
1. Tries to acquire both chopsticks.
2. Eats for a random amount of time.
3. Releases the chopsticks.
4. Thinks for a random amount of time.

## Implementation Details

- Each philosopher is represented as a separate **thread**.
- Chopsticks are modeled as synchronized objects.
- A philosopher attempting to pick up an unavailable chopstick enters a `wait` state.
- When a chopstick becomes available, the next waiting philosopher is notified via `notify()`.
- To prevent deadlock:
  - Chopsticks are numbered.
  - Each philosopher always picks up the **lower-numbered** chopstick first, then the higher.

## GUI Features

- A simple GUI visualizes the state of each philosopher.
- When a philosopher is **eating**, their appearance (color or icon) changes.
- Used images to represent each philosopher and chopstick.

### The project was completed as part of the Advanced Programming in Java course - 20554 (maman 15). Final grade: 100.
