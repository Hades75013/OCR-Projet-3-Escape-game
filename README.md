
# OCR-Projet 3 - Escape game online

Contexte :
GAMEPLAY STUDIO, l’entreprise d’édition de logiciels, où vous venez d’être recruté, a signé un nouveau contrat.
Il s’agit d’une commande pour la réalisation d’un jeu numérique basé sur le concept des Escape Games.
Vous êtes affecté à l’équipe de développeurs Java qui va travailler sur ce projet. En tant que développeur Java junior, vous êtes sous la direction de Sophie, team lead, et de Steven, l’architecte logiciel.
Vous recevez ce mail de la part de Sophie :

    Hello,

    Comme nous en avons discuté à la réunion de lancement de projet, avec Steven, nous souhaitons que tu travailles sur la brique “mécanisme de recherche d’une combinaison à X chiffres”.

    Comme c’est ton premier projet, on voudrait t’intégrer en douceur dans nos process de développements. Nous te proposons donc de réaliser cette brique de façon indépendante au reste du projet.

    Je récapitule les spécifications à suivre :

    1) L'intelligence artificielle de l’ordinateur joue le rôle de défenseur. Elle définit une combinaison de X chiffres aléatoirement.
    2) Le joueur a le rôle d’attaquant et doit faire une proposition d’une combinaison de X chiffres.
    3) L'intelligence artificielle de l’ordinateur indique pour chaque chiffre de la combinaison proposée si le chiffre de sa combinaison est plus grand (+), plus petit (-) ou si c’est le bon (=).
    4) Il y a un nombre limité d’essais.
    Cette façon de faire est le mode “challenger”.
    
    Voici les spécifications pour l’autre mode “défenseur” :

    Le joueur (cette fois dans le rôle de défenseur) définit une combinaison de X chiffres aléatoirement.
    L'intelligence artificielle de l’ordinateur doit faire une proposition d’une combinaison de X chiffres (c’est le rôle attaquant).
    Le joueur indique pour chaque chiffre de la combinaison proposée si le chiffre de sa combinaison est plus grand (+), plus petit (-) ou si c’est le bon (=).
    L’intelligence artificielle fait une autre proposition en se basant sur la réponse fournit par le joueur.
    Il y a un nombre limité d’essais.
    
Enfin, il y a le mode “duel” ! Voici les spécifications pour ce mode :

    Le joueur et l’intelligence artificielle de l’ordinateur jouent tour à tour. Le premier à trouver la combinaison secrète de l'autre a gagné ! (Perso, je pense que ce mode sera le plus sympa à jouer ;) ).

Pour tester ton développement, tu mettras en place une interface “console” qui permettra les actions suivantes :

    - Au démarrage, l’utilisateur choisit un mode (challenger, défenseur, duel). L'application lance le mode sélectionné.
    - L'utilisateur joue. S'il perd, l'application affiche la solution.
    - À la fin de la partie, l'utilisateur peut choisir :
        de rejouer au même mode ;
        de lancer un autre mode (retour à l'écran de choix du début) ;
        de quitter l'application.

Et par défaut, le nombre de chiffres de la combinaison est 4.

Si tu as des questions, n’hésite pas à me demander.

Sophie.



Steven vous a également envoyé un mail afin de vous préciser les contraintes techniques à respecter :

    Salut,

    Sophie t’a normalement déjà fourni les spécifications fonctionnelles. En tant qu’architecte, je souhaite que tu tiennes compte des points suivants dans ton développement :

        - Utilise la modularité de la programmation objet pour que ton code soit ensuite réutilisable dans le projet principal Escape game (donc pas de programmation procédurale !). Il faut qu’on puisse extraire tes packages/classes à terme.
        - Un fichier de configuration doit contenir les paramètres de l’application (nombre de chiffres dans la combinaison, nombre d’essais, mode “développeur” activé ou non).
        - Un mode “développeur” doit pouvoir être activé via un paramètre. Ce mode affiche la solution dès le début du jeu.
        - Un fichier de configuration ( log4j.xml ) permettra de paramétrer les logs de l'application. La gestion des logs se fera avec Apache Log4j.
    Comme tu es nouveau je préfère le préciser, tu n’oublieras pas de mettre ton code sur un repository github, d’indenter, commenter et formater le nom des variables. ;)

    Je reste à ta dispo !

    Steven



##Pour importer le projet :
git clone https://github.com/Hades75013/OCR-Projet-3-Escape-game.git

##Pour lancer le projet :
importer le projet dans IntelliJ et lancer la classe Main (Main.java)



