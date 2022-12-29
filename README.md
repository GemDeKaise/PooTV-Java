### Anghelescu Andrei 322CA
***
## POO TV -Proiect-Etapa 1

### Descriere
Tema respupune implementarea unei platforme de streaming 
folosind conceptele de OOP. Pe platfora se afla mai multi useri inregistrati care au
acces la mai multe filme.

De-a lungul programului mai pot fi adaugati useri ca pot face diferite comenzi
(BUY, UPDATE, WATCH, LIKE, etc.).

### Clase
#### Principalele clase importante sunt:
* **DataBase** - clasa ce stocheaza datele.
* **User** - clasa de baza pentru user
* **Page** - clasa de baza pentru pagini

#### Clasa DataBase
* Pentru clasa DataBase am ales sa implementez un synchronized singleton, doarece
am nevoie doar de o instanta pentru clasa ce stocheaza datele, astfel fiind mult mai usor de 
gestionat.
* Dupa ce clasa iese din functiune, aceasta se distruge pentru a putea crea una nou la un alt run.

#### Clasele derivate din User:
* **StandardUser** - useri standard
* **PremiumUser** - useri care au platit pentru beneficii extra.

Pentru construirea lor m am folosit de un Factory foarte simplu.

#### Clasele derivate din Page:
* **HomePageN** - pagina principala a userului neautentifiacat
* **LoginPage** - pagina de login
* **RegisterPage** - pagina de inregistrare
* **HomePage** - pagina principala
* **MoviesPage** - pagina cu detalii despre un filme
* **SeeDetailsPage** - pagina cu detalii despre un film
* **UpgradesPage** - pagina cu upgrade-uri

Pentru construirea lor m am folosit de un desing pattern numir Command 
Pattern. Astfel, pentru fiecare pagina, am creat o clasa care sa o reprezinte
si care sa contina metodele necesare pentru a o ii executa feature-urile.

## Concluzii

***
 Consider ca fata de prima tema, am o gandire mult mai dezvoltata spre oop,
si am putut observa cu adevarat cu aparitia desing patter-urilor, functionalitatea
 adevarata a acestui mod de programare.

Astept partea a 2 a, eu unul am depus destul de mult efort pentru a face codul sa
cat mai usor de exins, si sper sa ma bucur de asta la partea 2.