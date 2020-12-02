RunCalc var opprinnelig en coding-challenge for enkle CRUD-operasjoner. I etterkant har jeg videreutviklet og endret database-oppsettet,
dette for å gjøre det mer skalerbar og brukervennlig. Målet er at brukere skal kunne legge inn GPX/TCX filer og dermed få økten opp på et kart,
man skal også kunne legge inn flere målinger over tid på BMI og BMR. Database-strukturen har derfor blitt endret med OneToMany-koblinger istedet.
Tjenesten er fortsatt work-in-progress.  

Ny teknologi; PostgreSQL, Spring Security og Heroku.

Skrevet 29.11.2020

Målet for oppgaven er å lage en løsning som gir deg ulike resultater som kan bli brukt for å komme i form, samt nå sine fysiske mål.
Tjenesten har ulike kalkulatorer som skal hjelpe til med det, deriblant BMI og BMR. Det er også blitt laget kode for å regne ut hvilken 
hastighet man må holde for å løpe et gitt antall kilometer.

Den er satt opp slik at man må lage seg en bruker og plotte inn ulike data om deg selv, så vil den da gi deg BMI og BMR.
Inne på tjenesten skal også hastighetskalkulatoren være.

Det har blitt tatt i bruk 3 ulike tabeller, 1 for brukere, 1 for dataen til brukerne og 1 til BMI/BMR resultater.

Teknologier som er tatt i bruk er Java, Spring, Thymeleaf, MYSQL, H2, HTML og CSS.


Skrevet 08.10.2020 21:57


