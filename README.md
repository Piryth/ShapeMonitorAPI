# ShapeMonitorAPI
ShapeMonitorAPI est l'API d'un projet d'application fitness, ShapeMonitor. Le projet n'ayant pas abouti pour l'instant, j'ai décidé de le rendre public. Ce projet est maintenant un showcase de mes compétences en développement web avec Java Spring.


## Shape Monitor
Mon objectif était de créer une application de fitness. Pourquoi ? Je voyais beaucoup d'applications mobiles style "journal de perte de poids". Ces applications sont destinées à tout le monde, quelque soi son âge, ou son niveau d'activité. Cependant, il n'y a pas d'outil qui permette de tracker ses mensurations pour les pratiquants de musculations plus avancés. Je voulais une application où l'on peut tracker son poids, mais bien d'autres métriques, telles que le taux de masse grasse et les mensurations.

Je voulais aussi créer une approche tournée objectifs. Le but est de définir un objectif sportif, et d'avoir un objectif à atteindre chaque semaine. L'application calcule ensuite la différence entre l'objectif de base et la réalité, et peut proposer de modifier les objectifs en fonction. J'ai déjà implémenté cette partie sur un autre projet, mais juste en frontend (une sorte de PoC utilisant le local storage).

## Technologies utilisées

### Hibernate et JPA
Mon application utilise Hibernate et JPA pour la persistance des données. Les données sont à la base persistées sur une  base PostgreSQL, mais j'avais pour projet de la porter sur MongoDB.

### Spring security
A travers ce projet, j'ai pu me familiariser avec les bases de Spring Boot et Spring Security. J'ai pu implémenter un système d'authentification JWT, et de sécurité. L'application est en soi assez simple et propose de réaliser des opérations CRUD sur les différentes entitées du modèle.
![image](https://github.com/Piryth/ShapeMonitorAPI/assets/94105105/68169d0e-a988-474d-8740-83daa3594aaf)


