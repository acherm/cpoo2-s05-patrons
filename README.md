# CPOO2, séance 5 : quatre patrons, quatre petits programmes

Espace de travail de la séance 5 de CPOO2 (INSA Rennes, 4INFO, 2026-2027).
Quatre patrons de conception : État, Patron de méthode, Poids-mouche et
Commande.

## Pour démarrer

Il faut Java 21 et Maven. Rien d'autre.

```bash
mvn test          # rouge au départ : c'est l'énoncé
```

Pour lancer les tests d'un seul exercice, ou d'une seule question :

```bash
mvn test -Dtest=GaletteTest
mvn test -Dtest='CommandeTest#q8*'
```

## Ce que contient le dépôt

| Exercice | Patron | Questions | Paquet (`src/main/java/cpoo2/s05/`) | Tests |
|---|---|---|---|---|
| 1. Le distributeur de bonbons | État | Q1 à Q4 | `bonbons` (la version à `if`, à lire), `bonbonsetat` (la version à états, à compléter) | `DistributeurTest` dans les deux, `EtatTest`, `GagnantTest` |
| 2. Les galettes | Patron de méthode | Q5 | `galettes` | `GaletteTest` |
| 3. Le brin d'ADN | Poids-mouche | Q6 | `adn` | `BasesTest` |
| 4. La télécommande | Commande | Q7 et Q8 | `telecommande` | `TelecommandeTest`, `CommandeTest` |
| Patterns et langage (optionnel) | | Q9 et Q10 | `adn`, `telecommande` | |

Les exercices sont indépendants. Trois petits programmes se lancent pour
voir le code tourner : `DistributeurDemo` (dans `bonbons` et dans
`bonbonsetat`), `BrinDemo` et `TelecommandeDemo`.

Au départ, 48 tests, dont 25 verts. Une grande partie du code est déjà
écrite. Les tests dont le nom commence par `q` suivi d'un numéro passent au
vert à la question du même numéro.

## Vos réponses

Il n'y a rien à rendre, et la séance n'est pas notée. C'est en revanche une
excellente préparation au DS final, qui porte sur ces patrons. Le dossier
`reponses/` garde ce que vous écrivez, pour réviser :

- `s05-distributeur.puml`, la machine à états du distributeur (question 1) ;
- `s05.md` : deux tableaux de rôles à remplir, aux questions 2 et 7, un
  nombre à la question 4, et les questions optionnelles 9 et 10.

Cette séance se fait sans IA, ni pour comprendre le code ou l'énoncé, ni
pour écrire.
