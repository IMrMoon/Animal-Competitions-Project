# Animal Tournament Project

## Overview
The Animal Tournament Project is a Java-based application designed to simulate dynamic animal competitions with a user-friendly interface built using Java Swing. The project features real-time animations, where various animals move along tracks based on their unique speeds and orientations, creating an engaging and interactive experience.

## Project Structure
1. **Tournament Logic**: At the core of the project is an abstract `Tournament` class that defines the competition setup and manages tournament execution through a `TournamentThread`. The use of threads ensures efficient handling of animal movements and real-time updates.
2. **Graphical Interface**: The user interface, created with Java Swing, provides a dynamic and interactive environment for viewing the tournament. Animal movements are visualized using `BufferedImage` for smooth rendering.
3. **Animal Movements**: Animals move in real-time along tracks, with behavior defined by speed and direction. This movement logic, managed by threads, allows for smooth and responsive updates in the simulation.

## Key Features
- **Interactive UI**: Built with Java Swing, offering real-time updates as animals compete.
- **Efficient Graphics**: Smooth rendering using `BufferedImage` for an engaging visual experience.
- **Thread Management**: Threads are used to handle animal movements and ensure the application runs efficiently.
- **Customizable Competitions**: Users can define tournament settings, including animal types and scoring rules.
- **OOP Design**: The project leverages object-oriented programming for maintainable and scalable code.

## Tools and Technologies
- **Java**: Main programming language for the application.
- **Java Swing**: Used to create the graphical user interface.
- **BufferedImage**: Utilized for efficient graphics rendering.
- **Threads**: For managing real-time updates and efficient execution.

## Rights and Attribution
All rights reserved © Segev Chen.
