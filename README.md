
# Attack On Titan Tower Defense Game

I made a game along with other colleagues

## Intro:
**Attack on Titan: Utopia** is a one-player, endless 2 , tower defense game 1
inspired by the hit anime **Attack on Titan**. The story of the anime
revolves around how titans, gigantic humanoid creatures, emerged one day
and wiped out most of humanity. The few surviving humans fled and hid
behind 3 great walls that provided safe haven from the titan threats. Wall
Maria is the outer wall, Wall Rose is the middle wall and Wall Sina is the
inside wall

This game takes place in an imaginary scenario where the titans breached
their way throughout Wall Maria and reached the northern border of Wall
Rose at the Utopia District. The human forces stationed in Utopia engage
the titans in battle for one last hope of preventing the titans from
breaching Wall Rose. The humans fight by deploying different types of
Anti-Titan weapons in order to stop the Titan’s onslaught and keep Utopia’s
(and Wall Rose’s) walls safe.

**Tower Defense Games:** is a type of game where the player controls a
base and the objective is to continue defending this base from incoming
enemies by deploying some weapons/tools to get rid of these enemies. In
our case the base we need to protect is the Utopia District Walls.

**Endless:** it means that the game will have no winning condition and the
player will keep playing and defeat as many enemies as possible.

## Space (Battle) Setting

The battlefield is divided into multiple lanes, each lane will have the following:

    1. A part of the wall to be defended.
    This wall part will have a starting HP (health points)
    that decreases after being attacked and if this part of the wall is destroyed,
    this lane will no longer be considered an active lane and will be a lost lane.

    2. The weapons that the player has already deployed into this lane.

    3. The titans that are on their way to attack
    the part of the wall at the end of the lane.
    The titans can be at different distances from the walls
    depending on how much they have already moved.
    Each titan will have a starting HP (health points) that decreases
    after being attacked.

Each lane will have a danger level that can be calculated
based on the number and types of titans inside this lane.

In the player’s base, the player will have the option to see all the available
types of weapons and can choose to buy and deploy them into their
choice of an active lane. The player should be able to view the currently
gathered resources and acquired score as well as the remaining HPs of
all walls and titans as well as each titan’s distance from the wall. The
player can also see the approaching titans in order, these approaching
titans will be added to the lanes in the upcoming turns.

The Battle has 3 phases depending on the number of turns that already passed: Early, Intense, Grumbling.

## Enemy Characters (Titans)
There are multiple types of titans in this game. However, all the titans will
have some attributes in common. Each titan will have the following stats

    1. HP: The health points of the titan.
    2. Damage: The amount of damage the titan does when attacking a wall.
    3. Height: The height of the titan in meters, doesn’t affect the gameplay.
    4. Distance from walls: How far the titan is from the walls in “Distance Unit” 3.
    5. Speed: The distance that the titan moves per turn in “Distance Unit”.
    6. Resources value: The amount of resources that the player gains by defeating this titan
    7. Danger level: How much this titan affects a lane’s danger level.

“Distance Unit” : A special distance unit used for the sake of this game
(does not necessarily translate to any realistic distance unit)

| Type | HP | Damage | Height | Speed | Resource Values | Danger Level |
|----------|----------|----------|----------|----------|----------|----------|
| Pure Titan    |100 |15  |15|10|10|1|
| Abnormal Titan|100 |20  |10|15|15|2|
| Armored Titan |200 |85  |15|10|30|3|
| Colossal Titan|1000|100 |60|5|60|4|

In Addition, some of the titan types have special traits that affect how they behave during the battle.

| Type | Special Trait |
|----------|----------|
| Abnormal Titan|Performs the attack action twice per turn instead of once |
| Armored Titan |Takes only 25% of the intended damage |
| Colossal Titan|After every movement, Increases its speed stat by 1 “Distance Unit”.|

## Friendly Pieces (Weapons)

There are multiple types of weapons in this game. However, all the
weapons will have some attributes in common. Each weapon will have the
following stats:

    1. Damage: The amount of damage the weapon does when attacking a Titan.
    2. Price: The amount of resources needed to purchase and deploy a weapon of this type

A specific type of weapons, called the “Volley Spread Cannon” will have a
couple of extra stats:

    1. Min Range: The minimum range of the weapon from the wall in “Distance Unit”.
    2. Max Range: The maximum range of the weapon from the wall in “Distance Unit”.

The different types of weapons will have a different set of starting stats
according to their type.

| Weapon Type | Price | Damage | Weapon Name | Min Range | Max Range | 
|----------|----------|----------|----------|----------|----------|
| Piercing Cannon       |25  |10  |Anti-Titan Shell  |-|-|
| Sniper Cannon         |25  |35  |Long Range Spear  |-|-|
| Volley Spread Cannon  |100 |5   |Wall Spread Cannon|20|50|
| Wall Trap             |75  |100 |Proximity Trap    |-|-|

All the weapons type behave uniquely while performing their attack
actions.

| Weapon Type         | Attack Action (per turn)                                                                 |
|---------------------|-------------------------------------------------------------------------------------------|
| Piercing Cannon     | Attacks the closest 5 titans to the wall <br> on the weapon’s lane.                      |
| Sniper Cannon       | Attacks the first closest titan to the wall <br> on the weapon’s lane.                   |
| Volley Spread Cannon| Attacks all the titans in between the weapon’s <br> min and max ranges on the lane.      |
| Wall Trap           | Attacks only one titan that has already <br> reached the wall (only the first is hit).   |


## Game Rules

Winning and losing Conditions: The game will have no winning
condition and the player will keep playing and defeat as many enemies as
possible. The player loses when all the starting lanes become lost lanes
(All their Wall Parts are destroyed) and the accumulated score by then is
the player’s final score.

Titan Movement: Each turn, every titan inside all of the active lanes that
has not reached the walls yet will move closer to the wall (The distance
from the wall will decrease) a distance equal to their speed stat. Note that
Colossal titans gain an extra speed of 1 “Distance Unit” per movement
action.
Attack Actions: Both Titans and Weapons are able to perform attack
actions:
1- Titans: Each turn, only titans inside active lanes that have already
reached the wall (distance from wall is 0) will perform their attack action
on the wall part of their lane (reducing the Wall Part’s HP by the amount of
that Titan’s damage). Note that Abnormal Titans perform their attack
actions twice per turn.
2- Weapons: Each turn, only weapons that are deployed into active lanes
will perform their attack action on the titans their lane (reducing the
Titans’ HP by the amount of that Weapon’s damage). Each weapon will
follow the above weapons table on which titans to attack.
Defeated Attack Targets: Since Titans and Wall Parts can be attacked,
they can be defeated/destroyed. This happens when the attack target’s HP
is dropped to 0 or below as a result of an attack. Defeated Titans are
removed from the lanes they were in (and the game) and their resources

value is added to the player’s gathered resources as well as the player’s
score (score increases with the same value as the gathered resources). If a
Wall Part is destroyed, the lane with this Wall Part is then marked as a Lost
Lane and not an active Lane. Lost Lanes can not have weapons deployed
to them nor will have any more Titans spawning in them.
Approaching Titans: This is a queue of titans that are not yet added to
any lane. However, it is used to decide which Titan types will be added to
the active lanes each turn. Whenever it is time to add a new Titan to an
active lane, the titan at the front of this approaching titans queue is
removed and then added to the intended lane. If the queue is empty while
attempting to remove a titan, then the queue is refilled with multiple
titans according to the below table.
Titans Spawning & Battle Phase change: Each turn, A specific
number of titans (Initially 1) is removed from the Approaching Titans
and added to the lane with the least danger level. A Lane’s danger level is
the sum of all the titans’ danger levels inside this lane. If, while attempting
to get an approaching titan, all of the approaching titans have been added
into lanes (Empty queue), the approaching titans will refill according to the
following table (If the battle phases has changed while some approaching
titans still remain, the approaching titans will not refill till all of them are
added to lanes and then refilled according to the battle phase at the
moment of refill). The table also shows how the battle phase and the
number of titans to be added into the lanes change based on the elapsed
number of turns.

| Turns   | Battle Phase | #Titans Per Turn                       | Approaching Titans Refill (Front → Back)                                |
|---------|--------------|----------------------------------------|-------------------------------------------------------------------------|
| initial | EARLY        | 1                                      | Pure, Pure, Pure, Abnormal,<br>Pure, Armored, Colossal                  |
| 15      | INTENSE      | 1                                      | Abnormal, Abnormal, Abnormal,<br>Pure, Armored, Armored, Colossal       |
| 30      | GRUMBLING    | 1                                      | Colossal, Colossal, Colossal, Colossal,<br>Colossal, Colossal, Colossal |
| 35      |              | 2<br>(then doubles every<br>5 turns)   |                                                                         |


Weapon Purchase: The player will have the option to see all the available
types of weapons and can choose to buy and deploy them into their
choice of an active lane. To purchase a weapon, the player should have
enough resources (higher than the weapon’s price) and then the weapon’s
price is deducted from the gathered resources.
Turn Actions: Each turn the player can choose to either Purchase and
Deploy a Weapon or pass their turn without any actions. Either way the
turn will proceed as follows. After the player’s action, The titans will do
their move action. Then the weapons will do their attack action followed by
the titans’ attack actions. After that, Titans will be added to the lanes
according to the logic mentioned above. Finally, finalizing the turn by
updating the battle phase and the relevant info if needed based on the
number of elapsed turns, also according to the logic mentioned above.

## Game Flow

idk how to make Flowcharts :)

test
test


```mermaid
graph TD
    A[Start] --> B{Set Up Lanes and Walls and Initial Turn count and battle phase}
    B --> C[Player's turn]
    C -- Purchase Weapon --> D{Update Resources and Deploy Weapon into a Lane}
    C -- Pass --> E{Titans Move Action}

