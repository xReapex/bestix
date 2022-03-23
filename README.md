# Bestix

- **Bestix** est un site web permettant d'organiser des compétitions de **paris sur le foot** entre amis ou pour une communauté.

# Front

- Le coté **Front** est composé du **framework** Angular, Tailwinds et DaisyUI.

_<h4>Securité :</h4>_

- Angular gère le login et le register grâce à des requêtes HTTP envoyées directement sur la partie Back du site qui renvoie des réponses accordant ou non la connexion au site.

# Back

- Le coté **Back** est géré grâce à **Spring Boot** qui va traiter les demandes de connexions utilisateurs et également participer au stockages et à la distribution via API des données des joueurs, équipes, paris joués...

_<h4>Utilisateurs :</h4>_

<table>
    <thead>
        <tr>
            <th colspan="2">User Entity</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>Id</td>
            <td>Email</td>
            <td>Username</td>
            <td>Password</td>
            <td>BetHistory</td>
            <td>GuildId</td>
        </tr>
    </tbody>
</table>
