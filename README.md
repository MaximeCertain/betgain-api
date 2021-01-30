
#API Bet & Gain

| Technologies   |
| ---      | 
| Spring Boot | 
| PostgresSQL     | 
| Docker     | 
| Gitlab-CI     | 


<h1>Installation</h1>


<h3>Paquets prérequis</h3>
<ul>
<li>docker-compose</li>
<li>make</li>
</ul>
<hr>
<h5>Installer le projet </h5>

```bash
make install
```
<hr>
<h5>Mettre à jour le projet</h5>

```bash
make update
```

<hr>
<h5>Accèder à l'interface BDD PGADMIN</h5>
<ul>
<li>se rendre sur 0.0.0.0:5050</li>
<li>Se connecter avec toto@hitweb.fr, mot de passe : hitweb<img src="https://www.pixenli.com/image/gZ1ZJ-kR"></li>
<li>Cliquez sur "create a server" et renseigner pgsql-server en nom <img src="https://www.pixenli.com/image/Mf7yBa-f"> </li>
<li>Dans l'onglet "Connection"  renseigner les informations suivantes  (password : betgain )<br> <img src="https://www.pixenli.com/image/_7b3e3OD"></li></ul>
<li>Cliquez sur save pour finaliser la connexion à la base de données</li></ul>
<li>Visualisez les tables et leurs données ici </li>
<img src="https://www.pixenli.com/image/St4fjUug">
<hr>


<h3>Configurer et Recevoir les mails</h3>

<ul>
<li>se rendre dans le fichier src/main/resources/application.properties</li>
<li>Renseigner votre username et password mailtrap dans les deux champs concernés 
<img src="https://www.pixenli.com/image/KfV-frSo"></li>
<li>Pour trouver ce username/password allez sur le site mailtrap : https://mailtrap.io  (inscription automatique avec github ou google)</li>
<li>Les deux informations se trouvent ensuite sur votre "inbox" lorsque vous cliquez sur Show Credentials<img src="https://www.pixenli.com/image/4TYsSCDH"> </li>
</ul>
<hr>
