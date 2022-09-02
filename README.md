# SoccerGame

This program uses classes in the objects package to manage teams and schedule games. As specified in the project requirements, the temperature system used is Fahrenheit and there three attempts to schedule a game if the temperature is at or below 32.

The scheduler class instantiates four team objects who play games with each other as determined by a simple game scheduler. Scores are determined randomly using a scaling maximum score which increases with the temperature.

The game class records the teams who play each game, their scores and the game's temperature. When the season ends, all game details are printed alongside the highest and average temperatures.

The team class records all teams statistics which are editable by the scheduler class, then when the season ends, all team statistics are printed.

Error trapping is implemented such as only accepting integer input, and any caught errors don't increment the attempt counter.

This application was created as a part of my Certificate IV in Information Technology (Programming) at South Metropolitan TAFE in 2022.
