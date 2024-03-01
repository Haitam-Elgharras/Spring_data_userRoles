### Rapport - Gestion des Utilisateurs et Rôles avec Spring Data

#### Introduction
Ce rapport décrit le développement d'un système de gestion des utilisateurs et des rôles en utilisant Spring Data. L'objectif principal de ce projet était de mettre en pratique les concepts étudiés en cours et de créer un système fonctionnel permettant la gestion des utilisateurs et de leurs rôles associés.

#### Implémentation des Fonctionnalités
1. **Ajout d'Utilisateurs**:
   - Une méthode a été développée pour ajouter de nouveaux utilisateurs dans le système. Chaque utilisateur se voit attribuer un identifiant unique généré de manière aléatoire.
   
2. **Ajout de Rôles**:
   - Une fonctionnalité permettant d'ajouter de nouveaux rôles au système a été implémentée. Chaque rôle est identifié par un nom unique.

3. **Recherche d'Utilisateurs par Nom d'Utilisateur**:
   - Une méthode a été mise en place pour rechercher un utilisateur dans la base de données en spécifiant son nom d'utilisateur.

4. **Recherche de Rôles par Nom de Rôle**:
   - Une fonctionnalité permettant de rechercher un rôle dans la base de données en spécifiant son nom a été implémentée.

5. **Attribution de Rôles à des Utilisateurs**:
   - Une méthode a été développée pour attribuer des rôles spécifiques à des utilisateurs. Si l'utilisateur ou le rôle spécifié n'existe pas, une exception est levée.

6. **Liste de tous les Utilisateurs**:
   - Une méthode permettant de récupérer une liste de tous les utilisateurs enregistrés dans le système a été mise en place.

#### Architecture et Implémentation
- Les services sont définis dans une interface `UserService`, tandis que leur implémentation est réalisée dans la classe `UserServiceImpl`.
- L'interaction avec la base de données se fait à travers les repositories `UserRepository` et `RoleRepository`.

#### Conclusion
Ce projet a permis de mettre en pratique les concepts fondamentaux de Spring Data et de la gestion des utilisateurs et des rôles. L'implémentation des fonctionnalités a été réalisée avec succès, fournissant un système fonctionnel pour la gestion des utilisateurs et des rôles dans une application Spring.
