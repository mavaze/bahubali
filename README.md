# Bahubali
**Bahubali** is a Hindi word, meaning, *The One with Strong Arms*. This game is named after Hindi movie, [Baahubali 2: The Conclusion](https://en.wikipedia.org/wiki/Baahubali_2:_The_Conclusion), released recently worldwide and making over 700 crores business on box office today. Though this game is nothing to do with the story, it came to my mind while I was in quest for a name in relation to war, combat etc. A German word like ‘Wehrmacht’ sounded cool to me. But finally went ahead with a Hindi name as a popular choice at my end.

# Preface
The requirements are quite lose demanding a lot imagination than focusing on any specific ones. The implementation is by no means a beast, but it targets a key requirement ‘extensible’. Looking at number of packages added, it may look complicated, but I always strive for a well designed and structured one over anything else. So is this a small effort in the same direction. I don’t claim it to be a bug free and well tested application, so please consider this as a proof of concept.

# Workflows

### Workflow 1 (Visiting Places):
1.	New Game > Select Theme > Create Player > Display user possible actions (theme decides)
2.	Player wants to visit places > Display list of objects (again theme decides)
3.	These objects will tell what operations are possible from a player against it e.g. a object, for instance, an ‘Hotel’ will say player, you can ‘Eat’, a Temple can say you can ‘Prey’ here etc.

### Workflow 2 (Fighting with opponent):
1.	New Game > Select Theme > Create Player > Display user possible actions (theme decides)
2.	Player wants to fight > Display list of living characters (again theme decides) 

### Workflow 3 (Saving Game):
1.	New Game > Select Theme > Create Player > Display user possible actions (theme decides)
2.	Here player can save the game (Format: “<Name> <Timestamp>.snapshot”) and exit. Currently I am serializing objects like Topic, Player, Current Action etc. and the corresponding object graph. Again the implementation can be replaced. 
3.	Back option is provided wherever needed to let user go to previous options.

### Workflow 4 (Loading Game):
1.	Load Game > Show List of saved snapshots
2.	User selects one and bypass all initial steps as theme, player, living objects, last actions etc. were restored to its saved state, from where player can resume game.
Design Considerations:
1.	Coded it to interfaces at maximum extent so that one implementation can be swapped out with another one, achieving lose coupling.
2.	Supports multiple Topics/Themes and with one line change of code (call register method of TopicRegistry which maintains list of loaded themes) and addition of an jar in classpath will do its magic. Currently I have 2 themes viz. ‘Classic’ and ‘Game of Thrones’. ‘Classic’ one is not fully implemented though.
3.	Since future requirement could be to map an object on the map, instead of writing sysouts one after another, the text on screen is managed with its x,y coordinates.
4.	Display is layout based and a composite layout is created with StatisticsLayout, MenusLayout and MapLayout as embedded containers. The names suggest their purpose. Theme can decide its own map, and will render itself in MapLayout (though it is yet to be implemented).
5.	A ‘Terminal’ interface is introduced to let us tomorrow swap current console based terminal with any other, say graphical one, with possible support of swing/awt.
6.	Terminal is updated only and only through ScreenController which manages Screen State and gets updated on receiving specific events from various part of code.
7.	MenuItem interface tells which Items be appeared as options list to let user chose one from. Some examples are, Topics, Actions, Snapshots which implement the MenuItem interface.

# Modules

This is a maven structured application with following 4 modules:

* bahubali-core
A core module which works as a framework for any theme and its objects get loaded in. It also provides default behavior/actions keeping theme to implements anything at bare minimum level.

* bahubali-classis
A classic theme with intention of implementation of a regular city with objects like hotel, hospital, bank etc. It is not implemented fully yet. This is added to demonstrate theme/topic functionality.

* bahubali-thrones
It implements popular ‘Game of Thrones’ theme with names of objects coming from the very TV show. It’s doesnot necessarily walk you through the same story though.

* bahubali-build
Holds entry point of game i.e. Main class. It loads the themes into ThemeRegistry and give game a push. This can be extended to read theme configuration from xml/properties file to control application from outside. 

# How to compile and run
```
mvn clean package
sh run.sh
```
